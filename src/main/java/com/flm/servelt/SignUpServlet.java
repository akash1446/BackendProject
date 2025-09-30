package com.flm.servelt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.flm.dao.ResidentDao;
import com.flm.model.Resident;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String username = req.getParameter("username");
         String password = req.getParameter("password");
         String email = req.getParameter("email");
         String phone = req.getParameter("phone");
         String role = req.getParameter("role");
         Resident resident = new Resident();
         resident.setUsername(username);
         resident.setPassword(password);
         resident.setEmail(email);
         resident.setPhone(phone);
         resident.setRole(role);
         ResidentDao dao = new ResidentDao();
         dao.saveResident(resident);
         req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
