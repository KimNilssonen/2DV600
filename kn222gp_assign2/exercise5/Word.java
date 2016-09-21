package kn222gp_assign2.exercise5;

public class Word implements Comparable<Word> {
	private String _word;

	public Word(String str) {
		_word = str;
	}
	
	public String toString() {
		return _word; 
	}
	
	// Using code from slides (Hashing and Binary Search).
	@Override
	public int hashCode() { 
		int hashCode = 0;
		_word.toLowerCase();
		for ( int i = 0; i < _word.length(); i++) {
			char character = _word.charAt(i);
			hashCode += Character.getNumericValue(character); 
		}
		return hashCode;

	}
	
	// Using code from slides (Hashing and Binary Search).
	@Override
	public boolean equals(Object other) { 
		if(other instanceof Word) {
			Word otherWord = (Word)other;
			return _word.toLowerCase().equals(otherWord._word.toLowerCase());
		}
		return false;
	}
	
	/* Implement Comparable */
	@Override
	public int compareTo(Word w) { 
		//"compares two words lexicographically"
		return _word.compareToIgnoreCase(w.toString());
	}
}