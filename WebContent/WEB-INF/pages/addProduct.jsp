<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Add Form</title>
</head>
<body>
	<div align="center">
		<form:form method="POST" action="addProduct" modelAttribute="product">
			<h2>Please enter your product's details.</h2>
			<table style="with: 50%">
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" /></td>

				</tr>
				<tr>
					<td><form:label path="price">Cost</form:label></td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td><form:label path="brandName">Brand Name</form:label></td>
					<td><form:input path="brandName" /></td>
				</tr>
				<tr>
					<td><form:label path="image">Image</form:label></td>
					<td><form:input path="image" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
			<br />
			<br />


			<form:errors path="*" />
		</form:form>
	</div>
</body>
</html>