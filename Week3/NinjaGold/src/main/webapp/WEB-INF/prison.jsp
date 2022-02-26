<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Prison</title>
</head>
<body>
	<div class="container">
	<div class="row">
			<div class="card col text-center p-3 m-3 text-white bg-danger">
				<h2>With <c:out value="${gold}"/> you have fallen too far in to debt.</h2>
				<h3>Restart Game</h3>
				<h5>(sets gold to 0)</h5>
				<form action="/action" method="post">
				<input type="hidden" name="activity" value="reset">
				<input type="submit" class="btn btn-outline-primary" value="Reset">
				</form>
			</div>
		</div>
	</div>
</body>
</html>