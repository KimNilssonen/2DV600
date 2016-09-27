package kn222gp_assign2.exercise5;

import java.util.Iterator;

public class TreeWordSet implements WordSet{

	private Node _root = null;
	private int _size = 0;

	@Override
	public void add(Word word) {
		if(_root == null) {
			_root = new Node(word);
		}
		else if(!contains(word)) {
			_root.add(word);
		}
		else {
			return; // if the tree contains the word, stop here so the size doesn't increase.
		}
		_size++;
	}

	@Override
	public boolean contains(Word word) {
		if(_root != null) {
			return _root.contains(word);
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		return _size;
	}
	
	@Override
	public String toString() {
		
		Iterator<Word> treeWordSetIterator = iterator();
		String string = "";
		string += "\nTREE:\n";
		while(treeWordSetIterator.hasNext()){
			string += treeWordSetIterator.next() + "\n";
		}
		return string;
	}

	@Override
	public Iterator iterator() {
		return new TreeIterator();
	}

	private class TreeIterator implements Iterator<Word> {
		private Node node = null;

		public TreeIterator() {			
			node = _root;
			while(node.left != null) {
				Node temp = node;
				node = node.left;
				node.parent = temp;
			}
		}

		@Override
		public boolean hasNext() {
			return node != null;
		}

		/*
		 * Collaborated this solution with Filip Rydberg (fr222cy).
		 */
		@Override
		public Word next() {    
			node.visited = true;
			Node toBeReturned = node;

			if(node.right != null) {
				node = node.right;
				if(node.parent == null) {
					node.parent = toBeReturned;
				}
				while(node.left != null) {
					Node temp = node;
					node = node.left;
					node.parent = temp;
				}
			}
			else {
				/*
				 * Noticed that I could only iterate once since each node value had been set to visited.
				 * 	A temporary node is my solution to this problem. Maybe not the best, but it does the job.
				 */
				while(node.visited) {
					Node temp = node;
					node.visited = false;
					if(node.parent == null) {
						node = null;
						break;
					}
					node = temp.parent;
				}
			}
			return toBeReturned.word;
		}
	}

	private class Node {
		Word word;
		Node left = null;
		Node right = null;
		Node parent = null;
		boolean visited = false;

		private Node (Word w) {
			word = w;
		}

		private void add(Word w) {
			if(w.compareTo(word) < 0) {
				if(left == null) {
					left = new Node(w);
				}
				else {
					left.add(w);
				}
			}
			else if(w.compareTo(word) > 0) {
				if(right == null) {
					right = new Node(w);
				}
				else {
					right.add(w);
				}
			}
		}

		private boolean contains(Word w) {
			if(w.compareTo(word) < 0) {
				if(left == null) {
					return false;
				}
				else {
					return left.contains(w);
				}
			}
			else if(w.compareTo(word) > 0) {
				if(right == null) {
					return false;
				}
				else {
					return right.contains(w);
				}
			}
			return true;
		}
	}
}

