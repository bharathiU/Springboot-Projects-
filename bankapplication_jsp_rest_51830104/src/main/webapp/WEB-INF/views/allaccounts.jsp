<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	width: 50%;
	height: 50px;
}

body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}

div.styling {
	text-align: center;
	padding-top: 10px;
}
</style>
</head>
<body>
	<div class="styling">welcome ${user.name }</div>
	<br />
	<div class="styling">
		<a href="logout">logout</a>
	</div>
	<table align="center">
		<thead>
			<tr>
			
				<th>accountNumber</th>
				<th>balance</th>
				<th>blocked</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.accountNumber }</td>
					<td>${account.balance }</td>
				    <td>${account.blocked }</td>
					
					<td><a href="update?id=${account.accountNumber}">update</a></td>
					<td><a href="delete?id=${account.accountNumber}">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="styling">
		<a href="addaccount">addaccount</a>
	</div>
</body>
</html>













