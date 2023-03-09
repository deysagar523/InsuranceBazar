/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.CategoryService;
import com.exavalu.services.ClaimService;
import com.exavalu.services.InsuranceOfficerService;
import com.exavalu.services.LoginService;
import com.exavalu.services.PlanService;
import com.exavalu.services.UnderwriterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.ApplicationMap;

import org.apache.struts2.interceptor.ApplicationAware;

/**
 *
 * @author HP
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the imageData
     */
    public String getImageData() {
        return imageData;
    }

    /**
     * @param imageData the imageData to set
     */
    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    /**
     * @return the image
     */
    public File getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(File image) {
        this.image = image;
    }

    /**
     * @return the incomeSource
     */
    public String getIncomeSource() {
        return incomeSource;
    }

    /**
     * @param incomeSource the incomeSource to set
     */
    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    private String email, password, role, fullName, userId, countryCode, stateCode, districtCode, phone, gender, dob;
    private String incomeSource;
    private String imageData;
    private File image;
    private String age;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }

    public String doSignUp() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doSignUp(this);

        if (success) {
            MailSender.sendEmailToRegisterUser(this.email);
            System.out.println("Returning Success from doSignUp method");
            String successMsg = "Account created successfully";
            sessionMap.put("SuccessMsgForSignUp", successMsg);
            result = "SUCCESS";
        } else {
            String errorMsg = "Email Already Exists! Try with anotherEmail";
            sessionMap.put("ErrorMsgForSignUp", errorMsg);
            System.out.println("Returning Failure from doSignUp method");
        }

        return result;
    }

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doLogin(this);

        if (success) {
            ArrayList planList = PlanService.getAllBikePlans();
            ArrayList childPlanList = PlanService.getAllChildPlans();
            ArrayList medPlanList = PlanService.getAllMedPlans();

            System.out.println("Returning Success from doLogin method");
            User user = LoginService.getUser(this.getEmail());
//            System.out.println("gender:"+user.getGender()+" phone:"+user.getPhone());
            if (user.getRole().equals("1")) {
                sessionMap.put("Plans", planList);
                sessionMap.put("ChildPlans", childPlanList);
                sessionMap.put("MedPlans", medPlanList);
                sessionMap.put("userId", user.userId);
                result = "USER";
            } else if (user.getRole().equals("2")) {
                result = "UNDERWRITER";
                String todayDateElement = UnderwriterService.elementsForXaxis("0");
                sessionMap.put("CurrentDay", todayDateElement);
                String day1 = UnderwriterService.elementsForXaxis("-1");
                sessionMap.put("Day1", day1);
                String day2 = UnderwriterService.elementsForXaxis("-2");
                sessionMap.put("Day2", day2);
                String day3 = UnderwriterService.elementsForXaxis("-3");
                sessionMap.put("Day3", day3);
                String day4 = UnderwriterService.elementsForXaxis("-4");
                sessionMap.put("Day4", day4);
                String day5 = UnderwriterService.elementsForXaxis("-5");
                sessionMap.put("Day5", day5);

//                System.out.println(todayDateElement);
//                 System.out.println(day1);
//                  System.out.println(day2);
//                   System.out.println(day3);
//                    System.out.println(day4);
//                     System.out.println(day5);
                String todayRegisteration = UnderwriterService.totalRegisteredUsers("0");
                sessionMap.put("TodayUsers", todayRegisteration);
                String day1User = UnderwriterService.totalRegisteredUsers("-1");
                sessionMap.put("Day1Users", day1User);
                String day2User = UnderwriterService.totalRegisteredUsers("-2");
                sessionMap.put("Day2Users", day2User);
                String day3User = UnderwriterService.totalRegisteredUsers("-3");
                sessionMap.put("Day3Users", day3User);

                String day4User = UnderwriterService.totalRegisteredUsers("-4");
                sessionMap.put("Day4Users", day4User);

                String day5User = UnderwriterService.totalRegisteredUsers("-5");
                sessionMap.put("Day5Users", day5User);
                
                
                String todayPolicy = UnderwriterService.totalBoughtPlans("0");
                sessionMap.put("TodayPolicy", todayPolicy);
                String day1Policy = UnderwriterService.totalBoughtPlans("-1");
                sessionMap.put("Day1Policy", day1Policy);
                String day2Policy = UnderwriterService.totalBoughtPlans("-2");
                sessionMap.put("Day2Policy", day2Policy);
                String day3Policy = UnderwriterService.totalBoughtPlans("-3");
                sessionMap.put("Day3Policy", day3Policy);

                String day4Policy = UnderwriterService.totalBoughtPlans("-4");
                sessionMap.put("Day4Policy", day4Policy);

                String day5Policy = UnderwriterService.totalBoughtPlans("-5");
                sessionMap.put("Day5Policy", day5Policy);
                
                String totalNoOfUsers=UnderwriterService.getInstance().getNoOfUsers();
                sessionMap.put("TotalUsers", totalNoOfUsers);
                String totalRevenue=UnderwriterService.getInstance().getTotalRevenue();
                sessionMap.put("TotalRevenue", totalRevenue);
                

//                System.out.println("today "+todayPolicy);
//                 System.out.println("1 "+day1Policy);
//                  System.out.println("2 "+day2Policy);
//                   System.out.println("3 "+day3Policy);
//                    System.out.println("4 "+day4Policy);
//                     System.out.println("5 "+day5Policy);
                ArrayList underwriter_approved_histories = UnderwriterService.getInstance().getAllApprovedHistories();
                sessionMap.put("UnderwriterApprovedHistories", underwriter_approved_histories);
                ArrayList underwriter_rejected_histories = UnderwriterService.getInstance().getAllRejectedHistories();
                sessionMap.put("UnderwriterRejectedHistories", underwriter_rejected_histories);
                ArrayList allPendingMediclaimClaims = UnderwriterService.getInstance().getAllPendingHealthMediclaimClaims();
                ArrayList allPendingCriticalIllnessClaims = UnderwriterService.getInstance().getAllPendingHealthCriticalIllnessClaims();
                ArrayList allPendingTwoWheelerClaims = UnderwriterService.getInstance().getAllPendingCarTwoWheelerClaims();
                ArrayList allPendingFourWheelerClaims = UnderwriterService.getInstance().getAllPendingCarFourWheelerClaims();
                ArrayList allPendingLifeInsuranceClaims = UnderwriterService.getInstance().getAllPendingTermLifeInsuranceClaims();
                ArrayList allPendingTermForNriClaims = UnderwriterService.getInstance().getAllPendingTermForNriClaims();
                ArrayList allPendingChildInvestmentClaims = UnderwriterService.getInstance().getAllPendingInvestmentChildClaims();
                ArrayList allPendingPensionPlanClaims = UnderwriterService.getInstance().getAllPendingInvestmentPensionClaims();
                ArrayList allPendingTravelClaims = UnderwriterService.getInstance().getAllPendingOtherTravelClaims();
                ArrayList allPendingEducationalPlanClaims = UnderwriterService.getInstance().getAllPendingOtherEducationalClaims();

                sessionMap.put("AllPendingMediclaimClaims", allPendingMediclaimClaims);
                sessionMap.put("AllPendingCriticalIllnessClaims", allPendingCriticalIllnessClaims);
                sessionMap.put("AllPendingTwoWheelerClaims", allPendingTwoWheelerClaims);
                sessionMap.put("AllPendingFourWheelerClaims", allPendingFourWheelerClaims);
                sessionMap.put("AllPendingLifeInsuranceClaims", allPendingLifeInsuranceClaims);
                sessionMap.put("AllPendingTermForNriClaims", allPendingTermForNriClaims);
                sessionMap.put("AllPendingChildInvestmentClaims", allPendingChildInvestmentClaims);
                sessionMap.put("AllPendingPensionPlanClaims", allPendingPensionPlanClaims);
                sessionMap.put("AllPendingTravelClaims", allPendingTravelClaims);
                sessionMap.put("AllPendingEducationalPlanClaims", allPendingEducationalPlanClaims);
            } else {
                result = "OFFICER";
                String todayDateElement = UnderwriterService.elementsForXaxis("0");
                sessionMap.put("CurrentDay", todayDateElement);
                String day1 = UnderwriterService.elementsForXaxis("-1");
                sessionMap.put("Day1", day1);
                String day2 = UnderwriterService.elementsForXaxis("-2");
                sessionMap.put("Day2", day2);
                String day3 = UnderwriterService.elementsForXaxis("-3");
                sessionMap.put("Day3", day3);
                String day4 = UnderwriterService.elementsForXaxis("-4");
                sessionMap.put("Day4", day4);
                String day5 = UnderwriterService.elementsForXaxis("-5");
                sessionMap.put("Day5", day5);
                
                String todayPolicy = UnderwriterService.totalBoughtPlans("0");
                sessionMap.put("TodayPolicy", todayPolicy);
                String day1Policy = UnderwriterService.totalBoughtPlans("-1");
                sessionMap.put("Day1Policy", day1Policy);
                String day2Policy = UnderwriterService.totalBoughtPlans("-2");
                sessionMap.put("Day2Policy", day2Policy);
                String day3Policy = UnderwriterService.totalBoughtPlans("-3");
                sessionMap.put("Day3Policy", day3Policy);

                String day4Policy = UnderwriterService.totalBoughtPlans("-4");
                sessionMap.put("Day4Policy", day4Policy);

                String day5Policy = UnderwriterService.totalBoughtPlans("-5");
                sessionMap.put("Day5Policy", day5Policy);


//                System.out.println(todayDateElement);
//                 System.out.println(day1);
//                  System.out.println(day2);
//                   System.out.println(day3);
//                    System.out.println(day4);
//                     System.out.println(day5);
                String todayRegisteration = UnderwriterService.totalRegisteredUsers("0");
                sessionMap.put("TodayUsers", todayRegisteration);
                String day1User = UnderwriterService.totalRegisteredUsers("-1");
                sessionMap.put("Day1Users", day1User);
                String day2User = UnderwriterService.totalRegisteredUsers("-2");
                sessionMap.put("Day2Users", day2User);
                String day3User = UnderwriterService.totalRegisteredUsers("-3");
                sessionMap.put("Day3Users", day3User);

                String day4User = UnderwriterService.totalRegisteredUsers("-4");
                sessionMap.put("Day4Users", day4User);

                String day5User = UnderwriterService.totalRegisteredUsers("-5");
                sessionMap.put("Day5Users", day5User);

//                System.out.println("today"+todayRegisteration);
//                 System.out.println("1"+day1User);
//                  System.out.println("2"+day2User);
//                   System.out.println("3"+day3User);
//                    System.out.println("4"+day4User);
//                     System.out.println("5"+day5User);
                ArrayList insuranceOfficer_sanctioned_histories = InsuranceOfficerService.getInstance().getAllSanctionedHistories();
                sessionMap.put("InsuranceOfficerSanctionedHistories", insuranceOfficer_sanctioned_histories);
                ArrayList allApprovedMediclaimClaims = InsuranceOfficerService.getInstance().getAllApprovedHealthMediclaimClaims();
                ArrayList allApprovedCriticalIllnessClaims = InsuranceOfficerService.getInstance().getAllApprovedHealthCriticalIllnessClaims();
                ArrayList allApprovedTwoWheelerClaims = InsuranceOfficerService.getInstance().getAllApprovedCarTwoWheelerClaims();
                ArrayList allApprovedFourWheelerClaims = InsuranceOfficerService.getInstance().getAllApprovedCarFourWheelerClaims();
                ArrayList allApprovedLifeInsuranceClaims = InsuranceOfficerService.getInstance().getAllApprovedTermLifeInsuranceClaims();
                ArrayList allApprovedTermForNriClaims = InsuranceOfficerService.getInstance().getAllApprovedTermForNriClaims();
                ArrayList allApprovedChildInvestmentClaims = InsuranceOfficerService.getInstance().getAllApprovedInvestmentChildClaims();
                ArrayList allApprovedPensionPlanClaims = InsuranceOfficerService.getInstance().getAllApprovedInvestmentPensionClaims();
                ArrayList allApprovedTravelClaims = InsuranceOfficerService.getInstance().getAllApprovedOtherTravelClaims();
                ArrayList allApprovedEducationalPlanClaims = InsuranceOfficerService.getInstance().getAllApprovedOtherEducationalClaims();

                sessionMap.put("AllApprovedMediclaimClaims", allApprovedMediclaimClaims);
                sessionMap.put("AllApprovedCriticalIllnessClaims", allApprovedCriticalIllnessClaims);
                sessionMap.put("AllApprovedTwoWheelerClaims", allApprovedTwoWheelerClaims);
                sessionMap.put("AllApprovedFourWheelerClaims", allApprovedFourWheelerClaims);
                sessionMap.put("AllApprovedLifeInsuranceClaims", allApprovedLifeInsuranceClaims);
                sessionMap.put("AllApprovedTermForNriClaims", allApprovedTermForNriClaims);
                sessionMap.put("AllApprovedChildInvestmentClaims", allApprovedChildInvestmentClaims);
                sessionMap.put("AllApprovedPensionPlanClaims", allApprovedPensionPlanClaims);
                sessionMap.put("AllApprovedTravelClaims", allApprovedTravelClaims);
                sessionMap.put("AllApprovedEducationalPlanClaims", allApprovedEducationalPlanClaims);
            }
//            ArrayList fnolList = FNOLService.getAllFnols();
//            sessionMap.put("fnolList", fnolList);
            sessionMap.put("User", user);
            System.out.println(user.getFullName());
//            result = "SUCCESS";
        } else {
            String errorMsg = "Invalid Email Or Password Combination";
            sessionMap.put("ErrorMsgForLogin", errorMsg);
            System.out.println("Returning Failure from doSignUp method");

        }

        return result;
    }

    public String doUpdateUser() throws FileNotFoundException {
        String result = "FAILURE";
        boolean updated = false;
        if (this.image != null) {
            updated = LoginService.updateUser(this, this.userId);
        } else {
            updated = LoginService.updateUser2(this, this.userId);
        }

        System.out.println("user id " + this.userId + "to be updated");
        if (updated) {
            User user = LoginService.getUser(this.email);
            sessionMap.put("User", user);
            System.out.println("user id " + this.phone + "updated");
            result = "SUCCESS";
        } else {

            System.out.println("failed to update");
        }
        return result;
    }

    public String doLogOut() throws Exception {
        String result = "SUCCESS";

        sessionMap.clear();

        return result;
    }

    public String doGetBoughtBikes() {
        String result = "FAILURE";
        ArrayList planList = ClaimService.getBoughtPlans(this.userId);
        System.out.println("bought bikes" + this.userId);
        if (!planList.isEmpty()) {
            System.out.println("planlist fetched");
            sessionMap.put("PlanList", planList);
            result = "SUCCESS";
        } else {
            System.out.println("No plans fetched");
        }
        return result;
    }

//     public String doPreSignup() throws Exception{
//         String result="SUCCESS";
//        ArrayList countryList = LoginService.getInstance().getAllCountries();
//        sessionMap.put("countryList", countryList);
//        
//        if(this.countryCode!=null){
//            ArrayList stateList = LoginService.getInstance().getAllStates(this.countryCode);
//            sessionMap.put("stateList", stateList);
//            sessionMap.put("user", this);
//            result="STATELIST";
//        }
//        
//        if(this.stateCode!=null){
////            ArrayList stateList = LoginService.getInstance().getAllStates(this.countryCode);
////            sessionMap.put("stateList", stateList);
//            ArrayList districtList = LoginService.getInstance().getAllDistricts(this.stateCode);
//            sessionMap.put("districtList", districtList);
//            sessionMap.put("user", this);
//            result="DISTRICTLIST";
//        }
////           if (this.countryCode != null && this.stateCode != null && this.districtCode != null && this.countryCode.length() > 0 && this.stateCode.length() > 0 && this.districtCode.length() > 0) {
//////            boolean success = LoginService.getInstance().doSignup(this);
////            if (success) {
////                result = "DONE";
////                String successMsg = "Account Created,Now Login to your Account";
////
////                sessionMap.put("SignUpSuccessMsg", successMsg);
////
////            } else {
////            org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(LoginService.class.getName());
////            log.error(LocalDateTime.now() + "Existing Email already ");
//////            result = "EXISTS";
//////             String errorMsg = "This Email is already registered..Try with another Email";
//////
//////               sessionMap.put("SignUpFailureMsg", errorMsg);
////}}
////        return result;
////    }
////  
//     
}
