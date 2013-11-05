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
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/photoZoom.min.js"></script>
 	

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menustyles.css" />
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>

<script type="text/javascript">

var firstTime=0;
function closePupop(popupId,bgPopupId){
	//alert("firstTime = "+firstTime);
	//if(firstTime!=0) {
	    disablePopup('#showSummaryPopup','#bgComposePopup');
	   // firstTime=0;
//	}else{
	//	firstTime=1;
	//}
}
	
///
var viewSummaryUserName="";
var viewSummaryUserId="";
function viewUserSummary(pname,puserid){
	     viewSummaryUserName=pname;
	     viewSummaryUserId=puserid;
		 $('#viewFromUserId').html(pname);
		 $('#viewhuserid').val(puserid);
		 $('#emailIDTD').html(pname);
		 //changing the image for img tag using src attribute 		 
  		 var newSrc="${pageContext.request.contextPath}/auth/loadImageById.htm?userid="+puserid;
  		 //alert(newSrc);
		 $("img[id=#viewPhoto]").attr('src', newSrc);
		 openPupop('#viewSummaryPopup','#bgComposePopup');
	}
		
	function startChat(pname,puserid){
		//alert("+++__++++++");
		 $('#fromUserId').html(pname);
		 $('#huserid').val(puserid);
		disablePopup('#viewSummaryPopup','#bgComposePopup');
		 openPupop('#showSummaryPopup','#bgComposePopup');
	}
	
	  function openPupop(popupId,bgPopupId){
		    centerPopup(popupId,bgPopupId);
			//load popup
		    loadPopup(popupId,bgPopupId);
      }
	  
	  
	  function findAvailableUsers() {
		  var damenu="<ul><li><a href=\'#\'><span><h2>Available Users<h2></span></a> <ul>";
	     var demenuend="</ul></li></ul>";
		  
		  $.ajax({url:"${pageContext.request.contextPath}/auth/availableUsers.htm",	success:function(data) {
					var auser = data.split(",") // Delimiter is a string
					var mmenu="";
					for (var i = 0; i < auser.length-1; i++) {				
						var fname=auser[i].substring(0,auser[i].indexOf(":"));
						var puserid=auser[i].substring(auser[i].indexOf(":")+1);
						mmenu=mmenu+"<li ><a  href=\'#\' onclick=\"startChat('"+fname+"','"+puserid+"');\" onmouseover=\"viewUserSummary('"+fname+"','"+puserid+"');\"><h4><font color=\"black\">"+fname+"</font></h4></a></li>";
						//alert(fname);
					}
					damenu=damenu+mmenu+demenuend;
					$("#pcssmenu").html(damenu);
	  			}
		   });  
		  setTimeout(findAvailableUsers, 10000); // you could choose not to continue on failure...
	  }
	  
	  function executeQuery() {
		  var puserid="${sessionScope.userId}";
		 // alert("puserid = "+puserid);
		  var goahead=1;
		  $.getJSON("${pageContext.request.contextPath}/chat/checkMessage.htm", { userid: puserid}, function(jsonResponse) {
				 if(!jQuery.isEmptyObject(jsonResponse)) {
					 if(jsonResponse['cid']==0) {
						 
					 }else {
						 goahead=0;
						 $('#fromUserId').html(jsonResponse['fromuser']);
						 $('#huserid').val(jsonResponse['fromuser']);
						// $("[id$='fromChatMessageId']").val(val['msg']);
						var alreadyOpened=$("textarea#fromChatMessageId").val();
						var messageFromServer=jsonResponse['fromuser']+": "+jsonResponse['msg'];
						//when popup is not opened
						if(alreadyOpened.length==0){
							$("textarea#fromChatMessageId").text(messageFromServer);
							 openPupop('#showSummaryPopup','#bgComposePopup');	
						}else{
							$("textarea#fromChatMessageId").append("\n"+messageFromServer);
						}
						 
					 }
					  //alert(jsonResponse['fromuser']);
						   
	       		 }  //end of if
	       	 });
		   if(goahead==1) {
		   	setTimeout(executeQuery, 10000); // you could choose not to continue on failure...
		   }
	}

	   $(document).ready(
			//   $("#folderContent").hide();
				function(){
					
					$("#sendChatMessage").click(function(){
						//write code here
						 var touserid=$('#huserid').val();
						 var fcm=$("textarea#currentTypedMessageId").val();
						 $("textarea#currentTypedMessageId").val('');
						// alert("fcm = "+fcm);
						 $("textarea#fromChatMessageId").append("\nme: "+fcm);
						 //pushing data into the data
						 $.ajax({url:"${pageContext.request.contextPath}/chat/sendChatMessage.htm",data:{touserid:touserid,fcm:fcm},	success:function(data) {
								//message is send here
				  			}
					   });  
						 
						 						
					});			
					
					
					// $("#imageContainer").photoZoom();

					 // run the first time; all subsequent calls will take care of themselves
					  setTimeout(executeQuery, 10000);
					  setTimeout(findAvailableUsers, 10000);
					  
					$("#composePopupClose").click(function(){
						disablePopup('#composePopup','#bgComposePopup');
					});
					
					
					
					$("#createLabelPopupClose").click(function(){
						disablePopup('#createLabelPopup','#bgComposePopup');
					});
					
					$("#showSummaryPopupClose").click(function(){
						disablePopup('#showSummaryPopup','#bgComposePopup');
					});
					
					$("#viewSummaryPopupClose").click(function(){
						disablePopup('#viewSummaryPopup','#bgComposePopup');
					});
					
					
					$("#passwordPopupClose").click(function(){
						disablePopup('#passwordPopup','#bgComposePopup');
					});
					
					$("#profilePopupClose").click(function(){
						disablePopup('#profilePopup','#bgComposePopup');
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
  
  function  submitChangepwdForm(){
	  try{
	   if (document.changepwdForm.newpassword.value == "") {
		   alert("Password cannot be empty..")
		   // document.changepwdForm.newpassword.innerHTML = "Password cannot blank..";
			document.changepwdForm.newpassword.focus();
			
			return false;
		}
	   if (document.changepwdForm.cpassword.value == "") {
		   alert("Password cannot be empty..")
		   // document.changepwdForm.newpassword.innerHTML = "Password cannot blank..";
			document.changepwdForm.cpassword.focus();
			
			return false;
		}
	   if (document.changepwdForm.newpassword.value != document.changepwdForm.cpassword.value) {
		   alert("Password and confirm password does not match..")
		   // document.changepwdForm.newpassword.innerHTML = "Password cannot blank..";
			document.changepwdForm.cpassword.focus();
			
			return false;
		}
		document.changepwdForm.submit();
	  }catch(err){
		  alert(err);
	  }
  
  }
  
  
  function  submitchangeProfileForm(){
	  if (document.changeProfileForm.phone.value == "") {
			alert("Phone should be left blank");
			document.changeProfileForm.phone.focus();
			return false;
		}
		if (document.changeProfileForm.location.value == "") {
			alert("Location should be left blank");
			document.changeProfileForm.location.focus();
			return false;
		}
		if (document.changeProfileForm.address.value == "") {
			alert("Address should be left blank");
			document.changeProfileForm.address.focus();
			return false;
		}
	 	  document.changeProfileForm.submit();
  }

</script>

</head>

<body>
	<div id="main_container">
		<%@ include file="emailHomeHeader.jsp"%>
		<div id="main_content">
			<div id="email_left_content">
				<div id="email_nav">
					<ul>
					
						<li
							onmouseover11="openPupop('#showSummaryPopup','#bgComposePopup');"><a
							href="#" title="Summary"><b>test</b>
						</a>
						</li>
						<li><a href="#" title="Compose"
							onclick="openPupop('#composePopup','#bgComposePopup');"><b>Compose</b>
						</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/email/showEmails.htm?folderName=Inbox&show=next&page=0"
							title=""><b>Inbox</b>
						</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/email/showEmails.htm?folderName=Send_Item&show=next&page=0"
							title=""><b>Send Item</b>
						</a>
						</li>
						<li><a class="current" href="#" title=""><b>Settings</b>
						</a>
						</li>

						<c:forEach var="item" items="${folderForms}">
							<li><a
								href="${pageContext.request.contextPath}/email/showEmails.htm?folderName=${item.folder}&show=next&page=0"
								title="${item.folder}"><b>${item.folder}</b>
							</a>
							</li>
						</c:forEach>
						<!-- Folder List -->
						<li><a href="#" title="Create Label"
							onclick="openPupop('#createLabelPopup','#bgComposePopup');"><b>Create
									Label</b>
						</a>
						</li>
						
						
					</ul>
				</div>
						
			</div>
			<!--end of left content-->
			<div id="right_content">
				<center>
					<h3>${message}</h3>
					<p>${error}</p>
				</center>
		
						
			</div>
		</div>
		<!--end of right content-->



		<div style="clear: both;"></div>
	</div>
	<!--end of main content-->

	<div id="footer">
		<div class="copyright">
			<a href="home.html"><img
				src="${pageContext.request.contextPath}/images/footer_logo.gif"
				border="0" alt="" title="" />
			</a>
		</div>
		<div class="footer_links">
			<a href="#">About us</a> <a href="privacy.html">Privacy policy</a> <a
				href="contact.html">Contact us </a> <a
				href="http://www.webpagedesign.com.au">Art for the web</a>

		</div>
	</div>
	</div>
	
	
	<!--  Create Label POPUP STARTS HERE--------------------------------------------------------- -->
	<div id="viewSummaryPopup">
		<!-- onclick="closePupop('#showSummaryPopup','#bgComposePopup');" -->
		<a id="viewSummaryPopupClose">x</a>
		<h1>
			<span id="viewFromUserId">Nagendra Kumar</span>
		</h1>
		<p id="popupContact">
			<ff:form
				action="${pageContext.request.contextPath}/folder/addFolder.htm"
				method="post">
				
				<input type="hidden"  id="viewhuserid"  name="viewhuserid"/>
				
				<table align="center" border="0">
					<tr>
						<td id="emailIDTD">nagendra.yadav.niit@gmail.com</td>
						<td align="right"><img
				src="${pageContext.request.contextPath}/auth/loadImageById.htm?userid=${sessionScope.userId}"
				alt="center" title="Hello ${sessionScope.userId}!" width="50"
				height="50"  id="viewPhoto"/></td>
					</tr>
					
					<tr>
						<td align="right" colspan="2">
						<a href="#"  onclick="startChat(viewSummaryUserName, viewSummaryUserId);">
						<img
				src="${pageContext.request.contextPath}/images/chat1.jpg"
				alt="center" title="Hello ${sessionScope.userId}!" width="50"
				height="50"  id="viewPhoto" />
				
				</a>
				</td>
					</tr>
				</table>
			</ff:form>
		</p>
	</div>
	


	<!--  Create Label POPUP STARTS HERE--------------------------------------------------------- -->
	<div id="showSummaryPopup">
		<!-- onclick="closePupop('#showSummaryPopup','#bgComposePopup');" -->
		<a id="showSummaryPopupClose">x</a>
		<h1>
			<span id="fromUserId">Manish Kumar</span>
		</h1>
		<p id="popupContact">
			<ff:form
				action="${pageContext.request.contextPath}/folder/addFolder.htm"
				method="post">
				
				<input type="hidden"  id="huserid"  name="huserid"/>
				
				<table align="center" border="0">
					<tr>
						<td colspan="2"><textarea cols="45" rows="6" id="fromChatMessageId" style="background-color: pink"></textarea>
						</td>
					</tr>
					<tr>
						<td valign="top" colspan="2" align="center">
						<textarea id="currentTypedMessageId" cols="40" rows="2" style="background-color:#7D166E;color: white " ></textarea>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="button"
							value="Send" class="button"  id="sendChatMessage"/>
						</td>
					</tr>
				</table>
			</ff:form>
		</p>
	</div>
	
	<!--  CHANGE PASSWORD POPUP STARTS HERE--------------------------------------------------------- -->

	<div id="passwordPopup">
		<a id="passwordPopupClose">x</a>
		<h1>Change Password</h1>
		<p id="popupContact">

			<ff:form name="changepwdForm"
				action="${pageContext.request.contextPath}/auth/changepwd.htm"
				method="post">
				<table align="center" size="120" border="0">


					<tr>
						<td>Current Password</td>
						<td><input type="password" readonly name="password"
							value=<%=session.getAttribute("password")%> id="t1" size="33" />
						</td>
					</tr>


					<tr>
						<td>New Password</td>
						<td><input type="password" name="newpassword"
							id="newpassword" size="33" />
						</td>
					</tr>

					<tr>
						<td>Confirm Password</td>
						<td><input type="password" name="cpassword" id="cpassword"
							size="33" />
						</td>
					</tr>

					<tr>

						<td align="center" colspan="2"><input type="button"
							onclick="submitChangepwdForm();" value="Save " class="button" />
						</td>
						<!--
									Some Dynamic Control Here
									<input type="hidden" name="bank">   -->
					</tr>

				</table>
			</ff:form>
		</p>
	</div>
	<!--  POPUP ends HERE--------------------------------------------------------- -->

	<!-- PROFILE POPUP STARTS HERE--------------------------------------------------------- -->
	<div id="profilePopup">
		<a id="profilePopupClose">x</a>
		<h1>Change Profile</h1>
		<p id="popupContact">
			<ff:form name="changeProfileForm"
				action="${pageContext.request.contextPath}/auth/changeprofile.htm"
				method="post" enctype="multipart/form-data">
				<table align="center" size="120" border="0">

					<tr>
						<td>Phone</td>
						<td><input type="text" name="phone" id="phone"
							value="${customerform.phone}" size="33" />
						</td>
					</tr>
					<tr>

						<td>Location</td>
						<td><input type="text" name="location" id="location"
							value="${customerform.location}" size="33" />
						</td>
					</tr>
					<tr>
						<td>Address</td>
						<td><textarea name="address" id="address"> ${customerform.address} </textarea>
						</td>
					</tr>
					<tr>
						<td>Select Profile Image</td>
						<td><input type="file" name="photo" />
						</td>
					</tr>

					<tr>

						<td align="center" colspan="2"><input type="button"
							onclick="submitchangeProfileForm();" value="Save " class="button" />
						</td>
						<!--
									Some Dynamic Control Here
									<input type="hidden" name="bank">   -->
					</tr>

				</table>
			</ff:form>
		</p>
	</div>
	<!--  POPUP ends HERE--------------------------------------------------------- -->


	<!--  Create Label POPUP STARTS HERE--------------------------------------------------------- -->
	<div id="createLabelPopup">
		<a id="createLabelPopupClose">x</a>
		<h1>Create Label</h1>
		<p id="popupContact">
			<ff:form
				action="${pageContext.request.contextPath}/folder/addFolder.htm"
				method="post">

				<table align="center" border="0">
					<tr>
						<td>Folder Name</td>
						<td><input type="text" name="folderName" id="t1" size="33" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="Add" class="button" />
						</td>
						<!--
	Some Dynamic Control Here
	<input type="hidden" name="bank">   -->
					</tr>
				</table>
			</ff:form>
		</p>
	</div>
	<div id="backgroundPopup"></div>
	--%>
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
						<td><input type="text" name="MAILTO" id="t1" size="33" />
						</td>
					</tr>

					<tr>
						<td>Cc</td>
						<td><input type="text" name="MAILCC" id="t1" size="33" />
						</td>
					</tr>

					<tr>
						<td>Bcc</td>
						<td><input type="text" name="MAILBCC" id="t3" size="33" />
						</td>
					</tr>

					<tr>
						<td>Subject</td>
						<td><input type="text" name="SUBJECT" id="t3" size="33" />
						</td>
					</tr>



					<tr>
						<td>Message</td>
						<td><textarea name="MAILDATA" id="t1" rows="4" cols="30"></textarea>
						</td>
					</tr>
					<tr>

						<td align="center" colspan="2"><input type="submit"
							value="Send" class="button" />
						</td>
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
