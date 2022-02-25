<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container p-3">
		<h1>Here's your Omikuji!</h1>
		<div class="card bg-info p-5">
			<h3>In <c:out value="${num}"/> years, you will live in <c:out value="${city}"/> with 
			<c:out value="${person}"/> as your roommate, <c:out value="${profession}"/> for a living.</h3>
			<h3>The next time you see a <c:out value="${animal}"/>, you will have good luck.</h3>
			<h3>Also, <c:out value="${message}"/></h3>
		</div>
		<a href="/omikuji">Go Back</a>
	</div>
</body>
</html>