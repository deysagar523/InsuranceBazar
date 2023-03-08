<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div >
    <table border="5">

        <tr>
            <td>
                <table style="color:black">
                    <th>Details of Mediclaim:</th>
                    <tr>
                        <td>POLICY NAME: <strong>${ParticularMedClaim.policyName}</strong></td>
                    </tr>
                    <tr>
                        <td>FULL NAME : <strong>${ParticularMedClaim.fullName}</strong></td>
                    </tr>
                    <tr>
                        <td>Issue For : <strong>${ParticularMedClaim.relativeType}</strong></td>
                    </tr>
                    <tr>
                        <td>Medical History : <strong>${ParticularMedClaim.medicalHistory}</strong></td>


                    </tr>
                    <tr>
                        <c:choose>
                            <c:when  test="${ParticularMedClaim.disease.length()==0 || ParticularMedClaim.disease==null}">
                                <td>Disease Name : <strong>None</strong></td>
                            </c:when>
                            <c:otherwise>

                                <td>Disease Name : <strong>${ParticularMedClaim.disease}</strong></td>

                            </c:otherwise>
                        </c:choose>






                    </tr>
                    <tr>
                        <c:choose>
                            <c:when test="${ParticularMedClaim.relationAdhar.length()==0 || ParticularMedClaim.relationAdhar==null}">
                               <td>Adhar card  : <strong>${ParticularMedClaim.adharCard}</strong></td>
                            </c:when>
                            <c:otherwise>
                                <td>Adhar card : <strong>${ParticularMedClaim.relationAdhar}</strong></td>
                            </c:otherwise>
                        </c:choose>
                        






                    </tr>
                    <tr>
                        <td>PLAN EXPIRY DATE : <strong>${ParticularMedClaim.claimExpiryDate}</strong></td>
                    </tr>



                </table>
            </td>
        </tr>
        <tr>
            <td>

                <button type="button" class="btn btn-primary text-light mt-3 w-90" onclick="fetchVapi(${ParticularMedClaim.claimId})">Check patient's details</button>

            </td>
        </tr>
        <tr>
            <td>

                <button type="button" class="btn btn-success btn-sm text-light mt-2 w-50" onclick="functionApprove(${ParticularMedClaim.claimId})">Approve</button>

            </td>

        </tr>
        <tr>
            <td>

                <button type="button" class="btn btn-danger btn-sm text-light mt-2 w-50" onclick="functionReject(${ParticularMedClaim.claimId})">Reject</button>

            </td>
        </tr>
    </table>
</div>
