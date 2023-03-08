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
                        <c:choose>
                                    <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('HO')}">
                                        <td>BIKE MAKE : <strong>Honda</strong></td>
                                    </c:when>

                                    <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('BA')}">
                                        <td>BIKE MAKE : <strong>Bajaj</strong></td>
                                    </c:when>

                                    <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('YA')}">
                                        <td>BIKE MAKE : <strong>Yamaha</strong></td>
                                    </c:when>

                                    <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('RE')}">
                                       <td>BIKE MAKE : <strong>Royal Enfield</strong></td>
                                    </c:when>

                                    <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('SU')}">
                                       <td>BIKE MAKE : <strong>Suzuki</strong></td>
                                    </c:when>
                                        <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('HD')}">
                                        <td>BIKE MAKE : <strong>Harley Davidson</strong></td>
                                    </c:when>
                                    <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('HM')}">
                                        <td>BIKE MAKE : <strong>Hero Motocarp</strong></td>
                                    </c:when>
                                    <c:when test="${ParticularClaim.getBikeMake().equalsIgnoreCase('MA')}">
                                       <td>BIKE MAKE : <strong>Mahindra</strong></td>
                                    </c:when>
                                </c:choose>
                        
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
