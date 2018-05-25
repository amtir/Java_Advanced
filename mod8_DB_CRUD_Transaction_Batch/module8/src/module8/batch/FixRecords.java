package module8.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FixRecords {

	private static final Logger log4j = Logger.getLogger(FixRecords.class.getName());
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

			Savepoint marker = null;
			conn.setAutoCommit(false);

			// String sqlStat = "INSERT INTO STUDENT (NAME, MARKS) VALUE(?, ?)"; // PK
			// AutoIncrement used
			String sqlStat = "UPDATE STUDENT SET MARKS=?  WHERE ID=?";

			try (PreparedStatement stmt = conn.prepareStatement(sqlStat);) {
				// Start transaction
				marker = conn.setSavepoint("start_trans");
				stmt.setInt(1, 66);
				stmt.setInt(2, 10);
				stmt.addBatch();

				stmt.setInt(1, 33);
				stmt.setInt(2, 9);
				stmt.addBatch();

				log4j.debug("Executing batch.");

				int[] r = stmt.executeBatch();

				log4j.debug("Inserted/updated  " + r.length + " record(s).");

				conn.commit();
				log4j.debug("Commited transaction.");
				// Ending transaction
				conn.releaseSavepoint(marker);
				conn.setAutoCommit(true);
			}

		} catch (SQLException e) {
			log4j.error("Batch processing failed.", e);
		} finally {
			log4j.debug("Connection closed.");
		}

	}

}
