<%@ taglib uri="http://www.springframework.org/tags/form" prefix="ff"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Home</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style.css" media="screen" />
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css" /> --%>
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
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/photoZoom.min.js"></script>	
<script type="text/javascript">
	
	  function openPupop(popupId,bgPopupId){
		    centerPopup(popupId,bgPopupId);
			//load popup
		    loadPopup(popupId,bgPopupId);
      }

	   $(document).ready(
				function(){
					 $("#imageContainer").photoZoom();
					  
					$("#composePopupClose").click(function(){
						disablePopup('#composePopup','#bgComposePopup');
					});
					
					$("#createLabelPopupClose").click(function(){
						disablePopup('#createLabelPopup','#bgComposePopup');
					});
					
					//Click out event!
					$("#bgComposePopup").click(function(){
						disablePopup('#composePopup','#bgComposePopup');
					});
					
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
		<%@ include file="emailHomeHeader.jsp" %>
		<div id="main_content">
			<div id="email_left_content">
				<div id="email_nav">
					<ul>
						<li><a href="#" title="Compose"
							onclick="openPupop('#composePopup','#bgComposePopup');"><b>Compose</b></a></li>
						<li><a
							href="${pageContext.request.contextPath}/email/showEmails.htm?folderName=Inbox"
							title=""><b>Inbox</b></a></li>
						<li><a
							href="${pageContext.request.contextPath}/email/showEmails.htm?folderName=Send_Item"
							title=""><b>Send Item</b></a></li>
						<li><a class="current" href="#" title=""><b>Settings</b></a></li>

						<c:forEach var="item" items="${sessionScope.folderForms}">
							<li><a
								href="${pageContext.request.contextPath}/email/showEmails.htm?folderName=${item.folder}"
								title="${item.folder}"><b>${item.folder}</b></a></li>
						</c:forEach>
						<!-- Folder List -->
						<li><a href="#" title="Create Label"
							onclick="openPupop('#createLabelPopup','#bgComposePopup');"><b>Create
								Label</b></a></li>
					</ul>
				</div>
			</div>
			<!--end of left content-->
			<div id="right_content">
				<p>From: ${emailContent.MAILFROM}<br/>
					To: ${emailContent.MAILTO}<br/>
					Date: ${emailContent.MAILDATE}<br/>
					<br/>
					Message:<br/>
					${emailContent.MAILDATA}
				
				</p>				
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
	<div id="createLabelPopup">
		<a id="createLabelPopupClose">x</a>
		<h1>Create Label</h1>
		<p id="popupContact">
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
	<div id="composePopup">
		<a id="composePopupClose">x</a>
		<h1>Compose</h1>
		<!--  <a id="minimize">-</a>  -->
		<p id="popupContact">
			<ff:form
				action="${pageContext.request.contextPath}/email/sentEmail.htm"
				method="post" commandName="sentEmailForm">
				<table align="center" size="15" border="0">
					<tr>
						<td>To</td>
						<td><input type="text" name="MAILTO" id="t1" size="33" /></td>
					</tr>

					<tr>
						<td>Cc</td>
						<td><input type="text" name="MAILCC" id="t1" size="33" /></td>
					</tr>

					<tr>
						<td>Bcc</td>
						<td><input type="text" name="MAILBCC" id="t3" size="33" /></td>
					</tr>

					<tr>
						<td>Subject</td>
						<td><input type="text" name="SUBJECT" id="t3" size="33" /></td>
					</tr>



					<tr>
						<td>Message</td>
						<td><textarea name="MAILDATA" id="t1" rows="4" cols="30"></textarea>
						</td>
					</tr>
					<tr>

						<td align="center" colspan="2"><input type="submit"
							value="Send" class="button" /></td>
					</tr>
				</table>
			</ff:form>
		</p>
	</div>
	<div id="backgroundPopup"></div>

	<!-- <script>
		$('ul#navi li a').click(function(){
			var folder = $(this).attr('title');
			$('#right_content').text(folder);
			$.ajax({
				type : "POST",
				url : "/${pageContext.request.contextPath}/auth/showFolderContent.htm",
				dataType : "json",
				data : folder,
				success : function(responseText) {
					//alert(responseText);
					$('#folderContent').show(); 
				},

				error : function(jqXHR, exception) {
					if (jqXHR.status == 0) {
						alert('Not connect.\n Verify Network.');
					} else if (jqXHR.status == 404) {
						alert('Requested page not found. [404]');
					} else if (jqXHR.status == 500) {
						alert('Internal Server Error [500].');
					} else {
						alert('Other Error.\n'
								+ jqXHR.responseText);
					}
				}
			});
			return false;
		});
	</script> -->

</body>
</html>
