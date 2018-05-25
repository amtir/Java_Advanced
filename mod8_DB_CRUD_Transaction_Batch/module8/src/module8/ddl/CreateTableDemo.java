package module8.ddl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;


public class CreateTableDemo {
	
	private static final Logger log4j = Logger.getLogger(CreateTableDemo.class.getName());
	private static final String DB_CONN_FILE = "resources/dbconn.properties";

	public static void main(String[] args) {
		Properties p = new Properties();
		
		try {p.load(new FileInputStream(new File(DB_CONN_FILE)));
			
		}catch(IOException e) {
			log4j.error("Error reading " + DB_CONN_FILE, e);
			System.exit(-1);
		}
		
		log4j.debug("Connecting to database.");
		
		try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p);)  {
			log4j.debug("Connecting succeeded.");
			
			String sqlStat = "CREATE TABLE student_temp (ID INT PRIMARY KEY, NAME VARCHAR(20))";
			Statement stmt = conn.createStatement();
			stmt.execute(sqlStat);
			log4j.debug("Table created.");
		}catch (SQLException e) {
			log4j.error("Connection failed.", e);
		}finally {
			log4j.debug("Connection closed.");
		}
			
	}

}
