<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>My Login Page</h2>
		<form action='myloginprocessor' method='POST'>
	
<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name='name' value=''></td></tr>
				<tr>
				<td>Password:</td><td><input type="password" name='password'/></td></tr>
				<tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
		</table>
			</form>
		
</body>
</html>