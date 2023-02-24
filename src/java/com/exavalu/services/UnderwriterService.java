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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author LENOVO
 */
public class UnderwriterService {
        public ArrayList getAllPendingHealthClaims() {
      ArrayList pendingHealthPolicyList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from claims c,users u,categories ca,policies p where c.userId=u.userId and c.categoryId=ca.categoryId and c.policyId=p.policyId and claimStatus=?";
                    
            PreparedStatement preparedStatement = con.prepareStatement(sql);

             preparedStatement.setString(1, "1");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getString("claimId"));
                claim.setClaimExpiryDate(rs.getString("claimExpiryDate"));
                claim.setClaimStatus(rs.getString("claimStatus"));
                
                claim.setHealthIssue(rs.getString("healthIssue"));
                
                
                claim.setFullName(rs.getString("fullName"));
                claim.setEmail(rs.getString("email"));
                
                
                claim.setCategoryName(rs.getString("categoryName"));
                
                claim.setPolicyName(rs.getString("policyName"));
                claim.setPolicyDescription(rs.getString("policyDescription"));
                
                
//                System.out.println(claim.getClaimId());
//                 System.out.println(claim.getClaimStatus());
//                  System.out.println(claim.getDriverName());
//                   System.out.println(claim.getEmailAddress());
//                    System.out.println(claim.getDate());
                pendingHealthPolicyList.add(claim);

            }

        } catch (SQLException ex) {
            Logger log=Logger.getLogger(UnderwriterService.class.getName());
            log.error(LocalDateTime.now()+ "@"+ex);
            ex.printStackTrace();
        }
        System.out.println("Number of pending list = " + pendingHealthPolicyList.size());
        return pendingHealthPolicyList;
    }
}
