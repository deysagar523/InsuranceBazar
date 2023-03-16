/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;
import com.exavalu.services.ClaimService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *The model has all the instance variables declared and it deals with fetching bike models corrresponding to the bike make
 * @author user
 */

public class BikeModel extends ActionSupport implements SessionAware, Serializable{

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
     * @return the bikeModelId
     */
    public String getBikeModelId() {
        return bikeModelId;
    }

    /**
     * @param bikeModelId the bikeModelId to set
     */
    public void setBikeModelId(String bikeModelId) {
        this.bikeModelId = bikeModelId;
    }

    /**
     * @return the bikeMakeCode
     */
    public String getBikeMakeCode() {
        return bikeMakeCode;
    }

    /**
     * @param bikeMakeCode the bikeMakeCode to set
     */
    public void setBikeMakeCode(String bikeMakeCode) {
        this.bikeMakeCode = bikeMakeCode;
    }

    /**
     * @return the bikeModel
     */
    public String getBikeModel() {
        return bikeModel;
    }

    /**
     * @param bikeModel the bikeModel to set
     */
    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }
    private String bikeModelId;
    
    private String bikeMakeCode;
    private String bikeModel; 
    private String bikeModelCode;
    
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
    

    public String doFetchBikeModels(){
        System.out.println("this:"+this.getBikeModelId()+" "+ this.getBikeMakeCode()+ " "+this.getBikeModel());
        
        String result="FAILURE";
        System.out.println("within dobikemodels");
        System.out.println("bikeMakeCode: "+this.getBikeMakeCode());
        if(this.getBikeMakeCode()!=null){
            System.out.println("bikeMakeCode: "+this.getBikeMakeCode());
            List models= ClaimService.getInstance().getBikeModels(this.getBikeMakeCode());
            System.out.println("models: "+models.size());
            result="SUCCESS";
            getSessionMap().put("models", models);
            
        }
        
        
        return result;
    }
    
}
