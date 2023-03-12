<!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>


</c:if>
<html lang="en">
    <head>
        <title>Health Policy List</title>
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
        #tableId{
            margin-top: 20px;
        }
        #patientIdentityDetails{
            margin-left: 20px;

        }

    </style>
    <script>
        function fetchContent(claimId)
        {
            //alert(claimId);
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function ()
            {
                document.getElementById("onclickViewClaim").innerHTML = xmlhttp.responseText;
            };


            xmlhttp.open("POST", "FetchParticularClaim?claimId=" + claimId, true);
            xmlhttp.send();
        }
        function fetchVapi(claimId)
        {
            alert(claimId);
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function ()
            {
                document.getElementById("patientIdentityDetails").innerHTML = xmlhttp.responseText;
            };


            xmlhttp.open("POST", "FetchMedApi?claimId=" + claimId, true);
            xmlhttp.send();
            //FetchApi
        }
        function functionApprove(claimId)
        {
            alert(claimId);
            window.location.href = `ApprovePolicy?claimId=` + claimId;

        }
        function functionReject(claimId)
        {
            alert(claimId);
            window.location.href = `RejectPolicy?claimId=` + claimId;

        }

    </script>
    <body>

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
                                        <th>Claim Id</th>
                                        <th>Issue For</th>
                                        <th>Relative's Name</th>
                                        <th>Adhar Card </th>
                                        <th>Policy Name</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${User.role.equals('2')}">
                                        <c:if test="${AllPendingMediclaimClaims.size()!=0}">
                                            <c:forEach items="${AllPendingMediclaimClaims}" var="claim">
                                                <tr data-index="0">
                                                    <td><c:out value="${claim.claimId}"> </c:out></td>

                                                        <td><c:out value="${claim.relativeType}"> </c:out></td>
                                                    <c:choose>
                                                        <c:when test="${claim.relativeName.length()==0 or claim.relativeName==null}">
                                                            <td>
                                                                NA
                                                            </td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td>
                                                                ${claim.relativeName}
                                                            </td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <c:choose>
                                                        <c:when test="${claim.relationAdhar.length()==0 or claim.relationAdhar==null}">
                                                            <td>
                                                                ${claim.adharCard}
                                                            </td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td>
                                                                ${claim.relationAdhar}
                                                            </td>
                                                        </c:otherwise>
                                                    </c:choose>





                                                    <td><c:out value="${claim.policyName}"> </c:out></td>


                                                        <!--                                                        <td>
                                                                                                                    <a href="#" class="btn btn-success">Approve</a>
                                                                                                                    <a href="#" class="btn btn-danger">Reject</a>
                                                                                                                </td>-->
                                                        <td>
                                                            <button type="button" class="btn btn-success" onclick="fetchContent(${claim.claimId})">View</button>
                                                    </td>






                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${AllPendingMediclaimClaims.size()==0}">
                                        <h1>No results to show</h1>
                                    </c:if>
                                </c:if>
                                <c:if test="${User.role.equals('3')}">
                                    <c:if test="${AllApprovedMediclaimClaims.size()!=0}">
                                        <c:forEach items="${AllApprovedMediclaimClaims}" var="claim">
                                            <tr data-index="0">
                                                <td><c:out value="${claim.claimId}"> </c:out></td>

                                                    <td><c:out value="${claim.relativeType}"> </c:out></td>
                                                <c:choose>
                                                    <c:when test="${claim.relativeName.length()==0 or claim.relativeName==null}">
                                                        <td>
                                                            NA
                                                        </td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>
                                                            ${claim.relativeName}
                                                        </td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${claim.relationAdhar.length()==0 or claim.relationAdhar==null}">
                                                        <td>
                                                            ${claim.adharCard}
                                                        </td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>
                                                            ${claim.relationAdhar}
                                                        </td>
                                                    </c:otherwise>
                                                </c:choose>





                                                <td><c:out value="${claim.policyName}"> </c:out></td>






                                                    <td>
                                                        <a href=SanctionPolicy?claimId=${claim.claimId} class="btn btn-success">Issue</a>

                                                </td>




                                            </tr>
                                        </c:forEach>
                                    </c:if>

                                    <c:if test="${AllApprovedMediclaimClaims.size()==0}">
                                        <h1>No results to show</h1>
                                    </c:if>
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
                        <div id="patientIdentityDetails">


                        </div>

                    </td>

                </table>
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

