<%@page import="BankHibernateDBManager.Manager"%>
<%@page import="BankHibernateEntity.UserPojoEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
</head>
<%
UserPojoEntity user = (UserPojoEntity) session.getAttribute("userData");
String withdraw = request.getParameter("withdrawMoney");
if(withdraw!=null){
	int amount = Integer.parseInt(withdraw);
	Manager manager = new Manager();
	if(manager.withdrawMoney(user, amount)){
	%>
		<p>Money Withdrawed!</p>	
	<%} //end of inner if
	else{ %>
		<p>Please enter a valid amount</p>
	<%} //end of else
} //end of outer if%>
<body>
	<form method = "post">
	Enter the Amount you want to Withdraw : <input type = "withdrawMoney" name = "withdrawMoney">
	<input type = "Submit" value ="Withdraw">
	</form>
</body>
</html>