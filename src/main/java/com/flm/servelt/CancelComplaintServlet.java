package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.flm.dao.ComplaintDao;
import com.flm.model.Complaint;


@WebServlet("/CancelComplaintServlet")
public class CancelComplaintServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int complaintId =Integer.parseInt(req.getParameter("complaintId"));
		ComplaintDao  dao = new ComplaintDao();
		Complaint complaint = dao.getComplaintById(complaintId);
	 	dao.deleteComplaint(complaint);
	 	resp.sendRedirect("ResidentViewServlet");
	 	
	}

}
