/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.interceptor.ApplicationAware;
/**
 *This is Plan model where all the instance variables are declared and CRUD operations are written
 * @author user
 */
public class Plan extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    /**
     * @return the planIDV
     */
    public String getPlanIDV() {
        return planIDV;
    }

    /**
     * @param planIDV the planIDV to set
     */
    public void setPlanIDV(String planIDV) {
        this.planIDV = planIDV;
    }

  

    /**
     * @return the lumpSumPayout
     */
    public String getLumpSumPayout() {
        return lumpSumPayout;
    }

    /**
     * @param lumpSumPayout the lumpSumPayout to set
     */
    public void setLumpSumPayout(String lumpSumPayout) {
        this.lumpSumPayout = lumpSumPayout;
    }

    /**
     * @return the coverAmount
     */
    public String getCoverAmount() {
        return coverAmount;
    }

    /**
     * @param coverAmount the coverAmount to set
     */
    public void setCoverAmount(String coverAmount) {
        this.coverAmount = coverAmount;
    }
    private String planId; 
    private String policyId;
    private String planCompany; 
    private String planDuration; 
    private String planAmount;
    private String policyName;
    private String planIDV;
    private String lumpSumPayout; 
    private String coverAmount;
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
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
     * @return the planId
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * @param planId the planId to set
     */
    public void setPlanId(String planId) {
        this.planId = planId;
    }

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
     * @return the planCompany
     */
    public String getPlanCompany() {
        return planCompany;
    }

    /**
     * @param planCompany the planCompany to set
     */
    public void setPlanCompany(String planCompany) {
        this.planCompany = planCompany;
    }

    /**
     * @return the planDuration
     */
    public String getPlanDuration() {
        return planDuration;
    }

    /**
     * @param planDuration the planDuration to set
     */
    public void setPlanDuration(String planDuration) {
        this.planDuration = planDuration;
    }

    /**
     * @return the planAmount
     */
    public String getPlanAmount() {
        return planAmount;
    }

    /**
     * @param planAmount the planAmount to set
     */
    public void setPlanAmount(String planAmount) {
        this.planAmount = planAmount;
    }
    
    

    
    
    
}
