/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;


import com.exavalu.services.DmvService;
import com.exavalu.services.FnolService;
import com.exavalu.services.LoginService;
import com.exavalu.services.PolicyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;


/**
 *
 * @author Nairwita Chakraborty
 */
public class Fnol extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the fnolStatus
     */
    public String getFnolStatus() {
        return fnolStatus;
    }

    /**
     * @param fnolStatus the fnolStatus to set
     */
    public void setFnolStatus(String fnolStatus) {
        this.fnolStatus = fnolStatus;
    }

    /**
     * @return the driverId
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * @param driverId the driverId to set
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    private String fnolId;
    private int userId;
    private String policyId;
    private String title;
    private String description;
    private String claimDate;
    private String incidentLocation;
    private String fnolStatus;
    private String driverName;
    private String driverId;
    private String email;
    private String licenseNumber;
    private String carModel;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String phone;
    private String address;
    private String body;

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
    
    
    
    
  
    public String doAddFnol() {

        String result = "FAILURE";

        Fnol fnol = new Fnol();
        fnol.setUserId(getUserId());
        fnol.setPolicyId(policyId);
        fnol.setDriverName(driverName);
        fnol.setDescription(description);
        fnol.setClaimDate(claimDate);
        fnol.setIncidentLocation(incidentLocation);
        fnol.setFnolStatus(getFnolStatus());

        boolean res = FnolService.addFnol(fnol);
        if (res) {
            result = "SUCCESS";
            ArrayList fnolList= FnolService.getUserFnols(this.getUserId());
            getSessionMap().put("Success", "successfull");
            sessionMap.put("fnolList", fnolList);
            System.out.println("Successfully Filed");
        } else {
            System.out.println("FNOL not filed!");
        }
        return result;
    }

    public String doUpdateFnolStatus(){
        
        String result= "FAILURE";
        System.out.println("Current FNOL id: "+this.getFnolId());
        boolean res = FnolService.updateFnolStatus(this.getFnolId());
        
        if(res){
            result="SUCCESS";
            ArrayList fnolList = FnolService.getAllFnols();
            getSessionMap().put("successUpdate", "statusUpdated");
            System.out.println("FNOL status updated");
            getSessionMap().put("fnolList", fnolList);
            
        }else{
            System.out.println(" FNOL status not updated");
        }
        return result;
    }
    
    public String doRejectFnol(){
        
        String result= "FAILURE";
        System.out.println("Current FNOL id: "+this.getFnolId());
        boolean res = FnolService.rejectFnol(this.getFnolId());
        
        if(res){
            result="SUCCESS";
            ArrayList fnolList = FnolService.getAllFnols();
            getSessionMap().put("successUpdateTo-1", "statusUpdatedTo-1");
            System.out.println("FNOL status updated to -1");
            getSessionMap().put("fnolList", fnolList);
            
        }else{
            System.out.println(" FNOL status not updated to -1");
        }
        return result;
    }
    
    public String doSanctionFnol(){
        
        String result= "FAILURE";
        System.out.println("Current FNOL id: "+this.getFnolId());
        boolean res = FnolService.sanctionFnol(this.getFnolId());
       
        if(res){
            result="SUCCESS";
            ArrayList fnolList = FnolService.getAllUpdatedFnols();
            getSessionMap().put("successUpdateTo2", "statusUpdatedTo2");
            System.out.println("FNOL status updated to 2");
            getSessionMap().put("fnolList", fnolList);
            
        }else{
            System.out.println(" FNOL status not updated to 2");
        }
        return result;
    }
    
    
    
    public String doViewFnol(){
        
        String result="SUCCESS";
        System.out.println("Current fnol is: "+this.getFnolId());
        Fnol fnol= FnolService.getFnol(this.getFnolId());
       
        getSessionMap().put("successUpdate", "viewSuccess");
        System.out.println("FROM FNOL MODEL:  FNOL FETCHED");
        getSessionMap().put("fnol", fnol);
            
        
        return result;
    }
    
    public String doSearchFnols(){
        String result="FAILURE";
        ArrayList fnolList= FnolService.searchFnols(fnolId);
        System.out.println("Fnol Id: "+fnolId);
        System.out.println("fnolList: "+fnolList.size());
        if(!fnolList.isEmpty()){
            sessionMap.put("fnolList", fnolList);
            result="SUCCESS";
        }
        else{
            result="FAILURE";
        }
        return result;
    }
    
    public String doViewPolicy(){
        
        String result="SUCCESS";
        System.out.println("Current policy is: "+this.getPolicyId());
        Fnol fnol= FnolService.getFnolByPolicyId(this.getPolicyId());
       
        sessionMap.put("successUpdate", "viewSuccess");
        System.out.println("FROM FNOL MODEL:  POLICY FETCHED");
        sessionMap.put("fnol", fnol);
            
        
        return result;
    }
    
    public String doViewDriver(){
        
        String result="SUCCESS";
        System.out.println("Current driver is: "+this.getDriverName());
        Fnol fnol= FnolService.getFnolByDriverName(this.getDriverName());
       
        sessionMap.put("successUpdate", "viewSuccess");
        System.out.println("FROM FNOL MODEL:  Driver FETCHED");
        sessionMap.put("fnol", fnol);
            
        
        return result;
    }
    
    public String doGetFnols(){
        String result="FAILURE";
        ArrayList fnolList= FnolService.getAllFnols();
       
        System.out.println("fnolList: "+fnolList.size());
        if(!fnolList.isEmpty()){
            sessionMap.put("fnolList", fnolList);
            result="SUCCESS";
        }
        else{
            result="FAILURE";
        }
        return result;
    }
    
    

    /**
     * @return the fnolId
     */
    public String getFnolId() {
        return fnolId;
    }

    /**
     * @param fnolId the fnolId to set
     */
    public void setFnolId(String fnolId) {
        this.fnolId = fnolId;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the claimDate
     */
    public String getClaimDate() {
        return claimDate;
    }

    /**
     * @param claimDate the claimDate to set
     */
    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    /**
     * @return the incidentLocation
     */
    public String getIncidentLocation() {
        return incidentLocation;
    }

    /**
     * @param incidentLocation the incidentLocation to set
     */
    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    

    /**
     * @return the driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName the driverName to set
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the licenseNumber
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * @param licenseNumber the licenseNumber to set
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * @return the carModel
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * @param carModel the carModel to set
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel;
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
