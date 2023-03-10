<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style-signup.jsp" rel="stylesheet">
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <style>
            .alert-danger{
                background:#d9534f;
                width:30vw;
                height:40px;
                margin-top: 10vh;
                color: white;
                margin-left:auto;
                margin-right:auto;
                text-align: center;
                border-radius: 10px;
            }
                    </style>

    </head>

    <script>
        function validate_password() {

            var pass = document.getElementById('pass').value;
            var confirm_pass = document.getElementById('confirm_pass').value;
            if (pass != confirm_pass) {
                document.getElementById('wrong_pass_alert').style.color = 'red';
                document.getElementById('wrong_pass_alert').innerHTML
                        = '<span><i class="fa fa-times" aria-hidden="true"></i></span> Use same password';
                document.getElementById('create').disabled = true;
                document.getElementById('create').style.opacity = (0.4);
            } else {
                document.getElementById('wrong_pass_alert').style.color = 'green';
                document.getElementById('wrong_pass_alert').innerHTML =
                        '<span><i style="color:green;" class="fa fa-check" aria-hidden="true"></i></span> Password Matched';
                document.getElementById('create').disabled = false;
                document.getElementById('create').style.opacity = (1);
            }
        }
    </script>

    <body>
        <!--        Content-Security-Policy-Report-Only: script-src https://accounts.google.com/gsi/client; frame-src https://accounts.google.com/gsi/; connect-src https://accounts.google.com/gsi/;-->
        <div>
            <c:if test="${ErrorMsgForSignUp.length()!=0}">
                <div class="alert-danger">
                    ${ErrorMsgForSignUp}
                </div>
            </c:if>
        </div>
        <div class="signup">

            <div class="signup-connect">
                <h1>Create An Account</h1>
                <a href="#" class="btn btn-social btn-facebook">
                    <i class="fa fa-facebook" aria-hidden="true"></i>
                    Sign in with Facebook
                </a>
                <a href="#" class="btn btn-social btn-twitter">
                    <i class="fa fa-twitter" aria-hidden="true"></i>
                    Sign in with Twitter
                </a>
                <!--                <a href="#" class="btn btn-social btn-google">
                                    <i class="fa fa-google-plus" aria-hidden="true"></i>
                                    Sign in with Google
                                </a>-->
                <div id="g_id_onload"
                     data-client_id="1042083289978-vm99se78o6vk270sl3974m71q1mrasm7.apps.googleusercontent.com"
                     data-context="signup"
                     data-ux_mode="popup"
                     data-callback="handleCredentialResponse"
                     data-auto_prompt="false">
                </div>

                <div class="g_id_signin"
                     data-type="standard"
                     data-shape="rectangular"
                     data-theme="filled_blue"
                     data-text="signup_with"
                     data-size="large"
                     data-logo_alignment="left">
                </div>

            </div>

            <div class="signup-classic">

                <h2>Enter Your Details</h2>
                <form action="SignUp" method="post" class="form">
                    <!--      <fieldset class="username">
                            <input type="text" placeholder="username">
                          </fieldset>-->
                    <fieldset class="email">
                        <input type="email" name="email" placeholder="email">
                    </fieldset>
                    <fieldset class="password">
                        <input id="pass" type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                               title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="password">
                    </fieldset>
                    <fieldset class="password">
                        <input id="confirm_pass" type="password" name="confirmPassword" onkeyup="validate_password()" placeholder="confirm password">
                    </fieldset>
                    <span id="wrong_pass_alert"></span>
                    <button type="submit" class="btn">Sign up</button>
                </form>
            </div>
        </div>
        <script>
            function decodeJwtResponse(data) {
                var tokens = data.split(".");
                return JSON.parse(atob(tokens[1]));
            }

            function handleCredentialResponse(response) {
                const responsePayLoad = decodeJwtResponse(response.credential);
                console.log(responsePayLoad);
                const user = {email: responsePayLoad.email, password: responsePayLoad.sub, fullName: responsePayLoad.name};
                console.log(user);
                $.ajax({
                    type: "Post",
                    url: "GoogleSignUp",
                    data: user,
                    success: function (reponseText) {
                        console.log(reponseText);
                        if (reponseText.success) {
                            location.href = 'login.jsp';
                        } else {
                            location.href = 'signup.jsp';
                        }
                    }
                });
            }

        </script>

    </body>

