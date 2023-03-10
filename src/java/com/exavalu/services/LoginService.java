/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Country;
import com.exavalu.models.District;
import com.exavalu.models.State;
import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import com.mysql.cj.protocol.Resultset;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Base64;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class LoginService {

    private static final Logger log = Logger.getLogger(LoginService.class);
    public static LoginService loginService = null;

    private LoginService() {
    }

    public static LoginService getInstance() {
        if (loginService == null) {
            return new LoginService();
        } else {
            return loginService;
        }
    }

    public boolean doLogin(User user) {
        boolean success = false;

        String sql = "Select * from users where email=? and password=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            System.out.println("LoginService :: " + ps);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                success = true;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }

        return success;
    }

    public boolean doSignUp(User user) {

        try {
            String sql2 = "select * from users where email=?";
            String sql = "INSERT INTO users(email,password, role,dateOfRegistration)\n" + "VALUES(? ,?, ?,CURDATE());";
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql2);
            ps1.setString(1, user.getEmail());
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                return false;
            }
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, "1");

            System.out.println("LoginService dosignup :: " + ps);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }

        return false;

    }

    public static User getUser(String email) {
        User user = new User();
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "Select * from users where email=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

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

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }

        return user;
    }


    public static boolean updateUser(User user, String userId) throws FileNotFoundException {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE users SET fullName = ? , gender = ? , phone = ?, age=?, incomeSource=?, image=? WHERE userId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            System.out.println("image: " + user.getImage());

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getAge());
            preparedStatement.setString(5, user.getIncomeSource());

            FileInputStream inputStream = new FileInputStream(user.getImage());
            preparedStatement.setBinaryStream(6, inputStream);

            preparedStatement.setString(7, userId);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                System.out.println("row updated");
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;
    }

    public static boolean updateUser2(User user, String userId) throws FileNotFoundException {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE users SET fullName = ? , gender = ? , phone = ?, age=?, incomeSource=? WHERE userId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //System.out.println("image: " + user.getImage());
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

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;
    }
}
