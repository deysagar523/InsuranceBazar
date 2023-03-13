<!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>


</c:if>
<html lang="en">
    <head>
        <title>Car Policy List</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/PolicyListStyle.css">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="css/Officerstyle.css">
        <!-- FontAwesome CSS-->
        <link rel="stylesheet" href="css/all.css">
        <!-- Boxicons CSS-->
        <link rel="stylesheet" href="css/boxicons.min.css">
        <link rel="stylesheet" href="css/plans.css">

    </head>

    <script>
        function ajaxViewClaim(claimId) {
            console.log(claimId);
            $.ajax({
                url: 'LoadClaimDetails',
                data: {
                    claimId: claimId
                },
                success: function (responseText) {
                    alert(responseText)

                    $("#container").html(responseText);
                }
            });
        }
    </script>

    <section>
        <nav class="navbar" style="background-image: url(img/bg.png);">
            <div class="container main-nav flex">
                <a href="userHomePage.jsp" class="company-logo">
                    <!--                        <img src="assets/HireSphere.png" alt="Company Logo">-->
                    <h1 style="color:#9ec645"> Insurance Bazzar</h1>
                </a>
                <div class="nav-links">
                    <ul class="flex" style="display: flex">
                        <li><a style="text-decoration: none; color:#9ec645" href="userHomePage.jsp" class="hover-link">Home</a></li>

                        <li><a style="text-decoration: none; color:#9ec645" href="ViewApplication?candidateId=${candidate.getCandidateId()}" class="hover-link">My Policies</a></li>

                        <li><a style="text-decoration: none; color:#9ec645" href="userProfile.jsp" class="hover-link">Profile</a></li>
                        <li><a href="Logout" class="hover-link secondary-button" style="background-color:#9ec645; color:white;";>Logout</a></li
                    </ul>
                </div>
            </div>
        </nav> 
    </section>
    <body id="container">



        <div>
            <section class="ftco-section">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-6 text-center mb-5">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-wrapper-scroll-y my-custom-scrollbar">

                                <table class="table table-bordered table-striped mb-0">
                                    <thead class="thead-primary"> 
                                        <tr>
                                            <!--                                        <th>Incident Location</th>
                                                                                    <th>Incident Date</th>
                                                                                    <th>Police Report No</th>-->
                                            <th>Policy</th>
                                            <th>Plan Company</th>
                                            <th>Plan Expiry</th>
                                            <th>Plan Amount</th>
                                            <th>Action</th>

                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:if test="${PlanList.size()!=0}">
                                            <c:forEach items="${PlanList}" var="plan">
                                                <tr data-index="0">
                                                    <td><c:out value="${plan.policyName}"> </c:out></td>
                                                    <td><c:out value="${plan.planCompany}"> </c:out></td>
                                                    <td><c:out value="${plan.claimExpiryDate}"> </c:out></td>
                                                    <td><span>&#8377; &nbsp;</span><c:out value="${plan.planAmount}"> </c:out>

                                                        <td>
                                                            <!--<a onClick="ajaxViewClaim(<c:out value="${plan.claimId}"> </c:out>)" style="cursor:pointer" class="btn btn-success mr-2">View Details</a>-->
                                                        <a href="LoadClaimDetails?claimId=${plan.claimId}" style="cursor:pointer" class="btn btn-success mr-2">View Details</a>




                                                    </td>





                                                    <!--                                                                <td>
                                                                                                                        <a href=ApprovePolicy?claimId=${claim.claimId} class="btn btn-success">Approve</a>
                                                                                                                    <a href="RejectPolicy?claimId=${claim.claimId}" class="btn btn-danger">Reject</a>
                                                                                                                </td>-->







                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${PlanList.size()==0}">
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
