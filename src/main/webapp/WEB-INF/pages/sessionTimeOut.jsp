<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" media="screen" />
</head>

<body>
	<div id="main_container">
		<div id="header">
			<div id="logo">
				<a href="home.html"><img src="${pageContext.request.contextPath}/images/shlogo.jpg" alt="" title=""
					border="0" /></a>
			</div>

			<div id="menu">
			    </br>
				<marquee crollAmount=4 scrollDelay=200 ><h3 style="color:white">Sorry! your session is time out, please log in once again</h3></marquee>
			</div>

		</div>
		<br/>
		

		<div id="main_content">
			<div id="left_content">
				<img src="${pageContext.request.contextPath}/images/loginpage.png" alt="" title=""
					border="0" />

                <br/>
                	<h3><font color="black">This application is under construction!</font></h3>
			</div>
			<!--end of left content-->


			<div id="right_content">
	         <h1 align="center"><font color="red"><span id="message">${error}</span></font></h1>
				<br/>				
				<center><a href="${pageContext.request.contextPath}/auth/login.htm" ><b>Click here to Login</b></a></center>
				<center>
				<img src="${pageContext.request.contextPath}/images/lock.jpg" alt="right" title=""
					border="0" /></center>
			</div>
			<!--end of right content-->

			<div style="clear: both;"></div>
		</div>
		<!--end of main content-->


		<div id="footer">
			<div class="copyright">
				<a href="home.html"><img src="${pageContext.request.contextPath}/images/footer_logo.gif" border="0"
					alt="" title="" /></a>
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
