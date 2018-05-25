package module8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;


public final class TestConnectionMySQL {
	
	
	private static final Logger log4j = Logger.getLogger(TestConnectionMySQL.class.getName());
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
		}catch (SQLException e) {
			log4j.error("Connection failed.", e);
		}finally {
			log4j.debug("Connection closed.");
		}
			
	}

}
