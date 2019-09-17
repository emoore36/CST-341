<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div align="center" style = "line-height: 1.6;">
	<h2>Log in</h2>
		<form:form method="POST" action="authenticate" modelAttribute="user">

		Username: <form:input path="username" />
			<br />
		Password: <form:input path="password" />
			<br />
			<input type="submit" value="submit" />

		</form:form>
	</div>
</body>
</html>