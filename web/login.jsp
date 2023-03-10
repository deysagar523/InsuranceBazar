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
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <link href="css/style-login.css" rel="stylesheet">
            <script src="https://code.jquery.com/jquery-3.6.3.js" 
                                integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                                crossorigin="anonymous">
                                    <script src="https://accounts.google.com/gsi/client" async defer></script>
    </script>



        <style>
            body{
                background-image: url('img/blur.png');
            }
        </style>
    </head>

    <body id="container">




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
        </script>
        <div class="container" id="container">

            <div class="form-container sign-up-container">
                <form action="#">
                    <h1>Create Account</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f fw-normal"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>or use your email for registration</span>
                    <input type="text" placeholder="Name" />
                    <input type="email" placeholder="Email" />
                    <input type="password" placeholder="Password" />
                    <button>Sign Up</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <div>
                    <c:if test="${ErrorMsgForLogin.length()!=0}">
                        <div class="alert alert-danger" role="alert" style="margin-top: 50px;width: 50%;justify-content: center;">
                            ${ErrorMsgForLogin}
                        </div>
                    </c:if>
                </div>
                <div>
                    <c:if test="${SuccessMsgForSignUp.length()!=0}">
                        <div class="alert alert-success" role="alert" style="margin-top: 50px;width: 50%;justify-content: center;">
                            ${SuccessMsgForSignUp}
                        </div>
                    </c:if>
                </div>
                <form action="Login" method ="Post">
                    <h1>Sign in</h1>
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
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>or use your account</span>
                    <input type="email" name="email" placeholder="Email" />
                    <input type="password"  name="password" placeholder="Password" />
                    <a href="#"></a>
                    <button type="submit">Sign In</button>
                    <a onclick="loadPage('ForgetPassword.jsp')">Forgot your password? </a>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>To keep connected with us please login with your personal info</p>
                        <button class="ghost" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Enter your personal details and start journey with us</p>
                        <a onclick="loadPage('signup.jsp')">	<button class="ghost" id="signUp">Sign Up</button> </a>
                    </div>
                </div>
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
                    url: "GoogleLogin",
                    data: user,
                    success: function (reponseText) {
                        console.log(reponseText);
                        if (reponseText.success) {
                            location.href = 'userHomePage.jsp';
                        } else {
                            location.href = 'login.jsp';
                        }
                    }
                });
            }

        </script>

    </body>
</html>




















<!--
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="./Media Files/webLogo.ico" type="image/icon type">
  <link rel="stylesheet" href="css/style-log.css">
  <link rel="stylesheet" href="css/responsive.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
  <title>Register Yourself</title>
</head>
<body>
  <div class="form-box">
     NAVIGATION BAR  
    <div class="button-box">
      <div id="navbar"></div>
      <button type="button" class="toggle-button navbar" id="loginBtn">Login</button>
      <button type="button" class="toggle-button" id="registerBtn">Register</button>
    </div>
     SOCIAL ICONS  
    <div class="social-icons">
      <a href="https://www.facebook.com/" target="_blank">
          <img src="./Media Files/fb.png" alt="login with facebook">
      </a>
      <a href="https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.co.in%2F&ec=GAZAmgQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
        target="_blank">
          <img src="./Media Files/google.png" alt="Login with Google">
      </a>
      <a href="https://twitter.com/login" target="_blank">
        <img src="./Media Files/login_twitter.webp" alt="login with twitter">
      </a>
    </div>
     login form  
    <div class="outer-login-div">
      <div class="login-div">
        <form action="Login" method="Post">
          <input type="text" id="login_Email" class="login_input_field" placeholder="Email" name="email" required>
          <input type="password" id="login_Password" class="login_input_field" placeholder="Password" name="password"
            required>
          <div class="login_check">
            <input type="checkbox" id="login_show_password_check">
            <span id="login_show_password_tick" class="unselectable">Show Password</span>
          </div>
          <div class="login_check">
            <input type="checkbox" id="login_tick" required>
            <span id="checkLoginInputs" class="unselectable">Accept <span class="color_blue">Terms &#38;
                Conditions</span></span>
          </div>
          <button type="submit" class="login_submit_btn" >Log
            in</button>
        </form>
        <div>
            <img id="login_boy" class="boy_image" src="./Media Files/login.png" alt="Logo">
        </div>
      </div>
      <div id="snackbar_login" class="snackbar">Login Successful :)</div>
    </div>
     REGISTRATION FORM  
    <div class="outer-registration">
      <div class="inner-registration">
        <form id="registration_form" class="login_input_group" onsubmit="return false">
          <input type="text" id="registration_name" class="login_input_field" placeholder="Name " name="Name" required>
          <input type="email" id="registration_email" class="login_input_field" placeholder="Email Id" name="Email"
            required>
          <input type="text" id="registration_stream" class="login_input_field" placeholder="Stream" name="Stream"
            required>
          <input type="text" id="registration_password" class="login_input_field" placeholder="Password" name="Password"
            required>
          
          <div class="form-floating">
                    <select name="countryCode" class="form-select_country" id="countryCode" onchange="fetchContent('countryCode','stateCode')">
                        <option value="0">select a State</option>
                    </select>
          </div>
          <div class="login_check">
            <input type="checkbox" class="registration_checkbox" id="register_tick" required>
            <span id="term_condition" class="unselectable">I agree to the <span class="color_blue">Terms &#38;
                Conditions</span></span>
          </div>
          <button type="submit" class="login_submit_btn" id="registration_submit" disabled>Register</button>
        </form>
        <div>
            <img id="signup_boy" class="boy_image" src="./Media Files/2nd.png" alt="signup">
        </div>
      </div>
      <div id="snackbar_registration" class="snackbar">Registration Successful :)</div>
    </div>
  </div>
    <script src="js/scripts.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>-->