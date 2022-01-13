
<%@page import="BankHibernateDBManager.Manager"%>
<%@page import="BankHibernateEntity.UserPojoEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
</head>
<body>
<% UserPojoEntity user = (UserPojoEntity) session.getAttribute("userData");
int userId = (int)user.getId();
Manager manager = new Manager();
int showBalance =manager.showBalance(user);
if(showBalance !=0){
%> 
	<h4>Balance <%=user.getFirstName()%>:  <%=showBalance%></h4>	
<%}else{%>
	<p>Error Occured</p>
<%} %>
</body>
</html>