/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Claim;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ClaimService {
    
    public static boolean insertClaim(){
        return false;
    }
    
    public static ArrayList getAllClaims(){
        return null;
    }
    
    public static ArrayList getOfficerOnlyClaims(){
        return  null;
    }
    

    
    public static Claim getClaimById(String claimId){
        return null;
    }
    
    public static Claim getClaimByPolicyId(String policyId){
        return null;
    }
    
    public static ArrayList searchClaims(String claimId, String claimDate, String claimStatus, String policyName){
        return  null;
    }
}
