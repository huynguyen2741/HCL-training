package assignment7.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import assignment7.model.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class updateController extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {
//			display the list of current employee
			req.setAttribute("data", listController.getList());
			req.setAttribute("update_message", "");	
			RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
			rd.forward(req, res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
//		get employee id
		int empID = Integer.parseInt(req.getParameter("empID"));
		String empName=req.getParameter("empName");
		double salary = Double.parseDouble(req.getParameter("salary"));
		boolean update_result = false;
//		get employee's info from the database
		if (empName.equals("")) {
			req.setAttribute("empID", empID);
			rd = req.getRequestDispatcher("update_info.jsp");
			rd.forward(req, res);
		}
		else {
			try {
				update_result = GetDatabase.udpateEmployee(empID,empName,salary);
				if (update_result) {
					req.setAttribute("update_message", "Employee updated");			
				}
				else {
					req.setAttribute("update_message", "Error in input, employee is not updated.");	
				}
				req.setAttribute("data", listController.getList());
//				sent over failure or success message.
				rd = req.getRequestDispatcher("update.jsp");
				rd.forward(req,res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
}
