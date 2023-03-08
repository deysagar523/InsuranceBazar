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

        <title>Dashboard - User</title>

        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="css/Officerstyle.css">
        <!-- FontAwesome CSS-->
        <link rel="stylesheet" href="css/all.css">
        <!-- Boxicons CSS-->
        <link rel="stylesheet" href="css/boxicons.min.css">
        <!-- Apexcharts  CSS -->
    </head>
    <body>

        <!--Topbar -->
        <div class="topbar transition">
            <div class="bars">
                <button type="button" class="btn transition" id="sidebar-toggle">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
            <div class="menu">
                <ul>




                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                           
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="background-color: #86B817;">
                            <!--	<a class="dropdown-item" href="my-profile.html"><i class="fa fa-user size-icon-1"></i> <span>My Profile</span></a>
                                    <a class="dropdown-item" href="settings.html"><i class="fa fa-cog size-icon-1"></i> <span>Settings</span></a>
                                    <hr class="dropdown-divider">
                            -->
                            <a class="dropdown-item" href="#" ><img src="" > <span style="color: white">Logout</span></a>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>

        <!--Sidebar-->
        <div class="sidebar transition overlay-scrollbars animate_animated  animate_slideInLeft">
            <div class="sidebar-content"> 
                <div id="sidebar">

                    <!-- Logo -->
                    <div class="logo">
                        <h2 class="mb-0"><img src="https://png.pngtree.com/png-clipart/20200709/original/pngtree-life-insurance-logo-png-image_4113029.jpg"> Insurance Bazar</h2>
                    </div>

                    <ul class="side-menu">
                        <li>
                            <a href="officer_dash.html" class="active" style="background-color: #09470e;">
                                <i class='bx bxs-dashboard icon' ></i> User Dashboard
                            </a>
                        </li>

                        <!-- Divider-->
                        <li class="divider" data-text="STARTER"></li>

                        <li>
                            <a href="#">
                                <i class='bx bx-columns icon' ></i> 
                                 My Policies
                                <i class='bx bx-chevron-right icon-right' ></i>
                            </a>
                            <ul class="side-dropdown">
                                <li><a href="layout-default.html">Category </a></li>
                                <li><a href="layout-top-navigation.html">Sub Category</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="blank-pages.html">
                                <i class='bx bxs-meh-blank icon'></i> 
                                My Profile
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class='fa fa-th icon' ></i> 
                                Policy List 
                                <i class='bx bx-chevron-right icon-right' ></i>
                            </a>
                            <ul class="side-dropdown">
                                <li><a href="bootstrap-alert.html">Health</a></li>
                                <li><a href="bootstrap-badge.html">Life</a></li>
                                <li><a href="bootstrap-breadcrumb.html">Car</a></li>
                                <li><a href="bootstrap-buttons.html">Home</a></li>
                                <li><a href="bootstrap-card.html">Education</a></li>

                            </ul>
                        </li>


                </div>

            </div> 
        </div>
    </div><!-- End Sidebar-->


    <div class="sidebar-overlay"></div>


    <!--Content Start-->
    <div class="content-start transition" style="background-color: #d0f2f2;">
        <div class="container-fluid dashboard" >
            <div class="content-header">
                <h1>User</h1>
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
                                    <h5>$65</h5>
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
                                    <p>My Policies</p>
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
                                    <h5>256</h5>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                        </div>
                        <div class="card-body">
                            <div id="columnchart"></div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header">
                            <h4>Recent Users</h4>
                        </div>
                        <div class="card-body pb-4">
                            <div class="recent-message d-flex px-4 py-3">
                                <div class="avatar avatar-lg">
                                    <img src="assets/images/message/4.jpg">
                                </div>
                                <div class="name ms-4">
                                    <h5 class="mb-1">Hank Schrader</h5>
                                    <h6 class="text-muted mb-0">@johnducky</h6>
                                </div>
                            </div>
                            <div class="recent-message d-flex px-4 py-3">
                                <div class="avatar avatar-lg">
                                    <img src="assets/images/message/5.jpg">
                                </div>
                                <div class="name ms-4">
                                    <h5 class="mb-1">Dean Winchester</h5>
                                    <h6 class="text-muted mb-0">@imdean</h6>
                                </div>
                            </div>
                            <div class="recent-message d-flex px-4 py-3">
                                <div class="avatar avatar-lg">
                                    <img src="assets/images/message/1.jpg">
                                </div>
                                <div class="name ms-4">
                                    <h5 class="mb-1">John Doe</h5>
                                    <h6 class="text-muted mb-0">@Doejohn</h6>
                                </div>
                            </div>
                            <div class="px-4">
                                <button class='btn btn-block btn-xl btn-success' style="background-color: #86B817;">View All
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="card">
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

</body>
</html>