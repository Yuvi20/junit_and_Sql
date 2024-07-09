package mysqlEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckConnections {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver"); 
	// registering driver 
//	Statement stmt = null;
	String url = "jdbc:mysql://localhost:3306/eduproduct";
	Connection con = DriverManager.getConnection(url, "root", "2010");// establish connection //
	System.out.println(con);
	System.out.println("Database dbemp connection suceesfully establish");
	Statement stmt=con.createStatement();
//	ResultSet rs = stmt.executeQuery("select * from teachers"); 
	System.out.println("Get employee records:"); 
//	String query="insert into teachers values (5,'karan',30)";
//	stmt.executeUpdate(query);
//	String query="alter table teachers add email varchar(20)";
//	stmt.executeUpdate(query);
//	String query="update teachers set email='yuvayb777@gmail.com' where id=1";
//	stmt.executeUpdate(query);

	System.out.println("execution complete");
	ResultSet rs = stmt.executeQuery("select * from teachers"); 

	
	while (rs.next()) 
	{ 
		System.out.println("tid:"+rs.getInt(1));
		System.out.println("tname:"+rs.getString(2));
		System.out.println("tage:"+rs.getInt(3));
		System.out.println("temail:"+rs.getString(4));

	}
	

}
}
