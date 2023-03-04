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
        boolean success=false;
    
        String sql = "Select * from users where email=? and password=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            System.out.println("LoginService :: " + ps);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                success= true;
                
               
                
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }
        
        return success;
    }

    public boolean doSignUp(User user) {

        String sql = "INSERT INTO users(email,password, role,dateOfRegistration)\n" + "VALUES(? ,?, ?,CURDATE());";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, "1");

            System.out.println("LoginService dosignup :: " + ps);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now() + " " + ex.getMessage());

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
                user.setFullName(rs.getString("fullName"));
                System.out.println("from getUser fullName:"+rs.getString("fullName"));
                user.setCountryCode(rs.getString("countryCode"));
                user.setStateCode(rs.getString("stateCode"));
                user.setDistrictCode(rs.getString("districtCode"));
                user.setPhone(rs.getString("phone"));
                System.out.println("from getUser phone:"+rs.getString("phone"));
                user.setGender(rs.getString("gender"));
                System.out.println("from getUser gender:"+rs.getString("gender"));
                user.setDob(rs.getString("dob"));

                // con.close();
            }

        } catch (SQLException ex) {

        }

        return user;
    }

    public ArrayList getAllCountries() {
        ArrayList countryList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM country";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Country country = new Country();
                country.setCountryName(rs.getString("countryName"));
                country.setCountryCode(rs.getString("countryCode"));

                countryList.add(country);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.err.println("Number of countries = " + countryList.size());
        return countryList;
    }

    public ArrayList getAllStates(String countryCode) {
        ArrayList stateList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM state where countryCode=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, countryCode);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                State state = new State();

                state.setStateCode(rs.getString("stateCode"));
                state.setStateName(rs.getString("stateName"));

                stateList.add(state);

            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());;
        }
        System.err.println("Number of states = " + stateList.size());
        return stateList;
    }

    public ArrayList getAllDistricts(String stateCode) {

        ArrayList districtList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM district where stateCode=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, stateCode);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                District district = new District();

                district.setDistrictCode(rs.getString("districtCode"));
                district.setDistrictName(rs.getString("districtName"));

                districtList.add(district);

            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        System.err.println("Number of districts = " + districtList.size());
        return districtList;
    }
    
    
    public static boolean updateUser(User user, String userId) throws FileNotFoundException{
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE users SET fullName = ? , gender = ? , phone = ?, incomeSource=?, image=? WHERE userId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            System.out.println("image: "+user.getImage());
            FileInputStream inputStream = new FileInputStream(user.getImage());
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getIncomeSource());
            preparedStatement.setBinaryStream(5, inputStream);
            
        
                       
            preparedStatement.setString(6, userId);
            
            int row = preparedStatement.executeUpdate();

            if(row==1)
            {
                System.out.println("row updated");
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
