<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
h4 {
	color: red;
}
</style>
<title>New User | Camelback Confectionaries Ltd.</title>
</head>
<body>
	<div align="center">
		<form:form method="POST" action="register" modelAttribute="user">
			<h2>Please Enter your Details.</h2>
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
			<br />
			<br />
			<form:errors path="*" />
		</form:form>

		<br /> <br /> Already have an account? Click <a href="login">here</a>
		to log in.
	</div>
</body>
</html>