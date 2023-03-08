<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <table class="table table-sm  " style="width:400px">
    <th style="text-align: center;justify-content: center">Details of bike:</th>
    
    <tr>
        <td>ADHAR CARD NO  : </td>
        <td><input class="form-control" name="adharCard" type="text" class="form-control" id="bikeNo" placeholder="bikeNo" readonly value="${MedApi.adharCard}"></td>
    </tr>
    <tr>
        <td>MEDICAL HISTORY : </td>
        <td><input class="form-control" name="medicalHistory" type="text" class="form-control" id="bikeModel" placeholder="bikeModel" readonly value="${MedApi.medicalHistory}"></td>
    </tr>
    <tr>
        <td>DISEASE NAME  </td>
        <td><input class="form-control" name="disease" type="text" class="form-control" id="bikeRegistrationYear" placeholder="bikeRegistrationYear" readonly value="${MedApi.disease}"></td>
    </tr>

</table>
    </div>