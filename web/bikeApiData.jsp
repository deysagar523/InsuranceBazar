<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <table class="table table-sm  " style="width:400px">
    <th style="text-align: center;justify-content: center">Details of bike:</th>
    <tr>
        <td>CLAIM ID : </td>
        <td><input class="form-control" name="claimId" type="text" class="form-control" id="claimId" placeholder="bikeId" readonly value="${BikeApi.id}"></td>
    </tr>
    <tr>
        <td>BIKE NO  : </td>
        <td><input class="form-control" name="bikeNo" type="text" class="form-control" id="bikeNo" placeholder="bikeNo" readonly value="${BikeApi.bikeNo}"></td>
    </tr>
    <tr>
        <td>BIKE MAKE: </td>
        <td><input class="form-control" name="bikeMake" type="text" class="form-control" id="bikeModel" placeholder="bikeMake" readonly value="${BikeApi.bikeMake}"></td>
    </tr>
    <tr>
        <td>BIKE REGISTRATION YEAR </td>
        <td><input class="form-control" name="bikeRegistrationYear" type="text" class="form-control" id="bikeRegistrationYear" placeholder="bikeRegistrationYear" readonly value="${BikeApi.bikeRegistrationYear}"></td>
    </tr>

</table>
    </div>