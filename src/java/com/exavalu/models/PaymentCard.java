/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.PaymentCardService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.parser.ParseException;
/**
 *
 * @author user
 */
public class PaymentCard extends ActionSupport implements SessionAware, Serializable{
    
    

    /**
     * @return the cardHolderName
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * @param cardHolderName the cardHolderName to set
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the cardExpiration
     */
    public String getCardExpiration() {
        return cardExpiration;
    }

    /**
     * @param cardExpiration the cardExpiration to set
     */
    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    /**
     * @return the cvc
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * @param cvc the cvc to set
     */
    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
    
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();


  
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }
    
    /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the map
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }
    
    
    private String cardHolderName,cardNumber, cardExpiration, cvc;
    
    public String getDataFromAPI() throws ParseException, IOException{
        String result = "FAILURE";
        ArrayList cards = PaymentCardService.consumeFromAPI();
        
        PaymentCard paymentCard = new PaymentCard();
        boolean res = PaymentCardService.insertIntoPaymentCardDB(cards);
         
        if(!cards.isEmpty()){
            result = "SUCCESS";
            //String successMsg = "Entered API Data into Database!";
            sessionMap.put("Cards", cards);
            sessionMap.put("Card", paymentCard);
            return result;
        }
        
        return result;
    }
    
    

    
    
    
}
