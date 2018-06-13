<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Results</title>
</head>
<body>

	<h1>Character Search Results</h1>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Height</th>
			<th>Mass</th>
			<th>Hair Color</th>
		</tr>
		<tr>
			<td>${person.name}</td>
			<td>${person.height}</td>
			<td>${person.mass}</td>
			<td>${person.hair_color}</td>
		</tr>




	</table>

</body>
</html>