
<%@page import="BankHibernateEntity.UserPojoEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
UserPojoEntity user = (UserPojoEntity) session.getAttribute("userData"); 
/* session.setAttribute("userSession", user); */
System.out.println("Welcome"+user.getBalance());
%>
<h2>Welcome! <%=user.getUserName() %> <%=user.getId() %></h2>
<a href = "ShowBalance.jsp">Show Balance</a>
<a href="Deposit.jsp">Deposit Money</a>
<a href = "Withdraw.jsp">Withdraw Money</a>
<a href = "TransferMoney.jsp">Transfer Money</a>
<a href = "LogOutServlet">Log Out</a>

</body>
</html>