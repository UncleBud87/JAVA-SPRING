<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body class="bg_white2">
	<div class="grid bg_blue">
		<div class="container grid p2 col2">
			<div></div>
			<div class="flex col2 gap2">
				<c:if test="${user_id!=null}">
					<a class="col_white1" href="/logout">Logout</a>
				</c:if>
				<c:if test="${user_id==null}">
					<a class="col_white1" href="/login">Login</a>
				</c:if>
				<a class="col_white1" href="/register">Register</a>
			</div>
		</div>
	</div>

	<div class="container p2 grid gap2">
		<form:form class="card" action="/register" method="POST" modelAttribute="user" >
			<div class="card_head">
				<h1 class="col_white1">Register</h1>
			</div>
			
			<div class="card_body">
				<form:errors class="col_red" path="name" />
				<form:input placeholder="Name" path="name" />
			
				<form:errors class="col_red" path="email" />
				<form:input placeholder="Email" path="email" />
				
				<form:errors class="col_red" path="password" />
				<form:input type="password" placeholder="Password" path="password" />

				<form:errors class="col_red" path="confirm" />
				<form:input type="password" placeholder="Password Confirmation" path="confirm" />
				
				<input class="btn_submit" type="submit" value="Register" />
			</div>
		</form:form>
	</div>
</body>
</html>