<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminDashboard</title>
</head>
<body>
<h2>Hi <%= session.getAttribute("username") %></h2>
<h2>Welcome to adminDashboard</h2>
   
 <ul>
   <li><a href="AdminViewServlet">View All Complaints</a></li>
   <li><a href="login.jsp">Logout</a></li>
</ul> 
</body>
</html>