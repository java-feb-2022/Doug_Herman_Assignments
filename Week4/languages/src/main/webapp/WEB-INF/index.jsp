<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
<div class="container">
	<div class="card m-5">
		<h3 class="card-header">All Languages</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="language" items="${languages}">
				<tr>
					<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
					<td><c:out value="${language.creator}"/></td>
					<td><c:out value="${language.version}"/></td>
					<td class="d-flex align-items-center">
						<form action="languages/delete/${language.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete" class="btn btn-outline-danger me-3">
						</form>
						<a href="/languages/${language.id}/edit"><button type="button" class="btn btn-outline-primary">Edit</button></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="card m-5">
		<h3 class="card-header">Add a Language</h3>
		<form:form action="/languages" method="post" modelAttribute="newLanguage">
			<div class="form-group m-3">
				<form:label path="name">Name:</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input path="name" class="form-control"/>
			</div>
			<div class="form-group m-3">
				<form:label path="creator">Creator:</form:label>
				<form:errors path="creator" class="text-danger"/>
				<form:input path="creator" class="form-control"/>
			</div>
			<div class="form-group m-3">
				<form:label path="version">Version:</form:label>
				<form:errors path="version" class="text-danger"/>
				<form:input path="version" class="form-control"/>
			</div>
			<input type="submit" value="Submit" class="btn btn-outline-primary m-3">
		</form:form>
	</div>
</div>
</body>
</html>