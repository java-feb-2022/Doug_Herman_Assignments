<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
 <div class="container">
 	<nav class="navbar navbar-dark bg-dark text-white p-3">
		<h1>Welcome, <c:out value="${user.userName}!"/></h1>
		<a href="/logout"><button class="btn btn-outline-primary">Logout</button></a>
	</nav>
	<div class="card m-5 bg-light">
		<h3>This is your dashboard. Nothing to see here yet.</h3>
	</div>
</div>
</body>
</html>