package training;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd","root","");
		Statement st = con.createStatement();
		st.execute("insert into emp values(1,'Dylan',25)");
		st.execute("insert into emp values(2,'Ajay',26)");
		
		st.execute("update emp set ename='Lan' where id = 2");
		
		st.execute("delete from emp where id=1");
		
		ResultSet rs = st.executeQuery("select * from emp");
		
		while (rs.next()) {
			System.out.print("Emp Number " + rs.getInt(1));
			System.out.print("Name " + rs.getString("name"));
			System.out.print(rs.getString("age"));
		}

	}

}
