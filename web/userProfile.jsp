
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta charset="UTF-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="img/favicon.ico" rel="icon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <!-- Icon Font Stylesheet -->
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.3.js" 
                integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                crossorigin="anonymous">
        </script>
        <title>user Profile</title>

        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="css/Officerstyle.css">
        <!-- FontAwesome CSS-->
        <link rel="stylesheet" href="css/all.css">
        <!-- Boxicons CSS-->
        <link rel="stylesheet" href="css/boxicons.min.css">
    </head>

    <style>
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
            outline: 2px solid greenyellow;
        }
    </style>
    <script>
        function loadPage(jsp) {
            console.log("Within load Page");

            $.ajax({
                url: jsp,

                success: function (responseText) {

                    console.log(responseText);
                    $("#container").html(responseText);
                }
            });

        }

        function laodPlans(userId) {

            console.log(userId);

            $.ajax({
                url: 'FetchPlans',
                data: {
                    userId: userId
                },
                success: function (responseText) {

                    alert(responseText);
                    $("#container").html(responseText);
                }
            });

        }
    </script>
    <script>
        function previewImage(event) {
            alert("preview img working");
            var input = event.target;
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    var imagePreview = document.getElementById("image-preview");
                    imagePreview.src = e.target.result;
                };
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
    <body id="container">
        <!--Topbar -->
        <div class="topbar transition">
            <div class="bars">
                <button type="button" class="btn transition" id="sidebar-toggle">
                    <svg xmlns="http://www.w3.org/2000/svg" width="70" height="76" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16" color="black">
                    <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                    </svg>
                </button>
            </div>>
            <div class="menu">
                <ul>
                    <li class="nav-item dropdown dropdown-list-toggle">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-wechat" viewBox="0 0 16 16">
                            <path d="M11.176 14.429c-2.665 0-4.826-1.8-4.826-4.018 0-2.22 2.159-4.02 4.824-4.02S16 8.191 16 10.411c0 1.21-.65 2.301-1.666 3.036a.324.324 0 0 0-.12.366l.218.81a.616.616 0 0 1 .029.117.166.166 0 0 1-.162.162.177.177 0 0 1-.092-.03l-1.057-.61a.519.519 0 0 0-.256-.074.509.509 0 0 0-.142.021 5.668 5.668 0 0 1-1.576.22ZM9.064 9.542a.647.647 0 1 0 .557-1 .645.645 0 0 0-.646.647.615.615 0 0 0 .09.353Zm3.232.001a.646.646 0 1 0 .546-1 .645.645 0 0 0-.644.644.627.627 0 0 0 .098.356Z"/>
                            <path d="M0 6.826c0 1.455.781 2.765 2.001 3.656a.385.385 0 0 1 .143.439l-.161.6-.1.373a.499.499 0 0 0-.032.14.192.192 0 0 0 .193.193c.039 0 .077-.01.111-.029l1.268-.733a.622.622 0 0 1 .308-.088c.058 0 .116.009.171.025a6.83 6.83 0 0 0 1.625.26 4.45 4.45 0 0 1-.177-1.251c0-2.936 2.785-5.02 5.824-5.02.05 0 .1 0 .15.002C10.587 3.429 8.392 2 5.796 2 2.596 2 0 4.16 0 6.826Zm4.632-1.555a.77.77 0 1 1-1.54 0 .77.77 0 0 1 1.54 0Zm3.875 0a.77.77 0 1 1-1.54 0 .77.77 0 0 1 1.54 0Z"/>
                            </svg><span class="badge bg-danger notif">4</span>
                        </a> 				 
                        <div class="dropdown-menu dropdown-list">
                            <div class="dropdown-header">Notifications</div>
                            <div class="dropdown-list-content dropdown-list-icons">
                                <div class="custome-list-notif"> 
                                    <a href="#" class="dropdown-item dropdown-item-unread">
                                        <div class="dropdown-item-icon bg-primary text-white">
                                            <i class="fas fa-code"></i>
                                        </div>
                                        <div class="dropdown-item-desc">
                                            The Atrana template has the latest update!
                                            <div class="time text-primary">3 Min Ago</div>
                                        </div>
                                    </a>

                                    <a href="#" class="dropdown-item">
                                        <div class="dropdown-item-icon bg-info text-white">
                                            <i class="far fa-user"></i>
                                        </div>
                                        <div class="dropdown-item-desc">
                                            Sri asks you for friendship!
                                            <div class="time">12 Hours Ago</div>
                                        </div>
                                    </a>

                                    <a href="#" class="dropdown-item">
                                        <div class="dropdown-item-icon bg-danger text-white">
                                            <i class="fas fa-check"></i>
                                        </div>
                                        <div class="dropdown-item-desc">
                                            Storage has been cleared, now you can get back to work!
                                            <div class="time">20 Hours Ago</div>
                                        </div>
                                    </a>


                                    <a href="#" class="dropdown-item">
                                        <div class="dropdown-item-icon bg-info text-white">
                                            <i class="fas fa-bell"></i>
                                        </div>
                                        <div class="dropdown-item-desc">
                                            Welcome , I hope you enjoy using this template!
                                            <div class="time">Yesterday</div>
                                        </div>
                                    </a>

                                </div>
                            </div>

                            <div class="dropdown-footer text-center">
                                <a href="#">View All</a>
                            </div>


                    </li>

                    <li class="nav-item dropdown">

                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <c:if test="${User.imageData!=null}">
                                <img src="data:image/png;base64,${User.imageData}" style="max-width: 150px; max-height: 150px;">
                            </c:if>
                            <c:if test="${User.imageData==null}">

                                <img src="img/user.png" style="max-width: 150px; max-height: 150px;">
                            </c:if>
                        </a>







                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="my-profile.html"><i class="fa fa-user size-icon-1"></i> <span>My Profile</span></a>
                            <a class="dropdown-item" href="settings.html"><i class="fa fa-cog size-icon-1"></i> <span>Settings</span></a>
                            <hr class="dropdown-divider">
                            <a class="dropdown-item" href="Logout"><i class="fa fa-sign-out-alt  size-icon-1"></i> Logout</a>
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
                        <h2 class="mb-0"><img src="https://png.pngtree.com/png-clipart/20200709/original/pngtree-life-insurance-logo-png-image_4113029.jpg">Insurance Bazzar</h2>
                    </div>

                    <ul class="side-menu">
                        <li>
                            <a href="userProfile.jsp" class="active">
                                <i class='bx bxs-dashboard icon' ></i>  My Profile
                                <!--                            </a>
                                                        </li>
                                
                                                         Divider
                                                        <li class="divider" data-text="STARTER"></li>
                                
                                                        <li>
                                                            <a href="#">
                                                                <i class='bx bx-columns icon' ></i> 
                                                                My Profile
                                                                <i class='bx bx-chevron-right icon-right' ></i>
                                                            </a>
                                
                                                        </li>
                                
                                                        <li>
                                                            <a href="policyListTwoWheeler_1.jsp">
                                                                <i class='bx bxs-meh-blank icon'></i> 
                                                                My Policies
                                                            </a>
                                                        </li>
                                
                                                        <li>
                                                            <a href="#">
                                                                <i class='fa fa-th icon' ></i> 
                                                                Claim Support
                                                                <i class='bx bx-chevron-right icon-right' ></i>
                                                            </a>
                                
                                                        </li>
                                
                                                         Divider
                                                        <li class="divider" data-text="Atrana"></li>
                                
                                                        <li>
                                                            <a href="paymentForm.jsp">
                                                                <i class='bx bx-columns icon' ></i> 
                                                                Payment
                                                                <i class='bx bx-chevron-right icon-right' ></i>
                                                            </a>
                                
                                                        </li>
                                
                                                        <li>
                                                            <a href="#">
                                                                <i class='bx bxs-notepad icon' ></i> 
                                                                Help
                                                                <i class='bx bx-chevron-right icon-right' ></i>
                                                            </a>
                                
                                                        </li>
                                
                                
                                
                                                         Divider
                                                        <li class="divider" data-text="Pages"></li>
                                
                                                        <li>
                                                            <a href="#">
                                                                <i class='bx bxs-user icon' ></i> 
                                                                Settings
                                                                <i class='bx bx-chevron-right icon-right' ></i>
                                                            </a>
                                
                                                            </div>
                                
                                                            </div> 
                                                            </div>
                                                            </div> End Sidebar-->
                            </a>
                        </li>

                        <!-- Divider-->
                        <li class="divider" data-text="STARTER"></li>


                        <!--                            <li>
                                                        <a href="userProfile.jsp">
                                                            <i class='bx bxs-meh-blank icon'></i> 
                                                            My Profile
                                                        </a>
                                                    </li>-->

                        <li>
                            <a onClick="laodPlans(<c:out value="${userId}"> </c:out>)">
                                    <i class='bx bxs-meh-blank icon'></i> 
                                    My Plans
                                </a>
                            </li>






                            <li>
                                <a href="paymentForm.jsp">
                                    <i class='bx bx-columns icon' ></i> 
                                    Payment
                                    <i class='bx bx-chevron-right icon-right' ></i>
                                </a>
                            </li>
                            <li>
                                <a href="paymentForm.jsp">
                                    <i class='bx bx-columns icon' ></i> 
                                    Claim Support
                                    <i class='bx bx-chevron-right icon-right' ></i>
                                </a>
                            </li>
                            <li>


                                <a class="dropdown-item" href="Logout" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16" color="white">
                                    <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                    <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                    </svg> <span style="color: white">Logout</span></a>

                            </li>



                    </div>

                </div> 
            </div>
        </div><!-- End Sidebar-->


        <div class="sidebar-overlay"></div>


        <!--Content Start-->
        <div class="content-start transition">
            <div class="container-fluid dashboard">
                <div class="content-header">
                    <h4>Hi, ${User.fullName}!</h4>
                <p>Complete your Profile</p>
            </div>

            <div class="row">
                <div class="card">
                    <!--                        <div class="card-body">
                                                <div class="d-flex align-items-start align-items-sm-center  ">
                    
                    
                    
                                                </div>
                                            </div>-->

                    <div class="card-body"> 
                        <form action="UpdateUser"  method="POST" enctype="multipart/form-data">
                            <div class="row">

                                <div class="form-floating text-center">                                        
                                    <input type="file" id="image-file" name="image" onchange="previewImage(event)">
                                    <br>
                                    <img id="image-preview"  style="max-width: 200px; max-height: 200px;">
                                </div>


                                <input class="form-control" type="hidden" value="${User.userId}" readonly id="firstName" name="userId"  autofocus />

                                <div class="mb-3 col-md-6">
                                    <label for="firstName" class="form-label">Full Name</label>
                                    <input class="form-control" type="text" value="${User.fullName}" id="firstName" name="fullName"  autofocus required/>
                                </div>


                                <div class="mb-3 col-md-6">
                                    <label for="email" class="form-label">E-mail</label>
                                    <input class="form-control" type="text" readonly id="email" name="email" value="${User.email}" placeholder="Andree@example.com" />
                                </div>
                                <div class="mb-3 col-md-6">
                                    <label for="organization" class="form-label">Phone</label>
                                    <input type="text" class="form-control" id="organization" name="phone" value="${User.phone}" title="This is Not a Valid Phone Number" pattern="[6-9]{1}[0-9]{9}" required/>
                                </div>
                                <!-- Source of Income and Income Amount -->
                                <div class="mb-3 col-md-6">
                                    <label class="form-label">Source of Income</label>
                                    <select name="incomeSource" class="form-control" id="level" >
                                        <option value="Employed" <c:if test="${User.incomeSource.equalsIgnoreCase('Employed')}"> selected</c:if>>Employed</option>
                                        <option value="Self-Employed" <c:if test="${User.incomeSource.equalsIgnoreCase('Self-Employed')}"> selected</c:if>>Self-employed</option>
                                        <option value="UnEmployed" <c:if test="${User.incomeSource.equalsIgnoreCase('UnEmployed')}">selected</c:if>>Unemployed</option>
                                    </select>
                                </div>




                                <div class="mb-3 col-md-6">
                                    <<label for="age" class="form-label">Age</label>
                                    <input type="number" class="form-control" id="organization" name="age" value="${User.age}" required/>
                                </div>

                                <div class="mb-3 col-md-6">
                                    <!--                                        <label for="lastName" class="form-label">Gender</label>
                                                                            <input class="form-control" type="text" value="${User.gender}" name="gender" id="lastName"  required/>-->
                                    <div class="form-row p-t-20">
                                        <label class="label label--block"> Select Gender</label>
                                        <div class="p-t-15">
                                            <label>
                                                <input type="radio" name="gender" value="Male" <c:if test="${User.gender.equalsIgnoreCase('Male')}"> checked</c:if> >
                                                    <img src="https://img.freepik.com/premium-vector/men-icon-trendy-avatar-character-cheerful-happy-people-flat-vector-illustration-round-frame-male-portraits-group-team-adorable-guys-isolated-white-background_275421-286.jpg?w=2000" alt="Option 1">
                                                </label>
                                                <label>

                                                </label>

                                                <label>
                                                    <input type="radio" name="gender" value="Female" <c:if test="${User.gender.equalsIgnoreCase('Female')}"> checked</c:if>>
                                                <img src="https://static.vecteezy.com/system/resources/thumbnails/005/026/528/small_2x/illustration-female-avatar-in-flat-style-free-vector.jpg" alt="Option 2">
                                            </label>
                                        </div>
                                    </div>
                                </div>


                            </div>
                    </div>

                    <div class="mt-2">
                        <button type="submit" class="btn btn-primary me-2">Save changes</button>
                        <button type="reset" class="btn btn-outline-secondary">Cancel</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="card">
            <h5 class="card-header">Delete Account</h5>
            <div class="card-body">
                <div class="mb-3 col-12 mb-0">
                    <div class="alert alert-warning">
                        <h6 class="alert-heading fw-bold mb-1">Are you sure you want to delete your account?</h6>
                        <p class="mb-0">Once you delete your account, there is no going back. Please be certain.</p>
                    </div>
                </div>
                <form  method="POST" accept="my-profile.html"> 
                    <div class="form-check mb-3">
                        <input class="form-check-input" type="checkbox" name="accountActivation" id="accountActivation" />
                        <label class="form-check-label" for="accountActivation">I confirm my account deactivation</label>
                    </div>
                    <button type="submit" class="btn btn-danger deactivate-account">Deactivate Account</button>
                </form>
            </div>
        </div>
    </div>
</div>


</div> <!-- End Container -->
</div><!-- End Content -->


<!-- Footer -->				
<footer>
    <div class="footer">
        <div class="float-start">
            <p>2022 &copy; Atrana</p>
        </div>
        <div class="float-end">
            <p>Crafted with 
                <span class="text-danger">
                    <i class="fa fa-heart"></i> by 
                    <a href="https://www.facebook.com/andreew.co.id/" class="author-footer">Andre Tri Ramadana</a>
                </span> 
            </p>
        </div>
    </div>
</footer>


<!-- Preloader -->
<div class="loader">
    <div class="spinner-border text-light" role="status">
        <span class="sr-only">Loading...</span>
    </div>
</div>

<!-- Loader -->
<div class="loader-overlay"></div>

<!-- General JS Scripts -->
<script src="assets/js/atrana.js"></script>

<!-- JS Libraies -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/popper.min.js"></script>

<!-- Template JS File -->
<script src="js/script.js"></script>
<script src="js/custom.js"></script>
<!-- Script for range input label -->

</body>
</html>
