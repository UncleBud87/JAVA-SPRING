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
	<h1 class="card_head">Send an Omikuji!</h1>
	<div class="border_1 card_body">
	<form action="/omikuji" method="post">
		<label for="number">Pick any number from 5 to 25</label><br>
		<input type="number" name="number" min="5" max="25"><br>
		<label for="city">Enter the name of any city:</label><br>
		<input class="text" type="text" name="city"/><br>
		<label for="person">Enter the name of any real person:</label><br>
		<input class="text"	type="text" name="person"/><br>
		<label for="hobby">Enter professional endeavor or hobby:</label><br>
		<input class="text" type="text" name="hobby"/><br>
		<label for="thing">Enter any type of living thing:</label><br>
		<input class="text" type="text" name="thing"/><br>
		<label for="city">Say something nice to someone:</label><br>
		<textarea class="text" name="somethingNice">
		
		</textarea><br>
		<label class="tr" for="city">Send and show a friend:</label><br>
		<input type="submit" value="Send" class="bg_blue btn"/>
	
	</form>
	</div>
	</div>
	
	
</body>
</html>