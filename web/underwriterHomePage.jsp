<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>Dashboard - Underwriter</title>

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
					  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLKYamkRB_qMHdd_HvhrxBlHhExgcAW6Mquw&usqp=CAU" alt="">
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
	<div class="sidebar transition overlay-scrollbars animate__animated  animate__slideInLeft">
        <div class="sidebar-content"> 
        	<div id="sidebar">
			
			<!-- Logo -->
			<div class="logo">
					<h2 class="mb-0"><img src="https://png.pngtree.com/png-clipart/20200709/original/pngtree-life-insurance-logo-png-image_4113029.jpg"> Insurance Bazar</h2>
			</div>

            <ul class="side-menu">
                <li>
					<a href="officer_dash.html" class="active" style="background-color: #09470e;">
						<i class='bx bxs-dashboard icon' ></i> Underwriter Dashboard
					</a>
				</li>

				<!-- Divider-->
                <li class="divider" data-text="STARTER"></li>

                <li>
                    <a href="#">
						<i class='bx bx-columns icon' ></i> 
						Show Claims 
						
					</a>
                    
                </li>

                <li>
					<a href="blank-pages.html">
						<i class='bx bxs-meh-blank icon'></i> 
						History
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
<!--				<li class="divider" data-text="Pages"></li>-->

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
	<div class="content-start transition" style="background-color: #d0f2f2;">
		<div class="container-fluid dashboard" >
			<div class="content-header">
				<h1>Underwriter</h1>
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
