package mysqlEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class CrudOperation {
	  static final String DB_URL = "jdbc:mysql://localhost:3306/eduproduct";
	    static final String USER = "root";
	    static final String PASS = "2010";
	public static void addStudentDetails(){
		Scanner sc= new Scanner(System.in);
		System.out.println("enter id ");
		int id =sc.nextInt();
		System.out.println("enter name");
		String Name = sc.next();
		System.out.println("enter age");
		int age = sc.nextInt();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt=conn.createStatement();
			System.out.println(conn);
            String query="INSERT INTO student values( "+id+", "+"'"+Name+"', "+ age+")";
        	stmt.executeUpdate(query);
        	System.out.println("execution complete");
//    		ResultSet rs = stmt.executeQuery("select * from student"); 
//    		while (rs.next()) 
//    		{ 
//    			System.out.println("tid:"+rs.getInt(1));
//    			System.out.println("tname:"+rs.getString(2));
//    			System.out.println("tage:"+rs.getInt(3));
//
//    		}
		} catch(Exception e) {
			System.out.println("error");
		}
		
		
	}
public static void displayStudentDetails() {
	try {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=conn.createStatement();
		System.out.println(conn);
       	ResultSet rs = stmt.executeQuery("select * from student"); 
		while (rs.next()) 
		{ 
			System.out.println("tid:"+rs.getInt(1));
			System.out.println("tname:"+rs.getString(2));
			System.out.println("tage:"+rs.getInt(3));

		}
	} catch(Exception e) {
		System.out.println("error");
	}
	
	

}
	
public static void updateStudentDetails() {
	Scanner sc= new Scanner(System.in);
	try {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=conn.createStatement();
		System.out.println(conn);
//		String query="desc student";
//    	stmt.executeUpdate(query);
       	ResultSet rs = stmt.executeQuery("desc student");
    	while (rs.next()) 
		{ 
			System.out.println(rs.getString(1));
//			System.out.println("tname:"+rs.getString(2));
//			System.out.println("tage:"+rs.getInt(3));

		}
       	System.out.println("Enter what you have change");
       	String change= sc.next();
       	int id=sc.nextInt();
       	System.out.println("Change to");
       	String changeto=sc.next();
       	String query="update student set "+change+"= '"+changeto+"'"+"where id ="+id;
    	stmt.executeUpdate(query);
       	
	}catch(Exception e) {
		System.out.println("error");
	}
	
}

public static void  deleteStudentDetails() {
	Scanner sc= new Scanner(System.in);
	try {
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		Statement stmt=conn.createStatement();
		System.out.println(conn);
		ResultSet rs = stmt.executeQuery("desc student");
    	while (rs.next()) 
		{ 
			System.out.println(rs.getString(1));
//			System.out.println("tname:"+rs.getString(2));
//			System.out.println("tage:"+rs.getInt(3));

		}
    	System.out.println("enter what you have provide ");
    	String change= sc.next();
    	if(change.equalsIgnoreCase("sname")) {
    		String name= sc.next();
    		
    		String query="delete from student where sname='"+name+"'";
        	stmt.executeUpdate(query);
    		
    	}
    	else if(change.equalsIgnoreCase("id")) {
    		int id=sc.nextInt();
//    		ResultSet rs1 = stmt.executeQuery("select id from student");
//    		boolean id1=false;
//        	while (rs1.next()) 
//    		{ 
//    		  if(rs1.next()==id)
////    			System.out.println("tname:"+rs.getString(2));
////    			System.out.println("tage:"+rs.getInt(3));
//
//    		}
    		String query="delete from student where id="+id;
        	stmt.executeUpdate(query);
    	}
    	else {
    		int age = sc.nextInt();
    		String query="delete from student where id="+age;
        	stmt.executeUpdate(query);
    	}
	}
	catch(Exception e) {
		System.out.println("error");
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch;
		System.out.println("Enter your choice \n");
		do {
			System.out.println("1 - Add details");
            System.out.println("2 - Displaying of Students details");
            System.out.println("3 - Update of Students details");
            System.out.println("4 - Delete of Students details");
            System.out.println("5 - Exit");
            System.out.print("Enter the choice: ");
            ch = sc.nextInt(); 
            switch (ch) {
            case 1:
                addStudentDetails();
                break;
            case 2:
                displayStudentDetails();
                break;
            case 3:
                updateStudentDetails();
                break;
            case 4:
                deleteStudentDetails();
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please enter again.");
        }
    } while (ch != 5);
				

	}

	

}
