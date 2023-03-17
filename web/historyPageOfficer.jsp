<!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>


</c:if>
<html lang="en">
    <head>
        <title>History</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/PolicyListStyle.css">

        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="css/Officerstyle.css">
        <!-- FontAwesome CSS-->
        <link rel="stylesheet" href="css/all.css">
        <!-- Boxicons CSS-->
        <link rel="stylesheet" href="css/boxicons.min.css">
        <!-- Fixed Table Header CSS-->
        <link rel="stylesheet" href="css/fixedHeaderTable.css">

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
            display: block;
        }
    </style>
    <body>



        <section class="ftco-section">
            <div class="container">

                <div class="row">
                    <div class="col-md-12">


                        <h2>Sanctioned</h2>
                        <div class="table-wrapper-scroll-y my-custom-scrollbar">

                            <table class="table table-bordered table-striped mb-0">

                                <thead class="thead-primary"> 
                                    <tr>
                                        <th>Claim Id</th>

                                        <th>Policy Name</th>
                                        <th>User Full Name</th>
                                        <th>User Email</th>
                                        <th>Sanction Time </th>
                                    </tr>
                                </thead>
                                <tbody>


                                    <c:if test="${InsuranceOfficerSanctionedHistories.size()!=0}">
                                        <c:forEach items="${InsuranceOfficerSanctionedHistories}" var="claim">
                                            <tr data-index="0">
                                                <td><c:out value="${claim.claimId}"> </c:out></td>
                                                <td><c:out value="${claim.policyName}"> </c:out></td>
                                                <td><c:out value="${claim.userFullName}"> </c:out></td>
                                                <td><c:out value="${claim.userEmail}"> </c:out></td>
                                                <td><c:out value="${claim.timeOfAction}"> </c:out></td>






                                                </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${InsuranceOfficerSanctionedHistories.size()==0}">
                                    <h1>No results to show for sanctioned histories</h1>
                                </c:if>


                                </tbody>


                            </table>


                        </div>

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