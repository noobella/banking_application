<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.nkhurshid.models.BankAccount" %>
     <%@ page import="com.nkhurshid.models.CurrentAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Created</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<div class="d-flex flex-column justify-content-center w-100">
		<div class="d-flex flex-column justify-content-center align-items-center w-80 mt-4">
			<% BankAccount acc = (BankAccount) request.getAttribute("account"); 
				if (acc != null) {
			%>
				<h1 class="display-3">Account Created</h1>
				<div>
					<small><%=acc.getAccountType()%><%= acc.getAccountNo() %></small> <br>
					<%= acc.getAccountType().getName() %>  <br>
					Opening Balance: <%= acc.getBalance() %>  <br>
					<% if(acc instanceof CurrentAccount) { %>
					<% CurrentAccount cur = (CurrentAccount) acc; %>
					Overdraft Limit: <%= String.format("%.2f", cur.getOverdraftLimit()) %>  <br>
					<% } %>
					<br>
				</div>
				<a class="btn btn-secondary" href="/viewAccounts/<%= acc.getAccountNo()%>">View Account</a>
			<% } else { %>
				<h1 class="display-3">Unable to create account</h1>
				There was an issue trying to create an account, please try again later.
			<% } %>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>