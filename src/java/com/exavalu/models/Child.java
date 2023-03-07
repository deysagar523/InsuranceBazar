/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

/**
 *
 * @author user
 */
public class Child {

    /**
     * @return the medicalHistory
     */
    public String getMedicalHistory() {
        return medicalHistory;
    }

    /**
     * @param medicalHistory the medicalHistory to set
     */
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    /**
     * @return the childId
     */
    public String getChildId() {
        return childId;
    }

    /**
     * @param childId the childId to set
     */
    public void setChildId(String childId) {
        this.childId = childId;
    }

    /**
     * @return the childAge
     */
    public String getChildAge() {
        return childAge;
    }

    /**
     * @param childAge the childAge to set
     */
    public void setChildAge(String childAge) {
        this.childAge = childAge;
    }

    

    /**
     * @return the weightage
     */
    public String getWeightage() {
        return weightage;
    }

    /**
     * @param weightage the weightage to set
     */
    public void setWeightage(String weightage) {
        this.weightage = weightage;
    }
    
    private String childId, childAge, medicalHistory, weightage;
    
}
