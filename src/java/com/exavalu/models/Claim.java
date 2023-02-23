/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;


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
public class Claim extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

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
     * @return the claimId
     */
    public String getClaimId() {
        return claimId;
    }

    /**
     * @param claimId the claimId to set
     */
    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    /**
     * @return the incidentDate
     */
    public String getIncidentDate() {
        return incidentDate;
    }

    /**
     * @param incidentDate the incidentDate to set
     */
    public void setIncidentDate(String incidentDate) {
        this.incidentDate = incidentDate;
    }

    /**
     * @return the policeReportNo
     */
    public String getPoliceReportNo() {
        return policeReportNo;
    }

    /**
     * @param policeReportNo the policeReportNo to set
     */
    public void setPoliceReportNo(String policeReportNo) {
        this.policeReportNo = policeReportNo;
    }

    /**
     * @return the claimStatus
     */
    public String getClaimStatus() {
        return claimStatus;
    }

    /**
     * @param claimStatus the claimStatus to set
     */
    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    private String claimId;
    private String claimDate;
    private String incidentLocation;
    private String incidentDate;
    private String policeReportNo;
    private String claimStatus;
    
    private String userId;
    private String fullName;
    private String email;
    private String phone;
    
    private String categoryId;
    private String categoryName;
    
    private String policyId;
    private String policyName;
    private String policyExpiryDate;
    private String policyAmount;
    private String policyDescription;
    

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
    
    
    
    
  
//    public String doAddFnol() {
//
//        String result = "FAILURE";
//
//        Claim fnol = new Claim();
//        fnol.setUserId(getUserId());
//        fnol.setPolicyId(getPolicyId());
//        fnol.setDriverName(driverName);
//        fnol.setDescription(description);
//        fnol.setClaimDate(getClaimDate());
//        fnol.setIncidentLocation(getIncidentLocation());
//        fnol.setFnolStatus(getFnolStatus());
//
//        boolean res = FnolService.addFnol(fnol);
//        if (res) {
//            result = "SUCCESS";
//            ArrayList fnolList= FnolService.getUserFnols(this.getUserId());
//            getSessionMap().put("Success", "successfull");
//            getSessionMap().put("fnolList", fnolList);
//            System.out.println("Successfully Filed");
//        } else {
//            System.out.println("FNOL not filed!");
//        }
//        return result;
//    }
//
//    public String doUpdateFnolStatus(){
//        
//        String result= "FAILURE";
//        System.out.println("Current FNOL id: "+this.getFnolId());
//        boolean res = FnolService.updateFnolStatus(this.getFnolId());
//        
//        if(res){
//            result="SUCCESS";
//            ArrayList fnolList = FnolService.getAllFnols();
//            getSessionMap().put("successUpdate", "statusUpdated");
//            System.out.println("FNOL status updated");
//            getSessionMap().put("fnolList", fnolList);
//            
//        }else{
//            System.out.println(" FNOL status not updated");
//        }
//        return result;
//    }
//    
//    public String doRejectFnol(){
//        
//        String result= "FAILURE";
//        System.out.println("Current FNOL id: "+this.getFnolId());
//        boolean res = FnolService.rejectFnol(this.getFnolId());
//        
//        if(res){
//            result="SUCCESS";
//            ArrayList fnolList = FnolService.getAllFnols();
//            getSessionMap().put("successUpdateTo-1", "statusUpdatedTo-1");
//            System.out.println("FNOL status updated to -1");
//            getSessionMap().put("fnolList", fnolList);
//            
//        }else{
//            System.out.println(" FNOL status not updated to -1");
//        }
//        return result;
//    }
//    
//    public String doSanctionFnol(){
//        
//        String result= "FAILURE";
//        System.out.println("Current FNOL id: "+this.getFnolId());
//        boolean res = FnolService.sanctionFnol(this.getFnolId());
//       
//        if(res){
//            result="SUCCESS";
//            ArrayList fnolList = FnolService.getAllUpdatedFnols();
//            getSessionMap().put("successUpdateTo2", "statusUpdatedTo2");
//            System.out.println("FNOL status updated to 2");
//            getSessionMap().put("fnolList", fnolList);
//            
//        }else{
//            System.out.println(" FNOL status not updated to 2");
//        }
//        return result;
//    }
//    
//    
//    
//    public String doViewFnol(){
//        
//        String result="SUCCESS";
//        System.out.println("Current fnol is: "+this.getFnolId());
//        Claim fnol= FnolService.getFnol(this.getFnolId());
//       
//        getSessionMap().put("successUpdate", "viewSuccess");
//        System.out.println("FROM FNOL MODEL:  FNOL FETCHED");
//        getSessionMap().put("fnol", fnol);
//            
//        
//        return result;
//    }
//    
//    public String doSearchFnols(){
//        String result="FAILURE";
//        ArrayList fnolList= FnolService.searchFnols(fnolId);
//        System.out.println("Fnol Id: "+fnolId);
//        System.out.println("fnolList: "+fnolList.size());
//        if(!fnolList.isEmpty()){
//            getSessionMap().put("fnolList", fnolList);
//            result="SUCCESS";
//        }
//        else{
//            result="FAILURE";
//        }
//        return result;
//    }
//    
//    public String doViewPolicy(){
//        
//        String result="SUCCESS";
//        System.out.println("Current policy is: "+this.getPolicyId());
//        Claim fnol= FnolService.getFnolByPolicyId(this.getPolicyId());
//       
//        getSessionMap().put("successUpdate", "viewSuccess");
//        System.out.println("FROM FNOL MODEL:  POLICY FETCHED");
//        getSessionMap().put("fnol", fnol);
//            
//        
//        return result;
//    }
//    
//    public String doViewDriver(){
//        
//        String result="SUCCESS";
//        System.out.println("Current driver is: "+this.getDriverName());
//        Claim fnol= FnolService.getFnolByDriverName(this.getDriverName());
//       
//        getSessionMap().put("successUpdate", "viewSuccess");
//        System.out.println("FROM FNOL MODEL:  Driver FETCHED");
//        getSessionMap().put("fnol", fnol);
//            
//        
//        return result;
//    }
//    
//    public String doGetFnols(){
//        String result="FAILURE";
//        ArrayList fnolList= FnolService.getAllFnols();
//       
//        System.out.println("fnolList: "+fnolList.size());
//        if(!fnolList.isEmpty()){
//            getSessionMap().put("fnolList", fnolList);
//            result="SUCCESS";
//        }
//        else{
//            result="FAILURE";
//        }
//        return result;
//    }
    
    


    

    
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
