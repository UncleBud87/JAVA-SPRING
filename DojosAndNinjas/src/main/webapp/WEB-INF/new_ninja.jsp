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


	<form:form class="card" action="/ninja" method="POST" modelAttribute="ninja" >
		<div class="card_head">
			<h1 class="col_white1 text_center">New Ninja</h1>
		</div>
		<div class="card_body">
			<label>Dojo:</label>
			<form:select path="dojo" class="h2tx border_1">
			<c:forEach items="${dojos}" var="i">
			<form:option value="${i.id}">${i.name}</form:option>
			</c:forEach>
			</form:select>
			<label>First Name:</label>
			<form:errors class="col_red" path="first_name" />
			<form:input path="first_name" />
			<label>Last Name:</label>
			<form:errors class="col_red" path="last_name" />
			<form:input path="last_name" />
			<label>Age:</label>
			<form:errors class="col_red" path="age" />
			<form:input type="number" path="age" />
			<input class="btn_submit" type="submit" value="Create" />
		</div>
	</form:form>
	

		<c:forEach items="${dojos}" var="i" >
				
			<tr>
				<td><h2 class="text_center card_head"><a class="col_white1" href="/dojo/${i.id}">${i.name}</a></h2></td>
			</tr>

		</c:forEach>


</body>
</html>