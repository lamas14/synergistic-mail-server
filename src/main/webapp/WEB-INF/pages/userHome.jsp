<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Greefies Css Template</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css" />
<!-- Our CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/banks.css" />
<!-- Java Scripts-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.animated.innerfade.js"></script>
<!-- <script src="http://jqueryjs.googlecode.com/files/jquery-1.2.6.min.js"
	type="text/javascript"></script> -->
<script src="${pageContext.request.contextPath}/js/popup.js"
	type="text/javascript"></script>
<script type="text/javascript">
	   $(document).ready(
				function(){
						$('ul#animated-portfolio').animatedinnerfade({
						speed: 3000,<!--set speed-->
						timeout: 5000,<!--set Time-->
						type: 'sequence',<!--set type - sequence or random-->
						containerheight: '300px',
						containerwidth: '800px',
						animationSpeed: 2500,
						animationtype: 'fade',<!--Animation type - fade or slider-->
						bgFrame: 'none',
						controlBox: 'none',
						displayTitle: 'none'					});
			});
  	</script>

<script type="text/javascript">

  function  submitForm(){
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
				<div id="left_nav">
					<ul id="navi">
						<li><a href="home.html" title="">Compose</a></li>
						<li><a href="home.html" title="">Inbox</a></li>
						<li><a href="services.html" title="">Send Item</a></li>
						<li><a class="current" href="#" title="">Settings</a></li>

						<c:forEach var="current" items="${sessionScope.folders}">
							<li><a href="#" title="${current.folder}">${current.folder}</a></li>
						</c:forEach>
						<!-- Folder List -->
						<li><a href="#" onclick="onhref();" title="">Create Label</a></li>
					</ul>
				</div>



			</div>
			<!--end of left content-->


			<div id="right_content">
				<img src="${pageContext.request.contextPath}/images/loginpage.png"
					alt="" title="" border="0" />



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


	<!--  Create Label POPUP STARTS HERE--------------------------------------------------------- -->
	<div id="popupContact">
		<a id="popupContactClose">x</a>
		<h1>Create Label</h1>
		<p id="contactArea">


			<ff:form
				action="${pageContext.request.contextPath}/auth/addFolder.htm"
				method="post">

				<table align="center" border="0">
					<tr>
						<td>Folder Name</td>
						<td><input type="text" name="folderName" id="t1" size="33" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="Add" class="button" /></td>
						<!--
	Some Dynamic Control Here
	<input type="hidden" name="bank">   -->
					</tr>

				</table>
			</ff:form>


		</p>
	</div>

	<div id="backgroundPopup"></div>
	<!-- Create Label Popup ends here -->

	<script>
		$('ul#navi li a').click(function(){
			var folder = $(this).attr('title');
			$('#right_content').text(folder);
			/* $.post('auth/content.htm', {folder: folder}, function(data){
				$('#right_content').text(folder);
			}); */
		});
	</script>

</body>
</html>
