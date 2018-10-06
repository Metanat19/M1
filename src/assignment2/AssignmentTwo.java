package assignment2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AssignmentTwo {
	DAL dal;

	public AssignmentTwo() {
		dal = new DAL();
	}

	public void run() {

		//printIndexes();
		printTableConstrians();
		// printColumnNameAndType();// print Name and type
		try {
			// printKeys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 1
	private void printKeys() throws SQLException {
		DatabaseMetaData meta = dal.getDBMetaData();

		String[] tableTypes = { "TABLE" };
		try (ResultSet tables = meta.getTables(null, null, "%", tableTypes)) {
			while (tables.next()) {
				String catalog = tables.getString("TABLE_CAT");
				String schema = tables.getString("TABLE_SCHEM");
				String tableName = tables.getString("TABLE_NAME");
				System.out.println("\n\nTable: " + tableName);
				try (ResultSet primaryKeys = meta.getPrimaryKeys(catalog, schema, tableName)) {
					System.out.print("\t Primary key: \t");
					while (primaryKeys.next()) {
						System.out.print(primaryKeys.getString("COLUMN_NAME") + "\t");
					}
				}
				try (ResultSet forignKeys = meta.getExportedKeys(catalog, schema, tableName)) {
					System.out.print("\n\t Forign key: \t");
					while (forignKeys.next()) {
						System.out.print(forignKeys.getString("COLUMN_NAME") + "\t");
					}
				}
			}
		}
	}

	// 2
	private void printIndexes() {
		String tableName = "\"CRONUS Sverige AB$Employee\"";
		tableName = "sys.indexes";
		// Write a query
		String SQL_Query = "SELECT TOP 5 * FROM " + tableName;

		// Get the MetaData
		ResultSet rs = dal.run(SQL_Query);
		ResultSetMetaData rsmd = dal.getResultSetMetaData(rs);
		// Iterate through the Meta data in the resultSetMetaData and display
		// ColumnName.

		Map<String, String> map = new HashMap<String, String>();
		try {
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				String colName = rsmd.getColumnName(i);
				String colType = rsmd.getColumnTypeName(i);
				map.put(colName, colType);
			}
			for ( Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey());
			}
			System.out.println("");
			while (rs.next()) {
				for ( Map.Entry<String, String> entry : map.entrySet()) {
					if (entry.getValue().equals("int") || entry.getValue().equals("bit")  || entry.getValue().equals("tinyint")) {
						System.out.print(rs.getInt(entry.getKey()) + "\t ");
					}else if (entry.getValue().equals("nvarchar")) {
						System.out.print(rs.getString(entry.getKey()) + "\t ");
					} else {
						System.out.print("\t ");
					}
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//3
	private void printTableConstrians() {

		String SQL_Query = "SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
		ResultSet rs = dal.run(SQL_Query);
		ResultSetMetaData rsmd = dal.getResultSetMetaData(rs);
		try {
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				String colName = rsmd.getColumnName(i);

				System.out.println(colName );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 5
	private void printColumnNameAndType() {
		String tableName = "\"CRONUS Sverige AB$Employee\"";
		tableName = "\"sys.indexes\"";
		// Write a query
		String SQL_Query = "SELECT TOP 5 * FROM " + tableName;

		// Get the MetaData
		ResultSet rs = dal.run(SQL_Query);
		ResultSetMetaData rsmd = dal.getResultSetMetaData(rs);
		// Iterate through the Meta data in the resultSetMetaData and display
		// ColumnName.
		try {
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				String colName = rsmd.getColumnName(i);
				String colType = rsmd.getColumnTypeName(i);
				System.out.println("\"" + colName + "\" of type " + colType + "\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
