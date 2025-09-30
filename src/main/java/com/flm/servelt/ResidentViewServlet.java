package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.flm.dao.ComplaintDao;
import com.flm.model.Complaint;

@WebServlet("/ResidentViewServlet")
public class ResidentViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ComplaintDao dao = new ComplaintDao();
		HttpSession session=req.getSession(true);
		int resId = (int)session.getAttribute("resId");
		List<Complaint> list = dao.getComplaintByUser(resId);
		req.setAttribute("list", list);
		req.getRequestDispatcher("ResidentViewComplaint.jsp").forward(req, resp);
	}

}
