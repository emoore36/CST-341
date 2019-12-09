<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>Login Page</title>

	<div align="center"
		class="col-6 bg-light m-5 p-5 border border-dark rounded shadow-lg">
		<h2 class="bg-primary col-6 p-3 rounded shadow-sm text-white">Log
			in</h2>

		<br />
		<form:form method="POST" action="authenticate" modelAttribute="cred">

			<div class="form-group">
				<label for="username"><strong>Username</strong></label>
				<form:input type="text" class="form-control" id="username"
					path="username" />
			</div>
			<div class="form-group">
				<label for="password"><strong>Password</strong></label>
				<form:input type="password" class="form-control" id="password"
					path="password" />
			</div>
			<br />

			<input type="submit" value="Submit" class="btn btn-primary" />
			<br />
			<form:errors path="*" />
		</form:form>

	</div>

	<br />New user? Click
	<a href="newuser">here</a>!
