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
	<div class="grid bg_blue flex">
		<div class="container p1">
			<h1 class="col_white1">Hello, <c:out value="${user_name}"/></h1>
		</div>
		<div class="container p1">
			<c:if test="${user_id!=null}">
				<a class="col_white1" href="/logout">Logout</a>
			</c:if>
		</div>
	</div>

	<div class="card">

			
			
		<table>
			<tr>
				<th class="wide">Song:</th>
				<th>Genre:</th>
				<th># of Collaborations:</th>
			</tr>	
		<c:forEach items="${songs}" var="i" >				
			<tr>
				<td class="text_center"><h3><a href="/songs/${i.id}" class="col_blue">${i.title}</a></h3></td>
				<td class="text_center"><h3>${i.genre}</h3></td>
				<td class="text_center"><h3>${i.count}</h3></td>

			</tr>
		</c:forEach>
		</table>
		<a href="/songs/new" class="col_blue">Add Song</a>
	</div>

</body>
</html>