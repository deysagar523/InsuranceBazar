/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;
import com.exavalu.services.ClaimService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


/**
 *
 * @author user
 */
public class Disease extends ActionSupport implements SessionAware, Serializable{

    /**
     * @return the medicalHistoryCode
     */
    public String getMedicalHistoryCode() {
        return medicalHistoryCode;
    }

    /**
     * @param medicalHistoryCode the medicalHistoryCode to set
     */
    public void setMedicalHistoryCode(String medicalHistoryCode) {
        this.medicalHistoryCode = medicalHistoryCode;
    }
    
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
     * @return the diseaseId
     */
    public String getDiseaseId() {
        return diseaseId;
    }

    /**
     * @param diseaseId the diseaseId to set
     */
    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * @return the diseaseName
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * @param diseaseName the diseaseName to set
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

   
    
    private String diseaseId, diseaseName, medicalHistoryCode;
    
    public String doFetchDiseases(){
        String result="FAILURE";
        System.out.println("within dofetchdisesas");
        System.out.println("medicalhistorycode: "+this.medicalHistoryCode);
        if(this.medicalHistoryCode!=null && !this.medicalHistoryCode.equalsIgnoreCase("None")){
            System.out.println("medicalhistorycode: "+this.medicalHistoryCode);
            ArrayList diseases= ClaimService.getDiseases(this.medicalHistoryCode);
            System.out.println("diseeases: "+diseases.size());
            result="SUCCESS";
            sessionMap.put("diseases", diseases);
            
        }
        
        
        return result;
    }
    
}
