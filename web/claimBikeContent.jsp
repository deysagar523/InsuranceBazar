<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>
        
    
</c:if>
<div >
    <table border="5">

        <tr>
            <td>
                <table style="color:black">
                    <th>Details of Bike Claim:</th>
                    <tr>
                          <td>POLICY NAME: <strong>${ParticularClaim.policyName}</strong></td>
                    </tr>
                    <tr>
                          <td>FULL NAME : <strong>${ParticularClaim.fullName}</strong></td>
                    </tr>
                    <tr>
                        <td>BIKE NUMBER : <strong>${ParticularClaim.bikeNumber}</strong></td>
                    </tr>
                    <tr>
                        <td>BIKE MAKE : <strong>${ParticularClaim.bikeMake}</strong></td>
                    </tr>
                    <tr>
                        <td>BIKE MODEL : <strong>${ParticularClaim.bikeModel}</strong></td>
                    </tr>
                    <tr>
                        <td>BIKE REGISTRATION YEAR : <strong>${ParticularClaim.bikeRegistrationYear}</strong></td>
                    </tr>
                    <tr>
                        <td>PLAN EXPIRY DATE : <strong>${ParticularClaim.claimExpiryDate}</strong></td>
                    </tr>
                    
                    

                    </table>
                </td>
            </tr>
            <tr>
                <td>

                    <button type="button" class="btn btn-primary text-light mt-3 w-90" onclick="fetchVapi(${ParticularClaim.claimId})">Check bike's details</button>

                </td>
            </tr>
            <tr>
                <td>

                    <button type="button" class="btn btn-success btn-sm text-light mt-2 w-50" onclick="functionApprove(${ParticularClaim.claimId})">Approve</button>

            </td>
            
        </tr>
        <tr>
            <td>

                <button type="button" class="btn btn-danger btn-sm text-light mt-2 w-50" onclick="functionReject(${ParticularClaim.claimId})">Reject</button>

            </td>
        </tr>
    </table>
</div>
