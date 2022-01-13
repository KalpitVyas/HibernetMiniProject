<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action = "LoginServlet" method = "post">
	<label>Enter the User name  : </label><input type = "text" id = "userName" name = "userName">
	<label>Enter the Password</label><input type = "password" id="password" name = "password">
	<input type = "submit" value = "Submit">
</form>
</body>
</html>