<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>Registration Page</title>

<div align="center">
	<div
		class="col-6 bg-light m-5 p-5 border border-dark rounded shadow-lg">
		<form:form method="POST" action="register" modelAttribute="user">
			<h2 class="bg-primary col-6 p-3 rounded shadow-sm text-white">Create
				Account</h2>
			<br />
			<div class="form-group">
				<label for="firstName"><strong>First Name</strong></label> <input
					type="text" class="form-control" name="firstName" id="firstName" />
			</div>
			<div class="form-group">
				<label for="lastName"><strong>Last Name</strong></label> <input
					type="text" class="form-control" name="lastName" id="lastName" />
			</div>
			<div class="form-group">
				<label for="credentials.username"><strong>Username</strong></label>
				<input type="text" name="credentials.username" class="form-control"
					id="credentials.username" />
			</div>
			<div class="form-group">
				<label for="credentials.password"><strong>Password</strong></label>
				<input type="password" name="credentials.password"
					class="form-control" id="credentials.password" />
			</div>
			<div class="form-group">
				<label for="email"><strong>Email</strong></label> <input
					type="email" class="form-control" id="email" name="email" />
			</div>

			<strong>Role</strong>
			<br />
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" class="custom-control-input" id="basic"
					name="role" value="Basic User" /> <label
					class="custom-control-label" for="basic">Basic User</label>
			</div>
			<div class="custom-control custom-radio custom-control-inline">
				<input type="radio" class="custom-control-input" id="admin"
					name="role" value="Administrator" /> <label
					class="custom-control-label" for="admin">Administrator</label>
			</div>
			<br />
			<br />
			<button type="submit" class="btn btn-primary">Submit</button>

			<br />
			<br />
			<form:errors path="*" />
		</form:form>
	</div>

	<br /> <br /> Already have an account? Click <a href="login">here</a>
	to log in.
</div>