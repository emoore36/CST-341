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

</head>
<body>
	<div align="center">
		<table id="products" style="width: 50%" border="1" class="display">
			<thead class="thead thead-warning" align="center">
				<tr>
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
				<tr align="center">
					<td scope="row"><form:form action="showOneProduct"
							method="POST">
							<input type="hidden" name="ID" value="${product.ID}" />
							<input type="submit" value="View" />
						</form:form></td>
					<td scope="row">${product.name }</td>
					<td scope="row">${product.price}</td>
					<td scope="row">${product.brandName}</td>
					<td scope="row"><img width=20%
						src="../resources/images/${product.image }" /></td>
					<td scope="row"><form:form action="displayUpdateForm"
							method="POST">

							<input type="hidden" name="ID" value="${product.ID}" />
							<input type="submit" value="Edit" />

						</form:form></td>
					<td>
						<form action="deleteProduct" method="POST">

							<input type="hidden" name="ID" value="${product.ID}" /> <input
								onclick="return promptUser();" type="submit" value="Delete" />

						</form>
					</td>

				</tr>
			</c:forEach>
			<tbody align="center">

			</tbody>

		</table>
		<a href="add">Add Product</a>
	</div>
</body>