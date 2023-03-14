/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Claim;
import com.exavalu.models.InsuranceOfficerHistory;
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
 * Service Class that stores all the business logics involving the features of
 * insurance officer in terms of updating the claim status from approved to
 * issued and read data from the database
 *
 * @author LENOVO
 */
public class InsuranceOfficerService {

    private static final Logger log = Logger.getLogger(InsuranceOfficerService.class);
    public static InsuranceOfficerService insuranceOfficerService = null;

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
    public static InsuranceOfficerService getInstance() {
        if (insuranceOfficerService == null) {
            return new InsuranceOfficerService();
        } else {
            return insuranceOfficerService;
        }
    }

    /**
     *
     * This method is for getting all the approved mediclaim insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedHealthMediclaimClaims() {
        ArrayList approvedHealthMediclaimPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p,relatives r where c.relation=r.relationCode and c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedHealthMediclaimPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of approved mediclaim policy list = " + approvedHealthMediclaimPolicyList.size());
        return approvedHealthMediclaimPolicyList;
    }

    /**
     *
     * This method is for getting all the approved critical illness insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedHealthCriticalIllnessClaims() {
        ArrayList approvedHealthCriticalIllnessPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedHealthCriticalIllnessPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending mediclaim policy list = " + approvedHealthCriticalIllnessPolicyList.size());
        return approvedHealthCriticalIllnessPolicyList;
    }

    /**
     *
     * This method is for getting all the approved two wheeler insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedCarTwoWheelerClaims() {
        ArrayList approvedCarTwoWheelerPolicyList = new ArrayList();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedCarTwoWheelerPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Number of pending list two wheeler = " + approvedCarTwoWheelerPolicyList.size());
        return approvedCarTwoWheelerPolicyList;
    }

    /**
     *
     * This method is for getting all the approved four wheeler insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedCarFourWheelerClaims() {
        ArrayList approvedCarFourWheelerPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedCarFourWheelerPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return approvedCarFourWheelerPolicyList;
    }

    /**
     *
     * This method is for getting all the approved life insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedTermLifeInsuranceClaims() {
        ArrayList approvedTermLifeInsurancePolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedTermLifeInsurancePolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return approvedTermLifeInsurancePolicyList;
    }

    /**
     *
     * This method is for getting all the approved nri insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedTermForNriClaims() {
        ArrayList approvedTermForNriPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedTermForNriPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return approvedTermForNriPolicyList;
    }

    /**
     *
     * This method is for getting all the approved child investment insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedInvestmentChildClaims() {
        ArrayList approvedInvestmentChildPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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

                claim.setCategoryName(rs.getString("categoryName"));

                claim.setChildName(rs.getString("childName"));
                claim.setDob(rs.getString("dob"));

//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                approvedInvestmentChildPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return approvedInvestmentChildPolicyList;
    }

    /**
     *
     * This method is for getting all the approved pension insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedInvestmentPensionClaims() {
        ArrayList approvedInvestmentPensionPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedInvestmentPensionPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return approvedInvestmentPensionPolicyList;
    }

    /**
     *
     * This method is for getting all the approved travel insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedOtherTravelClaims() {
        ArrayList approvedOtherTravelPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedOtherTravelPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return approvedOtherTravelPolicyList;
    }

    /**
     *
     * This method is for getting all the approved education insurance
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllApprovedOtherEducationalClaims() {
        ArrayList approvedOtherEducationalPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,policies p where c.userId=u.userId  and c.policyId=p.policyId and claimStatus=?  and p.policyId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, "2");

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
                approvedOtherEducationalPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return approvedOtherEducationalPolicyList;
    }

    /**
     *
     * This method is for insurance officer to sanction a policy which is being
     * approved by the underwriter
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public boolean sanctionPolicy(String claimId) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancebazardb.claims\n"
                    + "SET claimStatus = ? where claimId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            //status 3 = sanctioned by the io
            preparedStatement.setString(1, "3");
            preparedStatement.setString(2, claimId);

//            System.out.println("sql="+preparedStatement);
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        System.out.println("Result is = " + result);
        return result;

    }

    /**
     *
     * This method is for insurance officer if he sanctions any policy then it
     * goes to the sanctioed history section
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public void addToSanctionedHistory(String claimId) {
        String sql = "INSERT INTO insurance_officer_histories(claimId,userFullName,userEmail,policyName,claimStatus,timeOfAction)\n" + "VALUES(? ,?,?,?,?,?);";

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
            ps.setString(5, "3");
            ps.setString(6, formattedDateTime);
            //System.out.println("LoginService dosignup :: "+ps);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());

        }

    }

    /**
     *
     * This method is for insurance officer to get all the sanctioned policies
     *
     *
     *
     *
     *
     *
     *
     *      
     */
    public ArrayList getAllSanctionedHistories() {
        ArrayList histories = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from insurance_officer_histories";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                InsuranceOfficerHistory history = new InsuranceOfficerHistory();

                history.setClaimId(rs.getString("claimId"));
                history.setPolicyName(rs.getString("policyName"));
                history.setUserEmail(rs.getString("userEmail"));
                history.setUserFullName(rs.getString("userFullName"));
                history.setTimeOfAction(rs.getString("timeOfAction"));
                histories.add(history);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger log = Logger.getLogger(InsuranceOfficerService.class.getName());
            log.error(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)) + " " + ex.getMessage());
        }
        //System.out.println("Number of pending list = " + pendingLifePolicyList.size());
        return histories;
    }
}
