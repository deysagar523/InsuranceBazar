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
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *The model has all the instance variables declared and it deals with fetching relative data corrresponding to the relative type
 * @author user
 */
public class Relative extends ActionSupport implements SessionAware, Serializable{
    
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
     * @return the relativeId
     */
    public String getRelativeId() {
        return relativeId;
    }

    /**
     * @param relativeId the relativeId to set
     */
    public void setRelativeId(String relativeId) {
        this.relativeId = relativeId;
    }

    /**
     * @return the relationCode
     */
    public String getRelationCode() {
        return relationCode;
    }

    /**
     * @param relationCode the relationCode to set
     */
    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode;
    }

    /**
     * @return the relativeType
     */
    public String getRelativeType() {
        return relativeType;
    }

    /**
     * @param relativeType the relativeType to set
     */
    public void setRelativeType(String relativeType) {
        this.relativeType = relativeType;
    }
    
    private String relativeId; 
    private String relationCode;
    private String relativeType;
    
    public String doFetchRelativeType(){
        String result="FAILURE";
        System.out.println("relationcode: "+this.relationCode);
        if(this.relationCode!=null && !this.relationCode.equalsIgnoreCase("SE")){
            System.out.println("relationCode: "+this.relationCode);
            List relatives= ClaimService.getInstance().getRelatives(this.relationCode);
            System.out.println("relatives: "+relatives.size());
            result="SUCCESS";
            sessionMap.put("relatives", relatives);
            
        }
        return result;
    }
    
    
    
}
