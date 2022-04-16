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

	<div class="card">
	
			<h1>${dojo.name}</h1>

		<table>
			<tr>
				<th class="wide">First Name:</th>
				<th class="wide">Last Name:</th>
				<th class="wide">Age:</th>
			</tr>	
		<c:forEach items="${dojo.ninjas}" var="i" >				
			<tr>
				<td><h3>${i.first_name}</h3></td>
				<td><h3>${i.last_name}</h3></td>
				<td><h3>${i.age}</h3></td>
			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>