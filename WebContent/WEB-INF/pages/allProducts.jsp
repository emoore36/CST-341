<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All products</title>
</head>
<body>
	<div align="center">
		<table class="table" align="center">
			<thead class="thead thead-warning">
				<tr>
					<th align="center" scope="col">Name</th>
					<th align="center" scope="col">Price</th>
					<th align="center" scope="col">Brand</th>
					<th align="center" scope="col">Image</th>
					<th align="center" scope="col">Admin</th>
				</tr>
			</thead>

			<c:forEach var="product" items="${products }">
				<tr align="center">
					<td scope="row">${product.name}</td>
					<td scope="row">${product.price}</td>
					<td scope="row">${product.brandName}</td>
					<td scope="row"><img width=20%
						src="../resources/images/${product.image }" /></td>
						
				</tr>
			</c:forEach>

		</table>
		<a href="add">Add Product</a>
	</div>
</body>
</html>