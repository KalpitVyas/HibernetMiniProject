
<%@page import="BankHibernateDBManager.Manager"%>
<%@page import="BankHibernateEntity.UserPojoEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transfer</title>
</head>
<%
	UserPojoEntity user = (UserPojoEntity) session.getAttribute("userData");
	String reciever = request.getParameter("receiverId");
	String amount = request.getParameter("amount");
	if(reciever!=null && amount!=null){
		Manager manager = new Manager();
		int receiverId = Integer.parseInt(reciever);
		int transferAmount = Integer.parseInt(amount);
		if(manager.transferMoney(user, receiverId, transferAmount)){%>
			<p>Amount Transfered!</p>		
		<%}
		else{%>
			<p>Error While Transfering The Amount</p>p
		<%}
}%>
<body>
	<form>
		Enter the Id of the receiver : <input type = "text" id = "receiverId" name = "receiverId">
		Enter the Amount : <input type = "text" id = "amount" name = "amount">
		<input type = "Submit" value = "Transfer Money">
	</form>
</body>
</html>