package assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DAL {
	// Connection string.
	String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Demo Database NAV (5-0);integratedSecurity=True";
	Connection con;
	Statement stmnt;
	
	public DAL() {
		// Create connection
		try {
			con = DriverManager.getConnection(connectionUrl);
			// We need Statement to execute the Query
			stmnt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet run(String query) {
		if (stmnt != null) {
			// Execute the Query and get the result
			try {
				return stmnt.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public DatabaseMetaData getDBMetaData() {
		try {
			return con.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultSetMetaData getResultSetMetaData(ResultSet rs) {
		if (stmnt != null) {
			// Execute the Query and get the result
			try {
				// Get the MetaData of the table in the Query
				return rs.getMetaData();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	public ResultSet getTables() {
		try {
			DatabaseMetaData dbmd = getDBMetaData();

			 
		      // Get a ResultSet that contains all of the tables in database
		      // We specify a table_type of "TABLE" to prevent seeing system tables,
		      // views and so forth
		      String[] tableTypes = { "TABLE" };
		      return dbmd.getTables(null,null,null,tableTypes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
