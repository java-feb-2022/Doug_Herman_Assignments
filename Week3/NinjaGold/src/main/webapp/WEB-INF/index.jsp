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
<title>Ninja Gold Game</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>Your Gold: <c:out value="${gold}"/></h3>
		</div>
		<div class="row">
			<div class="card col text-center p-3 m-3">
				<h3>Farm</h3>
				<h5>(earns 10-20 gold)</h5>
				<form action="/action" method="post">
				<input type="hidden" name="activity" value="farm">
				<input type="submit" class="btn btn-outline-primary" value="Find Gold!">
				</form>
			</div>
			<div class="card col text-center p-3 m-3">
				<h3>Cave</h3>
				<h5>(earns 5-10 gold)</h5>
				<form action="/action" method="post">
				<input type="hidden" name="activity" value="cave">
				<input type="submit" class="btn btn-outline-primary" value="Find Gold!">
				</form>
			</div>
			<div class="card col text-center p-3 m-3">
				<h3>House</h3>
				<h5>(earns 2-5 gold)</h5>
				<form action="/action" method="post">
				<input type="hidden" name="activity" value="house">
				<input type="submit" class="btn btn-outline-primary" value="Find Gold!">
				</form>
			</div>
			<div class="card col text-center p-3 m-3">
				<h3>Casino</h3>
				<h5>(earns/takes 0-50 gold)</h5>
				<form action="/action" method="post">
				<input type="hidden" name="activity" value="casino">
				<input type="submit" class="btn btn-outline-primary" value="Find Gold!">
				</form>
			</div>
			<div class="card col text-center p-3 m-3">
				<h3>Spa</h3>
				<h5>(takes 5-20 gold)</h5>
				<form action="/action" method="post">
				<input type="hidden" name="activity" value="spa">
				<input type="submit" class="btn btn-outline-primary" value="Spend Gold!">
				</form>
			</div>
		</div>
		<div class="row">
			<div class="card col text-center p-3 m-3">
				<h3>Restart Game</h3>
				<h5>(sets gold to 0)</h5>
				<form action="/action" method="post">
				<input type="hidden" name="activity" value="reset">
				<input type="submit" class="btn btn-outline-primary" value="Reset">
				</form>
			</div>
		</div>
		<div class="row">
			<h3>Activities:</h3>
			<div class="overflow-auto border activities">
				<c:out value="${activities}" escapeXml="false"/>
			</div>
		</div>
	</div>
</body>
</html>