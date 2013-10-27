<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Greefies Css Template</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" media="screen" />


<script type="text/javascript">
	function submitForm() {
		if (document.loginForm.username.value == "") {
			alert("User Name should be left blank");
			document.loginForm.username.focus();
			return false;
		}
		if (!/^[a-zA-Z0-9]*$/.test(document.loginForm.username.value)) {
			alert("User Name should not contain special characters like @!*&");
			document.loginForm.username.focus();
			return false;
		}
		if (document.loginForm.password.value == "") {
			alert("Password should be left blank");
			document.loginForm.password.focus();
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
				<img src="${pageContext.request.contextPath}/images/loginpage.png"
					alt="" title="" border="0" /> <br />
				<h3>
					<font color="black">This application is under construction!</font>
				</h3>
			</div>
			<!--end of left content-->


			<div id="right_content">
				<h3 align="center">
					<font color="black">++++Login Form+++</font>
				</h3>
				<form name="loginForm"
					action="${pageContext.request.contextPath}/auth/login.htm"
					method="post">
					<div id="contact_form">
						<c:out value="${sessionScope.error}"/>
						<div class="form_row">
							<label><font color="blue"><b>First Name:</b></font></label><input
								type="text" name="username" class="contact_input" 
								style="width:120px;"/><label>@synergisticit.com</label>
						</div>

						<div class="form_row">
							<label><font color="blue"><b>Password:</b></font></label><input
								type="password" name="password" class="contact_input" />
						</div>

						<div class="send">
							<a href="#" onclick="submitForm();">Sign in</a>
						</div>

					</div>

				</form>



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
