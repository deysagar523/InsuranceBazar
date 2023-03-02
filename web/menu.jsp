<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
        <link rel="stylesheet" href="./css/candidate_menu.css">
<!--        <style>
            .sticky {
                position: fixed;
                top: 0;
                width: 100%;
            }

            /* Add some top padding to the page content to prevent sudden quick movement (as the navigation bar gets a new position at the top of the page (position:fixed and top:0) */
            .sticky + .content {
                padding-top: 60px;
            }
        </style>-->
    </head>


    <body>
        
        <nav class="navbar">
                <div class="container main-nav flex">
                    <a href="candidatehome.jsp" class="company-logo">
<!--                        <img src="assets/HireSphere.png" alt="Company Logo">-->
                                <h1> Insurance Bazzar</h1>
                    </a>
                    <div class="nav-links">
                        <ul class="flex">
                            <li><a href="userHomePage.jsp" class="hover-link">Home</a></li>
                            
                            <li><a href="ViewApplication?candidateId=${candidate.getCandidateId()}" class="hover-link">My Policies</a></li>
                            
                            <li><a href="userProfile.jsp" class="hover-link">Profile</a></li>
                            <li><a href="Logout" class="hover-link secondary-button" style="background-color:#9ec645";>Logout</a></li
                        </ul>
                    </div>
                </div>
            </nav> 
            <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script>
               function visitCandidateProfile() {
          console.log("visit candidate profle is working");
          $.ajax({
              url: 'VisitCandidateProfile',

              success: function (responseText) {
// alert(responseText);
                  $("candidateProfile.jsp").html(responseText);

              }
          }
          );

         </script>
    </body>
</html>