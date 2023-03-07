<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>View Jobs</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

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



<!--        <link href="css/stylenav.css" rel="stylesheet">-->
        
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
        
    </head>

    <body>

        <section>
            <jsp:include page="menu.jsp"></jsp:include>
            </section>
            <div class="top-banner">
                <div class="container" style="background-color:#9ec645">
                    <div class="small-bold-text banner-text"></div>
                </div>
            </div>
            <hr>
            <div class="top-banner">
                <div class="container" style="background-color:#9ec645">
                <c:choose>
                    <c:when test='${Claim.getClaimStatus().equalsIgnoreCase("bought")}'>
                        <div class="small-bold-text banner-text">CLAIM YOUR FNOL</div>
                    </c:when>
                        
                        <c:when test='${Claim.getClaimStatus().equalsIgnoreCase("1")}'>
                        <div class="small-bold-text banner-text">Your FNOL is yet to be approved by the Underwriter!!</div>
                    </c:when>
                </c:choose>
                    
                </div>
            </div>  


            <div class="container-2">
                <div class="item">
                    <<img src="https://img.freepik.com/free-vector/privacy-policy-concept-illustration_114360-7478.jpg?w=740&t=st=1677772922~exp=1677773522~hmac=d1d11ee5f8add265fddaba977f8a22d3680b842d7d2814799d5a6009b82f36ce" alt="alt"/>
                </div>
                <div class="formbold-main-wrapper">
                    <!-- Author: FormBold Team -->
                    <!-- Learn More: https://formbold.com -->
                    <div class="formbold-form-wrapper">
                        <form action="UpdateBikeClaim" method="POST">
                            <div class="formbold-input-flex">
                                <div>
                                    <input type="hidden" value="${Claim.getClaimId()}" name="claimId"/>
                                <input
                                    type="text"
                                    name="fullName"
                                    id="firstname"
                                    value="${Claim.getFullName()}"
                                    class="formbold-form-input"
                                    />
                                <label for="fullName" class="formbold-form-label"> Full Name </label>
                            </div>
                            <div>
                                <input
                                    type="email"
                                    name="email"
                                    id="email"
                                    value="${Claim.getEmail()}"
                                    class="formbold-form-input"
                                    />
                                <label for="email" class="formbold-form-label"> Mail </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="gender"
                                    id="phone"
                                    value="${Claim.getGender()}"
                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Gender </label>
                            </div>

                        </div>
                        <!-- form bold input flex end -->

                        <div class="formbold-input-flex">


                            <div>
                                <input
                                    type="text"
                                    name="bikeNumber"
                                    id="phone"
                                    value="${Claim.getBikeNumber()}"
                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Bike Number </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="bikeMake"
                                    id="phone"
                                    value="${Claim.getBikeMake()}"
                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Bike Make </label>
                            </div>

                        </div>
                        <!-- form holder input flex end -->

                        <div class="formbold-input-flex">
                            <div>
                                <input
                                    type="text"
                                    name="bikeModel"
                                    id="phone"
                                    value="${Claim.getBikeModel()}"
                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Bike Model </label>
                            </div>
                            <div>
                                <input
                                    type="text"
                                    name="bikeRegistrationYear"
                                    id="phone"
                                    value="${Claim.getBikeRegistrationYear()}"
                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Bike Registration Year </label>
                            </div>


                        </div>
                        <!-- form bold input flex end -->
                        
                        

                        <c:choose>
                            <c:when test ='${Claim.getClaimStatus().equals("1")}'>
                                
                                

                                <div class="formbold-input-flex">

                                    <div>
                                        <input
                                            type="text"
                                            name="incidentLocation"
                                            id="phone"
                                            value="${Claim.getIncidentLocation()}"

                                            class="formbold-form-input"
                                            />
                                        <label for="phone" class="formbold-form-label"> Incident Location </label>
                                    </div>

                                    <div>
                                        <input
                                            type="text"
                                            name="incidentDate"
                                            id="phone"
                                            value="${Claim.getIncidentDate()}"

                                            class="formbold-form-input"
                                            />
                                        <label for="phone" class="formbold-form-label"> Incident Date </label>
                                    </div>

                                    <div>
                                        <input
                                            type="text"
                                            name="policeReportNo"
                                            id="phone"
                                            value="${Claim.getPoliceReportNo()}"
                                            class="formbold-form-input"
                                            />
                                        <label for="phone" class="formbold-form-label"> Police Report Number </label>
                                    </div>

                                    <div>
                                        <input
                                            type="text"
                                            name="adharCard"
                                            id="phone"
                                            value="${Claim.getAdharCard()}"
                                            class="formbold-form-input"
                                            />
                                        <label for="phone" class="formbold-form-label"> Your Adhar Card Number </label>
                                    </div>


                                </div>
                                <!-- form bold input flex end -->

                                <div class="formbold-textarea">
                                    <textarea
                                        rows="6"
                                        name="message"
                                        id="message"
                                        value="${Claim.getMessage()}"
                                        placeholder="Write your message..."
                                        class="formbold-form-input"
                                        ></textarea>
                                    <label for="message" class="formbold-form-label"> Message </label>
                                </div>
                                

                            </c:when>
                                
                                <c:when test ='${Claim.getClaimStatus().equalsIgnoreCase("bought")}'>
                                    
                                    <p class="text-danger"><b>Met with an accident? Fill the details below</b></p>

                            <div class="formbold-input-flex">

                            <div>
                                <input
                                    type="text"
                                    name="incidentLocation"
                                    id="phone"


                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Incident Location </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="incidentDate"
                                    id="phone"

                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Incident Date </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="policeReportNo"
                                    id="phone"

                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Police Report Number </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="adharCard"
                                    id="phone"

                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Your Adhar Card Number </label>
                            </div>


                        </div>
                        <!-- form bold input flex end -->

                        <div class="formbold-textarea">
                            <textarea
                                rows="6"
                                name="message"
                                id="message"
                                placeholder="Write your message..."
                                class="formbold-form-input"
                                ></textarea>
                            <label for="message" class="formbold-form-label"> Message </label>
                        </div>

                        <!--        <div class="formbold-input-file">
                                  <div class="formbold-filename-wrapper">
                                    <span class="formbold-filename">
                                      website-information-architecture.pdf
                        
                                      <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                      <g clip-path="url(#clip0_1670_1541)">
                                      <path d="M9.00005 7.93906L12.7126 4.22656L13.7731 5.28706L10.0606 8.99956L13.7731 12.7121L12.7126 13.7726L9.00005 10.0601L5.28755 13.7726L4.22705 12.7121L7.93955 8.99956L4.22705 5.28706L5.28755 4.22656L9.00005 7.93906Z" fill="#536387"/>
                                      </g>
                                      <defs>
                                      <clipPath id="clip0_1670_1541">
                                      <rect width="18" height="18" fill="white"/>
                                      </clipPath>
                                      </defs>
                                      </svg>
                                    </span>
                        
                                    <span class="formbold-filename">
                                      website-logo.png
                        
                                      <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                      <g clip-path="url(#clip0_1670_1541)">
                                      <path d="M9.00005 7.93906L12.7126 4.22656L13.7731 5.28706L10.0606 8.99956L13.7731 12.7121L12.7126 13.7726L9.00005 10.0601L5.28755 13.7726L4.22705 12.7121L7.93955 8.99956L4.22705 5.28706L5.28755 4.22656L9.00005 7.93906Z" fill="#536387"/>
                                      </g>
                                      <defs>
                                      <clipPath id="clip0_1670_1541">
                                      <rect width="18" height="18" fill="white"/>
                                      </clipPath>
                                      </defs>
                                      </svg>
                                    </span>
                                  </div>
                                  <label for="upload" class="formbold-input-label">
                                      <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                      <g clip-path="url(#clip0_1670_1531)">
                                      <path d="M12.3568 6.4644L7.64349 11.1786C7.5639 11.2554 7.50041 11.3474 7.45674 11.4491C7.41307 11.5507 7.39008 11.6601 7.38912 11.7707C7.38815 11.8814 7.40924 11.9911 7.45114 12.0935C7.49304 12.1959 7.55492 12.289 7.63316 12.3672C7.71141 12.4455 7.80445 12.5073 7.90686 12.5492C8.00928 12.5912 8.11901 12.6122 8.22966 12.6113C8.34031 12.6103 8.44966 12.5873 8.55133 12.5436C8.653 12.5 8.74495 12.4365 8.82182 12.3569L13.536 7.64356C14.0049 7.17468 14.2683 6.53875 14.2683 5.87565C14.2683 5.21255 14.0049 4.57661 13.536 4.10773C13.0671 3.63885 12.4312 3.37544 11.7681 3.37544C11.105 3.37544 10.469 3.63885 10.0002 4.10773L5.28599 8.8219C4.89105 9.20701 4.57652 9.6667 4.36062 10.1743C4.14473 10.6819 4.03178 11.2274 4.02832 11.779C4.02487 12.3306 4.13097 12.8774 4.34049 13.3877C4.55 13.8979 4.85876 14.3615 5.24884 14.7516C5.63892 15.1416 6.10256 15.4503 6.61287 15.6597C7.12318 15.8692 7.67 15.9752 8.2216 15.9717C8.77321 15.9681 9.31862 15.8551 9.82621 15.6391C10.3338 15.4232 10.7934 15.1086 11.1785 14.7136L15.8927 10.0002L17.071 11.1786L12.3568 15.8927C11.8151 16.4344 11.172 16.8641 10.4643 17.1573C9.75649 17.4505 8.99791 17.6014 8.23182 17.6014C7.46574 17.6014 6.70716 17.4505 5.99939 17.1573C5.29162 16.8641 4.64853 16.4344 4.10682 15.8927C3.56512 15.351 3.13542 14.7079 2.84225 14.0002C2.54908 13.2924 2.39819 12.5338 2.39819 11.7677C2.39819 11.0016 2.54908 10.2431 2.84225 9.5353C3.13542 8.82753 3.56512 8.18443 4.10682 7.64273L8.82182 2.9294C9.60767 2.17041 10.6602 1.75043 11.7527 1.75992C12.8451 1.76942 13.8902 2.20762 14.6627 2.98015C15.4353 3.75269 15.8735 4.79774 15.883 5.89023C15.8925 6.98271 15.4725 8.03522 14.7135 8.82106L10.0002 13.5369C9.76794 13.7691 9.49226 13.9532 9.18887 14.0788C8.88548 14.2045 8.56032 14.2691 8.23195 14.2691C7.90357 14.269 7.57843 14.2043 7.27507 14.0786C6.97171 13.9529 6.69607 13.7687 6.46391 13.5365C6.23174 13.3043 6.04759 13.0286 5.92196 12.7252C5.79633 12.4218 5.7317 12.0966 5.73173 11.7683C5.73177 11.4399 5.79649 11.1148 5.92219 10.8114C6.04788 10.508 6.2321 10.2324 6.46432 10.0002L11.1785 5.28606L12.3568 6.4644Z" fill="#07074D"/>
                                      </g>
                                      <defs>
                                      <clipPath id="clip0_1670_1531">
                                      <rect width="20" height="20" fill="white"/>
                                      </clipPath>
                                      </defs>
                                      </svg>
                                      Attach files
                                      <input type="file" name="upload" id="upload">
                                  </label>
                                </div>-->

                        <button type="submit" class="formbold-btn">
                            File FNOL
                        </button>
                                

                            </c:when>
                                
                        </c:choose>

<!--                        <div class="formbold-input-flex">

                            <div>
                                <input
                                    type="text"
                                    name="incidentLocation"
                                    id="phone"


                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Incident Location </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="incidentDate"
                                    id="phone"

                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Incident Date </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="policeReportNo"
                                    id="phone"

                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Police Report Number </label>
                            </div>

                            <div>
                                <input
                                    type="text"
                                    name="adharCard"
                                    id="phone"

                                    class="formbold-form-input"
                                    />
                                <label for="phone" class="formbold-form-label"> Your Adhar Card Number </label>
                            </div>


                        </div>
                         form bold input flex end 

                        <div class="formbold-textarea">
                            <textarea
                                rows="6"
                                name="message"
                                id="message"
                                placeholder="Write your message..."
                                class="formbold-form-input"
                                ></textarea>
                            <label for="message" class="formbold-form-label"> Message </label>
                        </div>

                                <div class="formbold-input-file">
                                  <div class="formbold-filename-wrapper">
                                    <span class="formbold-filename">
                                      website-information-architecture.pdf
                        
                                      <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                      <g clip-path="url(#clip0_1670_1541)">
                                      <path d="M9.00005 7.93906L12.7126 4.22656L13.7731 5.28706L10.0606 8.99956L13.7731 12.7121L12.7126 13.7726L9.00005 10.0601L5.28755 13.7726L4.22705 12.7121L7.93955 8.99956L4.22705 5.28706L5.28755 4.22656L9.00005 7.93906Z" fill="#536387"/>
                                      </g>
                                      <defs>
                                      <clipPath id="clip0_1670_1541">
                                      <rect width="18" height="18" fill="white"/>
                                      </clipPath>
                                      </defs>
                                      </svg>
                                    </span>
                        
                                    <span class="formbold-filename">
                                      website-logo.png
                        
                                      <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                      <g clip-path="url(#clip0_1670_1541)">
                                      <path d="M9.00005 7.93906L12.7126 4.22656L13.7731 5.28706L10.0606 8.99956L13.7731 12.7121L12.7126 13.7726L9.00005 10.0601L5.28755 13.7726L4.22705 12.7121L7.93955 8.99956L4.22705 5.28706L5.28755 4.22656L9.00005 7.93906Z" fill="#536387"/>
                                      </g>
                                      <defs>
                                      <clipPath id="clip0_1670_1541">
                                      <rect width="18" height="18" fill="white"/>
                                      </clipPath>
                                      </defs>
                                      </svg>
                                    </span>
                                  </div>
                                  <label for="upload" class="formbold-input-label">
                                      <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                      <g clip-path="url(#clip0_1670_1531)">
                                      <path d="M12.3568 6.4644L7.64349 11.1786C7.5639 11.2554 7.50041 11.3474 7.45674 11.4491C7.41307 11.5507 7.39008 11.6601 7.38912 11.7707C7.38815 11.8814 7.40924 11.9911 7.45114 12.0935C7.49304 12.1959 7.55492 12.289 7.63316 12.3672C7.71141 12.4455 7.80445 12.5073 7.90686 12.5492C8.00928 12.5912 8.11901 12.6122 8.22966 12.6113C8.34031 12.6103 8.44966 12.5873 8.55133 12.5436C8.653 12.5 8.74495 12.4365 8.82182 12.3569L13.536 7.64356C14.0049 7.17468 14.2683 6.53875 14.2683 5.87565C14.2683 5.21255 14.0049 4.57661 13.536 4.10773C13.0671 3.63885 12.4312 3.37544 11.7681 3.37544C11.105 3.37544 10.469 3.63885 10.0002 4.10773L5.28599 8.8219C4.89105 9.20701 4.57652 9.6667 4.36062 10.1743C4.14473 10.6819 4.03178 11.2274 4.02832 11.779C4.02487 12.3306 4.13097 12.8774 4.34049 13.3877C4.55 13.8979 4.85876 14.3615 5.24884 14.7516C5.63892 15.1416 6.10256 15.4503 6.61287 15.6597C7.12318 15.8692 7.67 15.9752 8.2216 15.9717C8.77321 15.9681 9.31862 15.8551 9.82621 15.6391C10.3338 15.4232 10.7934 15.1086 11.1785 14.7136L15.8927 10.0002L17.071 11.1786L12.3568 15.8927C11.8151 16.4344 11.172 16.8641 10.4643 17.1573C9.75649 17.4505 8.99791 17.6014 8.23182 17.6014C7.46574 17.6014 6.70716 17.4505 5.99939 17.1573C5.29162 16.8641 4.64853 16.4344 4.10682 15.8927C3.56512 15.351 3.13542 14.7079 2.84225 14.0002C2.54908 13.2924 2.39819 12.5338 2.39819 11.7677C2.39819 11.0016 2.54908 10.2431 2.84225 9.5353C3.13542 8.82753 3.56512 8.18443 4.10682 7.64273L8.82182 2.9294C9.60767 2.17041 10.6602 1.75043 11.7527 1.75992C12.8451 1.76942 13.8902 2.20762 14.6627 2.98015C15.4353 3.75269 15.8735 4.79774 15.883 5.89023C15.8925 6.98271 15.4725 8.03522 14.7135 8.82106L10.0002 13.5369C9.76794 13.7691 9.49226 13.9532 9.18887 14.0788C8.88548 14.2045 8.56032 14.2691 8.23195 14.2691C7.90357 14.269 7.57843 14.2043 7.27507 14.0786C6.97171 13.9529 6.69607 13.7687 6.46391 13.5365C6.23174 13.3043 6.04759 13.0286 5.92196 12.7252C5.79633 12.4218 5.7317 12.0966 5.73173 11.7683C5.73177 11.4399 5.79649 11.1148 5.92219 10.8114C6.04788 10.508 6.2321 10.2324 6.46432 10.0002L11.1785 5.28606L12.3568 6.4644Z" fill="#07074D"/>
                                      </g>
                                      <defs>
                                      <clipPath id="clip0_1670_1531">
                                      <rect width="20" height="20" fill="white"/>
                                      </clipPath>
                                      </defs>
                                      </svg>
                                      Attach files
                                      <input type="file" name="upload" id="upload">
                                  </label>
                                </div>

                        <button type="submit" class="formbold-btn">
                            File FNOL
                        </button>-->
                    </form>
                </div>
            </div>

        </div>

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
                height: 100px;
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
            .formbold-main-wrapper {
                display: flex;
                align-items: center;
                justify-content: center;
                padding: 50px;
            }

            .formbold-form-wrapper {
                margin: 0 auto;
                max-width: 550px;
                width: 100%;
                background: white;
            }

            .formbold-input-flex {
                display: flex;
                gap: 20px;
                margin-bottom: 22px;
            }
            .formbold-input-flex > div {
                width: 50%;
                display: flex;
                flex-direction: column-reverse;
            }
            .formbold-textarea {
                display: flex;
                flex-direction: column-reverse;
            }

            .formbold-form-input {
                width: 100%;
                padding-bottom: 10px;
                border: none;
                border-bottom: 1px solid #DDE3EC;
                background:#DDE3EC;
                font-weight: 500;
                font-size: 16px;
                color: #07074D;
                outline: none;
                resize: none;
            }
            .formbold-form-input::placeholder {
                color: #536387;
            }
            .formbold-form-input:focus {
                border-color: #6A64F1;
            }
            .formbold-form-label {
                color: #07074D;
                font-weight: 500;
                font-size: 14px;
                line-height: 24px;
                display: block;
                margin-bottom: 18px;
            }
            .formbold-form-input:focus + .formbold-form-label {
                color: #6A64F1;
            }

            .formbold-input-file {
                margin-top: 30px;
            }
            .formbold-input-file input[type="file"] {
                position: absolute;
                top: 6px;
                left: 0;
                z-index: -1;
            }
            .formbold-input-file .formbold-input-label {
                display: flex;
                align-items: center;
                gap: 10px;
                position: relative;
            }

            .formbold-filename-wrapper {
                display: flex;
                flex-direction: column;
                gap: 6px;
                margin-bottom: 22px;
            }
            .formbold-filename {
                display: flex;
                align-items: center;
                justify-content: space-between;
                font-size: 14px;
                line-height: 24px;
                color: #536387;
            }
            .formbold-filename svg {
                cursor: pointer;
            }

            .formbold-btn {
                font-size: 16px;
                border-radius: 5px;
                padding: 12px 25px;
                border: none;
                font-weight: 500;
                background-color:#9ec645;
                color: white;
                cursor: pointer;
                margin-top: 25px;
                align-content: center;
                justify-content: center;
                align-items: center;
            }
            .formbold-btn:hover {
                box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
            }

        </style>

    </body>
</html>