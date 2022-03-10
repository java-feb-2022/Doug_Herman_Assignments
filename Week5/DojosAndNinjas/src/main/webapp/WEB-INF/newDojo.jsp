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
<title>New Dojo</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark d-flex justify-content-between text-white p-3">
			<h1>New Dojo</h1>
			<a href="/ninjas/new"><button class="btn btn-outline-primary">New Ninja</button></a>
		</nav>
		<div class="card mt-5 bg-light">
			<form:form action="/dojos/new" method="post" modelAttribute="newDojo">
				<div class="form-group m-3">
					<form:label path="name">Name:</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" class="form-control"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
			</form:form>
		</div>
		
		<div class="card mt-5 bg-light">
			<table class="table">
				<thead>
				<tr>
					<th>Name</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${dojos}">
					<tr>
						<td><c:out value="${dojo.name}"/></td>
						<td><a href="/dojos/${dojo.id}">See Students</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>