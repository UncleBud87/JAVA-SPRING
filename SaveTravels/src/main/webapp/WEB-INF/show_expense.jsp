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
	<div class="container p2 grid gap2">
		<div class="card">
			<div class="card_head">
				<h1 class="col_white1 inline">Expense Details</h1><a href="/expense" class="mleft">Go back</a>
			</div>
			
			<div class="card_body">
				<h3>Expense: ${expense.expense_type}</h3>
				<h3>Vendor: ${expense.expense_vendor}</h3>			
				<h3>Amount: ${expense.expense_amount}</h3>
			</div>
		</div>
	</div>
</body>
</html>