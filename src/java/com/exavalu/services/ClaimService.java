/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.BikeModel;
import com.exavalu.models.BikeVariant;
import com.exavalu.models.Claim;
import com.exavalu.models.Disease;
import com.exavalu.models.Plan;
import com.exavalu.models.Relative;
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
import java.time.format.FormatStyle;
import javax.swing.text.DateFormatter;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class ClaimService {
private static final Logger log = Logger.getLogger(ClaimService.class);
    public static boolean insertHealthClaim(Claim claim) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, medicalHistory, relation, relativeName, claimStatus, fullName, email, age, gender, relativeAge, disease, adharCard, relationAdhar)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "1");
            preparedStatement.setString(3, claim.getMedicalHistory());

            preparedStatement.setString(4, claim.getRelation());

            preparedStatement.setString(5, claim.getRelativeName());

            preparedStatement.setString(6, "registered");

            preparedStatement.setString(7, claim.getFullName());
            preparedStatement.setString(8, claim.getEmail());
            preparedStatement.setString(9, claim.getAge());
            preparedStatement.setString(10, claim.getGender());
            preparedStatement.setString(11, claim.getRelativeAge());

            preparedStatement.setString(12, claim.getDisease());
            preparedStatement.setString(13, claim.getAdharCard());
            preparedStatement.setString(14, claim.getRelationAdhar());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, HEALTH CLAIM INSERTED");
            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;

    }

    public static boolean insertBikeClaim(Claim claim) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, bikeNumber, bikeMake, bikeModel, bikeRegistrationYear, claimStatus, fullName, email)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "3");
            preparedStatement.setString(3, claim.getBikeNumber());
            preparedStatement.setString(4, claim.getBikeMake());
            preparedStatement.setString(5, claim.getBikeModel());
           
            preparedStatement.setString(6, claim.getBikeRegistrationYear());
            preparedStatement.setString(7, "registered");

            preparedStatement.setString(8, claim.getFullName());
            preparedStatement.setString(9, claim.getEmail());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, CLAIM INSERTED");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;

    }

    public static ArrayList getBoughtPlans(String userId) {
        ArrayList claimList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "select * from claims c, policies p, plans plan, users u where c.policyId= p.policyId and c.userId= u.userId and c.planId= plan.planId and c.paid=\"true\" and u.userId=? order by c.claimId desc; ";
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
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of claims bought = " + claimList.size());
        return claimList;
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
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
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
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;

    }

  

    public static Claim getClaimById(String bikeNumber) {

        Claim claim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,policies p where c.policyId=p.policyId and bikeNumber=?;";
//            String sql = "select * from employees e, departments d, roles r "
//                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    +"and e.employeeId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, bikeNumber);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setUserId(rs.getString("userId"));
                claim.setEmail(rs.getString("email"));
                claim.setFullName(rs.getString("fullName"));
                claim.setPolicyName(rs.getString("policyName"));
//                claim.setPhone(rs.getString("phone"));
                claim.setGender(rs.getString("gender"));
                claim.setBikeNumber(rs.getString("bikeNumber"));
                claim.setBikeMake(rs.getString("bikeMake"));
                claim.setBikeModel(rs.getString("bikeModel"));
                claim.setBikeRegistrationYear(rs.getString("bikeRegistrationYear"));
                claim.setIncidentLocation(rs.getString("incidentLocation"));
                claim.setIncidentDate(rs.getString("incidentDate"));
                claim.setPoliceReportNo(rs.getString("policeReportNo"));
                claim.setMessage(rs.getString("message"));
                claim.setAdharCard(rs.getString("adharCard"));

            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE CLAIM FETCHED: " + claim.getClaimId());
        return claim;

    }


    public static boolean doPayment(String claimId, String planId, String planDuration) {
        boolean result = false;

        LocalDate planExpiryDate = LocalDate.now().plusYears(Integer.parseInt(planDuration));

        String claimExpiryDate = planExpiryDate.toString();
        System.out.println("The LocalDate after adding  years is: " + claimExpiryDate);
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "update claims set paid=\"true\", claimStatus=\"bought\", planId=?, claimExpiryDate=?,policyBoughtDay=CURDATE() where claimId=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            System.out.println("claimId=" + claimId);

            preparedStatement.setString(1, planId);
            preparedStatement.setString(2, claimExpiryDate);
             
            preparedStatement.setString(3, claimId);

            System.out.println("claim row to be updated");
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                System.out.println("claim row updated" + row);
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;
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
                particularClaim.setBikeNumber(rs.getString("bikeNumber"));
                particularClaim.setBikeMake(rs.getString("bikeMake"));
                particularClaim.setBikeModel(rs.getString("bikeModel"));
                particularClaim.setBikeRegistrationYear(rs.getString("bikeRegistrationYear"));
                particularClaim.setClaimExpiryDate(rs.getString("claimExpiryDate"));

                particularClaim.setChildAge(rs.getString("childAge"));
                particularClaim.setChildName(rs.getString("childName"));
                particularClaim.setChildGender(rs.getString("childGender"));
                particularClaim.setChildBirthNo(rs.getString("childBirthNo"));

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
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending mediclaim policy list = " + pendingHealthMediclaimPolicyList.size());
        return particularClaim;
    }
    
    public static Claim searchMedClaim(String claimId) {
        Claim particularClaim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,policies p,relatives r,medicalhistory m  where c.medicalHistory=m.medicalHistorycode and c.relation=r.relationCode and c.policyId=p.policyId and  claimId=?";

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
                particularClaim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                particularClaim.setMedicalHistory(rs.getString("medicalHistoryName"));
                particularClaim.setDisease(rs.getString("disease"));
                particularClaim.setRelativeType(rs.getString("relativeType"));
                particularClaim.setAdharCard(rs.getString("adharCard"));
                particularClaim.setRelativeAge(rs.getString("relativeAge"));
                particularClaim.setRelationAdhar(rs.getString("relationAdhar"));

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
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending mediclaim policy list = " + pendingHealthMediclaimPolicyList.size());
        return particularClaim;
    }

    public static Claim getClaim(String claimId) {

        Claim claim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c, policies p, plans pl, users u where c.policyId= p.policyId and c.planId= pl.planId and c.userId= u.userId and c.claimId=?;";
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
                claim.setAge(rs.getString("age"));
                claim.setBikeNumber(rs.getString("bikeNumber"));
                claim.setBikeMake(rs.getString("bikeMake"));
                claim.setBikeModel(rs.getString("bikeModel"));
                claim.setBikeRegistrationYear(rs.getString("bikeRegistrationYear"));
                claim.setAdharCard(rs.getString("adharCard"));
                claim.setPlanCompany(rs.getString("planCompany"));
                claim.setPlanAmount(rs.getString("planAmount"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setIncidentLocation(rs.getString("incidentLocation"));
                claim.setIncidentDate(rs.getString("incidentDate"));
                claim.setPoliceReportNo(rs.getString("policeReportNo"));
                claim.setMessage(rs.getString("message"));

                claim.setPolicyName(rs.getString("policyName"));

                claim.setChildName(rs.getString("childName"));
                claim.setChildAge(rs.getString("childAge"));
                claim.setChildGender(rs.getString("childGender"));
                claim.setChildBirthNo(rs.getString("childBirthNo"));
                
                claim.setRelativeName(rs.getString("relativeName"));
                claim.setRelativeAge(rs.getString("relativeAge"));
                claim.setRelationAdhar(rs.getString("relationAdhar"));
                claim.setMedicalHistory(rs.getString("medicalHistory"));
                claim.setDisease(rs.getString("disease"));
                claim.setRelation(rs.getString("relation"));

            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE CLAIM FETCHED: " + claim.getClaimId());
        return claim;

    }

    public static boolean updateBikeClaim(Claim claim) {

        String sql = "UPDATE claims SET claimStatus =\"1\", incidentLocation=?, incidentDate=?, policeReportNo=?, adharCard=?, message=? WHERE claimId = ?";
        boolean result = false;
        System.out.println(claim.getIncidentLocation());
        System.out.println(claim.getIncidentDate());
        System.out.println(claim.getAdharCard());

        try {
            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, claim.getIncidentLocation());
            preparedStatement.setString(2, claim.getIncidentDate());
            preparedStatement.setString(3, claim.getPoliceReportNo());
            preparedStatement.setString(4, claim.getAdharCard());
            preparedStatement.setString(5, claim.getMessage());
            preparedStatement.setString(6, claim.getClaimId());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                System.out.println(" from claimService status changred to 1");
                result = true;
            } else {
                System.out.println(" status not not changed to 1 claimService ");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
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
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE PLAN FETCHED: " + plan.getPlanId());
        return plan;

    }

    public static boolean insertChildClaim(Claim claim) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, childName, childAge, childGender, claimStatus, fullName, email, age, childBirthNo, medicalHistory)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "7");
            preparedStatement.setString(3, claim.getChildName());

            preparedStatement.setString(4, claim.getChildAge());

            preparedStatement.setString(5, claim.getChildGender());

            preparedStatement.setString(6, "registered");

            preparedStatement.setString(7, claim.getFullName());
            preparedStatement.setString(8, claim.getEmail());
            preparedStatement.setString(9, claim.getAge());
            preparedStatement.setString(10, claim.getChildBirthNo());
            preparedStatement.setString(11, claim.getMedicalHistory());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, CHILD CLAIM INSERTED");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;

    }

    
    public static Claim getClaimByChildBirthNo(String childBirthNo) {

        Claim claim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,policies p  where c.policyId=p.policyId and childBirthNo=?;";
//            String sql = "select * from employees e, departments d, roles r "
//                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    +"and e.employeeId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, childBirthNo);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setUserId(rs.getString("userId"));
                claim.setEmail(rs.getString("email"));
                claim.setFullName(rs.getString("fullName"));
                claim.setPolicyName(rs.getString("policyName"));
                claim.setAge(rs.getString("age"));
                claim.setChildBirthNo(rs.getString("childBirthNo"));
                claim.setChildName(rs.getString("childName"));
                claim.setChildAge(rs.getString("childAge"));
                claim.setChildGender(rs.getString("childGender"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE CLAIM FETCHED: " + claim.getClaimId());
        return claim;

    }

    public static boolean updateChildClaim(Claim claim) {

        String sql = "UPDATE claims SET claimStatus =\"1\", message=? WHERE claimId = ?";
        boolean result = false;

        try {
            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, claim.getMessage());
            preparedStatement.setString(2, claim.getClaimId());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                System.out.println(" from claimService status changred to 1");
                result = true;
            } else {
                System.out.println(" status not not changed to 1 claimService ");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;

    }

    public static ArrayList getDiseases(String medicalHistoryCode) {
        ArrayList dList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM diseases where medicalHistoryCode=?; ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, medicalHistoryCode);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Disease disease = new Disease();

                disease.setDiseaseName(rs.getString("diseaseName"));

                dList.add(disease);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of dideases = " + dList.size());
        return dList;
    }

    public static ArrayList getRelatives(String relationCode) {

        ArrayList rList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM relatives where relationCode=?; ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, relationCode);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Relative r = new Relative();

                r.setRelativeType(rs.getString("relativeType"));

                rList.add(r);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of relatives = " + rList.size());
        return rList;

    }


    public static Claim getClaimByRelationAdhar(String relationAdhar) {
        
        Claim claim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,policies p,relatives r  where c.relation=r.relationCode and c.policyId=p.policyId and relationAdhar=?;";
//            String sql = "select * from employees e, departments d, roles r "
//                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    +"and e.employeeId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, relationAdhar);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setUserId(rs.getString("userId"));
                claim.setEmail(rs.getString("email"));
                claim.setFullName(rs.getString("fullName"));
                claim.setPolicyName(rs.getString("policyName"));
                claim.setAge(rs.getString("age"));
                claim.setRelativeName(rs.getString("relativeName"));
                claim.setRelativeType(rs.getString("relativetype"));
                claim.setRelativeAge(rs.getString("relativeAge"));
                claim.setRelativeGender(rs.getString("relativeGender"));
                claim.setGender(rs.getString("gender"));
                claim.setMedicalHistory(rs.getString("medicalHistory"));
                claim.setDisease(rs.getString("disease"));

            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE CLAIM FETCHED: " + claim.getClaimId());
        return claim;

        
    }
    
    public static boolean updateHealthClaim(Claim claim) {

        String sql = "UPDATE claims SET claimStatus =\"1\", message=? WHERE claimId = ?";
        boolean result = false;

        try {
            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, claim.getMessage());
            preparedStatement.setString(2, claim.getClaimId());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                System.out.println(" from claimService status changred to 1");
                result = true;
            } else {
                System.out.println(" status not not changed to 1 claimService ");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;

    }

    public static Claim getClaimByAdhar(String adharCard) {
        
        Claim claim = new Claim();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,policies p  where c.policyId=p.policyId and adharCard=?;";
//            String sql = "select * from employees e, departments d, roles r "
//                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    +"and e.employeeId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, adharCard);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setUserId(rs.getString("userId"));
                claim.setEmail(rs.getString("email"));
                claim.setFullName(rs.getString("fullName"));
                claim.setPolicyName(rs.getString("policyName"));
                claim.setAge(rs.getString("age"));
                
                claim.setGender(rs.getString("gender"));
                claim.setMedicalHistory(rs.getString("medicalHistory"));
                claim.setDisease(rs.getString("disease"));

            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("FROM CLAIM SERVICE CLAIM FETCHED: " + claim.getClaimId());
        return claim;
    }

    public static boolean insertHealthClaim2(Claim claim) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "INSERT INTO claims (userId, policyId, medicalHistory, relation, claimStatus, fullName, email, age, gender,disease, adharCard)"
                    + "VALUES(?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            int totalRows = 0;

            preparedStatement.setString(1, claim.getUserId());
            preparedStatement.setString(2, "1");
            preparedStatement.setString(3, claim.getMedicalHistory());

            preparedStatement.setString(4, claim.getRelation());

            
            preparedStatement.setString(5, "registered");

            preparedStatement.setString(6, claim.getFullName());
            preparedStatement.setString(7, claim.getEmail());
            preparedStatement.setString(8, claim.getAge());
          
            preparedStatement.setString(9, claim.getGender());

            preparedStatement.setString(10, claim.getDisease());
            preparedStatement.setString(11, claim.getAdharCard());
           

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
                System.out.println("FROM CLAIM SERVICE, SELF HEALTH CLAIM INSERTED");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;

    }
    
    
    public static ArrayList getBikeModels(String bikeMakeCode) {

        ArrayList mList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM bikemodel where bikeMakeCode=?; ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, bikeMakeCode);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                BikeModel m = new BikeModel();

                m.setBikeModel(rs.getString("bikeModel"));
                m.setBikeModelCode(rs.getString("bikeModelCode"));

                mList.add(m);

            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(ClaimService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of makes = " + mList.size());
        return mList;

    }
    
    
}
