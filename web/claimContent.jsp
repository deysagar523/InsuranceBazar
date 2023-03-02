<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div >
    <table border="5">

        <tr>
            <td>
                <table style="color:black">
                    <th>Details of Bike Claim:</th>
                    <tr>
                        <td>CLAIM ID : <strong>${ParticularClaim.claimId}</strong></td>
                    </tr>
                    <tr>
                        <td>FULL NAME : <strong>${ParticularClaim.fullName}</strong></td>
                    </tr>
                    <tr>
                        <td>EMAIL : <strong>${ParticularClaim.email}</strong></td>
                    </tr>
                    <tr>
                        <td>POLICY NAME : <strong>${ParticularClaim.policyName}</strong></td>
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
