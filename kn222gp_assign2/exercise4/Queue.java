package kn222gp_assign2.exercise4;

import java.util.Iterator;

public class Queue<E> implements QueueInterface<E> {
	private int _size = 0;
	private Node _head = null;
	private Node _tail = null;
	
	@Override
	public int size() {
		return _size;
	}
	
	// Check if the queue is empty.
	@Override
	public boolean isEmpty() {
		if(_size == 0) {
			return true;
		}
		return false;
	}
	
	// Add a new object at the end of the queue.
	@Override
	public void enqueue(E element) {
		if(_head == null) {
			_head = new Node(element);
			_tail = _head;
		}
		else {
			_tail.setNext(new Node(element));
			_tail = _tail.getNext();
		}
		_size++;
	}
	
	// Return and remove the first object in the queue.
	@Override
	public E dequeue() {
		if(_head == null) {
			throw new IndexOutOfBoundsException();
		}
		else {
			Node nodeToBeRemoved = _head;
			_head = nodeToBeRemoved.getNext();
			
			_size--;
			return nodeToBeRemoved.getElement();
		}
	}
	
	// Return first object in the queue (head).
	@Override
	public E first() {
		if(_head == null) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return _head.getElement();
		}
	}
	
	// Return last object in the queue (tail).
	@Override
	public E last() {
		if(_head == null) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return _tail.getElement();
		}
	}
	
	// Returns a new ListIterator.
	@Override
	public Iterator iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E> {
        private Node node = _head;
        
        @Override
        public boolean hasNext() {
            return node != null;
        }
        
        @Override
        public E next() {
        	
        	if(node == null){
        		throw new IndexOutOfBoundsException();
        	}
        	else{
        		E element = node.getElement();
                node = node.getNext();
                return element;
        	}
        }
    }
	
	private class Node {
		private Node _next = null;
		private E _element;
		
		public Node(E element) {
			_element = element;
		}
		
		public E getElement() {
			return _element;
		}
		
		public void setNext(Node element) {
			_next = element;
		}
		
		public Node getNext() {
			return _next;
		}
	}
}