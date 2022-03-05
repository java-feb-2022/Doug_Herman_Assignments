<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body>
	<div class="container">
		<h1>Save Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${allExpenses}">
				<tr>
					<td><c:out value="${expense.expense}"/></td>
					<td><c:out value="${expense.vendor}"/></td>
					<td>$<c:out value="${expense.amount}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="card mt-10">
			<h3 class="card-header">Add an expense:</h3>
			<form:form action="/expenses/new" method="post" modelAttribute="newExpense">
				<div class="form-group m-3">
					<form:label path="expense">Expense Name:</form:label>
					<form:errors path="expense" class="text-danger"/>
					<form:input path="expense" class="form-control"/>
				</div>
				<div class="form-group m-3">
					<form:label path="vendor">Vendor:</form:label>
					<form:errors path="vendor" class="text-danger"/>
					<form:input path="vendor" class="form-control"/>
				</div>
				<div class="form-group m-3">
					<form:label path="amount">Amount:</form:label>
					<form:errors path="amount" class="text-danger"/>
					<form:input path="amount" class="form-control"/>
				</div>
				<div class="form-group m-3">
					<form:label path="description">Description:</form:label>
					<form:errors path="description" class="text-danger"/>
					<form:textarea path="description" class="form-control" rows="5"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
			</form:form>
		</div>
	</div>
</body>
</html>