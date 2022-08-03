package assignment7.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class createController extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		prepare the response
		res.setContentType("text/html");
//		get the value from the req parameter.
		int empID = Integer.parseInt(req.getParameter("empID"));
		String empName=req.getParameter("empName");
		double salary = Double.parseDouble(req.getParameter("salary"));
		boolean created_result = false;
//		pass parameter to database to create.
		try {
			created_result = GetDatabase.createEmployee(empID, empName, salary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (created_result) {
			req.setAttribute("message", "Employee created");			
		}
		else {
			req.setAttribute("message", "Error in input, employee not created.");	
		}
//		sent over failure or success message.
		RequestDispatcher rd = req.getRequestDispatcher("create.jsp");
		rd.forward(req,res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("message", "");
		RequestDispatcher rd = req.getRequestDispatcher("create.jsp");
		rd.forward(req, res);
	}
}
