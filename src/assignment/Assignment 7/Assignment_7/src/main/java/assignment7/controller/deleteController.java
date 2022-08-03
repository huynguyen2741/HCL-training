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

@WebServlet("/delete")
public class deleteController extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {
//			display the list of current employee
			req.setAttribute("data", listController.getList());
			req.setAttribute("delete_message", "");	
			RequestDispatcher rd = req.getRequestDispatcher("delete.jsp");
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
		
//		get employee id
		int empID = Integer.parseInt(req.getParameter("empID"));
		
		boolean delete_result = false;
//		get employee's info from the database

			try {
				delete_result = GetDatabase.deleteEmployee(empID);
				if (delete_result) {
					req.setAttribute("delete_message", "Employee deleted");			
				}
				else {
					req.setAttribute("delete_message", "Error in input, employee is not deleted.");	
				}
				req.setAttribute("data", listController.getList());
//				sent over failure or success message.
				RequestDispatcher  rd = req.getRequestDispatcher("delete.jsp");
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
