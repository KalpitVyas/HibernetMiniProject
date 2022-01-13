<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<form action = "CreateAccountServlet" method = "get">
	Enter the First Name : <input type = "text" id = "firstname" name = "firstname"><br>
	Enter the Last Name : <input type = "text" id = "lastname" name = "lastname"></br>
	Enter the Age : <input type = "text" id = "age" name = "age"><br>
	Enter the Start Amount : <input type ="text" id = "startAmt" name = "startAmt"><br>
	Enter the User name  : <input type = "text" id = "userName" name = "userName"><br>
	Enter the Password : <input type = "password" id="password" name = "password"><br>
	<input type = "submit" value = "Submit">
</form>
</body>
</html>