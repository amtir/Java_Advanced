package module8.query;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ReadingTableDemo {

	private static final Logger log4j = Logger.getLogger(ReadingTableDemo.class.getName());
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
			
			String sqlStat = "select * from mobile";
			Statement stmt = conn.createStatement();
			
			try(ResultSet set = stmt.executeQuery(sqlStat);) {
				int counter = 0;
				while(set.next()) {
					counter++;
					//System.out.println(set.getString(1) + " " +set.getString(2) + " " +set.getString(3));
					log4j.debug(set.getString("manuf_name") + " " +set.getString("price") + " " +set.getString("color"));
				}
				log4j.debug("Fetched " + counter + " rows.");
			}
			
			
		}catch (SQLException e) {
			log4j.error("Query failed.", e);
		}finally {
			log4j.debug("Connection closed.");
		}
			
	}

}
