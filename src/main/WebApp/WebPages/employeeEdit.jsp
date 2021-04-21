<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Details</title>
</head>
<body style="background-color: cornflowerblue;">
	<h3 align="right" style="vertical-align: top;">Welcome ${username}</h3>

	<form action="update" method="post">

		<input type="hidden" value="${employee.id}" name="id" /> <input
			type="text" value="${employee.name}" name="name" /> <input
			type="text" value="${employee.location}" name="location" /> <input
			type="text" value="${employee.email}" name="email" /> <input
			type="text" value="${employee.dob}" name="dob" /> <input
			type="submit" value="SAVE">

	</form>

</body>
</html>