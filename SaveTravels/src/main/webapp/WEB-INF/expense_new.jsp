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
	<div class="container p2">
		<div class="card_head">
				<h1 class="col_white1">Save Travels</h1>
			</div>
		<div class="card">
			
					<div>
					<table>
						<tr>
							<th class="wide">Expense:</th>
							<th class="wide">Vendor:</th>
							<th class="wide">Cost:</th>
						</tr>	
						<c:forEach items="${expenses}" var="i" >				
						<tr>
							<td>${i.expense_type}</td>
							<td>${i.expense_vendor}</td>
							<td>${i.expense_amount}</td>
						</tr>
						</c:forEach>
					</table>
					</div>
				
		</div>
		
		<form:form class="card" action="/expense" method="POST" modelAttribute="expense" >
			<div class="card_head">
				<h1 class="col_white1">Add Expense</h1>
			</div>
			<div class="card_body">
				<label>Expense:</label>
				<form:errors class="col_red" path="expense_type" />
				<form:input placeholder="Expense Type" path="expense_type" />
				<label>Vendor:</label>
				<form:errors class="col_red" path="expense_vendor" />
				<form:input placeholder="Vendor" path="expense_vendor" />
				<form:errors class="col_red" path="expense_amount" />
				<label>Cost:</label>
				<form:input placeholder="Cost" path="expense_amount" />	
				<input class="btn_submit" type="submit" value="Add Expense" />
			</div>
		</form:form>	
		

	
		
		
		
	</div>


</body>
</html>