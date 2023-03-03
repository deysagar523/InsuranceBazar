/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Claim;
import com.exavalu.models.Plan;
import com.exavalu.utils.JDBCConnectionManager;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.text.DateFormatter;

/**
 *
 * @author user
 */
public class ClaimService {

    public static boolean insertHealthClaim(Claim claim) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, medicalHistory, relation, dob, relativeName, claimStatus, message, fullName, email, age, gender)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "1");
            preparedStatement.setString(3, claim.getMedicalHistory());

            preparedStatement.setString(4, claim.getRelation());

            preparedStatement.setString(5, claim.getDob());
            preparedStatement.setString(6, claim.getRelativeName());

            preparedStatement.setString(7, "registered");
            preparedStatement.setString(8, claim.getMessage());

            preparedStatement.setString(9, claim.getFullName());
            preparedStatement.setString(10, claim.getEmail());
            preparedStatement.setString(11, claim.getAge());
            preparedStatement.setString(12, claim.getGender());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, HEALTH CLAIM INSERTED");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;

    }

    public static boolean insertBikeClaim(Claim claim) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, bikeNumber, bikeMake, bikeModel, bikeVariant, bikeRegistrationYear, claimStatus, message, fullName, email)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "3");
            preparedStatement.setString(3, claim.getBikeNumber());
            preparedStatement.setString(4, claim.getBikeMake());
            preparedStatement.setString(5, claim.getBikeModel());
            preparedStatement.setString(6, claim.getBikeVariant());
            preparedStatement.setString(7, claim.getBikeRegistrationYear());
            preparedStatement.setString(8, "registered");
            preparedStatement.setString(9, claim.getMessage());
            preparedStatement.setString(10, claim.getFullName());
            preparedStatement.setString(11, claim.getEmail());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, CLAIM INSERTED");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;

    }

    public static ArrayList getBoughtPlans(String userId) {
        ArrayList claimList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from claims c, policies p, plans plan, users u where c.policyId= p.policyId and c.userId= u.userId and c.planId= plan.planId and c.claimStatus=\"bought\" and u.userId=? order by c.claimId desc; ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Claim claim = new Claim();

                claim.setClaimId(rs.getString("claimId"));
                claim.setBikeNumber(rs.getString("bikeNumber"));
                claim.setBikeMake(rs.getString("bikeMake"));
                claim.setBikeModel(rs.getString("bikeModel"));
                claim.setBikeRegistrationYear(rs.getString("bikeRegistrationYear"));
                claim.setPolicyName(rs.getString("policyName"));
                claim.setPlanId(rs.getString("planId"));
                claim.setPlanCompany(rs.getString("planCompany"));
                claim.setPlanAmount(rs.getString("planAmount"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                

                claimList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Number of claims bought = " + claimList.size());
        return claimList;
    }

    public static ArrayList getAllClaims() {
        return null;
    }

    public static boolean insertCarClaim(Claim claim) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, carNo, carModel, carRegistrationYear, incidentLocation, incidentDate, policeReportNo, claimStatus, message, fullName, email)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "4");
            preparedStatement.setString(3, claim.getCarNo());

            preparedStatement.setString(4, claim.getCarModel());

            preparedStatement.setString(5, claim.getCarRegistrationYear());
            preparedStatement.setString(6, claim.getIncidentLocation());
            preparedStatement.setString(7, claim.getIncidentDate());
            preparedStatement.setString(8, claim.getPoliceReportNo());

            preparedStatement.setString(9, "registered");
            preparedStatement.setString(10, claim.getMessage());

            preparedStatement.setString(11, claim.getFullName());
            preparedStatement.setString(12, claim.getEmail());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, 4 WHEELER CLAIM INSERTED");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;

    }

    public static boolean insertTravelClaim(Claim claim) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, travelDestination, travelStartDate, travelEndDate, age, medicalHistory, claimStatus, message, fullName, email)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "9");
            preparedStatement.setString(3, claim.getTravelDestination());

            preparedStatement.setString(4, claim.getTravelStartDate());

            preparedStatement.setString(5, claim.getTravelEndDate());
            preparedStatement.setString(6, claim.getAge());
            preparedStatement.setString(7, claim.getMedicalHistory());

            preparedStatement.setString(8, "registered");
            preparedStatement.setString(9, claim.getMessage());

            preparedStatement.setString(10, claim.getFullName());
            preparedStatement.setString(11, claim.getEmail());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, TRAVEL CLAIM INSERTED");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;

    }

    public static ArrayList getOfficerOnlyClaims() {
        return null;
    }

    public static Claim getClaimById(String bikeNumber) {

        Claim claim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims where bikeNumber=?;";
//            String sql = "select * from employees e, departments d, roles r "
//                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    +"and e.employeeId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, bikeNumber);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                claim.setClaimId(rs.getString("claimId"));
                claim.setUserId(rs.getString("userId"));
                claim.setEmail(rs.getString("email"));
                claim.setFullName(rs.getString("fullName"));
//                claim.setPhone(rs.getString("phone"));
                claim.setGender(rs.getString("gender"));
                claim.setBikeNumber(rs.getString("bikeNumber"));
                claim.setBikeMake(rs.getString("bikeMake"));
                claim.setBikeModel(rs.getString("bikeModel"));
                claim.setBikeRegistrationYear(rs.getString("bikeRegistrationYear"));
                claim.setAdharCard(rs.getString("adharCard"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE CLAIM FETCHED: " + claim.getClaimId());
        return claim;

    }

    public static Claim getClaimByPolicyId(String policyId) {
        return null;
    }

    public static ArrayList searchClaims(String claimId, String claimDate, String claimStatus, String policyName) {
        return null;
    }

    public static boolean doPayment(String claimId, String planId, String planDuration) {
        boolean result = false;

        LocalDate planExpiryDate = LocalDate.now().plusYears(Integer.parseInt(planDuration));
        
        String claimExpiryDate= planExpiryDate.toString();
        System.out.println("The LocalDate after adding  years is: " + claimExpiryDate);
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "update claims set paid=\"true\", claimStatus=\"bought\", planId=?, claimExpiryDate=? where claimId=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            System.out.println("claimId=" + claimId);

            preparedStatement.setString(1, planId);
            preparedStatement.setString(2, claimExpiryDate);
            preparedStatement.setString(3, claimId);
            
            System.out.println("claim row to be updated");
            int row = preparedStatement.executeUpdate();
            
            if (row == 1) {
                System.out.println("claim row updated"+ row);
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static boolean doBuy(String planId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Claim searchClaim(String claimId) {
        Claim particularClaim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,policies p where c.policyId=p.policyId and  claimId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, claimId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                particularClaim.setClaimId(rs.getString("claimId"));
                //particularClaim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                //particularClaim.setClaimStatus(rs.getString("claimStatus"));
                //particularClaim.setClaimName(rs.getString("claimName"));

                particularClaim.setFullName(rs.getString("fullName"));
                particularClaim.setEmail(rs.getString("email"));

                //particularClaim.setCategoryName(rs.getString("categoryName"));
                particularClaim.setPolicyName(rs.getString("policyName"));
                //particularClaim.setPolicyDescription(rs.getString("policyDescription"));

                //particularClaim.setMedicalHistory(rs.getString("medicalHistory"));
                //particularClaim.setDob(rs.getString("dob"));
                //particularClaim.setRelation(rs.getString("relation"));
                //particularClaim.setRelativeName(rs.getString("relativeName"));
//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        //System.out.println("Number of pending mediclaim policy list = " + pendingHealthMediclaimPolicyList.size());
        return particularClaim;
    }

    public static Claim getClaim(String claimId) {

        Claim claim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c, policies p, users u where c.policyId= p.policyId and c.userId= u.userId and c.claimId=?;";
//            String sql = "select * from employees e, departments d, roles r "
//                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    +"and e.employeeId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, claimId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                claim.setUserId(rs.getString("userId"));
                claim.setEmail(rs.getString("email"));
                claim.setFullName(rs.getString("fullName"));
//                claim.setPhone(rs.getString("phone"));
                claim.setGender(rs.getString("gender"));
                claim.setBikeNumber(rs.getString("bikeNumber"));
                claim.setBikeMake(rs.getString("bikeMake"));
                claim.setBikeModel(rs.getString("bikeModel"));
                claim.setBikeRegistrationYear(rs.getString("bikeRegistrationYear"));
                claim.setAdharCard(rs.getString("adharCard"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE CLAIM FETCHED: " + claim.getClaimId());
        return claim;

    }

    public static boolean fileFnol(String claimId) {

        Claim claim = new Claim();

        String sql = "UPDATE claims SET claimStatus =\"1\" WHERE claimId = ?";
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, claimId);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                System.out.println(" from claimService status changred to 1");
                result = true;
            } else {
                System.out.println(" status not not changed to 1 fnolService ");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;

    }

    public static Plan getPlanDetails(String planId) {
        Plan plan = new Plan();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from plans p, policies po where p.policyId= po.policyId and planId=?;";
//            String sql = "select * from employees e, departments d, roles r "
//                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    +"and e.employeeId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, planId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                plan.setPlanAmount(rs.getString("planAmount"));
                plan.setPlanCompany(rs.getString("planCompany"));
                plan.setPlanDuration(rs.getString("planDuration"));
                plan.setPlanId(rs.getString("planId"));
                plan.setPolicyId(rs.getString("policyId"));
                plan.setPolicyName(rs.getString("policyName"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE PLAN FETCHED: " + plan.getPlanId());
        return plan;

    }
}
