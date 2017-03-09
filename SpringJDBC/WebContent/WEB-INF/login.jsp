<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>  
		<script type="text/javascript">
		$(document).ready(function(){ 	
			$('#btnload').click(function(){
				var form=$('#loginform');
				var postData = form.serializeArray();
				$.ajax({
					type: 'POST',
					url: '${pageContext.request.contextPath}/doLogin',
					async:false,
					data: postData,
					success:function(data){
						$('.result').html(data);
					}
				});
			});
		});
		</script>
	</head>
	<body>
		<div class="content">
			<fieldset>
				<legend>Navigation menu</legend>
				<a href="index.jsp">Home</a>
				
				<sf:form modelAttribute="userBean" id="loginform" >
					<br />
					<sf:label path="userId" id = "userId">UserName:</sf:label>
					<sf:input path="userId" />
					<br />
					<br/>
					<sf:label path="password" id = "password">Password:</sf:label>
					<sf:password path="password" />
					<br />
					<br/>
					<input type="button" value="Login" id="btnload" /><br />	
				</sf:form>
				
			</fieldset>
		</div>
			
		<div class="result"></div>	
	</body>
</html>