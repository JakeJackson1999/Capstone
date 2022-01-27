package fileTest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.*;

public class fileTest {
	// Check the characters for UTF-8 (we unit test this specifically)
	public static boolean utfCheck(String line) {
		
		ByteBuffer buffer = StandardCharsets.UTF_8.encode(line);
		
		//String encoded = StandardCharsets.UTF_8.decode(buffer).toString();
		
		for (int i = 0; i < line.length(); i++) {
			
			if (buffer.get(i) == ',' || buffer.get(i) == ' ') {
				continue;
			}
			else if (buffer.get(i) >= 97 && buffer.get(i) <= 122) { // Lower case EN
				continue;
			}
			else if (buffer.get(i) >= 65 && buffer.get(i) <= 90) { // Upper case EN
				continue;
			}
			else if (buffer.get(i) == 'ñ' || buffer.get(i) == 'Ñ') { // Special ES
				continue;
			}
			else { return false; }
		}
		
		return true;
	}
	
	// File reader, returns true if file is UTF-8
	public static boolean readFile(File infile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(infile));
		String line;
		boolean charCheck = true;
		
		while ((line = reader.readLine()) != null) {			
				charCheck = utfCheck(line);
				
				if (!charCheck) {
					break;
				}

		}
		
		reader.close();
		return charCheck;
	}
	
	// Main, calls the stuff
	public static void main(String[] args) throws IOException {		
		boolean check;
		
		File infile = new File("input.csv");
		
		if (infile.isFile()) {	
			check = readFile(infile);
			if (!check) {
				System.out.println("File is not fully UTF-8");
			}
		}
		else {
			System.out.println("File not found or is not a .csv file");	
		}
	}
}
