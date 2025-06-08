<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	body {
			background-image: url('https://wallpapers.com/images/high/mickey-flying-carpet-pixel-disney-laptop-pwcdl245xycen03o.webp');
        }
</style>
</head>
<body>
<div align="center">
<form action="<%=request.getContextPath()%>/SignupServlet" method="post">
<table>
	<tr>
		<th> User Sign-up Form </th>
	</tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="userName" <%-- pattern="[a-zA-Z]{1,10}" --%> required/></td>
	</tr>
	<tr>
		<td>User Email</td>
		<td><input type="email" name="userEmail" required/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" <%-- pattern="[a-zA-Z0-9$%&*]{7,10}" --%> required/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="password" name="password1" <%-- pattern="[a-zA-Z0-9$%&*]{7,10}" --%> required/></td>
	</tr>
	<tr>
		<td>Preferred Name</td>
		<td><input type="text" name="preferredName" pattern=".{1,20}" required/></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name="name" pattern=".{1,20}" required/></td>
	</tr>
</table>
<input type="reset" value="Clear" />
<input type="submit" value="Submit" />
</form>
</div>
</body>
</html>