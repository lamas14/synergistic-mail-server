<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Customer Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" media="screen" />

<script type="text/javascript">
	function submitForm() {
		if (document.customerForm.firstName.value == "") {
			alert("First Name should be left blank");
			document.customerForm.firstName.focus();
			return false;
		}
		if (document.customerForm.lastName.value == "") {
			alert("Last Name should be left blank");
			document.customerForm.lastName.focus();
			return false;
		}
		if (document.customerForm.userid.value == "") {
			alert("User ID should be left blank");
			document.customerForm.userid.focus();
			return false;
		}
		if (/^[a-zA-Z0-9]*$/.test(document.customerForm.userid.value) == false) {
			alert("User Name should not contain special characters like @!*&");
			document.loginForm.userid.focus();
			return false;
		}
		if (document.customerForm.password.value == "") {
			alert("Password should be left blank");
			document.customerForm.password.focus();
			return false;
		}
		if (document.customerForm.password.value != document.customerForm.cpassword.value) {
			alert("Passwords do not match");
			document.customerForm.cpassword.focus();
			return false;
		}
		if (document.customerForm.birthday.value == "") {
			alert("Birthday should be left blank");
			document.customerForm.birthday.focus();
			return false;
		}
		if (document.customerForm.phone.value == "") {
			alert("Phone should be left blank");
			document.customerForm.phone.focus();
			return false;
		}
		if (document.customerForm.location.value == "") {
			alert("Location should be left blank");
			document.customerForm.location.focus();
			return false;
		}
		if (document.customerForm.address.value == "") {
			alert("Address should be left blank");
			document.customerForm.address.focus();
			return false;
		}

		document.forms[0].submit();

	}
</script>

</head>

<body>
	<div id="main_container">
		<div id="header">
			<div id="logo">
				<a href="home.html"><img
					src="${pageContext.request.contextPath}/images/logo.gif" alt=""
					title="" border="0" /></a>
			</div>

			<div id="menu">
				<ul>
					<li><a href="home.html" title="">home</a></li>
					<li><a href="services.html" title="">services</a></li>
					<li><a href="#" title="">clients</a></li>
					<li><a href="#" title="">testimonials</a></li>
					<li><a class="current" href="contact.html" title="">contact
							us</a></li>
				</ul>
			</div>

		</div>

		<div class="green_box">
			<div class="clock">
				<img src="${pageContext.request.contextPath}/images/emaillogo.jpg"
					alt="" title="" />
			</div>
			<div class="text_content">
				<h1>Email Server welcomes you!</h1>
				<p class="green">"This is email server through which you can
					send email to other poeple within organization."</p>

			</div>

			<div id="right_nav">
				<ul>
					<li><a href="home.html" title="">Email Server</a></li>
					<li><a href="services.html" title="">Database Sever</a></li>
					<li><a class="current" href="#" title="">Settings</a></li>

				</ul>
			</div>


		</div>
		<!--end of green box-->

		<div id="main_content">
			<div id="left_content">
				<h2>Latest News</h2>
				<img src="${pageContext.request.contextPath}/images/email.jpg"
					alt="" title="" border="0" /> <img
					src="${pageContext.request.contextPath}/images/email1.jpg" alt=""
					title="" border="0" /> <br />
				<h3>
					<font color="black">This application is under construction!</font>
				</h3>
			</div>
			<!--end of left content-->

			<div id="right_content">
				<h2>Registration Form</h2>
				<ff:form name="customerForm"
					action="${pageContext.request.contextPath}/customer/addCustomer.htm"
					method="post" commandName="fcustomerForm">
					<div id="contact_form">
						<div class="form_row">
							<label>First Name:</label><input type="text" name="firstName"
								class="contact_input" />
						</div>

						<div class="form_row">
							<label>Last Name:</label><input type="text" name="lastName"
								class="contact_input" />
						</div>

						<div class="form_row">
							<label>UserId:</label><input type="text" name="userid"
								class="contact_input" size="15" />


							<div class="form_row">
								<label>Password:</label><input type="password" name="password"
									class="contact_input" />
							</div>


							<div class="form_row">
								<label>Confirm Password:</label><input type="password"
									name="cpassword" class="contact_input" />
							</div>


							<div class="form_row">
								<label>BirthDay:</label><input type="text" name="birthday"
									class="contact_input" />
							</div>


							<div class="form_row">
								<label>Gender:</label> <select name="gender">
									<option>MALE</option>
									<option>FEMALE</option>
								</select>

							</div>

							<div class="form_row">
								<label>Phone:</label><input type="text" name="phone"
									class="contact_input" />
							</div>

							<div class="form_row">
								<label>Location :</label><input type="text" name="location"
									class="contact_input" />
							</div>

							<div class="form_row">
								<label>Address:</label>
								<textarea name="address" class="contact_textarea"></textarea>
							</div>


							<div class="send">
								<a href="#" onclick="submitForm();">Next</a>
							</div>

						</div>
				</ff:form>



			</div>
			<!--end of right content-->



			<div style="clear: both;"></div>
		</div>
		<!--end of main content-->


		<div id="footer">
			<div class="copyright">
				<a href="home.html"><img
					src="${pageContext.request.contextPath}/images/footer_logo.gif"
					border="0" alt="" title="" /></a>
			</div>
			<div class="footer_links">
				<a href="#">About us</a> <a href="privacy.html">Privacy policy</a> <a
					href="contact.html">Contact us </a> <a
					href="http://www.webpagedesign.com.au">Art for the web</a>

			</div>


		</div>



	</div>
	<!--end of main container-->
</body>
</html>
