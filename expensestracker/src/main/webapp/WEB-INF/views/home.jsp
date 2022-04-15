<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Expenses Tracker</h1>
	<p>${message}</p>
	
	<a href="${contextRoot}/expense">Add Expense</a>
	
	<c:forEach var="expense" items="${expenses}">
		<div>
			<h3>${expense.expensename}</h3>
			<p>&#36;${expense.amount}</p>
			<a href="${contextRoot}/expense/${expense.id}">Edit</a>
		</div>
	
	</c:forEach>
	
</body>
</html>