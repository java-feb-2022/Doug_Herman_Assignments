<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title><c:out value="${language.name}"/></title>
</head>
<body>
<div class="container">
	<div class="card m-5">
	<h3 class="card-header"><c:out value="${language.name}"/></h3>
		<div class="row m-3">
			<h5>Creator:</h5>
			<h6><c:out value="${language.creator}"/></h6>
		</div>
		<div class="row m-3">
			<h5>Version:</h5>
			<h6><c:out value="${language.version}"/></h6>
		</div>
		<div class="row">
			<div><form action="languages/delete/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete" class="btn btn-outline-danger m-3">
			</form></div>
		<div><a href="/languages/edit/${language.id}"><button type="button" class="btn btn-outline-primary m-3">Edit</button></a></div>
		</div>
	</div>
	<a href="/languages/"><button type="button" class="btn btn-outline-primary ms-5">Dashboard</button></a>
</div>
</body>
</html>