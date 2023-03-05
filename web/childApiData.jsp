<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <table class="table table-sm  " style="width:400px">
    <th style="text-align: center;justify-content: center">Details of Child:</th>
    
    <tr>
        <td>CHILD DOB  : </td>
        <td><input class="form-control" name="bikeNo" type="text" class="form-control" id="bikeNo" placeholder="Date Of Birth" readonly value="${ChildApi.dob}"></td>
    </tr>
    <tr>
        <td>BIRTH LOCATION : </td>
        <td><input class="form-control" name="bikeModel" type="text" class="form-control" id="bikeModel" placeholder="Birth Location" readonly value="${ChildApi.birthLocation}"></td>
    </tr>
    <tr>
        <td>BIRTH REGISTRATION NUMBER </td>
        <td><input class="form-control" name="bikeRegistrationYear" type="text" class="form-control" id="birth Certificate Number" placeholder="Birth Certificate Number" readonly value="${ChildApi.birthCertificateNumber}"></td>
    </tr>

</table>
    </div>