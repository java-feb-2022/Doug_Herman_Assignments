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
<title>New Ninja</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark d-flex justify-content-between text-white p-3">
			<h1>New Ninja</h1>
			<a href="/dojos/new"><button class="btn btn-outline-primary">New Dojo</button></a>
		</nav>
		<div class="card mt-5 bg-light">
			<form:form action="/ninjas/new" method="post" modelAttribute="newNinja">
				<div class="form-group m-3">
					<form:label path="dojo">Select Dojo:</form:label>
					<form:select path="dojo" class="form-control">
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo.id}" label="${dojo.name}"/>
					</c:forEach>
					</form:select>
				</div>
				<div class="form-group m-3">
					<form:label path="firstName">First Name:</form:label>
					<form:errors path="firstName" class="text-danger"/>
					<form:input path="firstName" class="form-control"/>
				</div>
				<div class="form-group m-3">
					<form:label path="lastName">Last Name:</form:label>
					<form:errors path="lastName" class="text-danger"/>
					<form:input path="lastName" class="form-control"/>
				</div>
				<div class="form-group m-3">
					<form:label path="age">Age:</form:label>
					<form:errors path="age" class="text-danger"/>
					<form:input path="age" class="form-control"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
			</form:form>
		</div>
	</div>
</body>
</html>