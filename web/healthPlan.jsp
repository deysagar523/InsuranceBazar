<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>


</c:if>

<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- CSS here -->
        <link rel="stylesheet" href="css/style-car.css">
        <link rel="stylesheet" href="./css/jobdiv.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <link rel="stylesheet" href="css/jobdetail.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/octicons/8.5.0/octicons.min.css">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="WEB-INF/css/style.css" type="text/css"/>
        <link rel="stylesheet" href="WEB-INF/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="WEB-INF/lib/owlcarousel/assets/owl.carousel.css" type="text/css"/>



        <link href="css/stylenav.css" rel="stylesheet">
    </head>

    <body>

        <section>
            <jsp:include page="menu.jsp"></jsp:include>
            </section>
            <div class="top-banner">
                <div class="container" style="background-color:#9ec645">
                    <div class="small-bold-text banner-text">Find your Plans</div>
                </div>
            </div>
            <hr>
            <main>
                <!--                <div class="container" style="display: flex;justify-content: center;align-items: center;">
                                    <form class="d-flex"action="JobSearchByKeyword" method="Post">
                                        <input class="form-control me-2 " style="width: 400px; text-align: center; border-radius: 10px;height: 3rem;" type="search" placeholder="Job Title or Company or Type" aria-label="Search" type="text" id="floatingInput"  name="keyword">
                                        &nbsp;&nbsp;&nbsp;
                                            <button class="hover-link primary-button" style="border: none; width: 200px; border-radius: 10px; " type="submit">Search</button>
                                    </form>
                                </div>-->

                <div class="flex">
                    <div class="container">
                        <div class="row">
                            <!-- Left content -->
                            <!-- Right content -->
                            <div class="container">
                                <section>

                                <c:forEach items="${MedPlans}" var="plan">
                                    <div class="row rounded">
                                        <div class="col-12">
                                            <div class="tab-content mt-2" id="pills-tabContent">
                                                <div
                                                    class="tab-pane fade show active"
                                                    id="recent-job"
                                                    role="tabpanel"
                                                    aria-labelledby="recent-job-tab"
                                                    >
                                                    <div class="row">
                                                        <div class="col-lg-12">
                                                            <div
                                                                class="job-box bg-white overflow-hidden border rounded mt-4 position-relative overflow-hidden"
                                                                >
                                                                <div class="lable text-center pt-2 pb-2">
                                                                    <ul
                                                                        class="list-unstyled best text-white mb-0 text-uppercase"
                                                                        >
                                                                        <li class="list-inline-item">
                                                                            <i class="mdi mdi-star"></i>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <div class="p-4">
                                                                    <div class="row align-items-center">
                                                                        <div class="col-md-2">
                                                                            <div class="mo-mb-2">



                                                                                <c:choose>
                                                                                    <c:when test ='${plan.getPlanCompany().equalsIgnoreCase("care")}'>
                                                                                        <img
                                                                                            src="img/care.png"
                                                                                            alt=""
                                                                                            class="img-fluid mx-auto d-block"
                                                                                            />


                                                                                    </c:when>
                                                                                    <c:when test ='${plan.getPlanCompany().equalsIgnoreCase("niva")}'>
                                                                                        <img
                                                                                            src="img/niva.png"
                                                                                            alt=""
                                                                                            class="img-fluid mx-auto d-block"
                                                                                            />


                                                                                    </c:when>

                                                                                    <c:when test ='${plan.getPlanCompany().equalsIgnoreCase("reliance")}'>
                                                                                        <img
                                                                                            src="img/reliance.png"
                                                                                            alt="reliance"
                                                                                            class="img-fluid mx-auto d-block"
                                                                                            />


                                                                                    </c:when>





                                                                                </c:choose>


                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <div>
                                                                                <h5 class="f-18">
                                                                                    <a href="#" class="text-dark">${jobDetails.getJobTitle()}</a>
                                                                                </h5>
                                                                                <p class="text-muted mb-0">${plan.getPolicyName()}</p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <div>
                                                                                <p class="text-muted mb-0">${plan.getPlanDuration()} year</p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-2">
                                                                            <div>
                                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                                    <span class="text-primary"> &#8377; &nbsp;</span
                                                                                    ><i class="fa fa-rupee"></i>${plan.getPlanAmount()}/-
                                                                                </p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-2">
                                                                            <div>
                                                                                <p class="text-muted mb-0">&nbsp;&nbsp;&nbsp;&nbsp;</p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="p-3 bg-light">
                                                                    <div class="row">
                                                                        <div class="col-md-4">
                                                                            <div>
                                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                                    <span class="text-dark">Cover: ${plan.getCoverAmount()}/-</span
                                                                                    >
                                                                                </p>
                                                                            </div>
                                                                        </div>

                                                                        <div class="col-md-6">
                                                                            <div>
                                                                                <p class="text-muted mb-0 mo-mb-2">
                                                                                    <span class="text-dark">Notes :</span> Your pocket friendly plan
                                                                                </p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-2">
                                                                            <div>
                                                                                <a
                                                                                    href="BuyPlan?planId=${plan.getPlanId()}" 
                                                                                    class="primary-button"
                                                                                    >Buy Policy
                                                                                    <i class="mdi mdi-chevron-double-right"></i
                                                                                    ></a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                </c:forEach>                                                              

                            </section>
                        </div>
                    </div>
                </div>
            </div>



        </main>
        <hr>

    </body>
</html>