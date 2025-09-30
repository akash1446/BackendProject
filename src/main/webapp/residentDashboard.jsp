<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResidentDashboard</title>
</head>
<body>
<h1>Hi <%= session.getAttribute("username") %></h1>
<h2>Welcome to residentDashboard</h2>
      
<ul>
   <li><a href="RaiseComplaint.jsp">Raise Complaint</a></li>
   <li><a href="ResidentViewServlet">View My Complaint</a></li>
   <li><a href="ComplaintHistoryServlet">Complaints History</a></li>
   <li><a href="login.jsp">Logout</a></li>
</ul> 
</body>
</html>