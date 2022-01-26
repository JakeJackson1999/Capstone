//package fileTest;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//public class fileTest {
	
	private static ArrayList<Character> en = new ArrayList<Character>();
	private static ArrayList<Character> enC = new ArrayList<Character>();
	private static ArrayList<String> es = new ArrayList<String>();
	private static ArrayList<String> esC = new ArrayList<String>();
	
	public static void fillEn() {
		for (int i = 97; i < 123; i++) {
			en.add((char) i);
		}
	}
	
	public static void fillEnC() {
		for (int i = 65; i < 91; i++) {
			enC.add((char) i);
		}
	}
	
	public static void fillEs() {
		es.add("ñ");
		es.add("ll");
		es.add("ch");
	}
	
	public static void fillEsC() {
		es.add("Ñ");
		es.add("Ll");
		es.add("Ch");
	}
	
	// Check the characters for UTF-8 (we unit test this specifically)
	public static boolean utfCheck(String line) {
		
		for (int i = 0; i < line.length(); i++) {
			
			if (line.charAt(i) == ',') {
				continue;
			}
			else if (en.contains(line.charAt(i)) == true) {
				continue;
			}
			else if (enC.contains(line.charAt(i)) == true) {
				continue;
			}
			else if (es.contains(line.charAt(i)) == true) {
				continue;
			}
			else if (esC.contains(line.charAt(i)) == true) {
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
			
		
			// Placeholder code for now
			
			System.out.println(line);
		}
		
		reader.close();
		return charCheck;
	}
	
	// Main, calls the stuff
	public static void main(String[] args) throws IOException {
		
		fillEn();
		fillEnC();
		fillEs();
		fillEsC();
		
		boolean check;
		
		Scanner scanner = new Scanner(System.in);
		
		//System.out.println("Please provide input file");
		
		//String filename = scanner.nextLine();
		
		File infile = new File("input.csv");
		
		if (infile.isFile()) {	
			//System.out.println("File found and is a .csv");
			//System.out.println("Your file is: " + filename);
			
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
//}
