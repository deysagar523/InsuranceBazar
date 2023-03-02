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
    <a href="#" class="btn btn-social btn-google">
      <i class="fa fa-google-plus" aria-hidden="true"></i>
      Sign in with Google
    </a>

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
        <input id="pass" type="password" name="password" placeholder="password">
      </fieldset>
        <fieldset class="password">
        <input id="confirm_pass" type="password" name="confirmPassword" onkeyup="validate_password()" placeholder="confirm password">
      </fieldset>
        <span id="wrong_pass_alert"></span>
      <button type="submit" class="btn">Sign up</button>
    </form>
  </div>
</div>

    </body>

