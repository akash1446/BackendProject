<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body bgcolor="violet">
	<form action="signup" method="post">
		UserName: <input type="text" name="username" id="username"><br>
		Password: <input type="password" name="password" id="password"><br>
		Email : <input type="email" name="email" id="email"><br>
		Phone : <input type="text" name="phone" id="phone"><br>
		Role: <input type="radio" name="role" value="resident">Resident
		      <input type="radio" name="role" value="admin">Admin 
		      <br>
		      <br>
		    <button type="submit">Submit</button>
	</form>
</body>
</html>