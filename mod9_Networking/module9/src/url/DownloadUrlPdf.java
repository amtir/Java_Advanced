package url;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloadUrlPdf {
	
	private static String spec = "http://www.oracle.com/events/global/en/java-outreach/resources/java-a-beginners-guide-1720064.pdf";
	private static final int CHUNK_KB = 20000; //20480;  20 * 1000 
	
	public static void main(String[] args) {
	
		try {
			if (args.length != 1) {
				System.out.println("Usage: java DownloadUrlPdf path_where_to_download");
				System.exit(-1);
			}
			
		String pathFile = args[0];	// if the folder doesn't exit, should be created ...
		System.out.println("opening connection");
		URL url = new URL(spec);
		System.out.printf(" Protocol = %s \n", url.getProtocol() );
		System.out.printf(" Host = %s \n", url.getHost() );
		System.out.printf(" Path = %s \n", url.getPath() );
		
		Pattern patern = Pattern.compile("[^/]*.pdf$");
		Matcher m = patern.matcher(url.getPath());
		String OutputFile = null;

		if (m.find()) {
			OutputFile = m.group();
		}else {
			OutputFile = "OutputFile.pdf";
		}
		
		InputStream in = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File(pathFile + "/" + OutputFile));

		System.out.println("reading from resource and writing to file...");
		int length = -1; int p = 0;int c = 1;
		byte[] buffer = new byte[1024];// buffer for portion of data from connection
		while ((length = in.read(buffer)) > -1) {
		    fos.write(buffer, 0, length);
		    p=p+length; 
		    if(p/CHUNK_KB>=c) { c++;
		    	System.out.printf("File downloading %.2f KB\n" , p/1000.f );
		    }
		}
		fos.close();
		in.close();
		System.out.printf("File downloading %.2f KB\n" , (20.f*p)/CHUNK_KB );
		System.out.println("File downloaded ---> " + pathFile + "/" + OutputFile);
		
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL spec.");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Error reading streams.");
			e.printStackTrace();
		}
	}
 }
