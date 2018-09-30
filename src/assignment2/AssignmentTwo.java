package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignmentTwo {
	
	public void run() {
		
		System.out.println("Hello from assignmentTwo!");
		try {
			// Create a variable for the connection string.
	        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Demo Database NAV (5-0);integratedSecurity=True";
	        Connection con = DriverManager.getConnection(connectionUrl);
	        Statement stmt = con.createStatement();
	        
            String SQL_Query = "SELECT TOP 10 * FROM Company";
            ResultSet rs = stmt.executeQuery(SQL_Query);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

	}
}
