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

/**
 *
 * @author user
 */
public class CategoryService {
    
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
        }
        System.out.println("Number of categories = "+categories.size());
        return categories;
        
        
    }
    
}
