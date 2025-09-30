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


@WebServlet("/AdminViewServlet")
public class AdminViewServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ComplaintDao dao = new ComplaintDao();
		HttpSession session=req.getSession(true);
		List<Complaint> list = dao.getAllComplaints();
		req.setAttribute("list", list);
		req.getRequestDispatcher("AdminViewComplaint.jsp").forward(req, resp);;
		
	}

}
