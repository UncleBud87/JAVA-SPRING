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
<body>
	<div class="container">	
		<form:form class="card" action="/book/${book.id}/update" method="POST" modelAttribute="book" >
		<form:hidden value="${user_id}" path="user"/>
			<div class="card_head">
				<h1 class="col_white1 inline">Edit Book</h1><a href="/book" class="mleft">Go back</a>
			</div>
			
				<div class="card_body">
				<form:errors class="col_red" path="title" />
				<form:input placeholder="${title}" path="title" />
				<form:errors class="col_red" path="author" />
				<form:input placeholder="${author}" path="author" />
				<form:errors class="col_red" path="description" />
				<form:input placeholder="${description}" path="description" />
				
				<input class="btn_submit" type="submit" value="Update Book" />
				<a href="/book/${id}/delete">DELETE</a>
			</div>

			
		</form:form>
	</div>
</body>
</html>