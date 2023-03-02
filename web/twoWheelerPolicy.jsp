<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>FormWizard_v1</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <!-- MATERIAL DESIGN ICONIC FONT -->
        <link rel="stylesheet" href="css/material-design-iconic-font.css">

        <!-- STYLE CSS -->
        <link rel="stylesheet" href="css/style-HIN.css">
    </head>
    <style>
        @font-face {
            font-family: "Muli-Regular";
            src: url("../fonts/muli/Muli-Regular.ttf");
        }
        @font-face {
            font-family: "Muli-SemiBold";
            src: url("../fonts/muli/Muli-SemiBold.ttf");
        }
        * {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }

        body {
            font-family: "Muli-Regular";
            font-size: 15px;
            color: #999;
            margin: 0;
        }

        :focus {
            outline: none;
        }

        textarea {
            resize: none;
        }

        input, textarea, select, button {
            font-family: "Muli-Regular";
            font-size: 15px;
        }

        p, h1, h2, h3, h4, h5, h6, ul {
            margin: 0;
        }

        ul {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        a {
            text-decoration: none;
        }

        textarea {
            resize: none;
        }

        img {
            max-width: 100%;
        }

        .wrapper {
            height: 100vh;
            background: #f9f6f1;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .wizard {
            width: 920px;
            position: relative;
        }

        .wizard > .steps {
            position: absolute;
            top: 27.44%;
            right: 30%;
            transform: translateX(50%);
            z-index: 9;
        }

        .wizard > .steps .current-info, .wizard > .steps .number {
            display: none;
        }

        .wizard > .steps ul {
            display: flex;
            justify-content: center;
        }

        .wizard > .steps li a {
            display: inline-block;
            width: 12px;
            height: 12px;
            border-radius: 50%;
            background: #e9e0cf;
            margin-right: 78px;
            position: relative;
        }
        .wizard > .steps li a:before {
            content: "";
            width: 58px;
            height: 2px;
            background: #e9e0cf;
            position: absolute;
            right: 22px;
            top: 5px;
        }
        .wizard > .steps li a:after {
            content: "";
            width: 0;
            height: 2px;
            background: #6d7f52;
            position: absolute;
            left: -68px;
            top: 5px;
            transition: all 0.6s ease;
        }
        .wizard > .steps li.first a {
            background: #6d7f52;
        }
        .wizard > .steps li.checked a {
            background: #6d7f52;
        }
        .wizard > .steps li.checked a:after {
            width: 58px;
        }
        .wizard > .steps li:last-child a {
            margin-right: 0;
        }
        .wizard > .steps li:first-child a:before {
            display: none;
        }
        .wizard > .steps li:first-child a:after {
            display: none;
        }

        .wizard > .content {
            position: relative;
            height: 521px;
        }

        .inner {
            display: flex;
            background: #fff;
            box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.2);
            -webkit-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.2);
            -moz-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.2);
            -ms-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.2);
            -o-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.2);
        }

        .image-holder {
            width: 40%;
            height: 521px;
        }

        .form-content {
            width: 60%;
            padding-top: 65px;
            padding-left: 51px;
            padding-right: 51px;
        }

        .form-header {
            text-align: center;
        }

        h3 {
            font-family: "Muli-SemiBold";
            font-size: 22px;
            color: #453e79;
            text-transform: uppercase;
            letter-spacing: 7px;
            padding: 5px 15px;
            display: inline-block;
            border: 1px solid #dad8e4;
            margin-bottom: 75px;
        }

        p {
            font-family: "Muli-SemiBold";
            font-size: 20px;
            color: #6d7f52;
            text-align: center;
            margin-bottom: 26px;
        }

        .form-row {
            display: flex;
            margin-bottom: 18px;
        }
        .form-row .form-holder {
            width: 50%;
            margin-right: 30px;
        }
        .form-row .form-holder:last-child {
            margin-right: 0;
        }
        .form-row .form-holder.w-100 {
            width: 100%;
            margin-right: 0;
        }
        .form-row .select {
            width: 50%;
            margin-right: 30px;
        }
        .form-row .select .form-holder {
            width: 100%;
            margin-right: 0;
        }

        .select {
            position: relative;
        }
        .select .select-control {
            height: 37px;
            border-bottom: 2px solid #e6e6e6;
            width: 100%;
            color: #999;
            display: flex;
            align-items: center;
            cursor: pointer;
        }
        .select .dropdown {
            display: none;
            position: absolute;
            top: 100%;
            width: 100%;
            background: #fff;
            z-index: 9;
            border: 1px solid #81acee;
        }
        .select .dropdown li {
            padding: 5px 10px;
        }
        .select .dropdown li:hover {
            background: #81acee;
            color: #fff;
        }

        .form-holder {
            position: relative;
        }
        .form-holder i {
            position: absolute;
            bottom: 7px;
            right: 0;
            font-size: 17px;
        }

        .form-control {
            height: 37px;
            border: none;
            border-bottom: 2px solid #e6e6e6;
            width: 100%;
            color: #666;
        }
        .form-control:focus {
            border-color: #e9e0cf;
        }
        .form-control::-webkit-input-placeholder {
            color: #999;
        }
        .form-control::-moz-placeholder {
            color: #999;
        }
        .form-control:-ms-input-placeholder {
            color: #999;
        }
        .form-control:-moz-placeholder {
            color: #999;
        }

        select.form-control {
            -moz-appearance: none;
            -webkit-appearance: none;
            cursor: pointer;
            color: #999;
        }
        select.form-control option[value=""][disabled] {
            display: none;
        }

        textarea.form-control {
            padding: 8px 0;
            background: url("../images/textarea-bg.png") no-repeat right bottom 3px;
        }

        .actions {
            position: absolute;
            bottom: 55px;
            right: 51px;
        }
        .actions ul {
            display: flex;
        }
        .actions li a {
            padding: 0;
            border: none;
            display: inline-flex;
            height: 41px;
            width: 135px;
            align-items: center;
            background: #e9e0cf;
            font-family: "Muli-SemiBold";
            color: #666;
            cursor: pointer;
            position: relative;
            padding-left: 28px;
        }
        .actions li a:before {
            content: '\f301';
            position: absolute;
            top: 14px;
            right: 28px;
            font-family: Material-Design-Iconic-Font;
        }
        .actions li a:hover {
            background: #cfc7b8;
        }
        .actions li:first-child a {
            width: 144px;
            padding-left: 48px;
        }
        .actions li:first-child a:before {
            content: '\f2ff';
            position: absolute;
            top: 14px;
            left: 26px;
            font-family: Material-Design-Iconic-Font;
        }
        .actions li:nth-child(2) a, .actions li:last-child a {
            margin-left: 20px;
        }
        .actions li:last-child a {
            width: 124px;
            background: #6d7f52;
            color: #fff;
        }
        .actions li:last-child a:hover {
            background: #849963;
        }
        .actions li:last-child a:before {
            content: '\f26b';
            position: absolute;
            top: 13px;
            right: 28px;
            font-family: Material-Design-Iconic-Font;
        }
        .actions li[aria-disabled="true"] a {
            opacity: 0;
            transition: all 1s;
        }
        .actions li[aria-disabled="false"] ~ li a {
            background: #6d7f52;
            color: #fff;
        }
        .actions li[aria-disabled="false"] ~ li a:hover {
            background: #849963;
        }

        .checkbox-tick label {
            cursor: pointer;
            display: inline-block;
            padding-left: 23px;
            position: relative;
        }
        .checkbox-tick label.male {
            margin-right: 26px;
        }
        .checkbox-tick input {
            position: absolute;
            opacity: 0;
            cursor: pointer;
        }
        .checkbox-tick input:checked ~ .checkmark {
            background: #999;
        }
        .checkbox-tick input:checked ~ .checkmark:after {
            display: block;
        }
        .checkbox-tick .checkmark {
            position: absolute;
            top: 3px;
            left: 0;
            height: 13px;
            width: 13px;
            border: 1px solid #999;
            border-radius: 50%;
            font-family: Material-Design-Iconic-Font;
            color: #fff;
            font-size: 11px;
        }
        .checkbox-tick .checkmark:after {
            top: 0;
            left: 2px;
            position: absolute;
            display: none;
            content: '';
        }

        .checkbox-circle {
            position: relative;
            padding-left: 23px;
            margin-top: 41px;
            width: 63%;
        }
        .checkbox-circle.mt-24 {
            margin-top: 24px;
        }
        .checkbox-circle label {
            cursor: pointer;
            color: #999;
            font-size: 13px;
            line-height: 1.9;
            transform: translateY(-5px);
        }
        .checkbox-circle label a {
            color: #6d7f52;
        }
        .checkbox-circle label a:hover {
            color: #89b843;
        }
        .checkbox-circle input {
            position: absolute;
            opacity: 0;
            cursor: pointer;
        }
        .checkbox-circle input:checked ~ .checkmark:after {
            display: block;
        }
        .checkbox-circle .checkmark {
            position: absolute;
            top: 6px;
            left: 0;
            height: 13px;
            width: 13px;
            border-radius: 50%;
            border: 1px solid #999;
        }
        .checkbox-circle .checkmark:after {
            content: "";
            top: 2px;
            left: 2px;
            width: 7px;
            height: 7px;
            border-radius: 50%;
            background: #999;
            position: absolute;
            display: none;
        }

        @media (max-width: 991px) {
            .wizard {
                max-width: 768px;
            }

            .image-holder img {
                height: 521px;
                object-fit: cover;
            }
        }
        @media (max-width: 767px) {
            .inner {
                display: block;
                box-shadow: none;
                -webkit-box-shadow: none;
                -moz-box-shadow: none;
                -ms-box-shadow: none;
                -o-box-shadow: none;
            }

            .image-holder {
                width: 100%;
                height: 520px;
            }
            .image-holder img {
                width: 100%;
            }

            .form-content {
                width: 100%;
                padding: 50px 20px 30px;
            }

            .form-row {
                display: block;
            }
            .form-row .form-holder, .form-row .select {
                width: 100%;
                margin-right: 0;
                margin-bottom: 18px;

            }

            .wrapper {
                height: 1201px;
                background: none;
            }

            .checkbox-circle {
                width: 100%;
            }

            .wizard {
                height: 100%;
            }
            .wizard > .steps {
                right: 50%;
                top: 52%;
                transform: translateX(50%);
            }

            .actions {
                right: 50%;
                transform: translateX(50%);
                bottom: 3%;
            }




            /* This css is for normalizing styles. You can skip this. */
            *, *:before, *:after {
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            .form-holder{
                padding:80px;
            }



            .new {
                padding: 50px;
            }

            .form-group {
                display: block;
                margin-bottom: 15px;

            }

            .form-group input {
                padding: 0;
                height: initial;
                width: initial;
                margin-bottom: 0;
                display: none;
                cursor: pointer;
            }

            .form-group label {
                position: relative;
                cursor: pointer;
            }

            .form-group label:before {
                content:'';
                -webkit-appearance: none;
                background-color: transparent;
                border: 2px solid #0079bf;
                box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px rgba(0, 0, 0, 0.05);
                padding: 20px;
                display: inline-block;
                position: relative;
                vertical-align: middle;
                cursor: pointer;
                margin-right: 5px;
            }



            .form-group input:checked + label:after {
                content: '';
                display: block;
                position: absolute;
                top: 2px;
                left: 9px;
                width: 6px;
                height: 20px;
                border: solid #0079bf;
                border-width: 0 2px 2px 0;
                transform: rotate(45deg);
            }
            /* sourceMappingURL=style.css.map */

        </style>
        <body>
            <div class="wrapper">

                <form action="CreateBikeClaim" id="wizard" method="post">
                    <!-- SECTION 1 -->
                    <h2></h2>
                    <section>
                        <div class="inner">
                            <div class="image-holder">
                                <img src="img/bikeIN.jpg" alt="">
                            </div>
                            <div class="form-content" >
                                <div class="form-header">
                                    <h3>Bike Insurance</h3>
                                </div>
                                <p>Please fill with your details</p>
                                <div class="form-row">
                                    <div class="form-holder">
                                        <input type="text" readonly value="${User.getUserId()}" class="form-control" id="floatingInput" placeholder="Driver Name" name="userId" required>
                                    </div>

                                </div>
                                <div class="form-row">
                                    <div class="form-holder">
                                        <input type="text" readonly value="${User.getFullName()}" class="form-control" id="floatingInput" placeholder="Driver Name" name="fullName" required>
                                    </div>

                                </div>
                                <div class="form-row">
                                    <div class="form-holder">
                                        <input type="text" readonly value="${User.getEmail()}" class="form-control" id="floatingInput" placeholder="Driver Name" name="email" required>
                                    </div>

                                </div>
                                <div class="form-row">

                                    <div class="form-holder">
                                        <input type="text" placeholder="Bike Number" name="bikeNumber" class="form-control">
                                    </div>

                                    <div class="form-holder">
                                        <select name="bikeMake" class="form-select form-control" aria-label="Default select example">
                                            <option selected>Select Bike Make</option>
                                            <option value="Honda">Honda</option>
                                            <option value="Bajaj">Bajaj</option>
                                            <option value="Yamaha">Yamaha</option>
                                        </select>
                                        
                                    </div>

                                </div>
                                <div class="form-row">

                                    <div class="form-holder">
                                         <select name="bikeModel" class="form-select form-control" aria-label="Default select example">
                                            <option selected>Select Bike Model</option>
                                            <option value="Activa">Activa</option>
                                            <option value="CB Shine">CB Shine</option>
                                            <option value="Aviator">Aviator</option>
                                        </select>
                                        
                                    </div>

                                    <!--								<div class="form-holder" style="align-self: flex-end; transform: translateY(4px);">
                                                                                                            <div class="checkbox-tick">
                                                                                                                    <label class="male">
                                                                                                                            <input type="radio" name="gender" value="male" checked> Male<br>
                                                                                                                            <span class="checkmark"></span>
                                                                                                                    </label>
                                                                                                                    <label class="female">
                                                                                                                            <input type="radio" name="gender" value="female"> Female<br>
                                                                                                                            <span class="checkmark"></span>
                                                                                                                    </label>
                                                                                                            </div>
                                                                                                    </div>-->
                                </div>
                                <div class="checkbox-circle">
                                    <label>
                                        <input type="checkbox" checked> Nor again is there anyone who loves or pursues or desires to obtaini.
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </section>

                    <!-- SECTION 2 -->
                    <h2></h2>
                    <section>
                        <div class="inner">
                            <div class="image-holder ">
                                <img src="img/bikeIN.jpg" alt="">
                            </div>
                            <div class="form-content">
                                <div class="form-header">
                                    <h3>Registration</h3>
                                </div>
                                <p>Please fill with additional info</p>
                                <div class="form-holder" >
                                    <select name="bikeVariant" class="form-select form-control mb-2" aria-label="Default select example">
                                            <option selected>Select Bike Variant</option>
                                            <option value="3G(110cc)">3G(110cc)</option>
                                            <option value="4G(110cc)">4G(110cc)</option>
                                            <option value="5G(110cc)">5G(110cc)</option>
                                        </select>
                                    
                                </div>
                                <div class="form-row mt-2">
                                    <div class="form-holder">
                                        <select name="bikeRegistrationYear" class="form-select form-control mb-2" aria-label="Default select example">
                                            <option selected>Bike Registration Year</option>
                                            <option value="2023">2023</option>
                                            <option value="2022">2022</option>
                                            <option value="2021">2021</option>
                                            <option value="2020">2020</option>
                                            <option value="2019">2019</option>
                                            <option value="2018">2018</option>
                                        </select>
                                        
                                        
                                    </div>

                                </div>

                                <!--							<div class="form-row">
                                                                                                <div class="select">
                                                                                                        <div class="form-holder">
                                                                                                                <div class="select-control">Your country</div>
                                                                                                                <i class="zmdi zmdi-caret-down"></i>
                                                                                                        </div>
                                                                                                        <ul class="dropdown">
                                                                                                                <li rel="United States">United States</li>
                                                                                                                <li rel="United Kingdom">United Kingdom</li>
                                                                                                                <li rel="Viet Nam">Viet Nam</li>
                                                                                                        </ul>
                                                                                                </div>
                                                                                                <div class="form-holder"></div>
                                                                                        </div>-->
                            </div>
                        </div>
                    </section>

                    <!-- SECTION 3 -->
                    <h2></h2>
                    <section>
                        <div class="inner">
                            <div class="image-holder">
                                <img src="img/bikeIN.jpg" alt="">
                            </div>
                            <div class="form-content">
                                <div class="form-header">
                                    <h3>Registration</h3>
                                </div>
                                <p>Describe your Damage in Short</p>
                                <div class="form-row">
                                    <div class="form-holder w-100">
                                        <textarea  id="" placeholder="Your messagere here!" name="message" class="form-control" style="height: 99px;"></textarea>
                                    </div>
                                </div>
                                <div class="checkbox-circle mt-24">
                                    <label>
                                        <input type="checkbox" checked>  Please accept <a href="#">terms and conditions ?</a>
                                        <span class="checkmark"></span>
                                        <button type="submit">SAVE</button>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </section>
                </form>
            </div>

        </div>

        <!-- JQUERY -->
        <script src="js/jquery-3.3.1.min.js"></script>

        <!-- JQUERY STEP -->
        <script src="js/jquery.steps.js"></script>
        <script src="js/main-HIN.js"></script>
        <!-- Template created and distributed by Colorlib -->
    </body>
</html>
