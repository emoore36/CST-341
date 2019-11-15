<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Camelback Confectionaries Ltd.</title>

<!-- JQuery Code -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></link>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>


<!-- Bootstrap Code -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous"></link>

<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"></link>

<!-- <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="
	crossorigin="anonymous"></script> -->
<script src="//cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


<spring:url value="../resources/css/main.css" var="mainCss" />
<spring:url value="../resources/js/main.js" var="mainJs" />

<link href="${mainCss}" rel="stylesheet"></link>
<script src="${mainJs}"></script>

</head>

<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<div align="center">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>

</html>