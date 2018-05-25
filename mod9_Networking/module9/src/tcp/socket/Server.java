package tcp.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Server {

	private static final Logger log4j = Logger.getLogger(Server.class.getName());
	private static final String CONN_FILE = "resources/conn.properties";

	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File(CONN_FILE)));
		} catch (IOException e) {
			log4j.error("Error reading " + CONN_FILE);
			e.printStackTrace();
			System.exit(-1);
		}
		int port = Integer.valueOf(p.getProperty("tcp_port"));
		try (ServerSocket server = new ServerSocket(port);) {
			while (true) {
				log4j.debug("Waiting for connection ...");
				Socket client = server.accept();
				log4j.debug("Connected to " + client.toString());

				new Thread(new RequestProcessThread(client)).start();
			}
		} catch (IOException e) {
			log4j.info("Exception error: ", e);
			e.printStackTrace();
		} finally {
			System.out.println("Exiting server...");
		}
	}
}

class RequestProcessThread implements Runnable {

	private Socket client;
	private static final Logger log4j = Logger.getLogger(RequestProcessThread.class.getName());

	public RequestProcessThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {

		try (PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));) {
			//log4j.debug("Welcome to the Java multiple client Server");
			out.println("Welcome to the Java multiple client Server");
			String line = null;
			while ((line = in.readLine()) != null) {
				// String line = in.readLine();
				// if(line==null) break;
				log4j.debug("*** Echoing client --->  " + line);
				out.println("Message received ...");
			}
		} catch (Exception e) {
			log4j.info("Lost connection to host due to I/O error.");
		}

	}

}
