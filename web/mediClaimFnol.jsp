<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>InsuranceBazar-Mediclaim</title>

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
                }
                /* HIDE RADIO */
                [type=radio] {
                    position: absolute;
                    opacity: 0;
                    width: 0;
                    height: 0;
                }

                /* IMAGE STYLES */
                [type=radio] + img {
                    cursor: pointer;
                    width: 70px;
                    height: 70px;
                }

                /* CHECKED STYLES */
                [type=radio]:checked + img {
                    outline: 2px solid #9ec645;
                }



            </style>
            <div class="container-2">
                <!--  <div class="item">
                      <img src="img/mediclaim.png" width="70%"/>
                  </div>-->
                <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
                    <div class="wrapper wrapper--w790">

                        <div class="card card-5">

                            <div class="card-heading">
                            <c:choose>
                                <c:when test='${Claim.getClaimStatus().equalsIgnoreCase("bought")}'>
                                    <h2 class="title"> File Your  MediClaim</h2>
                                </c:when>

                                <c:when test='${Claim.getClaimStatus().equalsIgnoreCase("1")}'>
                                    <h2 class="title">Your FNOL is yet to be approved by the Underwriter!!</h2>
                                </c:when>
                                    <c:when test='${Claim.getClaimStatus().equalsIgnoreCase("2")}'>
                                    <h2 class="title">Your claim is yet to be approved by the Insurance Officer!!</h2>
                                </c:when>
                                    <c:when test='${Claim.getClaimStatus().equalsIgnoreCase("3")}'>
                                    <h2 class="title">Congratulations!!Insurance  sanctioned!!</h2>
                                </c:when>
                                    <c:when test='${Claim.getClaimStatus().equalsIgnoreCase("4")}'>
                                    <h2 class="title">Your claim got rejected by the underwriter!!</h2>
                                </c:when>
                            </c:choose>

                        </div>
                        <div class="card-body">
                            <form action='UpdateMedClaim' method="POST">
                                <input type="hidden" value="${Claim.getClaimId()}" name="claimId"/>
                                <div class="form-row">
                                    <div class="name">Your Name</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" type="text" value="${Claim.getFullName()}" name="fullName">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="name">User ID</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" type="text" value="${Claim.getUserId()}" name="userId">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="name">Your Email</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" value="${Claim.getEmail()}" type="email" name="email">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="name">Your Age</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" value="${Claim.getAge()}" type="number" name="age">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="name">Your Gender</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" value="${Claim.getGender()}" type="gender" name="gender">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="name">Your Adhar Card</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" value="${Claim.getAdharCard()}"  name="adharCard">
                                        </div>
                                    </div>
                                </div>
                                <c:choose>
                                    <c:when test="${!Claim.getRelation().equalsIgnoreCase('SE')}">
                                        <div class="form-row">
                                            <div class="name">Relative Name</div>
                                            <div class="value">
                                                <div class="input-group">
                                                    <input class="input--style-5" value="${Claim.getRelativeName()}" type="gender" name="relativeName">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="name">Relative Age</div>
                                            <div class="value">
                                                <div class="input-group">
                                                    <input class="input--style-5" value="${Claim.getRelativeAge()}" type="gender" name="relativeAge">
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-row">
                                            <div class="name">Relative's Adhar Card Number</div>
                                            <div class="value">
                                                <div class="input-group">
                                                    <input class="input--style-5" value="${Claim.getRelationAdhar()}" type="gender" name="relationAdhar">
                                                </div>
                                            </div>
                                        </div>

                                    </c:when>
                                </c:choose>
                                <!--                                <div class="form-row">
                                                            <div class="name">Medical History</div>
                                                            <div class="value">
                                                                <div class="input-group">
                                                                    <input class="input--style-5" value="${Claim.getMedicalHistory()}" type="gender" name="medicalHistory">
                                                                </div>
                                                            </div>
                                                        </div>-->




                                <div class="form-row">
                                    <div class="name">Medical History</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <c:choose>
                                                <c:when test="${Claim.getMedicalHistory().equalsIgnoreCase('EX')}">
                                                    <input class="input--style-5" value="Existing Illness" type="gender" name="medicalHistory">
                                                </c:when>
                                                <c:when test="${Claim.getMedicalHistory().equalsIgnoreCase('SU')}">
                                                    <input class="input--style-5" value="Surgical Procedure" type="gender" name="medicalHistory">
                                                </c:when>
                                                <c:when test="${Claim.getMedicalHistory().equalsIgnoreCase('None')}">
                                                    <input class="input--style-5" value="None" type="gender" name="medicalHistory">
                                                </c:when>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="name">Disease</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" value="${Claim.getDisease()}" type="gender" name="disease">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="name">Insured For</div>
                                    <div class="value">
                                        <div class="input-group">
                                            <c:choose>
                                                <c:when test="${Claim.getRelation().equalsIgnoreCase('SE')}">
                                                    <input class="input--style-5" value="Self" type="gender" name="gender">
                                                </c:when>     

                                                <c:when test="${Claim.getRelation().equalsIgnoreCase('SP')}">
                                                    <input class="input--style-5" value="Spouse" type="gender" name="gender">
                                                </c:when>
                                                <c:when test="${Claim.getRelation().equalsIgnoreCase('MO')}">
                                                    <input class="input--style-5" value="Mother" type="gender" name="gender">
                                                </c:when>
                                                <c:when test="${Claim.getRelation().equalsIgnoreCase('SO')}">
                                                    <input class="input--style-5" value="Son" type="gender" name="gender">
                                                </c:when>
                                                <c:when test="${Claim.getRelation().equalsIgnoreCase('DA')}">
                                                    <input class="input--style-5" value="Daughter" type="gender" name="gender">
                                                </c:when>
                                                <c:when test="${Claim.getRelation().equalsIgnoreCase('FA')}">
                                                    <input class="input--style-5" value="Father" type="gender" name="gender">
                                                </c:when>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>
                                <!--                        <div class="form-row m-b-55">
                                                            <div class="name">User ID</div>
                                                            <div class="value">
                                                                <div class="row row-space">
                                                                    <div class="col-2">
                                                                        <div class="input-group-desc">
                                                                            <input class="input--style-5" type="text" name="userId">
                                                                            <label class="label--desc">Full Name</label>
                                                                        </div>
                                                                        <div class="col-2">
                                                                        <div class="input-group-desc">
                                                                            <input class="input--style-5" type="text" name="userId">
                                                                            <label class="label--desc">User  Id</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <div class="input-group-desc">
                                                                            <input class="input--style-5" type="text" name="email">
                                                                            <label class="label--desc">Email</label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>-->


                                <!--                        <div class="form-row">
                                                            <div class="name">child's age</div>
                                                            <div class="value">
                                                                <div class="input-group">
                                                                    <input class="input--style-5" type="number" name="age">
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <!-- <div class="form-row">
                                                            <div class="name">Medical History</div>
                                                            <div class="value">
                                                                <div class="input-group">
                                                                    <div class="rs-select2 js-select-simple select--no-search">
                                                                        <select name="subject">
                                                                            <option disabled="disabled" selected="selected">Select option</option>
                                                                            <option>Existing Illness</option>
                                                                            <option>Surgical Procedure</option>
                                                                            <option>None</option>
                                                                        </select>
                                                                        <div class="select-dropdown"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <!--                             <div class="form-row">
                                                            <div class="name">Relation</div>
                                                            <div class="value">
                                                                <div class="input-group">
                                                                    <input class="input--style-5" type="number" name="childAge">
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <!--  <div class="form-row">
                                                            <div class="name">Relative Name</div>
                                                            <div class="value">
                                                                <div class="input-group">
                                                                    <input class="input--style-5" type="number" name="age">
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <!--  <div class="form-row">
                                                            <div class="name">Date of Birth</div>
                                                            <div class="value">
                                                                <div class="input-group">
                                                                    <input class="input--style-5" type="date" name="age">
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <!--                        <div class="form-row m-b-55">
                                                            <div class="name">Phone</div>
                                                            <div class="value">
                                                                <div class="row row-refine">
                                                                    <div class="col-3">
                                                                        <div class="input-group-desc">
                                                                            <input class="input--style-5" type="text" name="area_code">
                                                                            <label class="label--desc">Area Code</label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-9">
                                                                        <div class="input-group-desc">
                                                                            <input class="input--style-5" type="text" name="phone">
                                                                            <label class="label--desc">Phone Number</label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <!--                        <div class="form-row">
                                                            <div class="name">Subject</div>
                                                            <div class="value">
                                                                <div class="input-group">
                                                                    <div class="rs-select2 js-select-simple select--no-search">
                                                                        <select name="subject">
                                                                            <option disabled="disabled" selected="selected">Choose option</option>
                                                                            <option>Subject 1</option>
                                                                            <option>Subject 2</option>
                                                                            <option>Subject 3</option>
                                                                        </select>
                                                                        <div class="select-dropdown"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>-->
                                <c:choose>
                                    <c:when test ='${Claim.getClaimStatus().equals("1") || Claim.getClaimStatus().equalsIgnoreCase("2") || Claim.getClaimStatus().equalsIgnoreCase("3") || Claim.getClaimStatus().equalsIgnoreCase("4")}'>
                                        <div class="form-row">
                                            <div class="name">Your Message</div>
                                            <div class="value">
                                                <div class="input-group">
                                                    <input class="input--style-5" type="textarea" name="message" value="${Claim.getMessage()}">
                                                </div>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test ='${Claim.getClaimStatus().equals("bought")}'>
                                        <b>Get Your Health Insurance Approved!!</b>
                                        <div class="form-row">
                                            <div class="name">Your Message</div>
                                            <div class="value">
                                                <div class="input-group">
                                                    <textarea
                                                        rows="6"
                                                        name="message"
                                                        id="message"
                                                        placeholder="Write your message..."
                                                        class="formbold-form-input"
                                                        ></textarea>
<!--                                                    <input class="input--style-5" type="textarea" name="message" >-->
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <button class="btn btn--radius-2 btn" style="background-color: #9ec645" type="submit">Submit</button>
                                        </div>
                                    </c:when>
                                </c:choose>    
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <div class="item">
                <img src="img/medi.png" width="70%"/>
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