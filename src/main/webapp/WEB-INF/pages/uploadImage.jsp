<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Image upload page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" media="screen" />

<script type="text/javascript">
  function  submitForm(){
	  alert("Hello ,");
	  document.forms[0].submit();
	  
  }
</script>

</head>

<body>
	<div id="main_container">
		<div id="header">
			<div id="logo">
				<a href="home.html"><img src="${pageContext.request.contextPath}/images/logo.gif" alt="" title=""
					border="0" /></a>
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
				<img src="${pageContext.request.contextPath}/images/emaillogo.jpg" alt="" title="" />
			</div>
			<div class="text_content">
				<h1>Email Server welcomes you!</h1>
				<p class="green">"This is email server through which you can send email to other poeple within organization."</p>
				
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
				<img src="${pageContext.request.contextPath}/images/user.jpg" alt="" title=""
					border="0" />
                <br/>
                	<h3><font color="black">This application is under construction!</font></h3>
			</div>
			<!--end of left content-->

			<div id="right_content">
				<h3>Upload Image</h3>
				<ff:form name="imageForm" action="${pageContext.request.contextPath}/customer/uploadImage.htm" 
				method="post" enctype="multipart/form-data">
					<div id="contact_form">
							Select Profile Image:<input type="file" name="photo"/>
						<div class="send">
							<a href="#" onclick="submitForm();">Finish</a>
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
