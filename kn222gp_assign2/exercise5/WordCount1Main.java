package kn222gp_assign2.exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
	private static String _path = "";
	private static HashSet<Word> _hashSet = new HashSet<>();
	private static TreeSet<Word> _treeSet = new TreeSet<>();
	
	public static void main(String[] args) {

		// Read txt file.
		try {
			_path = args[0];
			if(!_path.endsWith(".txt")){
				_path += ".txt";
			}
			readFile(_path);
			System.out.println("HashSet size: " + _hashSet.size());
			System.out.println("TreeSet size: " + _treeSet.size());
			
			// Iterates over the tree and prints out each word.
			Iterator<Word> treeIterator = _treeSet.iterator();
			while(treeIterator.hasNext()) {
				System.out.println(treeIterator.next());
			}
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
			_hashSet.add(word);
			_treeSet.add(word);
		}
		scanner.close();
	}
}
