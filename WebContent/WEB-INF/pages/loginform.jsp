<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<div align="center" style="line-height: 1.6;">
		<h2>Log in</h2>
		<form:form method="POST" action="authenticate" modelAttribute="cred">

		Username: <form:input path="username" />
			<br />
		Password: <form:password path="password" />
			<br />
			<input type="submit" value="submit" />
			<br />
			<br />
			<form:errors path="*" />
		</form:form>
		<br /> <br />New user? Click <a href="newuser">here</a>!
	</div>


</body>