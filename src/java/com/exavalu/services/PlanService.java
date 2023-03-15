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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class PlanService {

    private static final Logger log = Logger.getLogger(PlanService.class);

    /**
     *
     * This method is for getting all the plans of bike insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static ArrayList getAllBikePlans() {

        ArrayList planList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from plans pl, policies po where pl.policyId= po.policyId and po.policyId=3;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("plans page:");
                Plan plan = new Plan();
                plan.setPlanId(rs.getString("planId"));
                plan.setPlanCompany(rs.getString("planCompany"));
                plan.setPolicyName(rs.getString("policyName"));
                plan.setPlanDuration(rs.getString("planDuration"));
                plan.setPlanAmount(rs.getString("planAmount"));
                plan.setPlanIDV(rs.getString("planIDV"));

                planList.add(plan);

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PlanService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("plans:" + planList.size());
        return planList;
    }

    /**
     *
     * This method is for getting all the plans of child investment insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static ArrayList getAllChildPlans() {

        ArrayList planList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from plans pl, policies po where pl.policyId= po.policyId and po.policyId=7;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("child plans page:");
                Plan plan = new Plan();
                plan.setPlanId(rs.getString("planId"));
                plan.setPlanCompany(rs.getString("planCompany"));
                plan.setPolicyName(rs.getString("policyName"));
                plan.setPlanDuration(rs.getString("planDuration"));
                plan.setPlanAmount(rs.getString("planAmount"));
                plan.setLumpSumPayout(rs.getString("lumpSumPayout"));

                planList.add(plan);

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PlanService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("child plans:" + planList.size());
        return planList;
    }

    /**
     *
     * This method is for getting all the plans of mediclaim insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static ArrayList getAllMedPlans() {

        ArrayList planList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from plans pl, policies po where pl.policyId= po.policyId and po.policyId=1;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("med plans page:");
                Plan plan = new Plan();
                plan.setPlanId(rs.getString("planId"));
                plan.setPlanCompany(rs.getString("planCompany"));
                plan.setPolicyName(rs.getString("policyName"));
                plan.setPlanDuration(rs.getString("planDuration"));
                plan.setPlanAmount(rs.getString("planAmount"));
                plan.setCoverAmount(rs.getString("coverAmount"));

                planList.add(plan);

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(PlanService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("med plans:" + planList.size());
        return planList;
    }
}
