<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.flm.model.Complaint" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminViewComplaint</title>
</head>
<body>
<h2>My Complaints</h2>
    <% List<Complaint> list = (List<Complaint>) request.getAttribute("list"); %>
   <table border="1">
      <tr>
			<th>Complaint Id</th>
			<th>User Id</th>
			<th>Category</th>
			<th>Subject</th>
			<th>Description</th>
			<th>Status</th>
			<th>Status Update</th>
			
	</tr>
	<%
	   for(Complaint complaint:list){
	 
	%>
     <tr>
			<td><%=complaint.getComplaintId() %></td>
			<td><%=complaint.getUserId() %></td>
			<td><%=complaint.getCategory() %></td>
			<td><%=complaint.getSubject() %></td>
			<td><%=complaint.getDescription() %></td>
			<td><%=complaint.getStatus() %></td>
			<td>
			   <a href="InitialUpdateStatusServlet?complaintId=<%=complaint.getComplaintId() %>">Edit</a>
			</td>			
	</tr>
     <%
      
	   }
     
     %>
   </table>
</body>
</html>