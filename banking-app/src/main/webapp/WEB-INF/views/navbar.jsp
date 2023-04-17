<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light px-2">
	<div class="d-flex flex-row justify-content-end w-100"
		id="navbarSupportedContent">
		<a href="/" class="navbar-brand w-100">ONLINE BANK</a>
		<ul class="navbar-nav mr-auto d-flex flex-row w-100"
			style="justify-content: right;">

			<li class="nav-item dropdown"></li>
			<%
			if (request.getSession().getAttribute("customer") != null) {
			%>
			<li class="nav-item mx-2"><a class="nav-link" href="/addAccount">Add
					Account</a></li>
			<a id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"
				class="nav-link dropdown-toggle mx-2"> Account </a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<a class="dropdown-item" href="/viewAccounts">View Accounts</a> <a
					class="dropdown-item" href="/viewPersonalDetails">View Personal
					Details</a>
			</div>

			<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
			</li>
			<%
			} else {
			%>
			<li class="nav-item"><a class="nav-link" href="/login">Login</a>
			</li>
			<%
			}
			%>

		</ul>
	</div>
</nav>