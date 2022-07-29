package assignment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Assignment_6 {
	/*
	Assignment 6:   Employee Management System:

		JDBC-> use Prepared Statement and CallableStatment as well in the assignment

		Java Console ->Front End
		MySQL Database-> Backend  (store atleast 5 records minimum)
		Getting the values from the user:
		Applly CRUD operations:
		
	*/
	static Scanner sc = new Scanner(System.in);
	static String query = null;
	static PreparedStatement pst =null;
	static ResultSet rs =null;
	static CallableStatement cs = null;
	
	
	public static void main(String[] args) throws SQLException {
		
		//create connection to the database.
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","");
		
//		Uncomment this block when first run to set up the database and table.
		/*
//		Create the table
		query ="create table employee (empID Integer Primary Key, empName VARCHAR(30))";
		pst = c.prepareStatement(query);
		pst.executeUpdate();
		
//		popoulate with 5 initial rows.
		query = "INSERT INTO employee VALUES " + 
				"(1,\"Huy\"),(2,\"Nick\"),(3,\"Alex\"),(4,\"Logan\"),(5,\"Jesse\")";
		pst = c.prepareStatement(query);
		pst.executeUpdate();	
		*/
		
		
		int choice = 0;
		do {
			System.out.print("Enter number \n1. to get list \n2. update \n3. delete \n4. get one employee \n0. to quit\n");
			choice = sc.nextInt();
			switch(choice) {
			case 1: getList(c); break;
			case 2: updateEmp(c); break;
			case 3: deleteEmp(c); break;
			case 4:	getEmp(c); break;
			}
		}while(choice >0);		
	}
	
	
//	i)  Get the list of employees
	static void getList(Connection c) throws SQLException {
		query ="SELECT * FROM employees.employee";
		pst = c.prepareStatement(query);
		rs = pst.executeQuery(query);
		while(rs.next()) {
			System.out.print("id: " + rs.getInt("empID") + " ");
			System.out.print("name: " + rs.getString("empName") + "\n");
		}
		System.out.println("\n\n");
	}

//	ii) Update the existing employee based in his/her id
	static void updateEmp(Connection c) throws SQLException {
//		get the id of the employee;
		System.out.print("Enter id of the employee: ");
		int id = sc.nextInt();
//		get the name of the employee
		System.out.print("Enter name of the employee: ");
		String name = sc.next();
//		prepare the statment
		cs = c.prepareCall("{call udpate_emp (?,?)}");
		cs.setInt(1, id);
		cs.setString(2, name);
//		execute and print result
		int rowAffected = cs.executeUpdate();
		System.out.println(rowAffected + " rows updated");
	}	
	
//	iii) Delete an employee based on the employee id	
	static void deleteEmp(Connection c) throws SQLException {
		int rowAffected = 0;
		while (rowAffected == 0) {
//			get the id of the employee;
			System.out.print("Enter id of the employee: ");
			int id = sc.nextInt();
			query = "DELETE FROM employee WHERE empID = ?";
			pst = c.prepareStatement(query);
			pst.setInt(1, id);
			rowAffected = pst.executeUpdate();
//			if id does not exist, print error, else print result
			if (rowAffected == 0) {
				System.out.println("Id does not exist, try again\n");
			}
			else {
				System.out.println(rowAffected + "row was deleted\n");
			}
		}
	}
	
//	iv) Get the employee by id
	static void getEmp(Connection c) throws SQLException {
		boolean emp_exist = false;
		do {
//			get the id of the employee;
			System.out.print("Enter id of the employee: ");
			int id = sc.nextInt();
			query = "SELECT * FROM employee WHERE empID = ?";
			pst = c.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()){
				System.out.print("id: " + rs.getInt("empID") + " ");
				System.out.println("name: " + rs.getString("empName") + "\n");
				emp_exist=true;
			}
			else {
				System.out.println("Id does not exist, try again\n");
			}
		}while (!emp_exist);		
		
	}

}
