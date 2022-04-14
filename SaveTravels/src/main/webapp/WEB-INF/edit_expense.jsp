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
		<form:form class="card" action="/expense/${expense.id}/update" method="POST" modelAttribute="expense" >
			<div class="card_head">
				<h1 class="col_white1 inline">Edit Expense</h1><a href="/expense" class="mleft">Go back</a>
			</div>
			
			<div class="card_body">
				<form:errors class="col_red" path="expense_type" />
				<form:input placeholder="Expense Type" path="expense_type" />
				<form:errors class="col_red" path="expense_vendor" />
				<form:input placeholder="Vendor" path="expense_vendor" />
				<form:errors class="col_red" path="expense_amount" />
				<form:input placeholder="Amount" path="expense_amount" />	
				<input class="btn_submit" type="submit" value="Add Expense" />
			</div>
		</form:form>
	</div>
</body>
</html>