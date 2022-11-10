<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>${product.name }Page</title>

<div class="col-6 bg-light m-5 p-5 border border-dark rounded shadow-lg">
	<div align="center">

		<h4>Here is the information we have for ${product.name }</h4>
		<br /> Name: ${product.name }<br /> Price: ${product.price }<br />
		Brand Name: ${product.brandName }<br />Image<br /> <img
			src="../resources/images/${product.image}" /> <br /> <br /> <a
			href="showAll">All Products</a>
	</div>
</div>