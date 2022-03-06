<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title><c:out value="${newLanguage.name}"/></title>
</head>
<body>
	<div class="container">
		<div class="card m-5">
		<h3 class="card-header">Edit Language</h3>
		<form:form action="/languages/edit" method="post" modelAttribute="newLanguage">
		<input type="hidden" name="_method" value="put">
		<form:hidden path="id"/>
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
	<a href="/languages/"><button type="button" class="btn btn-outline-primary ms-5">Dashboard</button></a>
	</div>
</body>
</html>