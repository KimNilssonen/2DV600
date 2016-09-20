package kn222gp_assign2.exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdentifyWordsMain {
	private static String _path = "";
	private static String _words;
	public static void main(String[] args) {

		// Read txt file.
		try {
			_path = args[0];
			if(!_path.endsWith(".txt")){
				_path += ".txt";
			}
			_words = readFile(_path);
			System.out.println(_words);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Create new txt file.
		try {
			createFile();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method that handles reading of file.
	public static String readFile(String file) throws FileNotFoundException{
		File fileToScan = new File(file);
		Scanner scanner = new Scanner(fileToScan);
		String line = "";
		String contentToBeSaved = "";
		while(scanner.hasNext()){
			line += scanner.nextLine() + "\n";
		}
		char[] charArr = line.toCharArray();
		for(Character character : charArr){
			if(Character.isWhitespace(character) || Character.isLetter(character)) {
				contentToBeSaved += character;
			}	
		}
		scanner.close();
		return contentToBeSaved;
	}

	// Creating the new txt file.
	public static void createFile() throws IOException {
		File file = new File(_path);
		PrintWriter writer = new PrintWriter(file.getParentFile().getPath()+"/words.txt", "UTF-8");
		writer.print(_words);
		writer.close();
	}
}
