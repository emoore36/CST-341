<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name }</title>
</head>
<body>
	
	<div align="center">
		<form:form method="POST" action="updateProduct" modelAttribute="product">
			<h2>Update Product.</h2>
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${product.name}" /></td>
					<td><input type="hidden" name="ID" value="${product.ID}" /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="${product.price}" /></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><input type="text" name="brandName" value="${product.brandName}"/></td>
				</tr>
				<tr>
					<td>Image</td>
					<td><input type="file" name="image" value="${product.image}"/></td>
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