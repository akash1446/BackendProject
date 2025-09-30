package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.flm.dao.ComplaintDao;
import com.flm.model.Complaint;


@WebServlet("/UpdateComplaintServlet")
public class UpdateComplaintServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int complaintId = Integer.parseInt(req.getParameter("complaintId"));
		ComplaintDao  dao = new ComplaintDao();
	 	Complaint complaint=dao.getComplaintById(complaintId);
	 	req.setAttribute("complaint", complaint);
	 	req.getRequestDispatcher("UpdateComplaint.jsp").forward(req, resp);
	 	
	}
	
	}


