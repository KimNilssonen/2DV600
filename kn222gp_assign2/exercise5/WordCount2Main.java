package kn222gp_assign2.exercise5;

import java.util.Iterator;

public class WordCount2Main {
	
	public static void main(String[] args) {

		/*
		 * HashWordSet
		 */

		System.out.println("Hash:\n");
		HashWordSet hashWordSet = new HashWordSet();
		
		// Hello
		hashWordSet.add(new Word("Hello"));
		hashWordSet.add(new Word("hello"));
		hashWordSet.add(new Word("heoll"));
		
		// Apa
		hashWordSet.add(new Word("Apa"));
		hashWordSet.add(new Word("apa"));
		
		// Test
		hashWordSet.add(new Word("Test"));
		hashWordSet.add(new Word("test"));
		hashWordSet.add(new Word("Ttes"));
		
		Iterator<Word> iterator = hashWordSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("HashWordSet size: " + hashWordSet.size());
		
		
		/*
		 * TreeWordSet
		 */
		
		System.out.println("\n\nTree:\n");
		TreeWordSet treeWordSet = new TreeWordSet();
		
		// Scrambled alphabet.
		treeWordSet.add(new Word("m"));
		treeWordSet.add(new Word("g"));
		treeWordSet.add(new Word("d"));
		treeWordSet.add(new Word("q"));
		treeWordSet.add(new Word("v"));
		treeWordSet.add(new Word("n"));
		treeWordSet.add(new Word("j"));
		treeWordSet.add(new Word("e"));
		treeWordSet.add(new Word("r"));
		treeWordSet.add(new Word("f"));
		treeWordSet.add(new Word("z"));
		treeWordSet.add(new Word("t"));
		treeWordSet.add(new Word("o"));
		treeWordSet.add(new Word("k"));
		treeWordSet.add(new Word("l"));
		treeWordSet.add(new Word("a"));
		treeWordSet.add(new Word("b"));
		treeWordSet.add(new Word("x"));
		treeWordSet.add(new Word("s"));
		treeWordSet.add(new Word("i"));
		treeWordSet.add(new Word("c"));
		treeWordSet.add(new Word("h"));
		treeWordSet.add(new Word("y"));
		treeWordSet.add(new Word("u"));
		treeWordSet.add(new Word("w"));
		treeWordSet.add(new Word("p"));
		
		
		Iterator<Word> iterator2 = treeWordSet.iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
		
		System.out.println("TreeWordSet size: " + treeWordSet.size());
		//System.out.println("TreeWordSet contains: " + treeWordSet.contains(new Word("Righty")));
	}

}
