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

		<form:form class="card" action="/songs/new" method="POST" modelAttribute="song" >
		<form:hidden value="${user_id}" path="user"/>
			<div class="card_head">
				<h1 class="col_white1">Start a new Song!</h1>
				<c:if test="${user_id!=null}"><a class="col_white1" href="/logout">Logout</a></c:if>
				<a href="/home" class="mleft col_white1">Go back</a>
			</div>
			<div class="card_body">
				<label>Title:</label>
				<form:errors class="col_red" path="title" />
				<form:input placeholder="Title" path="title" />
				<label>Genre:</label>
				<form:errors class="col_red" path="genre" />
				<form:input placeholder="Genre" path="genre" />
				<label>Lyrics:</label>
				<form:errors class="col_red" path="lyrics" />
				<form:input placeholder="Add your lyrics" path="lyrics" />
				<input class="btn_submit" type="submit" value="Add Song" />
			</div>
		</form:form>			

</body>
</html>