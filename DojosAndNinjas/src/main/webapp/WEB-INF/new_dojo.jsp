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
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>

	<form:form class="card" action="/dojo" method="POST" modelAttribute="dojo" >
	<div class="card_head">
				<h1 class="col_white1">New Dojo</h1>
			</div>
	<div class="card_body">
		<label>Name:</label>
		<form:errors class="col_red" path="name" />
		<form:input path="name" />
		<input class="btn_submit" type="submit" value="Create" />
	</div>
	</form:form>
</body>
</html>