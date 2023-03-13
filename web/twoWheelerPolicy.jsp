
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>


</c:if>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>Two Wheeler Policy</title>

        <!-- Icons font CSS-->
        <link href="policyRegister/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="policyRegister/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="policyRegister/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="policyRegister/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/policyRegister.css" rel="stylesheet" media="all">
    </head>
    <script src="https://code.jquery.com/jquery-3.6.3.js" 
                        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                crossorigin="anonymous"></script>
    <script>
        function fetchBikeModels(selectedId, targetId)

                {
            alert($("#" + selectedId).val());
                            
                    $.ajax({
                             url: 'FetchBikeModels',
                             data: {
                                    [selectedId]: $("#" + selectedId).val()
                              },
                             success: function (responseText) {
                    //                        alert(responseText);
                                    $("#" + targetId).html(responseText);
                             }
                          });
                            


        }
        function fetchBikeVariants(selectedId, targetId)

                {
            alert($("#" + selectedId).val());
                            
                    $.ajax({
                             url: 'FetchBikeVariants',
                             data: {
                                    [selectedId]: $("#" + selectedId).val()
                              },
                             success: function (responseText) {
                    //                        alert(responseText);
                                    $("#" + targetId).html(responseText);
                             }
                          });
                            


        }
    </script>
    <body>
        <section>
            <jsp:include page="menu.jsp"></jsp:include>
            </section>
            <style>
                @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap');

                .container-2 {
                    border: 2px solid;
                    border-radius: 4px;
                    padding: 10px;
                    background: white;
                    display: table;
                    table-layout: fixed;
                    width: 100%;
                    height: 100%;
                    box-sizing: border-box;
                    border-spacing: 10px;
                }
                .item {
                    /* float:left; */
                    display: table-cell;
                    vertical-align: middle;
                    text-align: center;

                }
                * {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                }
                body {
                    font-family: "Inter", sans-serif;
                    background: white;
                }</style>
            <div class="container-2">
                <div class="item">
                    <img src="img/bikepolicy.png" width="70%"/>
                </div>
                <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">

                    <div class="wrapper wrapper--w790">

                        <div class="card card-5">

                            <div class="card-heading">
                                <h2 class="title"> Two Wheeler Policy Registration Form</h2>
                            </div>
                            <div class="card-body">
                                <form action="CreateBikeClaim" method="POST">
                                    <div class="form-row">
                                        <div class="name">Name</div>
                                        <div class="value">
                                            <div class="input-group">

                                                <input class="input--style-5" type="text" value="${User.getFullName()}" name="fullName" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="name">User ID</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" type="text" value="${User.getUserId()}" name="userId" readonly>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="name">Email</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" type="email" value="${User.getEmail()}" name="email" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="name">Bike Number</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" type="text" placeholder="eg- WB12AC1417" name="bikeNumber" pattern="[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}" title="Wrong Bike Number Format" required>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="form-row">
                                    <div class="name">Bike Make</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select id="bikeMakeCode" name="bikeMake" onChange="fetchBikeModels('bikeMakeCode', 'bikeModelsId')" required>
                                                    <option value="">Select Bike Make</option>
                                                    <option value="HO">Honda</option>
                                                    <option value="BA">Bajaj</option>
                                                    <option value="YA">Yamaha</option>
                                                    <option value="RE">Royal Enfield</option>
                                                    <option value="MA">Mahindra</option>
                                                    <option value="SU">Suzuki</option>
                                                    <option value="HD">Harley Davidson</option>
                                                    <option value="HM">Hero Motocorp</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="bikeModelsId"></div>
                                
                                <div class="form-row">
                                    <div class="name">Bike Registration Year</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="bikeRegistrationYear" required>
                                                    <option value="">Bike Registration Year</option>
                                                    <option value="2023">2023</option>
                                                    <option value="2022">2022</option>
                                                    <option value="2021">2021</option>
                                                    <option value="2020">2020</option>
                                                    <option value="2019">2019</option>
                                                    <option value="2018">2018</option>
                                                    <option value="2017">2017</option>
                                                    <option value="2016">2016</option>


                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>








                                <div class="form-row">

                                    <div>
                                        <button class="btn btn--radius-2 btn" style="background-color: #9ec645" type="submit">Register</button>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Jquery JS-->
            <script src="policyRegister/jquery/jquery.min.js"></script>
            <!-- Vendor JS-->
            <script src="policyRegister/select2/select2.min.js"></script>
            <script src="policyRegister/datepicker/moment.min.js"></script>
            <script src="policyRegister/datepicker/daterangepicker.js"></script>

            <!-- Main JS-->
            <script src="js/policyRegister.js"></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->