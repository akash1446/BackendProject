<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.flm.model.Complaint" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateStatus</title>
</head>
<body bgcolor="green">
     <%
          Complaint complaint = (Complaint)request.getAttribute("complaint");
      %>
    <form action="UpdateStatusServlet" method="post">
        <input type ="hidden" name="complaintId" value=<%=complaint.getComplaintId() %>><br><br>
        <input type="radio" name="status" value="pending">Pending<br><br>
        <input type="radio" name="status" value="progress">Progress<br><br>
        <input type="radio" name="status" value="resolved">Resolved<br><br>
        <input type="submit" value="Update">
    </form>

</body>
</html>