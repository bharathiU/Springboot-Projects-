<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fundTransfer</title>
<style type="text/css">
.errors{

color: blue;
font-family: sans-serif;
}

</style>

</head>
<body>
<form:form action="transfer" method="post" modelAttribute="TransferRequest">
	Enter from Account : <form:input path="fromaccount"/><form:errors path="fromaccount" class="erros"/><br/>
	Enter to Account : <form:input path="toaccount"/><form:errors path="toaccount" class="errors"/><br/>
	Enter Amount to transfer : <form:input path="amount"/><form:errors path="amount" class="errors"/><br/>
	<input type="submit">
</form:form>
</body>
</html>