
<%@page import="java.util.Random"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDateTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>
        
    
</c:if>
<c:set var="user" value="${User}"/>

<c:set var="plan" value="${Plan}"/>

<!------ Include the above in your HEAD tag ---------->

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Fonts -->
        <link rel="dns-prefetch" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" href="Favicon.png">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.0/jspdf.umd.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.5.0-beta4/html2canvas.min.js"></script>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.js"></script>
        <style>

            body{
                margin: 0;
                font-size: .9rem;
                font-weight: 400;
                line-height: 1.6;
                color: #212529;
                text-align: left;
                background-color: #f5f8fa;
            }

            .navbar-laravel
            {
                box-shadow: 0 2px 4px rgba(0,0,0,.04);
            }

            .navbar-brand , .nav-link, .my-form, .login-form
            {
                font-family: Arial, sans-serif;
            }

            .my-form
            {
                padding-top: 1.5rem;
                padding-bottom: 1.5rem;
            }

            .my-form .row
            {
                margin-left: 0;
                margin-right: 0;
            }

            .login-form
            {
                padding-top: 1.5rem;
                padding-bottom: 1.5rem;
            }

            .login-form .row
            {
                margin-left: 0;
                margin-right: 0;
            }
            #pdf-content{
                margin: 50px;
            }
        </style>

        <title>Policy Details</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <script>
            window.onload = function () {
                document.getElementById("GetFile")
                        .addEventListener("click", () => {
                            const template = this.document.getElementById("pdf-content");
                            console.log(template);
                            console.log(window);
                            var opt = {
                                margin: 0,
                                filename: 'Policy.pdf',
                                image: {type: 'jpeg', quality: 0.98},
                                html2canvas: {scale: 2},
                                jsPDF: {unit: 'in', format: 'A3', orientation: 'portrait'}
                            };
                            html2pdf().from(template).set(opt).save();
                        });
            };
        </script>
        <main class="my-form">
            <div class="cotainer col-md-11" id="pdf-content">
                <!--                <div class="row justify-content-center">-->
                <!--<div class="col-md-11">-->
                <div class="card flex py-3">
                    <!--<div class="card-header"><img src="images\OIP.jpeg" height="85px" style="margin-top:-10px;">-->
                    <h2 class="text-center">InsuranceBazar</h2>
                </div>
                <!--</div>-->
                <div class="card">
                    <div class="card-header">Company Details</div>
                    <div class="card">
                        <div class="card-body">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Company Name</label>

                                <div class="col-sm-8">
                                    <input id="name" class="form-control" name="companyname" type="text" value = "${plan.planCompany}" readonly>

                                </div>
                            </div>



                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Company Address</label>
                                <div class="col-sm-4">
                                    <input  type="text" class="form-control" id="companyadd" name="companyadd" value = "10th Floor, 1 Ho Chi Minh Sarani" readonly>

                                </div>
                                <label class="col-sm-2 col-form-label" style = "padding-left: 85px">District</label>
                                <div class="col-sm-2">
                                    <input  type="text" class="form-control" id="companydist" name="companydist" value = "Kolkata" readonly>

                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">State</label>
                                <div class="col-sm-3">
                                    <input  type="text" class="form-control" id="companystate" name="companystate" value = "West-Bengal" readonly>

                                </div>
                                <label class="col-sm-2 col-form-label" style = "padding-left: 75px">Pin Code</label>
                                <div class="col-sm-3">
                                    <input  type="text" class="form-control" id="companypincode" name="companypincode" value = "743122" readonly>

                                </div>
                            </div>

                        </div>
                        <div class="card-header">Policy Plan Details</div>
                        <div class="card-body">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">E-Mail Address</label>

                                <div class="col-sm-8">
                                    <input id="email" class="form-control" name="email" type="email" value = "${user.email}" readonly>

                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Full Name</label>

                                <div class="col-sm-8">
                                    <input id="email" class="form-control" name="email" type="email" value = "${user.fullName}" readonly>

                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Policy Amount</label>
                                <div class="col-sm-8">
                                    <input id="phone" class="form-control" name="aadhaarNo" type="txt" value = "${plan.planAmount}" readonly>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Policy Duration</label>
                                <div class="col-sm-8">
                                    <input  type="text" class="form-control" id="proposername" name="proposerName" value = "${plan.planDuration} Year " readonly>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Policy Name</label>
                                <div class="col-sm-8">

                                    <input  type="text" class="form-control" id="iquotationdate" name="quotationDate" value = "${plan.policyName}" readonly>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label">Policy Expiry Date </label>
                                <div class="col-sm-8">

                                    <input  type="text" class="form-control" id="iquotationdate" name="quotationDate" value = "${ClaimExpiryDate}" readonly>
                                </div>
                            </div>






                        </div>
                        <div class="card-header" style="margin-left: -1.25rem; width: calc(100% + 2.5rem)">Declaration</div>
                        <div class="form-group row mr-2 mt-4">
                            <div class="col-sm-12">
                                I/ we hereby declare and state that the above statements made by me/ us are true and complete. No part of it is false. I/ we desire to effectan insurance as describe herein with
                                Future General India Insurance Co. Ltd.
                                and I/ we agree that this proposal and declarations shall be the basis of contract between me/ us and the
                                Future General India Insurance Co. Ltd.
                                and I/ we agree to accept the policy subject to the condition specified by the Insurance Company.
                                I/ we agree to receive the policy document (without enclosing the terms and conditions of policy) from the company and authorise the company to displayTerms and Conditions of the policy on its website that enables access by me.
                                I hereby confirm that I have mandated Aditya Birla Insurance Brokers Ltd. to place my insurance cover and have read and agreed on the terms andconditions and also give my unconditional consent for receiving a call from Aditya Birla Insurance Brokers or its affiliated entities on my number even if thenumber is enrolled under NDNC/DND registry

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <button type="button" class="btn btn-primary" id="GetFile">
                DOWNLOAD THE PDF
            </button>
        </div>
    </main>

</body>
</html>