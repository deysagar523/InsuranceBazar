
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Au Register Forms by Colorlib</title>

    <!-- Icons font CSS-->
    <link href="policyRegister/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="policyRegister/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="policyRegister/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="policyRegister/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/policyRegister.css" rel="stylesheet" media="all">
</head>

<body>
    <section>
            <jsp:include page="menu.jsp"></jsp:include>
        </section>
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
    <div class="container-2">
  <div class="item">
      <img src="img/child.jpeg" width="70%"/>
  </div>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
           
            <div class="card card-5">
                
                <div class="card-heading">
                    <h2 class="title"> Child Savings Policy Registration Form</h2>
                </div>
                <div class="card-body">
                    <form method="POST">
                         <div class="form-row">
                            <div class="name">Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="fullName">
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">User ID</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="userId">
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">Email</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="email">
                                </div>
                            </div>
                        </div>
<!--                        <div class="form-row m-b-55">
                            <div class="name">User ID</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="userId">
                                            <label class="label--desc">Full Name</label>
                                        </div>
                                        <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="userId">
                                            <label class="label--desc">User  Id</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="email">
                                            <label class="label--desc">Email</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
                        <div class="form-row">
                            <div class="name">Phone</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="phone">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Your age</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="age">
                                </div>
                            </div>
                        </div>
                             <div class="form-row">
                            <div class="name">Child's Age</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="number" name="childAge">
                                </div>
                            </div>
                        </div>
<!--                        <div class="form-row m-b-55">
                            <div class="name">Phone</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-3">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="area_code">
                                            <label class="label--desc">Area Code</label>
                                        </div>
                                    </div>
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="phone">
                                            <label class="label--desc">Phone Number</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
<!--                        <div class="form-row">
                            <div class="name">Subject</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="subject">
                                            <option disabled="disabled" selected="selected">Choose option</option>
                                            <option>Subject 1</option>
                                            <option>Subject 2</option>
                                            <option>Subject 3</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
                        <div class="form-row p-t-20">
                            <label class="label label--block">Child's Gender</label>
                            <div class="p-t-15">
                                <label class="radio-container m-r-55">Male
                                    <input type="radio" checked="checked" name="exist">
                                    <span class="checkmark"></span>
                                </label>
                                <label class="radio-container">Female
                                    <input type="radio" name="exist">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                        </div>
<div class="form-row">
                            <div class="name">Your Message</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="phone">
                                </div>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn--radius-2 btn" style="background-color: #9ec645" type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="policyRegister/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="policyRegister/select2/select2.min.js"></script>
    <script src="policyRegister/datepicker/moment.min.js"></script>
    <script src="policyRegister/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/policyRegister.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->