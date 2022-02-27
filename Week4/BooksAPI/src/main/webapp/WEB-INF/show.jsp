<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reading Books</title>
</head>
<body>
	<h1><c:out value="${title}"/></h1>
	<h3>Description: <c:out value="${desc}"/></h3>
	<h3>Language: <c:out value="${lang}"/></h3>
	<h3>Number of Pages: <c:out value="${pages}"/></h3>
</body>
</html>