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
			<div class="card_head">
				<h1 class="col_white1 inline">${book.title}</h1><a href="/book" class="mleft col_white1">Back to the shelves</a>
			</div>
			
			<div class="card_body">
				<h3><c:out value="${book.user.name}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h3>
				<h3>Here are <c:out value="${book.user.name}"/>'s thoughts:</h3>
				<br/>
				<form:input placeholder="Description" path="description" readonly="true"/>
				<br/>

				
				<a href="/book/${book.id}/edit" class="col_blue">Edit</a>
			</div>
		</form:form>
	</div>
</body>
</html>