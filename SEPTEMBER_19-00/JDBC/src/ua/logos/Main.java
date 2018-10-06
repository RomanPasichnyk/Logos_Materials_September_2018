package ua.logos;

import java.sql.*;

public class Main {

	static Connection conn;
	
	public static void main(String[] args) throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/university?useSSL=false";
		String username = "zavada";
		String password = "zavada";

		// Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dbUrl, username, password);
		System.out.println("Connected? " + !conn.isClosed());
		
		createTable();
		insertQuery();
		
		for(int i = 0; i < 10; i++) {
			insertQuery(i);
		}
		
		select();
		delete(5);
		select();
		
		conn.close();
	}
	
	private static void createTable() throws SQLException {
		String dropQuery = "DROP TABLE IF EXISTS student;";
		String query = "CREATE TABLE student("
				+ "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "full_name VARCHAR(80) NOT NULL,"
				+ "age INT NOT NULL"
				+ ");";
		
		Statement stmt = conn.createStatement();
		stmt.execute(dropQuery);
		stmt.execute(query);
		System.out.println("Table 'student' created!");
		stmt.close();
	}
	
	private static void insertQuery() throws SQLException {
		String query = "INSERT INTO student(full_name, age) VALUES(?, ?);";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "John Doe"); // VALUES("John Doe", ?)
		pstmt.setInt(2, 27); // VALUES("John Doe", 27)
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	private static void select() throws SQLException {
		String query = "SELECT * FROM student;";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					"ID: " + rs.getInt("id") + "\t | " +
					"Full name: " + rs.getString("full_name") + "\t | " +
					"Age: " + rs.getInt("age"));
		}
	}
	
	
	private static void insertQuery(int i) throws SQLException {
		String query = "INSERT INTO student(full_name, age) VALUES(?, ?);";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "John Doe#" + i);
		pstmt.setInt(2, 15 + i);
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	private static void delete(int id) throws SQLException {
		String query = "DELETE FROM student WHERE id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		
		pstmt.close();
	}

}
