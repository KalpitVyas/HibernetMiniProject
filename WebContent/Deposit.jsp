
<%@page import="BankHibernateDBManager.Manager"%>
<%@page import="BankHibernateEntity.UserPojoEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
</head>
<%
	String depositAmt = request.getParameter("depositMoney");
	UserPojoEntity user = (UserPojoEntity) session.getAttribute("userData");
	Manager manager = new Manager();
	if(depositAmt!=null){
		int amount = Integer.parseInt(depositAmt);
		if(manager.depositMoney(user, amount)){
		%>
			<p>Balance is updated!</p>	
		<%}
	else{ %>	
		<p>Please enter an amount</p>	
		<%} //end of inner Else 
	}//end of outer if %>
<body>
	<form method = "post">
		Enter the Amount you want to deposit : <input type = "text" id="depositMoney" name = "depositMoney">
		<input type = "Submit" value = "Deposit">
	</form>
</body>
</html>