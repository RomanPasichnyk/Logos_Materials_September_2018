package ua.logos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

static Connection conn;
	
	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/university?useSSL=false";
		String username = "zavada";
		String password = "zavada";
		
		conn = DriverManager.getConnection(dbUrl, username, password);
		System.out.println("Connected? " + !conn.isClosed());
		
		createTable();
		addStudent();
		
		for(int i = 0; i < 30; i++) {
			addStudents(i);
		}
		selectStudent(5);
		
		deleteStudent(2);
		
		selectStudents();
		
		conn.close();
	}
	
	private static void createTable() throws SQLException {
		String dropQuery = "DROP TABLE IF EXISTS student;";
		String query = "CREATE TABLE student("
				+ "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "full_name VARCHAR(60) NOT NULL,"
				+ "city VARCHAR(45) NOT NULL,"
				+ "age INT NOT NULL"
				+ ");";
		Statement stmt = conn.createStatement();
		stmt.execute(dropQuery);
		stmt.execute(query);
		System.out.println("Table 'Student' created");
		stmt.close();
	}
	
	private static void addStudent() throws SQLException {
		String query = "INSERT INTO student(full_name, city, age) VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "John Doe"); // VALUES("John Doe", ?, ?)
		pstmt.setString(2, "Lviv"); // VALUES("John Doe", "Lviv", ?)
		pstmt.setInt(3, 27); // VALUES("John Doe", "Lviv", 27)
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	private static void selectStudents() throws SQLException {
		String query = "SELECT * FROM student;";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					"ID: " + rs.getInt("id") + "\t |" +
				    "Full Name: " + rs.getString("full_name") + "\t |" +
				    "City: " + rs.getString("city") + "\t |" +
				    "Age: " + rs.getInt("age")
					);
			
		}
	}
	
	private static void addStudents(int i) throws SQLException {
		String query = "INSERT INTO student(full_name, city, age) VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "John Doe #" + i);
		pstmt.setString(2, "Lviv #" + i);
		pstmt.setInt(3, 27);
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	private static void selectStudent(int id) throws SQLException {
		String query = "SELECT * FROM student WHERE id = ?;";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					"ID: " + rs.getInt("id") + "\t |" +
				    "Full Name: " + rs.getString("full_name") + "\t |" +
				    "City: " + rs.getString("city") + "\t |" +
				    "Age: " + rs.getInt("age")
					);
		}
	}
	
	private static void deleteStudent(int id) throws SQLException {
		String query = "DELETE FROM student WHERE id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
	}
}
