
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

    <!-- NAVIGATION BAR  -->
    <div class="button-box">
      <div id="navbar"></div>
      <button type="button" class="toggle-button navbar" id="loginBtn">Login</button>
      <button type="button" class="toggle-button" id="registerBtn">Register</button>
    </div>

    <!-- SOCIAL ICONS  -->
    <div class="social-icons">
      <a href="https://www.facebook.com/" target="_blank">
          <img src="./Media Files/fb.png" alt="login with facebook">
      </a>
      <a href="https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.co.in%2F&ec=GAZAmgQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
        target="_blank">
          <img src="./Media Files/google.png" alt="Login with Google">
      </a>
<!--      <a href="https://twitter.com/login" target="_blank">
        <img src="./Media Files/login_twitter.webp" alt="login with twitter">
      </a>-->
    </div>

    <!-- login form  -->
    <div class="outer-login-div">
      <div class="login-div">
        <form action="Login" method="Post">

          <input type="text" id="login_Email" class="login_input_field" placeholder="" name="email" required>

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

    <!-- REGISTRATION FORM  -->
    <div class="outer-registration">
      <div class="inner-registration">
        <form id="registration_form" class="login_input_group" onsubmit="return false">
          <input type="text" id="registration_name" class="login_input_field" placeholder="Name " name="Name" required>
          <input type="email" id="registration_email" class="login_input_field" placeholder="Email Id" name="Email"
            required>
<!--          <input type="text" id="registration_stream" class="login_input_field" placeholder="Stream" name="Stream"
            required>-->
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

</html>