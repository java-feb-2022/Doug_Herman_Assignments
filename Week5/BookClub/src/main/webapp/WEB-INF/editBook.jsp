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
<title>Edit <c:out value="${book.title}"/></title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark text-white p-3">
			<h1>Edit <c:out value="${book.title}"/></h1>
			<div>
				<a href="/books"><button class="btn btn-outline-primary">Home</button></a>
				<a href="/logout"><button class="btn btn-outline-danger">Logout</button></a>
			</div>
		</nav>
		<div class="card m-5 bg-light">
			<form:form action="/books/${book.id}/edit" method="post" modelAttribute="book">
			<form:hidden path="id"/>
			<form:hidden path="user"/>
			<form:hidden path="borrower"/>
				<div class="form-group m-3">
					<form:label path="title">Title:</form:label>
					<form:errors path="title" class="text-danger"/>
					<form:input path="title" class="form-control"/>
				</div>
				<div class="form-group m-3">
					<form:label path="author">Author:</form:label>
					<form:errors path="author" class="text-danger"/>
					<form:input path="author" class="form-control"/>
				</div>
				<div class="form-group m-3">
					<form:label path="thoughts">My Thoughts:</form:label>
					<form:errors path="thoughts" class="text-danger"/>
					<form:textarea path="thoughts" rows="5" class="form-control"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
			</form:form>
			<form action="/books/${book.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" class="btn btn-outline-danger ms-3">
			</form>
		</div>
	</div>
</body>
</html>