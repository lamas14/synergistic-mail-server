<div id="header">
		<div id="logo">
				<a href="home.html"><img src="${pageContext.request.contextPath}/images/shlogo.jpg" alt="" title=""
					border="0"  align="top" height="110"/></a>
						<a href="home.html"><img src="${pageContext.request.contextPath}/images/email15.jpg" alt="" title=""
					border="0"  align="left" height="110"/></a>
					<a href="home.html"><img src="${pageContext.request.contextPath}/images/email13.jpg" alt="" title=""
					border="0"  align="right" height="110"/></a>
					
				 	<img src="${pageContext.request.contextPath}/images/emailglobe.jpg" alt="" title=""
					border="0"  align="right" height="110"/> 
			</div>

			<div id="menu">
				<ul>
					<li><a href="home.html" title="">Home</a></li>
					<li><a href="services.html" title="">Services</a></li>
					<li><a href="#" title="">Clients</a></li>
					<li><a href="#" title="">About Us</a></li>
					<li><a class="current" href="${pageContext.request.contextPath}/auth/logout.htm" title="">Logout
							</a></li>
				</ul>
			</div>

		</div>

		<div class="green_box">
			<div class="text_content">
					<div id="imageContainer">
					&nbsp;&nbsp;
					<img src="${pageContext.request.contextPath}/auth/loadImageById.htm?userid=${sessionScope.userId}" alt="center" title="Hello ${sessionScope.userId}!" width="50" height="50"/>
					<br/>&nbsp;&nbsp;&nbsp;<font color="yellow"><b>Hello ${sessionScope.userId}</b></font>
					</div>
				<p class="green"></p>
				
			</div>

			<div id="right_nav">
			<ul>
					<li><a href="${pageContext.request.contextPath}/customer/leaveBalance.htm" title=""><font color="black"><b>Edit Profile</b></font></a></li>
					<li><a href="${pageContext.request.contextPath}/customer/leaveHistory.htm" title=""><font color="black"><b>Change Password</b></font></a></li>
				<li><a href="${pageContext.request.contextPath}customer/attendanceStatus.htm" title=""><font color="black"><b>Setting</b></font></a></li>
				</ul>
			</div>
		</div>
		<!--end of green box-->