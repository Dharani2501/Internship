<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="assets/css/styles1.css" rel="stylesheet" type="text/css" />
<script> 
function validate()
{ 
     var firstName = document.form.firstName.value;
     var lastName = document.form.lastName.value;
     var username = document.form.username.value; 
     var password = document.form.password.value;
     var address = document.form.address.value;
     var contact = document.form.contact.value;
     
     if (firstName==null || firstName=="")
     { 
     alert("First Name can't be blank"); 
     return false; 
     }
     else if (lastName==null || lastName=="")
     { 
     alert("lastName can't be blank"); 
     return false; 
     }
     else if (username==null || username=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password can't be blank"); 
     return false; 
     } 
     else if (address==null || address=="")
     { 
     alert("Address can't be blank"); 
     return false; 
     } 
   <!--else if (contact==null || contact=="")
     { 
     alert("contact can't be blank"); 
     return false; 
     } -->
 } 
 </script>
</head>
<body>
	<div class="container">
		<div class="regbox box">
			<img class="avatar" src="img/collaboration.png">
			<h1>Register Account</h1>
			<form action="<%=request.getContextPath()%>/register" method="post" name="form" onsubmit="return validate()">
				<table style="with: 80%">
					<tr>
						<td>First Name</td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td>UserName</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td>ContactNo</td>
						<td><input type="text" name="contact" /></td>
					</tr>
				
				</table>
				<input type="submit" value="Submit" />
				<a href="index.jsp">Already have Account?</a>
			</form>
		</div>
	</div>
</body>
</html>