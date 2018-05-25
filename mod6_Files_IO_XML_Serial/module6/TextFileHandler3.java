package module6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public final class TextFileHandler3 {

	private static String file_Name = null;
	private static Map<String, String> table = new LinkedHashMap<String, String>();

	public static String getFile_Name() {
		return file_Name;
	}

	public static void setFile_Name(String file_Name) {
		TextFileHandler3.file_Name = file_Name;
	}

	public static Map<String, String> getTable() {
		return table;
	}

	public static void setTable(HashMap<String, String> table) {
		TextFileHandler3.table = table;
	}

	public static void printFirst10Lines() throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(file_Name)));
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file_Name + "_copy")));

		) {
			int i = 0;
			String line;
			while ((line = br.readLine()) != null) {
				i++;
				System.out.println("Line " + i + ": " + line);
				bw.write(line);
				bw.write("\n");
			}
		}
	}

	public static void loadFile(String filePath) throws FileNotFoundException, IOException {

		file_Name = filePath;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(file_Name)))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(line, ",");
				String val = null, key = null;

				while (tokens.hasMoreTokens()) {
					if (key == null) {
						key = tokens.nextToken().trim();
						continue;
					}
					val = tokens.nextToken().trim();
					table.put(key, val);
					System.out.println("key: " + key + " value: " + table.get(key));
				}
			}

		}
		System.out.println("--------------------------------");
	}

	public static void dumpTable(Map<String, String> map) {

		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			String key = it.next();
			System.out.println("key: " + key + " value: " + table.get(key));
		}
	}

	public static void writeToFile(String newFilename, char countryNameBeginningWith)
			throws FileNotFoundException, IOException {

		Set<String> keys = table.keySet();
		Iterator<String> it = keys.iterator();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(newFilename)));) {
			int i = 0;
			String line;

			while (it.hasNext()) {

				String key = it.next();

				if (key.startsWith(String.valueOf(countryNameBeginningWith))) {
					i++;
					System.out.println(i + " key: " + key + " value: " + table.get(key));
					line = key + "," + table.get(key);
					bw.write(line);
					bw.write("\n");
				}
			}
		}

	}

	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("Usage: Java module TextFileHandler3 csvFilePath csvFileDest charS");
			System.exit(-1);
		}

		try {
			TextFileHandler3.loadFile(args[0]);
			TextFileHandler3.writeToFile(args[1], args[2].charAt(0));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
