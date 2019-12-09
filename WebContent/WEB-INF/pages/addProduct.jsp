<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Product Add Form</title>

<div class="col-6 bg-light m-5 p-5 border border-dark rounded shadow-lg">
	<form:form method="POST" action="addProduct" modelAttribute="product">
		<h2 class="bg-primary col-6 p-3 rounded shadow-sm text-white">Please
			enter your product's details.</h2>
		<br />
		<div class="form-group">
			<label for="name"><strong>Name</strong></label> <input type="text"
				class="form-control" name="name" id="name" />
		</div>
		<div class="form-group">
			<label for="price"><strong>Cost</strong></label> <input type="text"
				class="form-control" name="price" id="price" />
		</div>
		<div class="form-group">
			<label for="brandName"><strong>Brand Name</strong></label> <input
				type="text" class="form-control" name="brandName" id="brandName" />
		</div>
		<div class="form-group">
			<label for="image"><strong>Image</strong></label> <input type='file'
				name='image' class="form-control">
		</div>
		<br />
		<button type="submit" class="btn btn-primary mb-5">Submit</button>

		<br />

		<form:errors path="*" />
	</form:form>
</div>
