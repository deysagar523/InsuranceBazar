/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.LoginService;
import com.exavalu.services.PolicyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author LENOVO
 */
public class Policy extends ActionSupport implements SessionAware, Serializable {

    /**
     * @return the policyId
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * @param policyId the policyId to set
     */
    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    private String policyId,categoryId;
    private String policyName,policyExpiryDate,policyAmount,policyDescription;
    
     private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();


  
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    

    

    /**
     * @return the policyName
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * @param policyName the policyName to set
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    /**
     * @return the policyExpiryDate
     */
    public String getPolicyExpiryDate() {
        return policyExpiryDate;
    }

    /**
     * @param policyExpiryDate the policyExpiryDate to set
     */
    public void setPolicyExpiryDate(String policyExpiryDate) {
        this.policyExpiryDate = policyExpiryDate;
    }

    /**
     * @return the policyAmount
     */
    public String getPolicyAmount() {
        return policyAmount;
    }

    /**
     * @param policyAmount the policyAmount to set
     */
    public void setPolicyAmount(String policyAmount) {
        this.policyAmount = policyAmount;
    }

    /**
     * @return the policyDescription
     */
    public String getPolicyDescription() {
        return policyDescription;
    }

    /**
     * @param policyDescription the policyDescription to set
     */
    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the map
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }
    
    public String doGetPolicyDetails(){
        String result="SUCCESS";
        Policy policy= PolicyService.getPolicyDetails(this.getPolicyId());
        
        sessionMap.put("Policy", policy);
        if(policy.getPolicyName().equals("Two Wheeler")){
            result="TWOWHEELER";
        }else if(policy.getPolicyName().equals("Four Wheeler")){
            System.out.println("this is"+policy.getPolicyName());
            result="FOURWHEELER";
        }else if(policy.getPolicyName().equals("Travel Insurance")){
            System.out.println("this is"+policy.getPolicyName());
            result="TRAVEL";
        }
        else if(policy.getCategoryId().equals("1")){
            result="HEALTH";
        }else if(policy.getPolicyName().equals("Education Plan")){
            result="EDUCATION";
        }else if(policy.getPolicyName().equals("Pension Plan")){
            result="PENSION";
        }else if(policy.getPolicyName().equals("Child Investment")){
            result="CHILD";
        }
        else if(policy.getPolicyName().equals("Life Insurance")){
            result="LIFE";
        }
        else{
            result= "NRI";
        }
        return result;
    }
    
}
