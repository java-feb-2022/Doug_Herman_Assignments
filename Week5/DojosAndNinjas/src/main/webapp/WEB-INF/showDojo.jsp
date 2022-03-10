<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark d-flex justify-content-between text-white p-3">
			<h1><c:out value="${dojo.name} Location Ninjas"></c:out></h1>
			<div>
				<a href="/dojos/new"><button class="btn btn-outline-primary">New Dojo</button></a>
				<a href="/ninjas/new"><button class="btn btn-outline-primary ms-3">New Ninja</button></a>
			</div>
			
		</nav>
		<div class="card mt-5 bg-light">
				<table class="table">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ninja" items="${dojo.ninjas}">
						<tr>
							<td><c:out value="${ninja.firstName}"/></td>
							<td><c:out value="${ninja.lastName}"/></td>
							<td><c:out value="${ninja.age}"/></td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
			</div>
	</div>
</body>
</html>