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
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;

/**
 * Service Class that stores all the business logics involving the features of
 * underwriter in terms of updating the claim status from pending to
 * approved/rejected and read data from the database
 *
 * @author LENOVO
 */
public final class UnderwriterService {

    private static final Logger log = Logger.getLogger(UnderwriterService.class.getName());

//    private static final Logger log = Logger.getLogger(UnderwriterService.class);
    /**
     *
     * This method is for getting the instance of the class
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public static UnderwriterService underwriterService = null;

    private UnderwriterService() {
    }

    public static UnderwriterService getInstance() {
        if (underwriterService == null) {
            return new UnderwriterService();
        } else {
            return underwriterService;
        }
    }

    /**
     *
     * This method is for underwriter to get all the pending mediclaim insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingHealthMediclaimClaims() {
        List<Claim> pendingHealthMediclaimPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p,relatives r where c.relation=r.relationCode and c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "1");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }

        }
        System.out.println("Number of pending mediclaim policy list = " + pendingHealthMediclaimPolicyList.size());
        return pendingHealthMediclaimPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending critical illness
     * insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingHealthCriticalIllnessClaims() {
        List<Claim> pendingHealthCriticalIllnessPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "2");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        // System.out.println("Number of pending mediclaim policy list = " + pendingHealthCriticalIllnessPolicyList.size());
        return pendingHealthCriticalIllnessPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending two wheeler
     * insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingCarTwoWheelerClaims() {
        List<Claim> pendingCarTwoWheelerPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "3");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        System.out.println("Number of pending list = " + pendingCarTwoWheelerPolicyList.size());
        return pendingCarTwoWheelerPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending four wheeler
     * insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingCarFourWheelerClaims() {
        List<Claim> pendingCarFourWheelerPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "4");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingCarFourWheelerPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending life insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingTermLifeInsuranceClaims() {
        List<Claim> pendingTermLifeInsurancePolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "5");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingTermLifeInsurancePolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending nri insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingTermForNriClaims() {
        List<Claim> pendingTermForNriPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "6");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingTermForNriPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending child investment
     * insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingInvestmentChildClaims() {
        List<Claim> pendingInvestmentChildPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "7");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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

                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        System.out.println("Number of pending list = " + pendingInvestmentChildPolicyList.size());
        return pendingInvestmentChildPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending pension insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingInvestmentPensionClaims() {
        List<Claim> pendingInvestmentPensionPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "8");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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

                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingInvestmentPensionPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending travel insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingOtherTravelClaims() {
        List<Claim> pendingOtherTravelPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "9");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingOtherTravelPolicyList;
    }

    /**
     *
     * This method is for underwriter to get all the pending education insurance
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllPendingOtherEducationalClaims() {
        List<Claim> pendingOtherEducationalPolicyList = new ArrayList<Claim>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "1");

                preparedStatement.setString(2, "10");
                try (ResultSet rs = preparedStatement.executeQuery()) {
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
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return pendingOtherEducationalPolicyList;
    }

    /**
     *
     * This method is for underwriter to approve a policy depending all rest api
     * call verification
     *
     *
     *
     *
     *
     *
     *      
     */
    public boolean approvePolicy(String claimId) {
        boolean result = true;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancebazardb.claims\n"
                    + "SET claimStatus = ? where claimId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                //status 2 = Approved by underwriter
                preparedStatement.setString(1, "2");
                preparedStatement.setString(2, claimId);

//            System.out.println("sql="+preparedStatement);
                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        return result;
    }

    /**
     *
     * This method is for underwriter to reject a policy depending all rest api
     * call verification
     *
     *
     *
     *
     *
     *
     *      
     */
    public boolean rejectPolicy(String claimId) {
        boolean result = true;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancebazardb.claims\n"
                    + "SET claimStatus = ? where claimId=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                //status 4 = rejected by underwriter
                preparedStatement.setString(1, "4");
                preparedStatement.setString(2, claimId);

//            System.out.println("sql="+preparedStatement);
                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        return result;
    }

    /**
     *
     * This method is for underwriter if he approve that then it will go to the
     * underwriter history(approved)
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public void addToApproveHistory(String claimId) {
        String sql = "INSERT INTO underwriter_histories(claimId,userFullName,userEmail,policyName,claimStatus,timeOfAction)\n" + "VALUES(? ,?,?,?,?,?);";

        String sql2 = "select * from claims c,policies p  where c.policyId=p.policyId and claimId=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {

                try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
                    ps2.setString(1, claimId);

                    try (ResultSet rs = ps2.executeQuery()) {
                        String userFullName = "";
                        String userEmail = "";
                        String policyName = "";
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
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }

        }

    }

    /**
     *
     * This method is for underwriter if he approve that then it will go to the
     * underwriter history(rejected)
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public void addToRejectedHistory(String claimId) {
        String sql = "INSERT INTO underwriter_histories(claimId,userFullName,userEmail,policyName,claimStatus,timeOfAction)\n" + "VALUES(? ,?,?,?,?,?);";

        String sql2 = "select * from claims c,policies p  where c.policyId=p.policyId and claimId=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
                    ps2.setString(1, claimId);

                    try (ResultSet rs = ps2.executeQuery()) {
                        String userFullName = "";
                        String userEmail = "";
                        String policyName = "";
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
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }

        }

    }

    /**
     *
     * This method is for underwriter to get all the approved histories
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllApprovedHistories() {
        List<UnderwriterHistory> histories = new ArrayList<UnderwriterHistory>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from underwriter_histories where claimStatus=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "2");

                try (ResultSet rs = preparedStatement.executeQuery()) {

                    while (rs.next()) {
                        UnderwriterHistory history = new UnderwriterHistory();

                        history.setClaimId(rs.getString("claimId"));
                        history.setPolicyName(rs.getString("policyName"));
                        history.setUserEmail(rs.getString("userEmail"));
                        history.setUserFullName(rs.getString("userFullName"));
                        history.setTimeOfAction(rs.getString("timeOfAction"));
                        histories.add(history);

                    }
                }
            }

        } catch (SQLException | ExceptionInInitializerError ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return histories;
    }

    /**
     *
     * This method is for underwriter to get all the rejected histories
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public List getAllRejectedHistories() {
        List<UnderwriterHistory> histories = new ArrayList<UnderwriterHistory>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from underwriter_histories where claimStatus=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, "4");
                try (ResultSet rs = preparedStatement.executeQuery()) {

                    while (rs.next()) {
                        UnderwriterHistory history = new UnderwriterHistory();
                        history.setClaimId(rs.getString("claimId"));
                        history.setPolicyName(rs.getString("policyName"));
                        history.setUserEmail(rs.getString("userEmail"));
                        history.setUserFullName(rs.getString("userFullName"));
                        history.setTimeOfAction(rs.getString("timeOfAction"));
                        histories.add(history);

                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return histories;
    }

    /**
     *
     * This method is for x axis in the chart.js
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public String elementsForXaxis(String interval) {
        String date = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select DATE_ADD(CURDATE(), INTERVAL ? DAY) as Date";
            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, interval);

                System.out.println("ps:" + ps);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        date = rs.getString("Date");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }

        }
        return date;
    }

    /**
     *
     * This method is for total no of users registered in our database
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public String totalRegisteredUsers(String interval) {
        String totalUsers = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT COUNT(email) as totalRegisteredUsersToday FROM users where dateOfRegistration = DATE_ADD(CURDATE(), INTERVAL ? DAY);";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, interval);

                System.out.println("ps:" + ps);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        totalUsers = rs.getString("totalRegisteredUsersToday");
                    } else {
                        totalUsers = "0";
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println(totalUsers);
        return totalUsers;
    }

    /**
     *
     * This method is for total no of bought plans in our database for last 5
     * days to show in the chart
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public String totalBoughtPlans(String interval) {
        String totalPolicies = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT COUNT(email) as totalPoliciesToday FROM claims where policyBoughtDay = DATE_ADD(CURDATE(), INTERVAL ? DAY);";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, interval);

                System.out.println("ps:" + ps);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        totalPolicies = rs.getString("totalPoliciesToday");
                    } else {
                        totalPolicies = "0";
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println(totalUsers);
        return totalPolicies;
    }

    /**
     *
     * This method is for total no of users registered in last 5 days to show in
     * the chart
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public String getNoOfUsers() {
        String totalUsers = null;

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT COUNT(email) as totalRegisteredUsers FROM users";

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                //System.out.println("ps:" + ps);
                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        totalUsers = rs.getString("totalRegisteredUsers");
                    } else {
                        totalUsers = "0";
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println(totalUsers);
        return totalUsers;
    }

    /**
     *
     * This method is for total revenue generated
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public String getTotalRevenue() {
        String totalRevenue = null;
        String moneyString = null;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT sum(planAmount) as revenue FROM claims c,plans p where c.planId=p.planId";

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                //System.out.println("ps:" + ps);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        totalRevenue = rs.getString("revenue");
                    } else {
                        totalRevenue = "0";
                    }
                    float amount = (float) Double.parseDouble(totalRevenue);

                    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

                    moneyString = formatter.format(amount);

                    System.out.println(moneyString);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (log.isEnabledFor(org.apache.log4j.Level.ERROR)) {
                String msg = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage();
                log.error(msg);
            }
        }
        //System.out.println(totalUsers);
        return moneyString;
    }
}
