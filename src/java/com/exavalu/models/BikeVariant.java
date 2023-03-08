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
public class BikeVariant extends ActionSupport implements SessionAware, Serializable{

    /**
     * @return the bikeModelCode
     */
    public String getBikeModelCode() {
        return bikeModelCode;
    }

    /**
     * @param bikeModelCode the bikeModelCode to set
     */
    public void setBikeModelCode(String bikeModelCode) {
        this.bikeModelCode = bikeModelCode;
    }

    /**
     * @return the bikeVariantId
     */
    public String getBikeVariantId() {
        return bikeVariantId;
    }

    /**
     * @param bikeVariantId the bikeVariantId to set
     */
    public void setBikeVariantId(String bikeVariantId) {
        this.bikeVariantId = bikeVariantId;
    }

    /**
     * @return the bikeVariant
     */
    public String getBikeVariant() {
        return bikeVariant;
    }

    /**
     * @param bikeVariant the bikeVariant to set
     */
    public void setBikeVariant(String bikeVariant) {
        this.bikeVariant = bikeVariant;
    }
    
    private String bikeModelCode, bikeVariantId, bikeVariant;
    
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
    

    
    public String doFetchBikeVars(){
        String result="FAILURE";
        System.out.println("within dobikevars");
        System.out.println("bikeModelCode: "+this.getBikeModelCode());
        if(this.getBikeModelCode()!=null){
            System.out.println("bikeModelCode: "+this.getBikeModelCode());
            ArrayList vars= ClaimService.getBikeVariants(this.getBikeModelCode());
            System.out.println("vars: "+vars.size());
            result="SUCCESS";
            getSessionMap().put("vars", vars);
            
        }
        
        
        return result;
    }
    
}
