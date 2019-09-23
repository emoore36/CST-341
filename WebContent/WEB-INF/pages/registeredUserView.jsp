<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>The User with Following details has been registered.</h2>
		First name: ${user.firstName }<br/>
		Last name: ${user.lastName }<br/>
		Username: ${user.userName }<br/>
		Email: ${user.email }<br/><br/>
		
		Click <a href="../login/displayform">here</a> to log in. 
		
	</div>
</body>
</html>