/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;
import com.exavalu.services.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
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
    private String email,password,role,fullName,userId,countryCode,stateCode,districtCode,phone, gender,dob;

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
            System.out.println("Returning Success from doSignUp method");
            result = "SUCCESS";
        } else {
            System.out.println("Returning Failure from doSignUp method");
        }

        return result;
    }

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doLogin(this);

        if (success) {
            System.out.println("Returning Success from doLogin method");
            User user = LoginService.getUser(this.getEmail());
            if(user.getRole().equals("1")){
                result = "USER";
            }
            else if(user.getRole().equals("2")){
                result = "UNDERWRITER";
            }
            else {
                result ="OFFICER";
            }
//            ArrayList fnolList = FNOLService.getAllFnols();
//            sessionMap.put("fnolList", fnolList);
            sessionMap.put("User", user);
//            result = "SUCCESS";
        } else {
            System.out.println("Returning Failure from doLogin method");
        }

        return result;
    }

    public String doLogOut() throws Exception {
        String result = "SUCCESS";

        sessionMap.clear();

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