<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name }</title>
</head>
<body>

	<div align="center">

		<h4>Here is the information we have for ${product.name }</h4>
		<br /> Name: ${product.name }<br /> Price: ${product.price }<br />
		Brand Name: ${product.brandName }<br />Image<br /> <img
			src="../resources/images/${product.image }" /> <br />
		<br /> <a href="showAll">All Products</a>


	</div>
</body>
</html>