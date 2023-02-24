/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

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
    private int policyId,categoryId;
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
     * @return the policyId
     */
    public int getPolicyId() {
        return policyId;
    }

    /**
     * @param policyId the policyId to set
     */
    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
    
}
