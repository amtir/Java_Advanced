package module6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileHandler {

	
	private static final int BUFFER_SIZE = 1024; // 512 256 128 64 32 16 8
	
	public static long copy(String srcName, String destName) throws FileNotFoundException, IOException
	{
		long bytesWritten = 0;
		int bytesRead = 0;
		byte[] buffer = new byte[BUFFER_SIZE];
		File fSrc = new File(srcName), fDest = new File(destName);
		try(
				BufferedInputStream instream = new BufferedInputStream(new FileInputStream(fSrc));
				BufferedOutputStream outstream = new BufferedOutputStream(new FileOutputStream(fDest));
				){
			while((bytesRead = instream.read(buffer, 0, BUFFER_SIZE))!=-1) {
				outstream.write(buffer,0,bytesRead);
				bytesWritten += bytesRead;
			}
		}
		return bytesWritten;
	}
	
	public static void main(String[] args) {

		if(args.length != 2) {
			System.out.println("Usage: Java BinaryFileHandler source destination file name.");
			System.exit(-1);
		}
		try {
			System.out.println("Bytes written: " + BinaryFileHandler.copy(args[0], args[1])) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
