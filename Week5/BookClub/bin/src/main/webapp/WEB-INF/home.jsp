<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Book Club</title>
</head>
<body>
 <div class="container">
 	<nav class="navbar navbar-dark bg-dark text-white p-3">
		<h1>Welcome, <c:out value="${user.userName}"/></h1>
		<a href="/logout"><button class="btn btn-outline-danger">Logout</button></a>
	</nav>
	<div class="card m-5 bg-light">
		<div class="card-header d-flex justify-content-between">
			<h4>Books from everyone's shelves:</h4>
			<a href="/books/new"><button class="btn btn-outline-primary">Add Book</button></a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href = "/books/${book.id}"><c:out value = "${book.title}"/></a></td>
						<td><c:out value = "${book.author}"/></td>
						<td><c:out value="${book.user.userName}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>