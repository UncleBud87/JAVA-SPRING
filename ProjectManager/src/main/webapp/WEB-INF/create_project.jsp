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

		<form:form class="card" action="/book/new" method="POST" modelAttribute="book" >
		<form:hidden value="${user_id}" path="user"/>
			<div class="card_head">
				<h1 class="col_white1">Create a Project</h1>
				<c:if test="${user_id!=null}"><a class="col_white1" href="/logout">Logout</a></c:if>
				<a href="/projects" class="mleft col_white1">Go back</a>
			</div>
			<div class="card_body">
				<label>Title:</label>
				<form:errors class="col_red" path="project_name" />
				<form:input placeholder="Project Name" path="project_name" />
				<label>Author:</label>
				<form:errors class="col_red" path="project_description" />
				<form:input placeholder="Project Description" path="project_description" />
				<label>Description:</label>
				<form:errors class="col_red" path="due_date" />
				<form:input type="date" path="due_date" />
				<input class="btn_submit" type="submit" value="Add Book" />
			</div>
		</form:form>			

</body>
</html>