package module6;

import java.io.File;
import java.io.FileFilter;

public class FileListing {

	public void scanFileDirectory(String path, String fileType) {

		File root = new File(path);
		File[] list = root.listFiles();
		FileTypeFilter ff = new FileTypeFilter(fileType);

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				System.out.println("Dir:" + f.getAbsoluteFile());
				scanFileDirectory(f.getAbsolutePath(), fileType);

			} else {
				if (ff.accept(f))
					System.out.println("File:" + f.getAbsoluteFile());
			}
		}
	}

	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.out.println("Usage: Java module FileListing pathDirectory fileType");
			System.exit(-1);
		}

		try {
			FileListing fl = new FileListing();
			fl.scanFileDirectory(args[0], args[1]);
		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}
}

class FileTypeFilter implements FileFilter {

	// private final String[] okFileExtensions = new String[] {"pdf", "jpg"};
	private String okFileExtension = null;

	public FileTypeFilter(String fileType) {
		okFileExtension = fileType;
	}

	public boolean accept(File file) {
		// for (String extension : okFileExtension)
		// {
		if (file.getName().toLowerCase().endsWith(okFileExtension)) {
			return true;
		}
		// }
		return false;
	}
}
