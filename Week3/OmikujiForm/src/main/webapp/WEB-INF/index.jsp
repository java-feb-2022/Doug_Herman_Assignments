<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji!</h1>
		<div class="card p-3">
			<form action="/create" method="post">
				<div class="form-group">
					<label for="num">Pick any number from 5 to 25</label>
					<select class="form-control" name="num">
						<c:forEach var="i" begin="5" end="25">
							<option><c:out value="${i}"/></option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="city">Enter the name of any city</label>
					<input type="text" class="form-control" name="city">
				</div>
				<div class="form-group">
					<label for="person">Enter the name of any real person</label>
					<input type="text" class="form-control" name="person">
				</div>
				<div class="form-group">
					<label for="profession">Enter professional endeavor or hobby</label>
					<input type="text" class="form-control" name="profession">
				</div>
				<div class="form-group">
					<label for="animal">Enter any type of living thing</label>
					<input type="text" class="form-control" name="animal">
				</div>
				<div class="form-group">
					<label for="message">Say something nice to someone:</label>
					<textarea class="form-control" name="message" rows="3"></textarea>
				</div>
				<p>Send and show a friend</p>
				<input type="submit" class="btn btn-outline-primary" value="Send">
			</form>
		</div>
	</div>
</body>
</html>