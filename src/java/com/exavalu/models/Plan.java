/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

/**
 *
 * @author user
 */
public class Plan {

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
    
    private String planId, policyId, planCompany, planDuration, planAmount, policyName;

    
    
    
}
