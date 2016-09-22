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
	public Iterator iterator() {
		return new TreeIterator();
	}

	private class TreeIterator implements Iterator<Word> {
		private Node node = null;

		public TreeIterator() {
			node = _root;
			while(node.left != null) {
				//Node temp = node;
				node = node.left;
				//node.parent = temp;
			}
		}

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Word next() {    
			Word toBeReturned = node.word;

			if(node.right != null) {
				node = node.right;
				while(node.left != null) {
					node = node.left;
				}
				return toBeReturned;
			}
			if(node.parent == null){
				node = null;
				return toBeReturned;
			}
			if(node.parent.left == node){
				node = node.parent;
				return toBeReturned;
			}
			node = node.parent;
			return toBeReturned;

		}

	}

	private class Node {
		Word word;
		Node left = null;
		Node right = null;
		Node parent = null;

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

