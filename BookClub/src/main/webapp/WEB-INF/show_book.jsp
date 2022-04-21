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
		<h1 class="col_white1">Welcome, <c:out value="${user_name}"/></h1>
		<h3 class="col_white1">Books from everyone's shelves:</h3>
		</div>
			<div class="p1">
				<c:if test="${user_id!=null}">
					<a class="col_white1" href="/logout">Logout</a>
				</c:if>
				<br/>
				<br/>
				<a href="/book/new" class="col_white1">Add Book</a>
			</div>
		
	</div>

	<div class="card">

			
			
		<table>
			<tr>
				<th>ID:</th>
				<th class="wide">Title:</th>
				<th>Author Name:</th>
				<th>Posted By:</th>
			</tr>	
		<c:forEach items="${books}" var="i" >				
			<tr>
				<td class="text_center"><h3>${i.id}</h3></td>
				<td class="text_center"><h3><a href="/book/${i.id}/details" class="col_blue">${i.title}</a></h3></td>
				<td class="text_center"><h3>${i.author}</h3></td>
				<td class="text_center"><h3>${i.user.name}</h3></td>
			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>