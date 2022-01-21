import java.io.*;
import java.util.Scanner;

public class fileTest {
	
	// Check the characters for UTF-8 (we unit test this specifically)
	public static boolean utfCheck(String line) {
		
		return true;
	}
	
	// File reader, returns true if file is UTF-8
	public static boolean readFile(File infile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(infile));
		String line;
		boolean charCheck = true;
		
		while ((line = reader.readLine()) != null) {
			
			/*
				Run utfcheck here
				
				if (!charCheck) {
					break;
				}
			*/
		
			// Placeholder code for now
			
			System.out.println(line);
		}
		
		reader.close();
		return charCheck;
	}
	
	// Main, calls the stuff
	public static void main(String[] args) throws IOException {
		boolean check;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please provide input file");
		
		String filename = scanner.nextLine();
		
		File infile = new File(filename);
		
		if (infile.isFile() && filename.contains(".csv")) {	
			System.out.println("File found and is a .csv");
			System.out.println("Your file is: " + filename);
			
			check = readFile(infile);
			
			if (!check) {
				System.out.println("File is not fully UTF-8");
				// Other stuff I guess
			}
		}
		else {
			System.out.println("File not found or is not a .csv file");	
		}
	}
}
