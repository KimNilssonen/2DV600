package kn222gp_assign2.exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount2Main {
	private static String _path = "";
	private static HashWordSet _hashWordSet = new HashWordSet();
	private static TreeWordSet _treeWordSet = new TreeWordSet();

	public static void main(String[] args) {

		// Read txt file.
		try {
			_path = args[0];
			if(!_path.endsWith(".txt")){
				_path += ".txt";
			}
			readFile(_path);
			System.out.println("HashWordSet size: " + _hashWordSet.size());
			System.out.println("TreeWordSet size: " + _treeWordSet.size());		
			
			hashWordSet();
			System.out.println("\n---End of hashWordSet | Start of treeWordSet---\n");
			treeWordSet();
			
			System.exit(0);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Method that handles reading of file.
	public static void readFile(String file) throws FileNotFoundException{
		File fileToScan = new File(file);
		Scanner scanner = new Scanner(fileToScan);
		String line = "";

		// Add each word to both sets as long as there is something to add.
		while(scanner.hasNext()){
			Word word = new Word(scanner.next());
			_hashWordSet.add(word);
			_treeWordSet.add(word);
		}
		scanner.close();
	}
	
	public static void hashWordSet() {
		try {
			System.out.println(_hashWordSet.toString());
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void treeWordSet() {
		try {		
			System.out.println(_treeWordSet.toString());
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
