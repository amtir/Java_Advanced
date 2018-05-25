package tcp.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Client {

	private static final Logger log4j = Logger.getLogger(Client.class.getName());
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
		String host = p.getProperty("host");
		int port = Integer.valueOf(p.getProperty("tcp_port"));

		try (Socket client = new Socket(host, port);) {

			try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));) {
				log4j.debug("Connected to host = " + host + " on port " + port);

				try (PrintWriter out = new PrintWriter(client.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));) {
					
					String line=null;
					if ((line = in.readLine()) != null) {
						System.out.println("*** Echoing Server --->  " + line);
						log4j.debug("*** Echoing Server --->  " + line);
					}
					
					for (int i=0; i<2; i++) {
						log4j.debug("Enter text to sent to server : ");
						String str = input.readLine();
						out.println(str);
						log4j.debug("*** Feedback from the server : " + in.readLine());
					}
					log4j.debug("Exiting client... ");
					out.println("Exiting client: " + client);
				}
				System.out.println("Exiting server ...");
			} catch (IOException e) {
				log4j.error("Lost connection to host due to I/O error.");
				e.printStackTrace();
			}

		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
