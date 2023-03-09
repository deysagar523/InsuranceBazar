/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Category;
import com.exavalu.models.Policy;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class PolicyService {
    private static final Logger log = Logger.getLogger(PolicyService.class);
    
    public static ArrayList getPoliciesByCategoryId(String categoryId){
        ArrayList policies= new ArrayList();
                
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from policies where categoryId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, categoryId);
            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Policy policy= new Policy();
                
                policy.setPolicyId(rs.getString("policyId"));
                policy.setPolicyName(rs.getString("policyName"));
                
                
                policies.add(policy);

            }


        } catch (SQLException ex) {
            
             System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PolicyService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of policies = "+policies.size());
        return policies;
    }
    
    public static Policy getPolicyDetails(String policyId){
        Policy policy= new Policy();
                
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from policies where policyId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, policyId);
            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                
                
                
                policy.setPolicyId(rs.getString("policyId"));
                policy.setPolicyName(rs.getString("policyName"));
                policy.setCategoryId(rs.getString("categoryId"));
                
                

            }


        } catch (SQLException ex) {
            
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PolicyService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("policy fetched = "+policy.getPolicyName());
        return policy;
    }
}
