<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Join Us</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="assets/css/styles2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="container">
		<div class="box">
			<img class="avatar" src="img/collaboration.png">
			<h1>Login Account</h1>
			<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
				<p>UserName</p><input type="text" name="username">
				<p>Password</p><input type="password" name="password"> 
				<input type="submit" value="Login"> 
				<a href="#">Forget Password?</a><br> <a href="userregister.jsp">Create New Account</a>
			</form>
		</div>
	</div>
</body>
</html>