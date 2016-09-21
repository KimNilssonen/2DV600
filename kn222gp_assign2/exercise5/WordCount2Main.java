package kn222gp_assign2.exercise5;

public class WordCount2Main {
	
	public static void main(String[] args) {
		HashWordSet _hashWordSet = new HashWordSet();

		_hashWordSet.add(new Word("Hello"));
		_hashWordSet.add(new Word("hello"));
		_hashWordSet.add(new Word("apa"));
		_hashWordSet.add(new Word("Kiosk"));
		
		System.out.println(_hashWordSet.toString());
		System.out.println(_hashWordSet.size());
	}

}
