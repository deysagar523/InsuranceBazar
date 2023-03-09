/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.PaymentCard;
import com.exavalu.utils.JDBCConnectionManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author user
 */
public class PaymentCardService {

    private static final Logger log = Logger.getLogger(PaymentCardService.class);

    public static ArrayList consumeFromAPI() throws ParseException {

        //String result = null;
        ArrayList<PaymentCard> cardList = new ArrayList();
        try {

            URL url = new URL("https://mocki.io/v1/f6777f82-291b-4252-8d6d-9cc8ceca9392");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();
                JSONParser parse = new JSONParser();
                JSONArray jsonArray = (JSONArray) parse.parse(inline);

                //JSONArray jsonArray = data_obj.getJSONArra("languages");
                for (int i = 0; i < jsonArray.size(); i++) {

                    PaymentCard paymentCard = new PaymentCard();
                    JSONObject obj = (JSONObject) jsonArray.get(i);
                    String cardHolderName = obj.get("cardHolderName").toString();
                    String cardNumber = obj.get("cardNumber").toString();
                    String cardExpiration = obj.get("cardExpiration").toString();
                    String cvc = obj.get("cvc").toString();

                    paymentCard.setCardHolderName(cardHolderName);
                    paymentCard.setCardNumber(cardNumber);
                    paymentCard.setCardExpiration(cardExpiration);
                    paymentCard.setCvc(cvc);

                    cardList.add(paymentCard);

                }

                System.out.println("Size of CARD List" + cardList.size());
            }

        } catch (MalformedURLException ex) {

            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PaymentCardService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PaymentCardService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }
        return cardList;
    }

    public static boolean insertIntoPaymentCardDB(ArrayList cardList) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO paymentcards(cardHolderName, cardNumber, cardExpiration, cvc)" + "VALUES(?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            con.setAutoCommit(false);

            Iterator itr = cardList.iterator();
            while (itr.hasNext()) {

                PaymentCard pc = (PaymentCard) itr.next();
                preparedStatement.setString(1, pc.getCardHolderName());
                preparedStatement.setString(2, pc.getCardNumber());
                preparedStatement.setString(3, pc.getCardExpiration());
                preparedStatement.setString(4, pc.getCvc());

                preparedStatement.addBatch();

            }
            int[] count = preparedStatement.executeBatch();
            con.commit();

            if (count.length >= 1) {
                result = true;
                System.out.println(count.length);
            }

            con.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PaymentCardService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }

        return result;

    }

}
