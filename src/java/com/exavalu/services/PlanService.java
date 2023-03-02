/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.Plan;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class PlanService {
    
    public static ArrayList getAllBikePlans(){
        ArrayList planList= new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from plans pl, policies po where pl.policyId= po.policyId and po.policyId=3;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Plan plan= new Plan();
                
                plan.setPlanCompany(rs.getString("planCompany"));
                plan.setPolicyName(rs.getString("policyName"));
                plan.setPlanDuration(rs.getString("planDuration"));
                plan.setPlanAmount(rs.getString("planAmount"));
                
                
                
                planList.add(plan);
                

            }


        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        System.out.println("plans:"+planList.size());
        return planList;
    }
    
}
