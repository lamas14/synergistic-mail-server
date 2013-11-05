<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css" media="screen" />


<script type="text/javascript">

   function clearMessage(){
	   document.getElementById('message').innerHTML="";
   }

  function  submitForm() {
	  var pusername=document.forms[0].username.value;
	  var ppassword=document.forms[0].password.value;
	  if(pusername.length==0){
		  alert("Username cannot be blank");
		  document.forms[0].username.focus();
		  return;
	  }	
	  if(ppassword.length==0){
		  alert("Password cannot be blank");
		  document.forms[0].ppassword.focus();
		  return;
	  }	
	  document.forms[0].submit();
	  username
	  
  }


</script>

</head>

<body>
	<div id="main_container">
		<div id="header">
			<div id="logo">
				<a href="home.html"><img src="${pageContext.request.contextPath}/images/shlogo.jpg" alt="" title=""
					border="0" /></a>
			</div>

			<div id="menu">
				<ul>
					<li><a href="home.html" title="">Home</a></li>
					<li><a href="#" title="">College</a></li>
					<li><a href="#" title="">Facebook</a></li>
					<li><a href="#" title="">Gmail</a></li>
					<li><a href="#" title="">Road Map</a></li>
					<li><a href="#" title="">About Us</a></li>
					
				</ul>
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


			<div id="loginright_content">
				
	           <h3 align="center"><font color="black">Sign in to continue to synergisticit email </font></h3>
	           
	           <h3 align="center"><font color="red"><span id="message">${error}</span></font></h3>
				
				<form name="loginForm" action="login.htm" method="post">
					<div id="contact_form">
						<div class="form_row">
							<label><font color="black"><b>Login:</b></font></label><input type="text" name="username"
								class="contact_input" onkeypress="clearMessage();"/>
						</div>

						<div class="form_row">
							<label><font color="black"><b>Password:</b></font></label><input type="password" name="password"
								class="contact_input" onkeypress="clearMessage();"/>
						</div>

						<div class="send">
							<a href="#" onclick="submitForm();">Sign in</a>
							
						</div>

				<center>
					<a href="${pageContext.request.contextPath}/customer/addCustomer.htm"><img src="${pageContext.request.contextPath}/images/register1.jpg" alt="right" title=""
					border="0" />
					</a>
					<img src="${pageContext.request.contextPath}/images/emailglobe.jpg" alt="right" title=""
					border="0"/>
					</center>
					</div>

				</form>


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
