<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All products</title>
</head>
<body>
<!-- 	<div class="card-group col-12 col-sm-6 col-md-4 col-lg-3"> -->
<!--  		<div class="card card-inverse card-primary"> -->
<!-- 			<div class="card-block"> -->
<!-- 		  		<div class="card-body"> -->
<!-- 			  		<h5 class="card-title">Juicy Fruit</h5> -->
<!-- 			    	<p class="card-text" style="margin:1rem"> -->
<!-- 			    	 	Cost : $ 2.99<br> -->
<!-- 			    		Brand Name : Juicy -->
<!-- 			    	</p> -->
<!-- 				</div> -->
<!-- 	 		</div> -->
<!--  		</div> -->
<!--  		<div class="card card-inverse card-primary"> -->
<!-- 			<div class="card-block"> -->
<!-- 		  		<div class="card-body"> -->
<!-- 			  		<h5 class="card-title">Mentos</h5> -->
<!-- 			    	<p class="card-text" style="margin:1rem"> -->
<!-- 			    	 	Cost : $ 2.99<br> -->
<!-- 			    		Brand Name : Juicy -->
<!-- 			    	</p> -->
<!-- 				</div> -->
<!-- 	 		</div> -->
<!--  		</div> -->
<!--  		<div class="card card-inverse card-primary"> -->
<!-- 			<div class="card-block"> -->
<!-- 		  		<div class="card-body"> -->
<!-- 			  		<h5 class="card-title">Juicy Fruit</h5> -->
<!-- 			    	<p class="card-text" style="margin:1rem"> -->
<!-- 			    	 	Cost : $ 2.99<br> -->
<!-- 			    		Brand Name : Juicy -->
<!-- 			    	</p> -->
<!-- 				</div> -->
<!-- 	 		</div> -->
<!--  		</div> -->
<!--  		<div class="card card-inverse card-primary"> -->
<!-- 		<div class="card-block"> -->
<!-- 	  		<div class="card-body"> -->
<!-- 		  		<h5 class="card-title">Juicy Fruit</h5> -->
<!-- 		    	<p class="card-text" style="margin:1rem"> -->
<!-- 		    	 	Cost : $ 2.99<br> -->
<!-- 		    		Brand Name : Juicy -->
<!-- 		    	</p> -->
<!-- 			</div> -->
<!--  		</div> -->
<!--  		</div> -->

<h3>These are all the products.</h3>
 		<div class="card card-inverse card-primary">
		<div class="card-block">
	  		<div class="card-body">
		  		<table>
		<tr>
			<th><label>Candy Name</label></th>
			<th><label>Cost</label></th>
			<th><label>Brand Name</label>
			
		</tr>
		<tr>
			<td><label>${product.name}</label></td>
			<td><label>$${product.price}</label></td>
			<td><label>${product.brandName}</label></td>
			
		</tr>
		
		<tr>
			<td colspan="2">
			<a href="add">Add another Product</a>
			</td>
		</tr>
		</table>
		
			</div>
 		</div>
 		
 		</div>
</body>
</html>