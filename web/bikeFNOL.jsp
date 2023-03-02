<%-- 
    Document   : addFnol
    Created on : 17-Feb-2023, 3:45:32 pm
    Author     : Nairwita Chakraborty
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <script src="https://code.jquery.com/jquery-3.6.3.js" 
                            integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                            crossorigin="anonymous">
    </script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">    
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <title>Add FNOL Details</title>
    </head>



    <body class="text-center" >
        <div class="container-fluid position-relative p-0">
            <nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
                <a href="" class="navbar-brand p-0">
                    <h1 class="text-primary m-0"><i class="fa fa-map-marker-alt me-3"></i>InsuranceBazzar</h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto py-0">
                        <!--                    <a href="index.html" class="nav-item nav-link active">Home</a>
                                            <a href="about.html" class="nav-item nav-link">About</a>
                                            <a href="service.html" class="nav-item nav-link">Services</a>-->
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Renew Your Policy</a>
                            <div class="dropdown-menu m-0">
                                <a href="FNOL.html" class="dropdown-item"><i class="fa fa-umbrella" style="font-size:20px;color:greenyellow"></i> Life Renewal</a>
                                <a href="helpClaim.html" class="dropdown-item"><i class='fas fa-heartbeat' style='font-size:20px;color:greenyellow'></i> Health Renewal</a>
                                <a href="team.html" class="dropdown-item"><i class='fas fa-car-crash' style='font-size:20px;color:greenyellow'></i> Motor Renewal</a>
                                <a href="testimonial.html" class="dropdown-item"><i class='fas fa-plane' style='font-size:20px;color:greenyellow'></i> Travel Renewal</a>
                                <!--                            <a href="404.html" class="dropdown-item">404 Page</a>-->
                            </div>
                        </div>

                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Claim</a>
                            <div class="dropdown-menu m-0">
                                <a href="FNOL.html" class="dropdown-item"> <i class='fas fa-edit' style='font-size:20px;color:greenyellow'></i>  File a New Claim</a>
                                <a href="helpClaim.html" class="dropdown-item"><i class='fas fa-search' style='font-size:20px;color:greenyellow'></i>  Know more about filing Claim</a>
                                <a href="team.html" class="dropdown-item"><i class='fas fa-calendar-alt' style='font-size:20px;color:greenyellow'></i>  Tracking existing Claim</a>
                                <!--                            <a href="testimonial.html" class="dropdown-item">Testimonial</a>-->
                                <!--                            <a href="404.html" class="dropdown-item">404 Page</a>-->
                            </div>
                        </div>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><button type="button" class="btn btn-primary rounded-pill py-2 px-4"><i class='fas fa-user-circle' style='font-size:20px;color:greenyellow'></i> My Account</button></a>
                        <div class="dropdown-menu m-0">
                            <a href="userProfile.jsp" class="dropdown-item"> <i class='far fa-user-circle' style='font-size:20px;color:greenyellow'></i>  My Profile</a>
                            <a href="helpClaim.html" class="dropdown-item"><i class='fas fa-id-badge' style='font-size:20px;color:greenyellow'></i>   My Policies</a>
                            <a href="team.html" class="dropdown-item"><i class='far fa-credit-card' style='font-size:20px;color:greenyellow'></i> My Transactions </a>
                            <a href="Logout" class="dropdown-item"><i class="fa fa-power-off" style="font-size:20px;color:greenyellow"></i> Sign Out</a>

                        </div>
                    </div>
                    <!--                <a href="#" target="displayarea"  class="btn btn-primary rounded-pill py-2 px-4">My Account</a>-->

                </div>
            </nav>



            <div class="row container">
                <div class="col-lg-6">
                    <img src="car-insurance.jpg" style="width:500px;">
                </div>
                <div class="col-lg-6 ">


                    <main class="form-control m-auto">
                        <div class="mt-3">
                            <div class="card-header">
                                <!--<img class="mb-5" src="images/Exavalu_Logo.png" alt="" width="300" height="100">-->
                                <h1 class="h3 mb-3 fw-normal text-center" style="color: #301934"><b>File FNOL</b></h1>
                            </div>
                            <form action="CreateCarClaim" method="Post">

                                <div class="form-floating">
                                    <input type="text" value="${User.getUserId()}" class="form-control" id="floatingInput" placeholder="Driver Name" name="userId" required>
                                    <label for="floatingInput">User Id</label>
                                </div>

                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="Car Number" name="carNo" required>
                                    <label for="floatingInput">Car Number</label>
                                </div>

                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="Car Model" name="carModel" required>
                                    <label for="floatingInput">Car Model</label>
                                </div>

                                <div class="form-floating">
                                    <input type="date" class="form-control" id="floatingInput" placeholder="Car Model" name="carRegistrationYear" required>
                                    <label for="floatingInput">Car Registration year</label>
                                </div>

                                <div class="form-floating">
                                    <input type="date" class="form-control" id="floatingInput" placeholder="YYYY-MM-DD" name="claimDate" required>
                                    <label for="floatingInput">Claim Date</label>
                                </div>

                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="Description" name="incidentLocation" required>
                                    <label for="floatingInput">Incident Location</label>
                                </div>

                                <br>
                                <button class="w-50 btn btn-lg btn-info" type="submit">Save</button>
                            </form>
                        </div>              
                    </main>



                </div>
            </div>
        </div>

        <%--        <div class="container">
                    <c:if test="${not empty SuccessMsg}">
                        <h1 style="color: darkgreen"><c:out value="${SuccessMsg}"/></h1>
                        <c:remove var="SuccessMsg" scope="session"/>
                        <% response.setHeader("Refresh", "3;url=showall.jsp");%>
                    </c:if>
                    <c:if test="${not empty ErrorMsg}">
                        <h1 style="color: red"><c:out value="${ErrorMsg}"/></h1>
                    </c:if>
                </div>--%>

        <!--        <main class="form-control w-25 m-auto">
                    <div class="mt-3">
                        <div class="card-header">
                            <img class="mb-5" src="images/Exavalu_Logo.png" alt="" width="300" height="100">
                            <h1 class="h3 mb-3 fw-normal text-center" style="color: #301934"><b>File FNOL</b></h1>
                        </div>
                        <form action="AddFnol" method="Post">
        
                            <div class="form-floating">
                                <input type="text" value="${user.getUserId()}" class="form-control" id="floatingInput" placeholder="Driver Name" name="userId" required>
                                <label for="floatingInput">User Id</label>
                            </div>
        
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Driver Name" name="driverName" required>
                                <label for="floatingInput">Driver Name</label>
                            </div>
        
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Description" name="description" required>
                                <label for="floatingInput">Description</label>
                            </div>
        
                            <div class="form-floating">
                                <input type="date" class="form-control" id="floatingInput" placeholder="YYYY-MM-DD" name="claimDate" required>
                                <label for="floatingInput">Claim Date</label>
                            </div>
        
                            <div class="form-floating">
                                <input type="text" class="form-control" id="floatingInput" placeholder="Description" name="incidentLocation" required>
                                <label for="floatingInput">Incident Location</label>
                            </div>
        
                            <br>
                            <button class="w-50 btn btn-lg btn-info" type="submit">Save</button>
                        </form>
                    </div>              
                </main>-->
    </body>
</html>
