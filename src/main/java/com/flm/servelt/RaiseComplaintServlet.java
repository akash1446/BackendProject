package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.flm.dao.ComplaintDao;
import com.flm.model.Complaint;


@WebServlet("/RaiseComplaintServlet")
public class RaiseComplaintServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession(true);
		int resId = (int)session.getAttribute("resId");
		String category = req.getParameter("category");
		String subject = req.getParameter("subject");
		String description = req.getParameter("description");
		Complaint complaint = new Complaint();
		complaint.setCategory(category);
		complaint.setSubject(subject);
		complaint.setDescription(description);
		complaint.setStatus("pending");
		complaint.setUserId(resId);
		ComplaintDao dao = new ComplaintDao();
		dao.saveComplaint(complaint);
		resp.sendRedirect("ResidentViewServlet");
	}

}
