<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User Detalis </title>
</head>
<body>
<table align="center" border="1">

		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>Email</th>
				<th>PhoneNo</th>
			    <th>Address</th>
			    <th>UserRole</th>
			</tr>
		</thead>


<tbody>
			<c:forEach items="${allUsers}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.email }</td>
				    <td>${user.phone }</td>
				   <td>${user.address }</td>
				    <td>${user.roles }</td>
				   
				</tr>
			</c:forEach>
		</tbody>


</table>
</body>
</html>