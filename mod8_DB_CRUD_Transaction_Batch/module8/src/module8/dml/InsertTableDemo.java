package module8.dml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;


public class InsertTableDemo {


	private static final Logger log4j = Logger.getLogger(InsertTableDemo.class.getName());
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
			
			String sqlStat = "INSERT INTO mobile (manuf_name, price, color) VALUE(?, ?, ?)";
			
			
			try(PreparedStatement stmt = conn.prepareStatement(sqlStat); ) {
				stmt.setString(1, args[0]);
				stmt.setString(2, args[1]);
				stmt.setString(3, args[2]);
				int r = stmt.executeUpdate();

				log4j.debug("Inserted  " + r  + " row(s).");
			}
			
			
		}catch (SQLException e) {
			log4j.error("Query failed.", e);
		}finally {
			log4j.debug("Connection closed.");
		}
			
	}

}
