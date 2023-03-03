<!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <title>Car Policy List</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/Policyliststyle.css">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="css/Officerstyle.css">
        <!-- FontAwesome CSS-->
        <link rel="stylesheet" href="css/all.css">
        <!-- Boxicons CSS-->
        <link rel="stylesheet" href="css/boxicons.min.css">

    </head>
    <style>
        .ftco-section{
            padding: 0;
        }
        .table thead.thead-primary{
            background: #86B817;
        }
        .my-custom-scrollbar {
            position: relative;
            height: 300px;
            overflow: auto;
        }
        .table-wrapper-scroll-y {
            display: block;
        }
        #tableId{
            margin-top: 20px;
        }
        #bikeIdentityDetails{
            margin-left: 20px;

        }
    </style>
    <script>
        function ajaxFileFNOL(claimId){
            console.log(claimId);
            $.ajax({
                url: 'LoadFNOLPage',
                data: {
                    claimId:claimId
                },
                success: function (responseText) {
                    alert(responseText)

                    $("#container").html(responseText);
                }
            });
        }
    </script>
    <body>

        <div id="container">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-wrapper-scroll-y my-custom-scrollbar">

                            <table class="table table-bordered table-striped mb-0">
                                <thead class="thead-primary"> 
                                    <tr>
                                        <!--                                        <th>Incident Location</th>
                                                                                <th>Incident Date</th>
                                                                                <th>Police Report No</th>-->
                                        <th>Claim Id</th>
                                        <th>Bike No</th>
                                        <th>Bike Make</th>
                                        <th>Bike Model</th>
                                        <th>Bike Registration Year</th>

                                        <th>Policy Name</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:if test="${BikeList.size()!=0}">
                                        <c:forEach items="${BikeList}" var="claim">
                                            <tr data-index="0">
                                                <td><c:out value="${claim.claimId}"> </c:out></td>
                                                <td><c:out value="${claim.bikeNumber}"> </c:out></td>
                                                <td><c:out value="${claim.bikeMake}"> </c:out></td>
                                                <td><c:out value="${claim.bikeModel}"> </c:out>
                                                <td><c:out value="${claim.bikeRegistrationYear}"> </c:out></td>

                                                    <td><c:out value="${claim.policyName}"> </c:out></td>


                                                    <!--                                                                <td>
                                                                                                                        <a href=ApprovePolicy?claimId=${claim.claimId} class="btn btn-success">Approve</a>
                                                                                                                    <a href="RejectPolicy?claimId=${claim.claimId}" class="btn btn-danger">Reject</a>
                                                                                                                </td>-->
                                                <td>
                                                    <button onClick="ajaxFileFNOL(<c:out value="${claim.claimId}"> </c:out>)" >File FNOL</button>
                                                </td>






                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${BikeList.size()==0}">
                                    <h1>No results to show</h1>
                                </c:if>




                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <table id="tableId" class="table-borderless">

                    <td rowspan = "3">
                        <div id="onclickViewClaim">

                        </div>
                    </td>
                    <td>
                        <div id="bikeIdentityDetails">


                        </div>

                    </td>

                </table>
            </div>
        </div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <!-- JS Libraies -->
        <script src="js/bootstrap.bundle.min.js"></script>

        <!-- Chart Js -->

        <!-- Template JS File -->
        <script src="js/script.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>

