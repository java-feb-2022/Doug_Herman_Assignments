<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Project Manager</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark text-white p-3">
			<h1>Project Manager</h1>
			<h4>A place for teams to manage projects.</h4>
		</nav>
		<div class="row">
			<div class="col">
				<div class="card m-5 bg-light">
					<h4 class="card-header">Register</h4>
					<form:form action="/register" method="post" modelAttribute="newUser">
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
							<form:label path="email">Email:</form:label>
							<form:errors path="email" class="text-danger"/>
							<form:input path="email" class="form-control"/>
						</div>
						<div class="form-group m-3">
							<form:label path="password">Password:</form:label>
							<form:errors path="password" class="text-danger"/>
							<form:password path="password" class="form-control"/>
						</div>
						<div class="form-group m-3">
							<form:label path="confirm">Confirm Password:</form:label>
							<form:errors path="confirm" class="text-danger"/>
							<form:password path="confirm" class="form-control"/>
						</div>
						<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
					</form:form>
				</div>
			</div>
			<div class="col">
				<div class="card m-5 bg-light">
					<h4 class="card-header">Login</h4>
					<form:form action="/login" method="post" modelAttribute="newLogin">
						<div class="form-group m-3">
							<form:label path="email">Email:</form:label>
							<form:errors path="email" class="text-danger"/>
							<form:input path="email" class="form-control"/>
						</div>
						<div class="form-group m-3">
							<form:label path="password">Password:</form:label>
							<form:errors path="password" class="text-danger"/>
							<form:password path="password" class="form-control"/>
						</div>
						<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>