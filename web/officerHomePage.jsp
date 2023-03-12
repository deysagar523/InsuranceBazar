<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>
        
    
</c:if>
<!doctype html>
<html lang="en">
    <head>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Dashboard - Admin</title>

        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="css/Officerstyle.css">
        <!-- FontAwesome CSS-->
        <link rel="stylesheet" href="css/all.css">
        <!-- Boxicons CSS-->
        <link rel="stylesheet" href="css/boxicons.min.css">
        <!-- Apexcharts  CSS -->

        <!-- Vendor CSS Files -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-icons.css" rel="stylesheet"> 
        <link href="css/boxicons.min.css" rel="stylesheet">
        <link href="css/quill.snow.css" rel="stylesheet">
        <link href="css/quill.bubble.css" rel="stylesheet">
        <link href="css/remixicon.css" rel="stylesheet">
        <link href="css/styleGraph.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="css/styleGraphMain.css" rel="stylesheet">
    </head>
    <script>
        function loadPage(jsp) {
            console.log("Within load Page");

            $.ajax({
                url: jsp,

                success: function (responseText) {

                    console.log(responseText);
                    $("#containerOfficer").html(responseText);
                }
            });

        }
    </script>
    <body>

        <!--Topbar -->
        <!--        <div class="topbar transition">
                    <div class="bars">
                        <button type="button" class="btn transition" id="sidebar-toggle">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16" color="black">
                            <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                            </svg>                </button>
                    </div>
                    <div class="menu">
                        <ul>
        
        
        
        
                            </li>
        
                            <li class="nav-item dropdown">
                                <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLKYamkRB_qMHdd_HvhrxBlHhExgcAW6Mquw&usqp=CAU" alt="">
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="background-color: #86B817;">
                                        <a class="dropdown-item" href="my-profile.html"><i class="fa fa-user size-icon-1"></i> <span>My Profile</span></a>
                                            <a class="dropdown-item" href="settings.html"><i class="fa fa-cog size-icon-1"></i> <span>Settings</span></a>
                                            <hr class="dropdown-divider">
                                    
                                    <a class="dropdown-item" href="Logout" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16" color="white">
                                        <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                        <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                        </svg> <span style="color: white">Logout</span></a>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>-->

        <!--Sidebar-->
        <div class="sidebar transition overlay-scrollbars animate__animated  animate__slideInLeft">
            <div class="sidebar-content"> 
                <div id="sidebar">

                    <!-- Logo -->
                    <div class="logo">
                        <h2 class="mb-0"><img src="https://png.pngtree.com/png-clipart/20200709/original/pngtree-life-insurance-logo-png-image_4113029.jpg"> Insurance Bazar</h2>
                    </div>

                    <ul class="side-menu">
                        <li>
                            <a href="officerHomePage.jsp" class="active" style="background-color: #09470e;">
                                <i class='bx bxs-dashboard icon' ></i> Dashboard
                            </a>
                        </li>

                        <!-- Divider-->
                        <li class="divider" data-text="STARTER"></li>



                        <li>
                            <a onclick="loadPage('historyPageOfficer.jsp')">
                                <i class='bx bxs-meh-blank icon'></i> 
                                History
                            </a>
                        </li>

                        <li>
                            <a>
                                <i class='fa fa-th icon' ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list-ul" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                                    </svg></i> 
                                health Policy List 
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
                                </svg> 
                            </a>
                            <ul class="side-dropdown">



                                <li><a onclick="loadPage('policyListMediclaim.jsp')">Mediclaim</a></li>
                                <li><a onclick="loadPage('policyListCriticalIllness.jsp')">Critical Illness</a></li>

                                <!--				<li><a href="bootstrap-carousel.html"></a></li>
                                                                <li><a href="bootstrap-dropdown.html"></a></li>
                                                                <li><a href="bootstrap-list-group.html"></a></li>
                                                                <li><a href="bootstrap-modal.html"></a></li>
                                                                <li><a href="bootstrap-nav.html"></a></li>
                                                                <li><a href="bootstrap-pagination.html"></a></li>
                                                                <li><a href="bootstrap-progress.html"></a></li>
                                                                <li><a href="bootstrap-spinner.html"></a></li>  -->
                            </ul>
                        </li>

                        <li>
                            <a>
                                <i class='fa fa-th icon' ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list-ul" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                                    </svg></i> 
                                Car Policy List 
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
                                </svg> 
                            </a>
                            <ul class="side-dropdown">




                                <li><a onclick="loadPage('policyListTwoWheeler.jsp')">two wheeler</a></li>
                                <li><a onclick="loadPage('policyListFourWheeler.jsp')">Four wheeler</a></li>
                                <!--				<li><a href="bootstrap-carousel.html"></a></li>
                                                                <li><a href="bootstrap-dropdown.html"></a></li>
                                                                <li><a href="bootstrap-list-group.html"></a></li>
                                                                <li><a href="bootstrap-modal.html"></a></li>
                                                                <li><a href="bootstrap-nav.html"></a></li>
                                                                <li><a href="bootstrap-pagination.html"></a></li>
                                                                <li><a href="bootstrap-progress.html"></a></li>
                                                                <li><a href="bootstrap-spinner.html"></a></li>  -->
                            </ul>
                        </li>

                        <li>
                            <a>
                                <i class='fa fa-th icon' ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list-ul" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                                    </svg></i> 
                                Term Policy List 
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
                                </svg> 
                            </a>
                            <ul class="side-dropdown">




                                <li><a onclick="loadPage('policyListLifeInsurance.jsp')" >Life Insurance</a></li>
                                <li><a onclick="loadPage('policyListTermForNri.jsp')">Term For Nri</a></li>
                                <!--				<li><a href="bootstrap-carousel.html"></a></li>
                                                                <li><a href="bootstrap-dropdown.html"></a></li>
                                                                <li><a href="bootstrap-list-group.html"></a></li>
                                                                <li><a href="bootstrap-modal.html"></a></li>
                                                                <li><a href="bootstrap-nav.html"></a></li>
                                                                <li><a href="bootstrap-pagination.html"></a></li>
                                                                <li><a href="bootstrap-progress.html"></a></li>
                                                                <li><a href="bootstrap-spinner.html"></a></li>  -->
                            </ul>
                        </li>
                        <li>
                            <a>
                                <i class='fa fa-th icon' ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list-ul" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                                    </svg></i> 
                                Investment Policy List 
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
                                </svg> 
                            </a>
                            <ul class="side-dropdown">




                                <li><a onclick="loadPage('policyListChildInvestment.jsp')">Child Investment</a></li>
                                <li><a onclick="loadPage('policyListPensionPlan.jsp')">Pension Plan</a></li>
                                <!--				<li><a href="bootstrap-carousel.html"></a></li>
                                                                <li><a href="bootstrap-dropdown.html"></a></li>
                                                                <li><a href="bootstrap-list-group.html"></a></li>
                                                                <li><a href="bootstrap-modal.html"></a></li>
                                                                <li><a href="bootstrap-nav.html"></a></li>
                                                                <li><a href="bootstrap-pagination.html"></a></li>
                                                                <li><a href="bootstrap-progress.html"></a></li>
                                                                <li><a href="bootstrap-spinner.html"></a></li>  -->
                            </ul>
                        </li>
                        <li>
                            <a>
                                <i class='fa fa-th icon' ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list-ul" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm-3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2zm0 4a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                                    </svg></i> 
                                Others Policy List 
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
                                </svg> 
                            </a>
                            <ul class="side-dropdown">




                                <li><a onclick="loadPage('policyListTravel.jsp')">Travel Insurance </a></li>
                                <li><a onclick="loadPage('policyListEducationPlan.jsp')">Education Plan</a></li>
                                <!--				<li><a href="bootstrap-carousel.html"></a></li>
                                                                <li><a href="bootstrap-dropdown.html"></a></li>
                                                                <li><a href="bootstrap-list-group.html"></a></li>
                                                                <li><a href="bootstrap-modal.html"></a></li>
                                                                <li><a href="bootstrap-nav.html"></a></li>
                                                                <li><a href="bootstrap-pagination.html"></a></li>
                                                                <li><a href="bootstrap-progress.html"></a></li>
                                                                <li><a href="bootstrap-spinner.html"></a></li>  -->
                            </ul>
                        </li>
                        <li>


                            <a class="dropdown-item" href="Logout" >
                                <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                </svg> <span style="color: white">Logout</span></a>

                        </li>

                        <!-- Divider-->
                        <!--         <li class="divider" data-text="Atrana">Atrana</li>
                 
                                                 <li>
                                     <a href="#">
                                                                 <i class='bx bx-columns icon' ></i> 
                                                                 Components 
                                                                 <i class='bx bx-chevron-right icon-right' ></i>
                                                         </a>
                                     <ul class="side-dropdown">
                                         <li><a href="component-avatar.html">Avatar</a></li>
                                                                 <li><a href="component-toastify.html">Toastify</a></li>
                                         <li><a href="component-sweet-alert.html">Sweet Alert</a></li>
                                         <li><a href="component-hero.html">Hero</a></li>
                                     </ul>
                                 </li>
                 
                                 <li>
                                     <a href="#">
                                                                 <i class='bx bxs-notepad icon' ></i> 
                                                                 Forms 
                                                                 <i class='bx bx-chevron-right icon-right' ></i>
                                                         </a>
                                     <ul class="side-dropdown">
                                         <li><a href="forms-editor.html">Editor</a></li>
                                         <li><a href="forms-validation.html">Validation</a></li>
                                         <li><a href="forms-checkbox.html">Checkbox</a></li>
                                         <li><a href="forms-radio.html">Radio</a></li>
                                     </ul>
                                 </li>
                 
                                                 <li>
                                     <a href="#">
                                                                 <i class='bx bxs-widget icon' ></i> 
                                                                 Widgets 
                                                                 <i class='bx bx-chevron-right icon-right' ></i>
                                                         </a>
                                     <ul class="side-dropdown">
                                         <li><a href="widgets-chatboxs.html">ChatBox</a></li>
                                         <li><a href="widgets-email.html">Emails</a></li>
                                         <li><a href="widgets-pricing.html">Pricing</a></li>
                                     </ul>
                                 </li>
                 
                                                 <li>
                                     <a href="#">
                                                                 <i class='bx bxs-bar-chart-alt-2 icon' ></i> 
                                                                 Charts 
                                                                 <i class='bx bx-chevron-right icon-right' ></i>
                                                         </a>
                                     <ul class="side-dropdown">
                                         <li><a href="chart-chartjs.html">ChartJS</a></li>
                                         <li><a href="chart-apexcharts.html">Apexcharts</a></li>
                                     </ul>
                                 </li>
                 
                                                 <li>
                                     <a href="#">
                                                                 <i class='bx bxs-cloud-rain icon' ></i> 
                                                                 Icons 
                                                                 <i class='bx bx-chevron-right icon-right' ></i>
                                                         </a>
                                     <ul class="side-dropdown">
                                         <li><a href="icons-fontawesome.html">Fontawesome</a></li>
                                         <li><a href="icons-boostrap.html">Bootstrap Icons</a></li>
                                     </ul>
                                 </li>  -->

                        <!-- Divider-->
                        <li class="divider" data-text="Pages"></li>

                        <!--	<li>
                            <a href="#">
                                                        <i class='bx bxs-user icon' ></i> 
                                                        Auth 
                                                        <i class='bx bx-chevron-right icon-right' ></i>
                                                </a>
                            <ul class="side-dropdown">
                                <li><a href="auth-login.html">Login</a></li>
                                <li><a href="auth-register.html">Register</a></li>
                                <li><a href="auth-forgot-password.html">Forgot Password</a></li>
                                <li><a href="auth-reset-password.html">Reset Password</a></li>
                            </ul>
                        </li>
        
                                        <li>
                            <a href="#">
                                                        <i class='bx bxs-error icon' ></i> 
                                                        Errors 
                                                        <i class='bx bx-chevron-right icon-right' ></i>
                                                </a>
                            <ul class="side-dropdown">
                                <li><a href="errors-403.html">403</a></li>
                                <li><a href="errors-404.html">404</a></li>
                                <li><a href="errors-500.html">500</a></li>
                                <li><a href="errors-503.html">503</a></li>
                            </ul>
                        </li>
        
        
                                        <li>
                                                <a href="credits.html"><i class='fa fa-pencil-ruler icon' ></i> 
                                                        Credits
                                                </a>
                                        </li>
        
                    </ul>
        
                    <div class="ads">
                                        <div class="wrapper">
                                                <div class="help-icon"><i class="fa fa-circle-question fa-3x"></i></div>
                                                <p>Need Help with <strong>Atrana</strong>?</p>
                            <a href="docs/" class="btn-upgrade">Documentation</a>
                         </div>
                    </div> --> 

                </div>

            </div> 
        </div>
    </div><!-- End Sidebar-->


    <div class="sidebar-overlay"></div>


    <!--Content Start-->
    <div class="content-start transition" style="background-color: #d0f2f2;" id="containerOfficer">
        <div class="container-fluid dashboard" >
            <div class="content-header">
                <h1>Admin</h1>
                <p></p>
            </div>

            <div class="row">

                <div class="col-md-6 col-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-4 d-flex align-items-center">
                                    <i class="fas fa-inbox icon-home bg-primary text-light"></i>
                                </div>
                                <div class="col-8">
                                    <p>Total Revenue</p>
                                    <h5>${TotalRevenue}</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-4 d-flex align-items-center">
                                    <i class="fas fa-clipboard-list icon-home bg-success text-light"></i>
                                </div>
                                <div class="col-8">
                                    <p>Policies</p>
                                    <h5>30</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-4 d-flex align-items-center">
                                    <i class="fas fa-chart-bar  icon-home bg-info text-light"></i>
                                </div>
                                <div class="col-8">
                                    <p>Top Most Sale</p>
                                    <h5>5000</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-4 d-flex align-items-center">
                                    <i class="fas fa-id-card  icon-home bg-warning text-light"></i>
                                </div>
                                <div class="col-8">
                                    <p>Users</p>
                                    <h5>${TotalUsers}</h5>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-md-6">
                    <div class="card-body" style="background-color: white; width: 75vw; margin-bottom: 20px">
                        <h5>Reports/Today</h5>

                        <!-- Line Chart -->
                        <div id="reportsChart"></div>

                        <script>
                            document.addEventListener("DOMContentLoaded", () => {
                                new ApexCharts(document.querySelector("#reportsChart"), {
                                    series: [ {
                                            name: 'Users Registered',
                                            data: [ ${Day5Users},${Day4Users},${Day3Users},${Day2Users},${Day1Users},${TodayUsers}]
                                        }, {
                                            name: 'Policy Bought',
                                            data: [${Day5Policy}, ${Day4Policy}, ${Day3Policy}, ${Day2Policy}, ${Day1Policy},${TodayPolicy}]
                                        }],
                                    chart: {
                                        height: 350,
                                        type: 'area',
                                        toolbar: {
                                            show: false
                                        },
                                    },
                                    markers: {
                                        size: 4
                                    },
                                    colors: ['#4154f1', '#2eca6a', '#ff771d'],
                                    fill: {
                                        type: "gradient",
                                        gradient: {
                                            shadeIntensity: 1,
                                            opacityFrom: 0.3,
                                            opacityTo: 0.4,
                                            stops: [0, 90, 100]
                                        }
                                    },
                                    dataLabels: {
                                        enabled: false
                                    },
                                    stroke: {
                                        curve: 'smooth',
                                        width: 2
                                    },
                                    xaxis: {
                                        type: 'date',
                                        categories: ["${Day5}", "${Day4}", "${Day3}", "${Day2}", "${Day1}", "${CurrentDay}"]
                                    },
                                    tooltip: {
                                        x: {
                                            format: 'dd/MM/yy'
                                        },
                                    }
                                }).render();
                            });
                        </script>
                        <!-- End Line Chart -->

                    </div>


                    <div class="col-md-12">
                        <div class="card" style="width: 75vw">
                            <div class="card-header">
                                <h4>Latest Claims</h4>
                            </div>
                            <div class="card-body"> 
                                <div class="table-responsive"> 
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th scope="col">FNOL Id</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Date</th>
                                                <th scope="col">Amount</th>
                                                <th scope="col">Policy Name</th>
                                                <th scope="col">Status</th>

                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <th scope="row">#SK2548	</th>
                                                <td>Neal Matthews</td>
                                                <td>07 Oct, 2022</td>
                                                <td>$400</td>
                                                <td>Health</td>
                                                <td><span class="text-success">Santioned</span></td>
                                                <td><button class="btn btn-primary btn-success" style="background-color: #86B817;">--</button></td>
                                            </tr>

                                            <tr>
                                                <th scope="row">#SK2548	</th>
                                                <td>Neal Matthews</td>
                                                <td>07 Oct, 2022</td>
                                                <td>$400</td>
                                                <td>Life</td>
                                                <td><span class="text-success">Santioned</span></td>
                                                <td><button class="btn btn-primary btn-success" style="background-color: #86B817;">--</button></td>
                                            </tr>

                                            <tr>
                                                <th scope="row">#SK2548	</th>
                                                <td>Neal Matthews</td>
                                                <td>07 Oct, 2022</td>
                                                <td>$400</td>
                                                <td>Car</td>
                                                <td><span class="text-danger">Rejected</span></td>
                                                <td><button class="btn btn-primary btn-success" style="background-color: #86B817;">--</button></td>
                                            </tr>

                                            <tr>
                                                <th scope="row">#SK2548	</th>
                                                <td>Neal Matthews</td>
                                                <td>07 Oct, 2022</td>
                                                <td>$400</td>
                                                <td>Education</td>
                                                <td><span class="text-warning">Pending</span></td>
                                                <td><button class="btn btn-primary btn-success" style="background-color: #86B817;">Edit</button></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <!-- Footer -->				
        <footer>
            <div class="footer">
                <div class="float-start">
                    <p>2023 &copy; Insurance Bazar</p>
                </div>

            </div>
        </footer>


        <!-- Preloader -->


        <!-- Loader -->

        <!-- General JS Scripts -->

        <!-- JS Libraies -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>

        <!-- Chart Js -->

        <!-- Template JS File -->
        <script src="js/script.js"></script>
        <script src="js/custom.js"></script>

        <!-- Vendor JS Files -->
        <script src="js/apexcharts.min.js"></script>
        <script src="js/chart.umd.js"></script>
        <script src="js/echarts.min.js"></script>
        <script src="js/quill.min.js"></script>
        <script src="js/simple-datatables.js"></script>
        <script src="js/tinymce.min.js"></script>

        <!-- Template Main JS File -->
        <script src="js/mainGraph.js"></script>
</body>

</body>
</html>
