<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="<%=request.getContextPath() %>/js/jquery-1.6.4.js" type="text/javascript">
</script>
<script type="text/javascript">
   //initializing JDOM
   //ready is registring these function on
   //html DOM.
   
   function executeQuery() {
	   $.ajax({url:"${pageContext.request.contextPath}/rest/checkName",data:{pusername: 'nagendra'},
			success:function(data) {
				//alert("done = "+data);
				status = data;
				$("#useridMessage").html(status);
  			}
	   });  
      setTimeout(executeQuery, 3000); // you could choose not to continue on failure...
}
   
   $(document).ready( function(){
	   // run the first time; all subsequent calls will take care of themselves
	   setTimeout(executeQuery, 3000);
	   
	   $("#username").keyup(function() {
		   //alert("I am here!");
			var username=$("#username").val();	
			if(username.length==0){
			   $("#username").focus();
			   return;
			}
			var status;
			$.ajax({url:"${pageContext.request.contextPath}/rest/checkName",data:{pusername: username},
					success:function(data) {
						//alert("done = "+data);
						status = data;
						$("#useridMessage").html(status);
		   			}
			});  
	   
	   }); //end of event method
	  	   
   });//ready end

</script>

</head>
<body bgcolor="#cccfff">

   <table border="1">
      <tr>
        <td>USER ID</td>
        <td><input type="text" id="username" name="username" onkeyup=""/></td>
         <td><span id="useridMessage"></span></td>
      </tr>
   </table>
  
</body>
</html>