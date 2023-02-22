

<!doctype html>
<html lang="en">
    <head>
        <title>Sign up - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

         
        <link href="css/signin.css" rel="stylesheet">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    <link href="https://fonts.googleapis.com/css2?family=Muli:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/style-with-prefix.css">
    
  <title>Register Yourself</title>
        
    </head>
<%@taglib prefix="s" uri="/struts-tags"%> 
   <body>

    <div class="main-container">
        <div class="form-container">

           

            <div class="form-body">
                <h2 class="title">Sign Up with</h2>
                <div class="social-login">
                    <ul>
                        <li class="google"><a href="#">Google</a></li>
                        <li class="fb"><a href="#">Facebook</a></li>
                    </ul>
                </div> SOCIAL LOGIN 

                <div class="_or">or</div>

                <form action="" class="the-form">
                    
                    <label for="Name">Name</label>
                    <input type="Name" name="Name" id="Name" placeholder="Enter your Name">

                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" placeholder="Enter your email">

                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" placeholder="Enter your password">
                    
                   

                    <input class="btn btn-primary rounded-pill py-2 px-4" type="submit" value="Sign UP">

                </form>

            </div> 
        </div> 
    </div>

</body>



</html>
