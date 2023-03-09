<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>


</c:if>
<html>
    <head>
        <meta charset="utf-8">
        <title>InsuranceBazaar</title>

        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

    </head>


    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700;800;900&display=swap');
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        body {
            width: 100vw;
            height: 100vh;
            background: linear-gradient(109.7deg, #32afd5 0%, #59ea68 50%, #c1dd52 100%);
            font-family: 'Inter', sans-serif;
        }
        .container {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            position: relative;
        }
        .main {
            background: rgba(255, 255, 255, 0.54);
            border-radius: 20px;
            width: 80rem;
            height: 56.5rem;
            margin: auto;
            position: relative;
            box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 2px, rgba(0, 0, 0, 0.07) 0px 2px 4px,
                rgba(0, 0, 0, 0.07) 0px 4px 8px, rgba(0, 0, 0, 0.07) 0px 8px 16px,
                rgba(0, 0, 0, 0.07) 0px 16px 32px, rgba(0, 0, 0, 0.07) 0px 32px 64px;
        }
        /* Shipping Address Section */
        .shipping_address {
            width: 55rem;
            height: 17rem;
            background-color: #fff;
            position: absolute;
            top: 30px;
            left: 30px;
            border-radius: 10px;
        }
        .ship_head {
            padding: 20px 0 20px 20px;
            font-weight: 900;
            font-size: 1.2rem;
        }
        .addresses {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .addresses form {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 20px;
        }
        .address_primary {
            width: 25rem;
            height: 8rem;
            border-radius: 10px;
            background-color: #bcf7da;
            box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px,
                rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            cursor: pointer;
            transition: all 0.3s;
        }
        .address_secondary {
            width: 25rem;
            height: 8rem;
            border-radius: 10px;
            background-color: #ffffff;
            box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px,
                rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            cursor: pointer;
            transition: all 0.3s;
        }
        .active1 {
            background-color: #ffffff;
        }
        .active {
            background-color: #bcf7da;
        }
        .info {
            display: grid;
            grid-template-columns: 20% 80%;
            gap: 10px;
            align-items: center;
            padding: 5px 0 0 30px;
            font-size: 15px;
        }
        .info .bold {
            font-weight: 700;
        }
        .new_address {
            font-weight: bold;
            font-size: 15px;
            position: absolute;
            bottom: 30px;
            left: 30px;
            text-transform: uppercase;
            color: #068e14;
            font-weight: bold;
            transition: all 0.3s;
        }
        .new_address:hover {
            color: #07cb1a;
            cursor: pointer;
        }
        /* Payment Method Section */
        .payment_method {
            width: 55rem;
            height: 35rem;
            background-color: #fff;
            position: absolute;
            bottom: 30px;
            left: 30px;
            border-radius: 10px;
        }
        .card_info {
            width: 40rem;
            height: 25rem;
            background:#9ec645;
            box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px,
                rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
            border-radius: 10px;
            margin: 0 0 0 40px;
            position: relative;
        }
        .card_head {
            display: flex;
            align-items: center;
            gap: 10px;
            padding: 20px 0 0 20px;
        }
        .card_head .card_title {
            font-size: 20px;
            font-weight: bold;
        }
        .card_head .btn1 {
            width: 20px;
            height: 20px;
        }
        .card_types {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 10px 0 0 60px;
        }
        .card_types .card_img {
            width: 50px;
            height: 50px;
        }
        .card_info form {
            display: flex;
            flex-direction: column;
            width: fit-content;
            padding: 10px 0 0 60px;
        }
        .card_info form input {
            padding: 15px 30px 15px 16px;
            margin-top: 20px;
            font-size: 15px;
            text-transform: capitalize;
            outline: none;
            border: none;
            border-radius: 50px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.25);
        }
        .card_info form div {
            display: flex;
            gap: 70px;
        }
        .save_card {
            font-weight: bold;
            font-size: 15px;
            position: absolute;
            bottom: 30px;
            left: 30px;
            text-transform: uppercase;
            color:#ffffff;
            font-weight: bold;
            transition: all 0.3s;
        }
        .save_card:hover {
            color: #07cb1a;
            cursor: pointer;
        }
        .e_payment {
            position: absolute;
            top: 70px;
            right: 50px;
        }
        .e_payment img {
            width: 100px;
            height: 100px;
            padding: 20px;
            margin-bottom: 15px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.4);
            border-radius: 50%;
            transition: all 0.2s;
        }
        .e_payment img:hover {
            cursor: pointer;
            transform: rotateZ(360deg);
        }
        .confirm_btn {
            background: #9ec645;
            padding: 10px 50px;
            font-size: 17px;
            font-weight: bold;
            color: #fff;
            position: absolute;
            right: 50px;
            bottom: 30px;
            border-radius: 50px;
            border: none;
            filter: drop-shadow(0px 10px 20px rgba(0, 0, 0, 0.25));
            transition: all 0.3s;
        }
        .confirm_btn:hover {
            background: #00474d;
            cursor: pointer;
            scale: 1.1;
        }
        /* Order Summary Section */
        .order_summary {
            width: 20rem;
            height: 35rem;
            position: absolute;
            top: 30px;
            right: 25px;
        }
        .order_head {
            padding: 20px 0 20px 80px;
            font-weight: 900;
            font-size: 1.2rem;
        }
        hr {
            border: none;
            border-top: 0.5px solid black;
        }
        .order_price {
            display: grid;
            grid-template-columns: repeat(1, 4fr);
            margin-top: 20px;
        }
        .price,
        .total_price {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .dark {
            font-weight: bold;
        }
        .qr_code {
            width: 10rem;
            height: 10rem;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: auto;
            margin-top: 70px;
        }
        .condition {
            margin-top: 40px;
            width: 100%;
            font-size: 15px;
        }
        .review_btn {
            background:#9ec645;
            padding: 10px 60px;
            margin: 30px 0 0 25px;
            font-size: 17px;
            font-weight: bold;
            color: #fff;
            border-radius: 50px;
            border: none;
            filter: drop-shadow(0px 10px 20px rgba(0, 0, 0, 0.25));
            transition: all 0.3s;
        }
        .review_btn:hover {
            background: #00474d;
            cursor: pointer;
            scale: 1.1;
        }
        .project_by {
            position: absolute;
            bottom: 50px;
            right: 85px;
            font-size: 13px;
            text-align: center;
        }
        .project_by span {
            font-size: 20px;
            text-transform: uppercase;
        }
    </style>
    <body>
        <main class="container">
            <div class="main">
                <!-- Shipping Address Section  -->
                <section class="shipping_address">
                    <!--        <h2 class="ship_head">Shipping Address</h2>-->
                    <div class="addresses">
                        <!--          <form action="">
                                    <div class="address_primary">
                                      <div class="info">
                                        <p class="bold">Name:</p>
                                        <p class="light">John Doe</p>
                                      </div>
                                      <div class="info">
                                        <p class="bold">Phone:</p>
                                        <p class="light">(305) 345-5678</p>
                                      </div>
                                      <div class="info">
                                        <p class="bold">Address:</p>
                                        <p class="light">312 Everette Alley, Miami, FL 33147</p>
                                      </div>
                                    </div>
                                    <div class="address_secondary">
                                      <div class="info">
                                        <p class="bold">Name:</p>
                                        <p class="light">John Doe</p>
                                      </div>
                                      <div class="info">
                                        <p class="bold">Phone:</p>
                                        <p class="light">(305) 345-5678</p>
                                      </div>
                                      <div class="info">
                                        <p class="bold">Address:</p>
                                        <p class="light">209 Marigold Lane, Miami, FL 33169</p>
                                      </div>
                                    </div>
                                  </form>-->
                    </div>
                    <!--        <span class="new_address">+ add new address</span>-->
                </section>
                <!-- Payment Method Section  -->
                <section class="payment_method">
                    <h2 class="ship_head">Payment Method</h2>
                    <div class="card_info">
                        <div class="card_head">
                            <h2 class="card_title">Debit or Credit Card</h2>
                        </div>
                        <div class="card_types">
                            <img class="card_img" src="https://cdn-icons-png.flaticon.com/512/349/349221.png" alt="" />
                            <img class="card_img" src="https://cdn-icons-png.flaticon.com/512/349/349230.png" alt="" />
                            <img class="card_img" src="https://cdn-icons-png.flaticon.com/512/349/349228.png" alt="" />
                            <img class="card_img" src="https://img.icons8.com/fluency/512/mastercard.png" alt="" />
                        </div>
                        <form action="Payment?claimId=${ClaimId}" method="post">
                            <input type="hidden" id="cardHolder"  value="${Plan.planId}" name="planId" maxlength="60" />
                            <input type="hidden" id="cardHolder"  value="${Plan.planDuration}" name="planDuration" maxlength="60" />
                            <input  type="hidden"  name="email" value="${User.email}" />
                            <input  type="hidden"  name="policyName" value="${PolicyName}" />
                            <input type="hidden" name="bikeNumber" value="${BikeNumber}"/>
                            <input type="hidden" name="bikeMake" value="${BikeMake}"/>
                            <input type="hidden" name="bikeModel" value="${BikeModel}"/>
                            <input type="hidden" name="adharCard" value="${AdharCard}"/>
                            <input type="hidden" name="relation" value="${RelativeType}"/>
                            <input type="hidden" name="disease" value="${Disease}"/>
                            <input type="hidden" name="relativeName" value="${RelativeName}"/>

                            <input type="hidden" name="childName" value="${ChildName}"/>
                            <input type="hidden" name="ChildAge" value="${ChildAge}"/>
                            <input type="hidden" name="childBirthNo" value="${ChildBirthNo}"/>

                            <input type="text" id="cardHolder"  value="" placeholder="Card Holder" maxlength="60" required/>
                            <span id="cardNumberWarning"></span>
                            <input type="text" id="cardNumber" onKeyup="loadCards()"  value="" placeholder="Card Number" maxlength="16" required/>
                            <div>
                                <input type="text" pattern="[0-9]{2}[/]{1}[23-30]{2}" title="card expired"  value="" placeholder="Expire-06/23" maxlength="5" required/>
                                <input type="text"  value="" placeholder="CVV" min="3" max="3" required/>
                            </div>
                            <button type="submit" class="confirm_btn">Confirm</button>
                        </form>
                        <span class="save_card">Save Card</span>
                    </div>
                    <div class="e_payment">
                        <div class="pay">
                            <img src="https://cdn-icons-png.flaticon.com/512/6124/6124998.png" alt="" />
                        </div>
                        <div class="pay">
                            <img src="https://cdn-icons-png.flaticon.com/512/5977/5977576.png" alt="" />
                        </div>
                        <div class="pay">
                            <img src="https://cdn-icons-png.flaticon.com/512/196/196565.png" alt="" />
                        </div>
                    </div>

                </section>
                <!-- Order Summary Section  -->
                <section class="order_summary">
                    <h2 class="order_head">Insurance Details</h2>
                    <div class="Insurance">
                        <hr />
                        <div class="price">
                            <p>Claim:</p>
                            <p>${Plan.getPolicyName()}</p>
                        </div>
                        <div class="price">
                            <p>Period</p>
                            <p>${Plan.getPlanDuration()} year</p>
                        </div>
                        <!--          <div class="price">
                                    <p>Members</p>
                                    <p>1</p>
                                  </div>-->
                        <br />
                        <hr />
                        <div class="total_price">
                            <p class="dark">Total:</p>
                            <p class="dark"><i class="fa fa-rupee"></i>${Plan.getPlanAmount()}</p>
                        </div>
                    </div>
                    <img class="qr_code" src="https://cdn-icons-png.flaticon.com/512/714/714390.png" alt="" />
                    <p class="condition">
                        Pay and Confirm Order by QR Code Using <b>Mobile Application</b>
                    </p>
                    <button href="userHomePage.jsp" class="review_btn">Review and Confirm</button>
                </section>

            </div>
        </main>
        <script src="cardValidation.js"></script>

    </body>
    <script>
                                const addPri = document.querySelector('.address_primary');
                                const addSec = document.querySelector('.address_secondary');
                                const addBg = () => {
                                    addPri.addEventListener('click', () => {
                                        addPri.classList.remove('active1');
                                        addSec.classList.remove('active');
                                    });
                                    addSec.addEventListener('click', () => {
                                        addSec.classList.add('active');
                                        addPri.classList.add('active1');
                                    });
                                };
                                addBg();
    </script>
</html>