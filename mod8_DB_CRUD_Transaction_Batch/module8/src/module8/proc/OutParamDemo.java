package module8.proc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class OutParamDemo {

	private static final Logger log4j = Logger.getLogger(OutParamDemo.class.getName());
	private static final String DB_CONN_FILE = "resources/dbconn.properties";

	public static void main(String[] args) {
		Properties p = new Properties();

		try {
			p.load(new FileInputStream(new File(DB_CONN_FILE)));

		} catch (IOException e) {
			log4j.error("Error reading " + DB_CONN_FILE, e);
			System.exit(-1);
		}

		log4j.debug("Connecting to database.");

		try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p);) {
			log4j.debug("Connecting succeeded.");

			String sqlStat = "CALL get_name(?, ?)";
			int ID = 2;
			try (CallableStatement proc = conn.prepareCall(sqlStat);) {
				proc.setInt(1, ID);
				proc.execute();

				String str = null;
				str = proc.getString(2);

				log4j.debug("ID : " + ID + " --> Name  " + str + " .");
			}
		} catch (SQLException e) {
			log4j.error("Call to the stored procedure failed.", e);
		} finally {
			log4j.debug("Connection closed.");
		}
	}
}
