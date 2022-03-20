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
<title>New Product or Category</title>
</head>
<body>
	<div class="container d-flex">
		<div class="col">
			<div class="card m-3 bg-light">
				<h3 class="card-header">New Product</h3>
				<form:form action="/products/new" method="post" modelAttribute="newProduct">
					<div class="form-group m-3">
						<form:label path="name">Name:</form:label>
						<form:input path="name" class="form-control"/>
					</div>
					<div class="form-group m-3">
						<form:label path="description">Description:</form:label>
						<form:textarea path="description" rows="3" class="form-control"/>
					</div>
					<div class="form-group m-3">
						<form:label path="price">Price:</form:label>
						<form:input path="price" class="form-control"/>
					</div>
					<input type="submit" value="Create" class="btn btn-outline-primary m-3">
				</form:form>
			</div>
			<div class="card m-3 bg-light">
				<h3 class="card-header">Products</h3>
				<table class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<td><a href="/products/${product.id}"><c:out value="${product.name}"/></a></td>
							<td>$<c:out value="${product.price}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col">
			<div class="card m-3 bg-light">
				<h3 class="card-header">New Category</h3>
				<form:form action="/categories/new" method="post" modelAttribute="newCategory">
					<div class="form-group m-3">
						<form:label path="name">Name:</form:label>
						<form:input path="name" class="form-control"/>
					</div>
					<input type="submit" value="Create" class="btn btn-outline-primary m-3">
				</form:form>
			</div>
			<div class="card m-3 bg-light">
				<h3 class="card-header">Categories</h3>
				<table class="table">
					<thead>
						<tr>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="category" items="${categories}">
						<tr>
							<td><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>