package kn222gp_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountJava {

	public static void main(String[] args) {
		try {

			String directory = args[0];
			File folder = new File(directory);

			System.out.println("Reading from root directory: " + directory);
			listFilesInDirectory(folder);

		} 
		catch (FileNotFoundException e) {
			System.out.println("Error reading file!");
		}
	}

	public static void listFilesInDirectory(File folder) throws FileNotFoundException{
		for(File file: folder.listFiles()) {
			if(file.isDirectory()) {
				listFilesInDirectory(file);
			}
			else{
				if(file.getName().contains(".java")){
					int amountOfLines = scanFileForLines(file);
					printToConsole(file.getName(), amountOfLines);
				}
			}
		}
	}

	public static int scanFileForLines(File file) {
		int amountOfLines = 1;
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				scanner.nextLine();
				amountOfLines++;
			}
			scanner.close();
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return amountOfLines;
	}

	public static void printToConsole(String string, int amountOfLines){
		System.out.println(string + " - Lines: " + amountOfLines);
	}

}