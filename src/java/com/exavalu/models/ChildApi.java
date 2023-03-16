/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author LENOVO
 */
public class ChildApi extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String id;
    private String dob;
    private String birthLocation;
    private String birthCertificateNumber;
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();
    private String claimId;

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
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the birthLocation
     */
    public String getBirthLocation() {
        return birthLocation;
    }

    /**
     * @param birthLocation the birthLocation to set
     */
    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    /**
     * @return the birthCertificateNumber
     */
    public String getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    /**
     * @param birthCertificateNumber the birthCertificateNumber to set
     */
    public void setBirthCertificateNumber(String birthCertificateNumber) {
        this.birthCertificateNumber = birthCertificateNumber;
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

    public String fetchChildApi() throws Exception {
        String result = "SUCCESS";
//        JDBCUtility jdbcUtility = JDBCUtility.getInstanceOfJDBCUtility();
        String apiUrl = "https://retoolapi.dev/JbyUzo/Childdata";

        URL obj = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
        //System.out.println(this.claimId);
        System.out.println("\nSending 'GET' request to URL : " + apiUrl);
        System.out.println("Response Code : " + responseCode);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));) {
            String inputLine;
            StringBuffer response = new StringBuffer();
//        int c = 0;
//        ArrayList userList = new ArrayList<>();
            JSONParser parse = new JSONParser();

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);
            }
            JSONArray jsonArray = (JSONArray) parse.parse(response.toString());
            System.out.println(jsonArray.size());
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject myResponse = (JSONObject) jsonArray.get(i);

                ChildApi childApi = new ChildApi();
                childApi.setId(myResponse.get("id").toString());
                //System.out.println(voterAPI.getVoterId());
                childApi.setDob(myResponse.get("dob").toString());
                childApi.setBirthLocation(myResponse.get("birthLocation").toString());
                childApi.setBirthCertificateNumber(myResponse.get("birthCertificateNumber").toString());
//           System.out.println(this.getClaimId());

                if (childApi.getId().equals(this.getClaimId())) {
                    sessionMap.put("ChildApi", childApi);
                }
            }
        }

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

}
