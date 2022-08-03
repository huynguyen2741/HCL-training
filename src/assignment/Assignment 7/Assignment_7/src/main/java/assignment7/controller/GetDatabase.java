package assignment7.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import assignment7.model.Employee;

public class GetDatabase {
//	establish connection to "employees" database
//	static Connection con = null;
	static String query = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	static Connection con =null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","");
			pst = con.prepareStatement("create table employee(empID Integer PRIMARY KEY, name VARCHAR(30), salary DECIMAL(10,2))");
			pst.executeUpdate();
			pst = con.prepareStatement("insert into employee values (1, \"huy\", 3000),(2, \"hoan\", 5000),(3, \"linh\", 2000)");
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
//	get a list of all employees' info.
	public static LinkedList<Employee> getEmployees() throws SQLException, ClassNotFoundException {		
		query = "SELECT * FROM employee";
		pst = con.prepareStatement(query);
		rs = pst.executeQuery();
		
		LinkedList<Employee> list = new LinkedList<>();
		while (rs.next()) {
			list.add(new Employee(rs.getInt("empID"),rs.getString("name"),rs.getDouble("salary")));
		}
		return list;
	}
//	create one employee based on paramenter from the jsp
	public static boolean createEmployee(int empID, String empName, double salary) throws SQLException {
		boolean result = false;
		query = "INSERT INTO employee VALUES (?,?,?)";
		pst = con.prepareStatement(query);
		pst.setInt(1, empID);
		pst.setString(2, empName);
		pst.setDouble(3, salary);
		int row_created = pst.executeUpdate();
		if (row_created > 0) {
			result = true;
		}
		return result;
	}
	
	public static boolean udpateEmployee(int empID, String empName, double salary) throws SQLException {
		query="UPDATE employee SET name=?, salary=? WHERE empID=?";
		pst=con.prepareStatement(query);
		pst.setString(1, empName);
		pst.setDouble(2, salary);
		pst.setInt(3, empID);
		int row_created = pst.executeUpdate();
		boolean result = false;
		if (row_created > 0) {
			result = true;
		}
		return result;
	}
	
	public static boolean deleteEmployee(int empID) throws SQLException {
		query="DELETE FROM employee WHERE empID = ?";
		pst = con.prepareStatement(query);
		pst.setInt(1, empID);		
		int row_deleted = pst.executeUpdate();
		boolean result = false;
		if (row_deleted > 0) {
			result = true;
		}
		return result;
	}
}
