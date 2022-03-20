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
<title>Category Page</title>
</head>
<body>
<div class="container">
	<nav class="navbar navbar-dark bg-dark d-flex justify-content-between text-white p-3">
		<h1><c:out value="${category.name}"/></h1>
		<a href="/new"><button class="btn btn-outline-primary">Home</button></a>
	</nav>
	
	<div class="card m-3 bg-light">
		<h3 class="card-header">Products:</h3>
		<ul class="list-group">
			<c:forEach var="prod" items="${category.products}">
				<li class="list-group-item"><c:out value="${prod.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	<div class="card m-3 bg-light">
		<form:form action="/categories/${category.id}" method="post" modelAttribute="newProd">
			<div class="form-group m-3">
				<form:label path="id">Add Product:</form:label>
				<form:select path="id" class="form-control">
					<form:options items="${unusedProds}" itemValue="id" itemLabel="name"/>
				</form:select>
			</div>
			<input type="submit" value="Add" class="btn btn-outline-primary m-3">
		</form:form>
	</div>
	
</div>
</body>
</html>