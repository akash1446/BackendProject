package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.flm.dao.ComplaintDao;
import com.flm.model.Complaint;


@WebServlet("/UpdatedComplaintServlet")
public class UpdatedComplaintServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int complaintId = Integer.parseInt(req.getParameter("complaintId"));
		String category = req.getParameter("category");
		String subject = req.getParameter("subject");
		String description = req.getParameter("description");
		ComplaintDao dao = new ComplaintDao();
		Complaint complaint = dao.getComplaintById(complaintId);
		complaint.setCategory(category);
		complaint.setSubject(subject);
		complaint.setDescription(description);
		dao.UpdateComplaint(complaint);
		resp.sendRedirect("ResidentViewServlet");
	
		
	}

}
