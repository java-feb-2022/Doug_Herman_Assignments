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
<title>Project Manager Dashboard</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark text-white p-3">
			<h1>Welcome, <c:out value="${user.firstName}"/>!</h1>
			<div>
				<a href="/projects/new"><button class="btn btn-outline-primary">New Project</button></a>
				<a href="/logout"><button class="btn btn-outline-danger">Logout</button></a>
			</div>
		</nav>
		
		<div class="card m-5 bg-light">
		<h4 class="card-header">All Projects:</h4>
		<table class="table">
			<thead><tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr></thead>
			<tbody>
				<c:forEach var="project" items="${projectsWithoutUser}">
					<tr>
						<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
						<td><c:out value="${project.projectLead.firstName}"/></td>
						<td><fmt:formatDate value="${project.dueDate}" pattern="MM/dd/yyyy"/></td>
						<td><a href="/projects/join/${project.id}">Join Team</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
		<div class="card m-5 bg-light">
		<h4 class="card-header">Your Projects:</h4>
		<table class="table">
			<thead><tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr></thead>
			<tbody>
				<c:forEach var="project" items="${projectsWithUser}">
					<tr>
						<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
						<td><c:out value="${project.projectLead.firstName}"/></td>
						<td><fmt:formatDate value="${project.dueDate}" pattern="MM/dd/yyyy"/></td>
						<c:choose>
							<c:when test="${project.projectLead.id == user.id}">
								<td><a href="/projects/edit/${project.id}">Edit</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="/projects/leave/${project.id}">Leave Team</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</body>
</html>