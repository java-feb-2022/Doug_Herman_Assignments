<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Project Details</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark text-white p-3">
			<h1>Edit Project</h1>
			<div>
				<a href="/dashboard"><button class="btn btn-outline-primary">Home</button></a>
				<a href="/logout"><button class="btn btn-outline-danger">Logout</button></a>
			</div>
		</nav>
		<div class="card m-5 bg-light">
			<div class="card-header d-flex justify-content-between">
				<h4>Title: <c:out value="${project.title}"/></h4>
				<div class="d-flex">
					<a href="/projects/${project.id}/tasks"><button class="btn btn-outline-primary">See Tasks</button></a>
					<form action="/projects/${project.id}/delete" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete" class="btn btn-outline-danger ms-3">
					</form>
				</div>
			</div>
			<table class="table">
				<tbody>
					<tr>
						<td>Description:</td>
						<td><c:out value="${project.description}"/></td>
					</tr>
					<tr>
						<td>Due Date:</td>
						<td><fmt:formatDate value="${project.dueDate}" pattern="MM/dd/yyyy"/></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>