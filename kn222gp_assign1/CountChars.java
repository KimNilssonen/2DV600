package kn222gp_assign1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountChars {

	public static void main(String[] args) {
		try {
			String filePath = args[0];
			if(!filePath.endsWith(".txt")){
				filePath += ".txt";
			}
			String file = filePath;
			readAndPrint(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readAndPrint(String file) throws FileNotFoundException{

		int upperCases = 0;
		int lowerCases = 0;
		int spaces = 0;
		int numbers = 0;
		int otherChars = 0;

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {

			String line;

			// Read each line until there is no more to read.
			while ((line = bufferReader.readLine()) != null) {

				char[] myChars = line.toCharArray();

				for (char c: myChars) {
					if(Character.isLowerCase(c)) {
						lowerCases++;
					}
					else if(Character.isUpperCase(c)) {
						upperCases++;
					}
					else if(Character.isWhitespace(c)) {
						spaces++;
					}
					else if(Character.isDigit(c)) {
						numbers++;
					}
					else {
						otherChars++;
					}
				} 
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		printToConsole("Upper cases      : " + upperCases);
		printToConsole("Lower cases      : " + lowerCases);
		printToConsole("Whitespaces      : " + spaces);
		printToConsole("Numbers          : " + numbers);
		printToConsole("Other characters : " + otherChars);
	}

	public static void printToConsole(String string){
		System.out.println(string);
	}

}
