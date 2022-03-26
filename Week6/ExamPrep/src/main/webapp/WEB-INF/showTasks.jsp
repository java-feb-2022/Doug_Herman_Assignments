<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Tasks Page</title>
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
			<div class="card-header">
				<h4>Project: <c:out value="${project.title}"/></h4>
				<h6>Project Lead: <c:out value="${project.projectLead.firstName}"/></h6>
			</div>
			<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="newTask" class="form m-3">
				<form:hidden path="project" value="${project.id}"/>
				<form:hidden path="user" value="${user.id}"/>
				<div class="form-control-group m-3">
					<form:label path="task">Add a task ticket for this team:</form:label>
					<form:errors path="task" class="text-danger"/>
					<form:textarea path="task" rows="4" class="form-control"/>
				</div>
				<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
			</form:form>
			
			<ul class="list-group">
				<c:forEach var="task" items="${tasks}">
					<li class="list-group-item list-group-item-dark">Added by <c:out value="${task.user.firstName}"/> at <fmt:formatDate value="${task.createdAt}" pattern="hh:mm aa  MM/dd/yyyy"/></li>
					<li class="list-group-item"> <c:out value="${task.task}"/> </li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>