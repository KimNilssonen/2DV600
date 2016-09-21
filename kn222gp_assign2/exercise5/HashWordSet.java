package kn222gp_assign2.exercise5;

import java.util.Iterator;

public class HashWordSet implements WordSet{
	private int _size;
	private Node[] buckets = new Node[8];

	@Override
	public Iterator iterator() {
		return new HashIterator();
	}

	@Override
	public void add(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];

		while(node != null) {
			if(node.value.equals(word)) {
				return;		// Returns because node was found.
			}
			else {
				node = node.next;
			}
		}

		node = new Node(word);
		node.next = buckets[pos];
		buckets[pos] = node;
		_size++;

		if(_size == buckets.length) {
			rehash();
		}
	}

	@Override
	public boolean contains(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		
		while(node != null) {
			if(node.value.equals(word)) {
				return true;		// Returns because node was found.
			}
			else {
				node = node.next;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return _size;
	}
	
	public String toString() {
		String string = "";
		for(Node node: buckets) {
			if(node != null) {
				string += node.toString() + "\n";
			}			
		}
		return string;
	}

	// Code from slides (Hashing and Binary Search Trees).
	private void rehash() {
		Node[] temp = buckets; // Copy of old buckets
		buckets = new Node[2*temp.length]; // New empty buckets
		_size = 0;
		for (Node node : temp) { // Insert old values into new buckets
			if (node == null) continue; // Empty bucket
			while (node != null ) {
				add(node.value ); // Add elements again
				node = node.next;
			}
		}
	}
	
	private int getBucketNumber(Word word) {
		int hashCode = word.hashCode();
		if(hashCode < 0) {
			hashCode = -hashCode;
		}
		return hashCode % buckets.length;
	}
	
	private class HashIterator implements Iterator<Word> {
		private Node node = null;
        
        public HashIterator() {
        	for(int i = 0; i < buckets.length; i++) {
        		if(buckets[i] != null) {
        			node = buckets[i];
        			break;
        		}
        	}
		}
        
        @Override
        public boolean hasNext() {
            return node != null;
        }
        
        @Override
        public Word next() {
        	if(node == null){
        		throw new IndexOutOfBoundsException();
        	}
        	else{
        		for(int i = getBucketNumber(node.value); i < buckets.length; i++) {
        			node.next = node;
        		}
                return node.next.value;
        	}
        }
    }

	private class Node {
		Word value;
		Node next = null;

		public Node (Word word) {
			value = word;
		}

		public String toString() {
			return value.toString();
		}
	}
}
