package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.flm.dao.ComplaintDao;
import com.flm.model.Complaint;


@WebServlet("/UpdateStatusServlet")
public class UpdateStatusServlet extends HttpServlet {
	
	
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int complaintId =Integer.parseInt(req.getParameter("complaintId"));
	    String status = req.getParameter("status");
		ComplaintDao dao = new ComplaintDao();
	    Complaint complaint = dao.getComplaintById(complaintId);
	    complaint.setStatus(status);
	    dao.updateStatusdao(complaint);
	    resp.sendRedirect("AdminViewServlet");
	 	
	    
	}

}
