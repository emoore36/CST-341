<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>${product.name }</title>

	<div
		class="col-6 bg-light m-5 p-5 border border-dark rounded shadow-lg">
		<div align="center">
			<form:form method="POST" action="updateProduct"
				modelAttribute="product">
				<h2>Update Product.</h2>
				<table style="width: 50%">
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
						<td><input type="text" name="brandName"
							value="${product.brandName}" /></td>
					</tr>
					<tr>
						<td>Image</td>
						<td><input type="file" name="image" value="${product.image}" /></td>
					</tr>

				</table>
				<input type="submit" value="Submit" />
				<br />
				<br />
				<form:errors path="*" />
			</form:form>
		</div>
	</div>