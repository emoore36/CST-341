<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<title>All products</title>

<!-- <script type="text/javascript">
	function promptUser() {
		return confirm("Are you sure you wish to delete this item?");
	};
</script> -->

<script type="text/javascript">
	function getProducts() {

		$.ajax({
			type : "GET",
			url : "/Camelback_Confectionaries_Ltd/products/getAll",
			dataType : "json",
			success : function(data) {

				// display orders in the JQuery DataTable
				$('#products').DataTable({
					"data" : data,
					"columns" : [ {
						"data" : "name"
					}, {
						"data" : "price"
					}, {
						"data" : "brandName"
					}, {
						"data" : "image"
					}, ]
				});
			},
			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
			}
		})

	}

	$(document).ready(getProducts);
</script>


<div align="center">
	<table id="products" style="width: 50%" border="1"
		class="display table table-primary">
		<thead class="bg-primary text-white">
			<tr>
				<th align="center" scope="col">Name</th>
				<th align="center" scope="col">Price</th>
				<th align="center" scope="col">Brand</th>
				<th align="center" scope="col">Image</th>
			</tr>
		</thead>

		<tbody align="center">

		</tbody>

	</table>
	<a href="add">Add Product</a><br /> <a href="admin">View Admin
		Page</a>

</div>