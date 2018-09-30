package assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignmentTwo {
	
	public void run() {
		
		try {
			// Create a variable for the connection string.
	        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Demo Database NAV (5-0);integratedSecurity=True";
	        // Create connection
	        Connection con = DriverManager.getConnection(connectionUrl);
	        
	        String tableName = "\"CRONUS Sverige AB$Employee\"";
	        //Write a query
            String SQL_Query = "SELECT TOP 5 * FROM " + tableName;
            //We need Statement to execute the Query
	        Statement stmt = con.createStatement();
	        // Execute the Query and get the result 
            ResultSet rs = stmt.executeQuery(SQL_Query);

            //Get the MetaData of the table in the Query
            ResultSetMetaData rsmd = rs.getMetaData();
            //printColumnNameAndType(rsmd);// print Name and type
            printKeys(con);
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

	}
	
	private void printColumnNameAndType(ResultSetMetaData rsmd) {
		// Iterate through the Meta data in the resultSetMetaData and display ColumnName.
        try {
			for(int i = 1; i < rsmd.getColumnCount(); i++) {
				String colName = rsmd.getColumnName(i);
				String colType = rsmd.getColumnTypeName(i);
				System.out.println("\"" + colName + "\" of type "+colType  + "\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printKeys(Connection con) throws SQLException {
		DatabaseMetaData meta = con.getMetaData();
		
		try (ResultSet tables = meta.getTables(null, null, "%", new String[] { "TABLE" })) {
		    while (tables.next()) {
		        String catalog = tables.getString("TABLE_CAT");
		        String schema = tables.getString("TABLE_SCHEM");
		        String tableName = tables.getString("TABLE_NAME");
		        System.out.println("\nTable: " + tableName);
		        try (ResultSet primaryKeys = meta.getPrimaryKeys(catalog, schema, tableName)) {
	                System.out.print("\t\n Primary key: \t");
		            while (primaryKeys.next()) {
		                System.out.print(primaryKeys.getString("COLUMN_NAME")+ "\t");
		            }
		        }
		        try (ResultSet forignKeys = meta.getExportedKeys(catalog, schema, tableName)) {
	                System.out.print("\t\n Forign key: \t");
		            while (forignKeys.next()) {
		                System.out.print(forignKeys.getString("COLUMN_NAME")+ "\t");
		            }
		        }
		        // similar for exportedKeys
		    }
		}
	}
}
