<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header d-flex justify-content-between align-items-center">
				<h3>Expense Details:</h3>
				<a href="/expenses">Go back</a>
			</div>
			<table class="table">
				<tbody>
					<tr>
						<th>Expense Details:</th>
						<td><c:out value="${expense.expense}"/></td>
					</tr>
					<tr>
						<th>Expense Description:</th>
						<td><c:out value="${expense.description}"/></td>
					</tr>
					<tr>
						<th>Vendor:</th>
						<td><c:out value="${expense.vendor}"/></td>
					</tr>
					<tr>
						<th>Amount Spent:</th>
						<td>$<c:out value="${expense.amount}"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>