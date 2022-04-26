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
		<form:form class="card" action="/songs/${song.id}/update" method="POST" modelAttribute="book" >
			<div class="card_head">
				<h1 class="col_white1 inline">${song.title}</h1><a href="/home" class="mleft col_white1">Go Back</a>
			</div>
			
			<div class="card_body">
				<h1><c:out value="${song.title}"/></h1>
				<h2>(Started by <c:out value="${song.user.name}"/>)</h2>
				<h3>Genre: <c:out value="${song.genre}"/></h3>
				
				<h3>Lyrics:</h3>
				<p><c:out value="${song.lyrics}"/></p>
				<br/>

				
				<a href="/songs/${song.id}/edit" class="col_blue">Contribute</a>
			</div>
		</form:form>
	</div>
</body>
</html>