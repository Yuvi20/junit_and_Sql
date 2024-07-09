package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatement {

	  static final String DB_URL = "jdbc:mysql://localhost:3306/eduproduct";
	    static final String USER = "root";
	    static final String PASS = "2010";

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("Database is connected!");
	            System.out.println("1 - Add details");
	            System.out.println("2 - Displaying of Students details");
	            System.out.println("3 - Update of Students details");
	            System.out.println("4 - Delete of Students details");
	            System.out.println("5 - Exit");
	            System.out.print("Enter the choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
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
	        } while (choice != 5);

	        scanner.close();
	    }

	    public static void addStudentDetails() {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             java.sql.PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student (id ,Sname, age) VALUES (?, ?, ?)")) {

	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Enter id: ");
	            int id = scanner.nextInt();
	            System.out.print("Enter name: ");
	            String Sname = scanner.nextLine();
	            scanner.nextLine(); 
	            System.out.print("Enter age: ");
	            int age = scanner.nextInt();
//	            scanner.nextLine();  // consume newline
	           
	            pstmt.setInt(1, id);

	            pstmt.setString(2, Sname);
	            pstmt.setInt(3, age);
	            pstmt.executeUpdate();

	            System.out.println("Student details added successfully.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void displayStudentDetails() {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             Statement stmt = conn.createStatement()) {

	            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String Sname = rs.getString("Sname");
	                int age = rs.getInt("age");
//	                String grade = rs.getString("grade");

	                System.out.println("ID: " + id + ", Name: " +Sname + ", Age: " + age );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void updateStudentDetails() {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             java.sql.PreparedStatement pstmt = conn.prepareStatement("UPDATE student SET Sname = ?, age = ?  WHERE id = ?")) {

	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Enter student ID to update: ");
	            int id = scanner.nextInt();
	            scanner.nextLine();  // consume newline
	            System.out.print("Enter new name: ");
	            String Sname = scanner.nextLine();
	            System.out.print("Enter new age: ");
	            int age = scanner.nextInt();
	            scanner.nextLine();  // consume newline
	           
	            pstmt.setInt(3, id);
	            pstmt.setString(1, Sname);
	            pstmt.setInt(2, age);
//	            pstmt.setString(3, grade);
	      
	            pstmt.executeUpdate();

	            System.out.println("Student details updated successfully.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void deleteStudentDetails() {
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             java.sql.PreparedStatement pstmt = conn.prepareStatement("DELETE FROM student WHERE id = ?")) {

	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Enter student ID to delete: ");
	            int id = scanner.nextInt();

	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();

	            System.out.println("Student details deleted successfully.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
