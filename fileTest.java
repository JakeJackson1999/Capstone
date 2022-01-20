import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class fileTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please provide input file");
		
		String filename = scanner.nextLine();
		
		File infile = new File(filename);
		
		if infile.isFile() {	
			System.out.println("File found");
			System.out.println("Your file is: " + filename);
		}
		else {
			System.out.println("File not found");	
		}
	}
}
