<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Current visit count</title>
</head>
<body>
	<div class="container mt-15">
		<h2>You have visited the home page <c:out value="${count}"/> times.</h2>
		<a href="/">Test another visit?</a>
		<a href="/plustwo">Add two visits?</a>
		<a href="/reset">Reset counter?</a>
	</div>
</body>
</html>