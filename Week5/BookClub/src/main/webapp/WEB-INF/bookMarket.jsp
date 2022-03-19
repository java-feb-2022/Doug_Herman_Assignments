<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Book Lender Dashboard</title>
</head>
<body>
 <div class="container">
 	<nav class="navbar navbar-dark bg-dark text-white p-3">
		<h1>Hello <c:out value="${user.userName}"/>, welcome to the Book Broker!</h1>
		<div>
			<a href="/books"><button class="btn btn-outline-primary">Home</button></a>
			<a href="/logout"><button class="btn btn-outline-danger">Logout</button></a>
		</div>
	</nav>
	<div class="card m-5 bg-light">
		<div class="card-header d-flex justify-content-between">
			<h4>Books available to borrow:</h4>
			<a href="/books/new"><button class="btn btn-outline-primary">Add Book</button></a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
				<c:if test="${book.borrower == null}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href = "/books/${book.id}"><c:out value = "${book.title}"/></a></td>
						<td><c:out value = "${book.author}"/></td>
						<td><c:out value="${book.user.userName}"/></td>
						<td class="d-flex">
						<c:choose>
							<c:when test="${book.user.id == user.id}">
								<a href="/books/${book.id}/edit"><button class="btn btn-outline-primary">Edit</button></a>
								<form action="/books/${book.id}/delete" method="post">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete" class="btn btn-outline-danger ms-3">
								</form>
							</c:when>
							<c:otherwise>
								<form action="/books/${book.id}/borrow" method="post">
									<input type="submit" value="Borrow" class="btn btn-outline-primary">
								</form>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="card m-5 bg-light">
	<h4 class="card-header">Books I'm Borrowing:</h4>
	<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
				<c:if test="${book.borrower.id == user.id}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href = "/books/${book.id}"><c:out value = "${book.title}"/></a></td>
						<td><c:out value = "${book.author}"/></td>
						<td><c:out value="${book.user.userName}"/></td>
						<td>
							<form action="/books/${book.id}/return" method="post">
								<input type="submit" value="Return" class="btn btn-outline-primary">
							</form>
						</td>
					</tr>
				</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>