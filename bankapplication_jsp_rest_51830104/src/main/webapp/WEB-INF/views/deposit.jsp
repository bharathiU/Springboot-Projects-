<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DepositForm</title>
<style type="text/css">
.errors{

color: blue;
font-family: sans-serif;


</style>
</head>
<body>


<form:form action="depositpost" method="post" modelAttribute="withdrawdepositbean">
	Enter accountNumber: <form:input path="accountNumber"/><form:errors path="accountNumber" class="errors"/> <br/>
	Enter amount to deposit: <form:input path="amount"/><form:errors path="amount" class="errors"/> <br/>
	<input type="submit"/>
</form:form>
</body>
</html>