/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.exavalu.utils.JDBCUtility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;


/**
 *
 * @author LENOVO
 */
public class BikeApi extends ActionSupport implements ApplicationAware, SessionAware, Serializable{
    
    private String id,claimId,bikeNo,bikeModel,bikeRegistrationYear,bikeMake;
    
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the bikeNo
     */
    public String getBikeNo() {
        return bikeNo;
    }

    /**
     * @param bikeNo the bikeNo to set
     */
    public void setBikeNo(String bikeNo) {
        this.bikeNo = bikeNo;
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

    /**
     * @return the bikeRegistrationYear
     */
    public String getBikeRegistrationYear() {
        return bikeRegistrationYear;
    }

    /**
     * @param bikeRegistrationYear the bikeRegistrationYear to set
     */
    public void setBikeRegistrationYear(String bikeRegistrationYear) {
        this.bikeRegistrationYear = bikeRegistrationYear;
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
    
    public String fetchBikeApi() throws Exception {
        String result = "SUCCESS";
        JDBCUtility jdbcUtility = JDBCUtility.getInstanceOfJDBCUtility();
        String apiUrl = "https://mocki.io/v1/8971c40e-b6c5-4b97-8e12-386b1992ace8";
//        String apiUrl= "https://insuranceapi.free.beeceptor.com/bikedata";
        URL obj = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
        System.out.println(this.claimId);
        System.out.println("\nSending 'GET' request to URL : " + apiUrl);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        int c = 0;
        ArrayList userList = new ArrayList<>();
        JSONParser parse = new JSONParser();

        while ((inputLine = in.readLine()) != null) {

            response.append(inputLine);
        }
        JSONArray jsonArray = (JSONArray) parse.parse(response.toString());
        System.out.println(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject myResponse = (JSONObject) jsonArray.get(i);

            BikeApi bikeApi = new BikeApi();
            bikeApi.setId(myResponse.get("id").toString());
            //System.out.println(voterAPI.getVoterId());
            bikeApi.setBikeMake(myResponse.get("bikeMake").toString());
            bikeApi.setBikeNo(myResponse.get("bikeNo").toString());
            bikeApi.setBikeRegistrationYear(myResponse.get("bikeRegistrationYear").toString());
           

            if (bikeApi.getId().equals(this.claimId)) {
                sessionMap.put("BikeApi", bikeApi);
            }
        }
        //System.out.println(sessionMap);
        return result;
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
     * @return the bikeMake
     */
    public String getBikeMake() {
        return bikeMake;
    }

    /**
     * @param bikeMake the bikeMake to set
     */
    public void setBikeMake(String bikeMake) {
        this.bikeMake = bikeMake;
    }



}
