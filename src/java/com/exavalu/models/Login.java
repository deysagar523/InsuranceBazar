///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.exavalu.models;
//
//import com.exavalu.services.CategoryService;
//import com.exavalu.services.LoginService;
//import java.util.ArrayList;
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.util.logging.Logger;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Map;
//import org.apache.struts2.dispatcher.SessionMap;
//import org.apache.struts2.interceptor.SessionAware;
//import org.apache.struts2.dispatcher.ApplicationMap;
//
//import org.apache.struts2.interceptor.ApplicationAware;
//
///**
// *
// * @author user
// */
//public class Login extends ActionSupport implements ApplicationAware, SessionAware, Serializable{
//    
//    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();
//
//    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();
//
//    @Override
//    public void setApplication(Map<String, Object> application) {
//        map = (ApplicationMap) application;
//    }
//
//    @Override
//    public void setSession(Map<String, Object> session) {
//        sessionMap = (SessionMap) session;
//    }
//
//    /**
//     * @return the email
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     * @param email the email to set
//     */
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    /**
//     * @return the password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * @param password the password to set
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    private String email, password;
//    
//    public String doLogin() throws Exception {
//        String result = LoginService.getInstance().doLogin(this.email, this.password);
//
//  
//
//        if (result.equalsIgnoreCase("USER")) {
//            
//            sessionMap.put("User", User.getInstance());
//            
//            ArrayList categories= CategoryService.getAllCategories();
//            sessionMap.put("Categories", categories);
//            System.out.println("userId: "+ User.getInstance().getUserId());
//            System.out.println("Returning Success from doLogin method");
////            User user = LoginService.getUser(this.getEmail());
//            
////            ArrayList fnolList = FNOLService.getAllFnols();
////            sessionMap.put("fnolList", fnolList);
//            
//            
////            result = "SUCCESS";
//        } else if(result.equalsIgnoreCase("UNDERWRITER")){
//            
//        }else if(result.equalsIgnoreCase("OFFICER")){
//            
//        }
//        else {
//            System.out.println("Returning Failure from doLogin method");
//            
//        }
//
//        return result;
//    }
//    
//    public String doLogOut() throws Exception {
//        String result = "SUCCESS";
//
//        sessionMap.clear();
//
//        return result;
//    }
//    
//}
