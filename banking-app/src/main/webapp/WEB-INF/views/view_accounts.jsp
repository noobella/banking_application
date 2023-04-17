<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.nkhurshid.models.BankAccount"%>
<%@ page import="com.nkhurshid.models.CurrentAccount"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Accounts</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="d-flex flex-column justify-content-center align-items-center w-100 mt-4">
		<div class="text-center">
			<h1 class="display-3 my-5">Your Accounts</h1>
			<div style="width: 60vw;">
				<% List<BankAccount> accounts = (ArrayList<BankAccount>) request.getAttribute("accounts");
				if (accounts.size() != 0) {
					for (BankAccount acc : accounts) {
				%>
				<a style="text-decoration:none; color:black;"href="/viewAccounts/<%= acc.getAccountNo() %>">
					<div style="display: flex; flex-direction: row; margin: 15px; justify-content: space-between; align-items:center;">
						<div style="text-align:left;">
							<small><%=acc.getAccountType()%><%= acc.getAccountNo() %></small> <br>
							<%= acc.getAccountType().getName() %>  <br>
							<% if(acc instanceof CurrentAccount) { %>
								<% CurrentAccount cur = (CurrentAccount) acc; %>
								Overdraft Limit: <%= String.format("%.2f", cur.getOverdraftLimit()) %>  <br>
							<% } %>
							<br>
						</div>
						<div class="justify-content-right">
							£<%=String.format("%.2f", acc.getBalance())%>
						</div>
					</div>
				</a>
				<%
					}
				} else {
				%>
				<h1 class="display-6" style="text-align: center;">You don't have any accounts.</h1>
				<a href="/addAccount" style="text-align: center;">Click here to add an account.</a>
				
				<%
				}
				%>
			</div>
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