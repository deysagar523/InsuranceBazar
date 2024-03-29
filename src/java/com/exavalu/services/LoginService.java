/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.util.Base64;
import org.apache.log4j.Logger;

/**
 * Service Class for Login Functionalities that stores all the business logics
 * in terms of adding data to database, updating the database and read data from
 * the database
 *
 * @author Avijit Chattopadhyay
 */
public final class LoginService {

    private static final Logger log = Logger.getLogger(LoginService.class.getName());

    private LoginService() {

    }

    public static LoginService loginService = null;

    /**
     *
     * This method is for getting the instance of the class
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static synchronized LoginService getInstance() {
        if (loginService == null) {
            loginService = new LoginService();
        }
        return loginService;

    }

    /**
     *
     * This method is for login functionality of the
     * user(customer,underwriter,insurance officer)
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public boolean doLogin(User user) throws NoSuchAlgorithmException {
        boolean success = false;

        String sql = "Select * from users where email=? and password=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(user.getPassword().getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user.getEmail());
                ps.setString(2, hashtext);

                System.out.println("LoginService :: " + ps);
                try (ResultSet rs = ps.executeQuery();) {
                    if (rs.next()) {

                        success = true;

                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }

        }

        return success;
    }

    /**
     *
     * This method is for sign up a normal customer using both google and normal
     * login
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public boolean doSignUp(User user) throws NoSuchAlgorithmException {

        try {
            String sql2 = "select * from users where email=?";
            String sql = "INSERT INTO users(email,password, role,dateOfRegistration)\n" + "VALUES(? ,?, ?,CURDATE());";
            Connection con = JDBCConnectionManager.getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (PreparedStatement ps1 = con.prepareStatement(sql2);) {
                    ps1.setString(1, user.getEmail());
                    try (ResultSet rs = ps1.executeQuery()) {
                        if (rs.next()) {
                            return false;
                        }
                        // Static getInstance method is called with hashing MD5
                        MessageDigest md = MessageDigest.getInstance("MD5");

                        // digest() method is called to calculate message digest
                        // of an input digest() return array of byte
                        byte[] messageDigest = md.digest(user.getPassword().getBytes());

                        // Convert byte array into signum representation
                        BigInteger no = new BigInteger(1, messageDigest);

                        // Convert message digest into hex value
                        String hashtext = no.toString(16);
                        while (hashtext.length() < 32) {
                            hashtext = "0" + hashtext;
                        }

                        ps.setString(1, user.getEmail());
                        ps.setString(2, hashtext);
                        ps.setString(3, "1");

                        System.out.println("LoginService dosignup :: " + ps);
                        ps.executeUpdate();
                        return true;

                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }

        }

        return false;

    }

    /**
     *
     * This method is for getting the details of a particular user when he or
     * she logs in
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static User getUser(String email) {
        User user = new User();
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "Select * from users where email=?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            try (ResultSet rs = preparedStatement.executeQuery();) {
                if (rs.next()) {
                    Blob imageBlob = rs.getBlob("image");
                    if (imageBlob != null) {
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        String imageString = Base64.getEncoder().encodeToString(imageBytes);
                        user.setImageData(imageString);
                    }
                    user.setEmail(rs.getString("email"));
                    user.setUserId(rs.getString("userId"));
                    user.setRole(rs.getString("role"));
                    user.setAge(rs.getString("age"));
                    user.setFullName(rs.getString("fullName"));
                    System.out.println("from getUser fullName:" + rs.getString("fullName"));
                    user.setCountryCode(rs.getString("countryCode"));
                    user.setStateCode(rs.getString("stateCode"));
                    user.setDistrictCode(rs.getString("districtCode"));
                    user.setPhone(rs.getString("phone"));
                    System.out.println("from getUser phone:" + rs.getString("phone"));
                    user.setGender(rs.getString("gender"));
                    System.out.println("from getUser gender:" + rs.getString("gender"));
                    //user.setDob(rs.getString("dob"));
                    user.setIncomeSource(rs.getString("incomeSource"));
                    System.out.println("from getUser income source:" + rs.getString("incomeSource"));

                    // con.close();
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }

        return user;
    }

    /**
     *
     * This method is for update the fields of a user
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static boolean updateUser(User user, String userId) throws FileNotFoundException, IOException {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE users SET fullName = ? , gender = ? , phone = ?, age=?, incomeSource=?, image=? WHERE userId = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                try (FileInputStream inputStream = new FileInputStream(user.getImage())) {
                    System.out.println("image: " + user.getImage());

                    preparedStatement.setString(1, user.getFullName());
                    preparedStatement.setString(2, user.getGender());
                    preparedStatement.setString(3, user.getPhone());
                    preparedStatement.setString(4, user.getAge());
                    preparedStatement.setString(5, user.getIncomeSource());

                    preparedStatement.setBinaryStream(6, inputStream);

                    preparedStatement.setString(7, userId);

                    int row = preparedStatement.executeUpdate();

                    if (row == 1) {
                        System.out.println("row updated");
                        result = true;
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        return result;
    }

    /**
     *
     * This method is for update the fields of a user without image
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static boolean updateUserWithoutImage(User user, String userId) throws FileNotFoundException {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE users SET fullName = ? , gender = ? , phone = ?, age=?, incomeSource=? WHERE userId = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getFullName());
                preparedStatement.setString(2, user.getGender());
                preparedStatement.setString(3, user.getPhone());
                preparedStatement.setString(4, user.getAge());
                preparedStatement.setString(5, user.getIncomeSource());

                preparedStatement.setString(6, userId);

                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    System.out.println("row updated");
                    result = true;
                }
            }

            //System.out.println("image: " + user.getImage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        return result;
    }
}
