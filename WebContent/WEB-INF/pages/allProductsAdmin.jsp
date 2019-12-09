<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<title>All products</title>

<script type="text/javascript">
	function promptUser() {
		return confirm("Are you sure you wish to delete this item?");
	};
</script>

<div align="center">
	<table id="products" style="width: 50%"
		class="table table-striped table-responsive-sm p-1 m-1 border border-dark rounded-lg col-6 bg-light m-5 p-5 border border-dark rounded-lg shadow-lg">
		<thead align="center">
			<tr class="bg-primary text-light">
				<th align="center" scope="col">View</th>
				<th align="center" scope="col">Name</th>
				<th align="center" scope="col">Price</th>
				<th align="center" scope="col">Brand</th>
				<th align="center" scope="col">Image</th>
				<th align="center" scope="col">Edit</th>
				<th align="center" scope="col">Delete</th>
			</tr>
		</thead>

		<c:forEach var="product" items="${products }">
			<tr align="center" class="border border-dark p-1 m-1">
				<td scope="row" class="border border-dark p-1 m-1"><form:form
						action="showOneProduct" method="POST">
						<input type="hidden" name="ID" value="${product.ID}" />
						<button type="submit" class="btn btn-primary">View</button>
					</form:form></td>
				<td scope="row" class="border border-dark p-1 m-1">${product.name }</td>
				<td scope="row" class="border border-dark p-1 m-1">$${product.price}</td>
				<td scope="row" class="border border-dark p-1 m-1">${product.brandName}</td>
				<td scope="row" class="border border-dark p-1 m-1"><img
					width=20% src="../resources/images/${product.image }"
					class="rounded"></td>
				<td scope="row" class="border border-dark p-1 m-1"><form:form
						action="displayUpdateForm" method="POST">

						<input type="hidden" name="ID" value="${product.ID}" />
						<button type="submit" class="btn btn-primary">Edit</button>

					</form:form></td>
				<td scope="row" class="border border-dark p-1 m-1">
					<form action="deleteProduct" method="POST">

						<input type="hidden" name="ID" value="${product.ID}" />
						<button onclick="return promptUser();" type="submit"
							value="Delete" class="btn btn-primary">Delete</button>

					</form>
				</td>

			</tr>
		</c:forEach>
		<tbody align="center">

		</tbody>

	</table>
	<a href="add">Add Product</a>
</div>