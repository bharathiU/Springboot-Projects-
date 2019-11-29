<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.error{
color:red;
font-family:serif;
font-style:italic;
}
</style>
</head>
<body>
<form:form action="addaccount" method="post" modelAttribute="account">

<%-- Enter accountNumber:<form:input path="accountNumber"/><form:errors path="accountNumber" class="error"/><br/> --%>
Enter accountBalance:<form:input path="accountBalance"/><form:errors path="accountBalance" class="error"/><br/>
Enter blocked:<form:input path="blocked"/><form:errors path="blocked" class="error"/><br/>
<%-- Enter type:<form:input path="type"/><form:errors path="type" class="error"/><br/>
 --%>Enter name:<form:input path="name"/><form:errors path="name" class="error"/><br/>
Enter email:<form:input path="email"/><form:errors path="email" class="error"/><br/>
Enter address:<form:input path="address"/><form:errors path="address" class="error"/><br/>
Enter city:<form:input path="city"/><form:errors path="city" class="error"/><br/>
Enter phone:<form:input path="phone"/><form:errors path="phone" class="error"/><br/>
Enter country:<form:input path="country"/><form:errors path="country" class="error"/><br/>


<input type="submit"/>
</form:form>
</body>
</html>