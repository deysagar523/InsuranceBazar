 *, *::before, *::after {
  box-sizing: border-box;
}

body {
  background-image: url(https://s3.ca-central-1.amazonaws.com/image-web-frankie/BackgroundBlue.jpg);
  background-size: cover;
  background-position: center;
  font-family: tahoma;
  overflow: hidden;
}

.btn {
  display: block;
  background-color: #bded7d;
  color: white;
  text-decoration: none;
  margin: 20px 0;
  padding: 15px 15px;
  border-radius: 5px;
  position: relative;
}

.btn::after {
  content: "";
  position: absolute;
  z-index: 1;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  transition: all 0.2s ease-in-out;
  box-shadow: inset 0 3px 0 rgba(0, 0, 0, 0), 0 3px 3px rgba(0, 0, 0, 0.2);
  border-radius: 5px;
}

.btn:hover::after {
  background-color: rgba(0, 0, 0, 0.1);
  box-shadow: inset 0 3px 0 rgba(0, 0, 0, 0.2);
}

.btn-social {
  padding-left: 64px;
  position: relative;
  z-index: 1;
}

.btn-social .fa {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1;
  width: 50px;
  height: 100%;
  text-align: center;
  background-color: rgba(0, 0, 0, 0.1);
  line-height: 3.2;
  border-radius: 5px 0 0 5px;
}

.btn-facebook {
  background-color:#138496;
}

.btn-twitter {
  background-color: #55acee;
}

.btn-google {
  background-color: #dd4b39;
}



.form fieldset {
  border: none;
  padding: 0;
  margin: 20px 0;
  position: relative;
}

.form fieldset input {
  width: 100%;
  height: 48px;
  color: #333;
  padding: 15px 40px 15px 15px;
  font-size: 14px;
  outline: none !important;
  border: 1px solid greenyellow;
  box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.2);
  vertical-align: top;
}

.form button {
  width: 100%;
  outline: none !important;
  background: linear-gradient(-5deg, #79b52c, #94d63d);
  border: none;
  text-transform: uppercase;
  font-weight: bold;
  box-shadow: 0 3px 0 rgba(115, 136, 89, 0.2);
  text-shadow: 0 2px 3px rgba(0, 0, 0, 0.2);
}


.signup {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 1;
  width: 800px;
  background-color: white;
  border-radius: 10px;
  box-shadow: 0 3px 25px rgba(0, 0, 0, 0.2);
  overflow: hidden;
  display: flex;
}

.signup-connect, .signup-classic {
  width: 50%;
  padding: 30px 50px;
}

.signup-connect {
  background: #94d63d;
  color: white;
}

.signup-classic h2 {
  font-size: 16px;
  font-weight: bold;
  margin-top: 23px;
  margin-bottom: 43px;
}

.signup-classic fieldset::after {
  content: "\f007";
  font-family: FontAwesome;
  position: absolute;
  right: 15px;
  top: 17px;
  z-index: 2;
  width: 20px;
  color: rgba(0, 0, 0, 0.2);
  text-align: center;
}

.signup-classic fieldset.email::after {
  content: "\f0e0";
}

.signup-classic fieldset.password::after {
  content: "\f023";
}
