package url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.System.out;

public class UrlContentReading {
	
	private static String spec = "http://www.ietf.org/rfc/rfc1616.txt";
	

	public static void main(String[] args) {

		try {
			URL url = new URL(spec);
			int count = 0;
			byte[] buffer = new byte[1024];
			
			InputStream istream = url.openStream();
			
			while((count=istream.read(buffer)) != -1){
				String content = new String(buffer, 0, count, "UTF-8");
				out.printf(content);
				//System.out.println(content);
			}
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL spec.");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Error reading streams.");
			e.printStackTrace();
		}
		
	}

}
