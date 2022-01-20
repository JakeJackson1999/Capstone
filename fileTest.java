import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class fileTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please provide input file");
		
		String filename = scanner.nextLine();
		
		System.out.println("Your file is: " + filename);
	}
}
