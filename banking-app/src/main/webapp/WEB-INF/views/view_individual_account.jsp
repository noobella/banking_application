<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.nkhurshid.models.BankAccount"%>
    <%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Individual Account</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="d-flex flex-column justify-content-center align-items-center w-100 mt-4">
		<div class="text-center">
			<% BankAccount account = (BankAccount) request.getAttribute("account"); %>
			<h1 class="display-3 my-5">Account <%= account.getAccountNo() %> </h1>
		</div>
		<div class="d-flex flex-column justify-content-center align-items-center" style="width: 15vw;">
			<a class="btn btn-secondary" href="/transactions/<%= account.getAccountNo() %>" style="width:inherit;">View Transactions</a><br>
			<a class="btn btn-secondary my-2" href="/viewAccounts/deposit/<%= account.getAccountNo() %>" style="width:inherit;">Deposit</a><br>
			<a class="btn btn-secondary" href="/viewAccounts/withdraw/<%= account.getAccountNo() %>" style="width:inherit;">Withdraw</a>
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