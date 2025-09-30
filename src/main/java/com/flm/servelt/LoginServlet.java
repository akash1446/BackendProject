package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.flm.dao.ResidentDao;
import com.flm.model.Resident;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
          String username = req.getParameter("username");
          String password = req.getParameter("password");
		  ResidentDao dao = new ResidentDao();
		  Resident resident = dao.isValid(username, password);
		  HttpSession session = req.getSession(true);
		  //role = resident
		  session.setAttribute("resId", resident.getRestId());
		  session.setAttribute("username", resident.getUsername());
		  session.setAttribute("email", resident.getEmail());
		  session.setAttribute("phone", resident.getPhone());
		  session.setAttribute("role", resident.getRole());
		  if(resident != null) {
			  if(resident.getRole().equals("admin")) {
				  resp.sendRedirect("adminDashboard.jsp");
			  }
			  else if(resident.getRole().equals("resident")) {
				  resp.sendRedirect("residentDashboard.jsp");
			  }
		  }
		  else {
			  req.getRequestDispatcher("index.jsp").forward(req, resp);
		  }
}

}
