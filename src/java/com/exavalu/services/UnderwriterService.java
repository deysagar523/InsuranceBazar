/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Claim;
import com.exavalu.models.UnderwriterHistory;

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
 * @author LENOVO
 */
public class UnderwriterService {

    private static final Logger log = Logger.getLogger(UnderwriterService.class);
    public static UnderwriterService underwriterService = null;

    public static UnderwriterService getInstance() {
        if (underwriterService == null) {
            return new UnderwriterService();
        } else {
            return underwriterService;
        }
    }

    public ArrayList getAllPendingHealthMediclaimClaims() {
        ArrayList pendingHealthMediclaimPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p,relatives r where c.relation=r.relationCode and c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "1");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                //claim.setCategoryName(rs.getString("categoryName"));
                claim.setAdharCard(rs.getString("adharCard"));
                claim.setPolicyName(rs.getString("policyName"));
                //claim.setPolicyDescription(rs.getString("policyDescription"));

                claim.setMedicalHistory(rs.getString("medicalHistory"));
                //claim.setDob(rs.getString("dob"));
                claim.setRelation(rs.getString("relation"));
                claim.setRelativeName(rs.getString("relativeName"));
                claim.setRelativeType(rs.getString("relativeType"));
                claim.setRelationAdhar(rs.getString("relationAdhar"));

                claim.setDisease("disease");
//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingHealthMediclaimPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of pending mediclaim policy list = " + pendingHealthMediclaimPolicyList.size());
        return pendingHealthMediclaimPolicyList;
    }

    public ArrayList getAllPendingHealthCriticalIllnessClaims() {
        ArrayList pendingHealthCriticalIllnessPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "2");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setCategoryName(rs.getString("categoryName"));

                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));

                claim.setMedicalHistory(rs.getString("medicalHistory"));
                claim.setDob(rs.getString("dob"));
                claim.setRelation(rs.getString("relation"));
                claim.setRelativeName(rs.getString("relativeName"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingHealthCriticalIllnessPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        // System.out.println("Number of pending mediclaim policy list = " + pendingHealthCriticalIllnessPolicyList.size());
        return pendingHealthCriticalIllnessPolicyList;
    }

    public ArrayList getAllPendingCarTwoWheelerClaims() {
        ArrayList pendingCarTwoWheelerPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "3");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));

//                claim.setIncidentDate(rs.getString("incidentDate"));
//                claim.setIncidentLocation(rs.getString("incidentLocatin"));
//                claim.setPoliceReportNo(rs.getString("policeReportNo"));
                claim.setBikeMake(rs.getString("bikeMake"));
                claim.setBikeModel(rs.getString("bikeModel"));
                claim.setBikeNumber(rs.getString("bikeNumber"));
                claim.setBikeRegistrationYear(rs.getString("bikeRegistrationYear"));
                claim.setBikeVariant(rs.getString("bikeVariant"));
//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingCarTwoWheelerPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of pending list = " + pendingCarTwoWheelerPolicyList.size());
        return pendingCarTwoWheelerPolicyList;
    }

    public ArrayList getAllPendingCarFourWheelerClaims() {
        ArrayList pendingCarFourWheelerPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "4");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setCategoryName(rs.getString("categoryName"));

                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));

                claim.setIncidentDate(rs.getString("incidentDate"));
                claim.setIncidentLocation(rs.getString("incidentLocatin"));
                claim.setPoliceReportNo(rs.getString("policeReportNo"));
                claim.setCarModel(rs.getString("carModel"));
                claim.setCarNo(rs.getString("carNo"));
                claim.setCarRegistrationYear(rs.getString("carRegistrationYear"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingCarFourWheelerPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingCarFourWheelerPolicyList;
    }

    public ArrayList getAllPendingTermLifeInsuranceClaims() {
        ArrayList pendingTermLifeInsurancePolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "5");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setCategoryName(rs.getString("categoryName"));

                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));

                claim.setOccupation(rs.getString("occupation"));
                claim.setAnnualIncome(rs.getString("annualIncome"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingTermLifeInsurancePolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingTermLifeInsurancePolicyList;
    }

    public ArrayList getAllPendingTermForNriClaims() {
        ArrayList pendingTermForNriPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "6");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setCategoryName(rs.getString("categoryName"));

                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));

                claim.setOccupation(rs.getString("occupation"));
                claim.setAnnualIncome(rs.getString("annualIncome"));

                claim.setChildName(rs.getString("childName"));
                claim.setDob(rs.getString("dob"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingTermForNriPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingTermForNriPolicyList;
    }

    public ArrayList getAllPendingInvestmentChildClaims() {
        ArrayList pendingInvestmentChildPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "7");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setPolicyName(rs.getString("policyName"));

                claim.setChildName(rs.getString("childName"));
                claim.setChildAge(rs.getString("childAge"));
                claim.setChildGender(rs.getString("childGender"));
                claim.setChildBirthNo(rs.getString("childBirthNo"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingInvestmentChildPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of pending list = " + pendingInvestmentChildPolicyList.size());
        return pendingInvestmentChildPolicyList;
    }

    public ArrayList getAllPendingInvestmentPensionClaims() {
        ArrayList pendingInvestmentPensionPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "8");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setCategoryName(rs.getString("categoryName"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingInvestmentPensionPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingInvestmentPensionPolicyList;
    }

    public ArrayList getAllPendingOtherTravelClaims() {
        ArrayList pendingOtherTravelPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "9");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setCategoryName(rs.getString("categoryName"));

                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));

                claim.setEducationLevel(rs.getString("educationLevel"));

                claim.setTravelEndDate(rs.getString("travelEndDate"));
                claim.setTravelStartDate(rs.getString("travelStartDate"));
                claim.setTravelDestination(rs.getString("travelDestination"));
                claim.setNoOfTravelMembers(rs.getString("noOfTravelMembers"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingOtherTravelPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingOtherTravelPolicyList;
    }

    public ArrayList getAllPendingOtherEducationalClaims() {
        ArrayList pendingOtherEducationalPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "1");

            preparedStatement.setString(2, "10");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                claim.setClaimName(rs.getString("claimName"));

                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));

                claim.setCategoryName(rs.getString("categoryName"));

                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));

                claim.setEducationLevel(rs.getString("educationLevel"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingOtherEducationalPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingOtherEducationalPolicyList;
    }

    public boolean approvePolicy(String claimId) {
        boolean result = true;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancebazardb.claims\n"
                    + "SET claimStatus = ? where claimId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            //status 2 = Approved by underwriter
            preparedStatement.setString(1, "2");
            preparedStatement.setString(2, claimId);

//            System.out.println("sql="+preparedStatement);
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;
    }

    public boolean rejectPolicy(String claimId) {
        boolean result = true;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancebazardb.claims\n"
                    + "SET claimStatus = ? where claimId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            //status 4 = rejected by underwriter
            preparedStatement.setString(1, "4");
            preparedStatement.setString(2, claimId);

//            System.out.println("sql="+preparedStatement);
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        return result;
    }

    public void addToApproveHistory(String claimId) {
        String sql = "INSERT INTO underwriter_histories(claimId,userFullName,userEmail,policyName,claimStatus,timeOfAction)\n" + "VALUES(? ,?,?,?,?,?);";

        String sql2 = "select * from claims c,policies p  where c.policyId=p.policyId and claimId=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, claimId);

            ResultSet rs = ps2.executeQuery();
            String userFullName = "", userEmail = "", policyName = "";
            while (rs.next()) {
                userFullName = rs.getString("fullName");
                policyName = rs.getString("policyName");
                userEmail = rs.getString("email");
            }
            LocalDateTime currentLocalDateTime = LocalDateTime.now();

            // Create DateTimeFormatter instance with specified format
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            // Format LocalDateTime to String
            String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);
            ps.setString(1, claimId);

            ps.setString(2, userFullName);
            ps.setString(3, userEmail);
            ps.setString(4, policyName);
            ps.setString(5, "2");
            ps.setString(6, formattedDateTime);
            //System.out.println("LoginService dosignup :: "+ps);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }

    }

    public void addToRejectedHistory(String claimId) {
        String sql = "INSERT INTO underwriter_histories(claimId,userFullName,userEmail,policyName,claimStatus,timeOfAction)\n" + "VALUES(? ,?,?,?,?,?);";

        String sql2 = "select * from claims c,policies p  where c.policyId=p.policyId and claimId=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, claimId);

            ResultSet rs = ps2.executeQuery();
            String userFullName = "", userEmail = "", policyName = "";
            while (rs.next()) {
                userFullName = rs.getString("fullName");
                policyName = rs.getString("policyName");
                userEmail = rs.getString("email");
            }
            LocalDateTime currentLocalDateTime = LocalDateTime.now();

            // Create DateTimeFormatter instance with specified format
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            // Format LocalDateTime to String
            String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);
            ps.setString(1, claimId);

            ps.setString(2, userFullName);
            ps.setString(3, userEmail);
            ps.setString(4, policyName);
            ps.setString(5, "4");
            ps.setString(6, formattedDateTime);
            //System.out.println("LoginService dosignup :: "+ps);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }

    }

    public ArrayList getAllApprovedHistories() {
        ArrayList histories = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from underwriter_histories where claimStatus=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "2");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                UnderwriterHistory history = new UnderwriterHistory();

                history.setClaimId(rs.getString("claimId"));
                history.setPolicyName(rs.getString("policyName"));
                history.setUserEmail(rs.getString("userEmail"));
                history.setUserFullName(rs.getString("userFullName"));
                history.setTimeOfAction(rs.getString("timeOfAction"));
                histories.add(history);

            }

        } catch (SQLException | ExceptionInInitializerError ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return histories;
    }

    public ArrayList getAllRejectedHistories() {
        ArrayList histories = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from underwriter_histories where claimStatus=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "4");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                UnderwriterHistory history = new UnderwriterHistory();
                Claim claim = new Claim();
                history.setClaimId(rs.getString("claimId"));
                history.setPolicyName(rs.getString("policyName"));
                history.setUserEmail(rs.getString("userEmail"));
                history.setUserFullName(rs.getString("userFullName"));
                history.setTimeOfAction(rs.getString("timeOfAction"));
                histories.add(history);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return histories;
    }

    public static String elementsForXaxis(String interval) {
        String date = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select DATE_ADD(CURDATE(), INTERVAL ? DAY) as Date";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, interval);

            System.out.println("ps:" + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                date = rs.getString("Date");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }
        return date;
    }

    public static String totalRegisteredUsers(String interval) {
        String totalUsers = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT COUNT(email) as totalRegisteredUsersToday FROM users where dateOfRegistration = DATE_ADD(CURDATE(), INTERVAL ? DAY);";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, interval);

            System.out.println("ps:" + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalUsers = rs.getString("totalRegisteredUsersToday");
            } else {
                totalUsers = "0";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println(totalUsers);
        return totalUsers;
    }
    
    public static String totalBoughtPlans(String interval) {
        String totalPolicies = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT COUNT(email) as totalPoliciesToday FROM claims where policyBoughtDay = DATE_ADD(CURDATE(), INTERVAL ? DAY);";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, interval);

            System.out.println("ps:" + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalPolicies = rs.getString("totalPoliciesToday");
            } else {
                totalPolicies = "0";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println(totalUsers);
        return totalPolicies;
    }

    public String getNoOfUsers() {
        String totalUsers = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT COUNT(email) as totalRegisteredUsers FROM users";

            PreparedStatement ps = con.prepareStatement(sql);
           

            //System.out.println("ps:" + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalUsers = rs.getString("totalRegisteredUsers");
            } else {
                totalUsers = "0";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println(totalUsers);
        return totalUsers;
    }

    public String getTotalRevenue() {
       String totalRevenue = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT sum(planAmount) as revenue FROM claims c,plans p where c.planId=p.planId";

            PreparedStatement ps = con.prepareStatement(sql);
           

            //System.out.println("ps:" + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalRevenue = rs.getString("revenue");
            } else {
                totalRevenue = "0";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println(totalUsers);
        return totalRevenue;
    }
}
