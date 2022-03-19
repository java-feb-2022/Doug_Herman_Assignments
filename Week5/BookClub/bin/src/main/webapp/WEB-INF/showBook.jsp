<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title><c:out value="${book.title}"></c:out></title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark text-white p-3">
			<h1>Add a Book to Your Shelf</h1>
			<div>
				<a href="/books"><button class="btn btn-outline-primary">Home</button></a>
				<a href="/logout"><button class="btn btn-outline-danger">Logout</button></a>
			</div>
		</nav>
		<div class="card m-5 bg-light">
			<c:choose>
				<c:when test="${book.user.id == user.id}">
					<div class="card-header d-flex justify-content-between">
						<h4>You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h4>
						<a href="/books/${book.id}/edit"><button class="btn btn-outline-primary">Edit</button></a>
					</div>
					<h5 class="m-3">Here are your thoughts:</h5>
				</c:when>
				<c:otherwise>
					<div class="card-header">
						<h4><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h4>
					</div>
					<h5 class="m-3">Here are <c:out value="${book.user.userName}"/>'s thoughts:</h5>
				</c:otherwise>
			</c:choose>
			<p class="m-5"><c:out value="${book.thoughts}"/></p>
		</div>
	</div>
</body>
</html>