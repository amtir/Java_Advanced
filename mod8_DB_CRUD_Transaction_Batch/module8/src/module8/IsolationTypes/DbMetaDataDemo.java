package module8.IsolationTypes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DbMetaDataDemo {
	// Fetch the MetaData Attributes of the DataBase MySQL
	private static final Logger log4j = Logger.getLogger(DbMetaDataDemo.class.getName());
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

			DatabaseMetaData dbMetaData = conn.getMetaData();

			if (!dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
				log4j.debug("Database does not support ResultSet.TYPE_SCROLL_SENSITIVE & ResultSet.CONCUR_UPDATABLE");
			}

			if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				log4j.debug("Database supports ResultSet.TYPE_SCROLL_INSENSITIVE");
			}

			if (dbMetaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ)) {
				log4j.debug("Database supports Connection.TRANSACTION_REPEATABLE_READ");
			}

			if (dbMetaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)) {
				log4j.debug("Database supports Connection.TRANSACTION_SERIALIZABLE");
			}

		} catch (SQLException e) {
			log4j.error("Reading Attributes failed.", e);
		} finally {
			log4j.debug("Connection closed.");
		}

	}

}
