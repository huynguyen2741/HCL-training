package assignment7.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/list")
public class listController extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		prepare the response
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();		
		try {
//			set key value pair to contain result in "data"
			req.setAttribute("data", getList());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
//		send over result to list.jsp
		rd.forward(req,res);		
	}	
	
	public static String getList() throws ClassNotFoundException, SQLException {
		String result ="List of employees: <br />(id--name--salary)<br />"; 
//		get the list from the database.
		LinkedList<Employee> list = GetDatabase.getEmployees();
		Iterator i = list.iterator();
		while(i.hasNext()) {
			Employee e = (Employee)i.next();
			result += e.getId()+ " - " + e.getName()+ " - " + e.getSalary() + "<br/>";
		}
		return result;
	}
}
