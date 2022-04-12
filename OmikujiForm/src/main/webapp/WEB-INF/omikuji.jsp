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
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	
	<div class="container">
	<h1 class="card_head">Here's Your Omikuji!</h1>
	<div class="border_1 card_body bg_blue">
		<h3>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your room mate, <c:out value="${hobby}"/> for a living. The Next time you see a <c:out value="${thing}"/> , you will have good luck. <c:out value="${somethingNice}"/> </h3>
	</div>
		<a href="http://localhost:8080/omikuji">Go Back</a>
	</div>
	

	
</body>
</html>