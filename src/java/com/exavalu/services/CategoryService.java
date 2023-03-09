/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.exavalu.models.Category;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class CategoryService {
    private static final Logger log = Logger.getLogger(CategoryService.class);
    
    public static ArrayList getAllCategories(){
        ArrayList categories= new ArrayList();
                
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from categories";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Category category= new Category();
                
                category.setCategoryId(rs.getString("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                
                
                categories.add(category);

            }


        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(CategoryService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of categories = "+categories.size());
        return categories;
        
        
    }
    
}
