package kn222gp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graphs.DirectedGraph;
import graphs.Node;
import kn222gp_assign2.exercise5.Word;

public class MyGraph<E> implements DirectedGraph<E>{

	private Map<E, MyNode<E>> _graph = new HashMap<E, MyNode<E>>();
	private Set<Node<E>> _heads = new HashSet<Node<E>>();
	private Set<Node<E>> _tails = new HashSet<Node<E>>();

	public MyGraph() {

	}

	@Override
	public Node<E> addNodeFor(E item) {
		if(item != null) {
			if(!_graph.containsKey(item)) {
				MyNode<E> node = new MyNode<E>(item);
				_heads.add(node);
				_tails.add(node);
				_graph.put(item, node);
			}
			return _graph.get(item);
		}
		else {
			throw new RuntimeException("Recieved_null_as_input");
		}
	}

	@Override
	public Node<E> getNodeFor(E item) {
		if(item == null || !_graph.containsKey(item)) {
			throw new RuntimeException("Recieved_null_as_input");
		}
		else {
			return _graph.get(item);
		}
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		if(from == null || to == null) {
			throw new RuntimeException("Recieved_null_as_input");
		}

		MyNode<E> source = (MyNode<E>) addNodeFor(from);
		MyNode<E> target = (MyNode<E>) addNodeFor(to); 

		if(source.hasSucc(target)) {
			return false;
		}
		else {
			source.addSucc(target);
			target.addPred(source);

			_tails.remove(source);
			_heads.remove(target);
		}
		return true;
	}

	@Override
	public boolean containsNodeFor(E item) {
		if(item != null) {
			if(_graph.containsKey(item)) {
				return true;
			}
			return false;
		}
		else {
			throw new RuntimeException("Recieved_null_as_input");
		}
	}

	@Override
	public int nodeCount() {
		return _graph.size();
	}

	@Override
	public Iterator<Node<E>> iterator() {
		return new nodeIterator();
	}

	@Override
	public Iterator<Node<E>> heads() {
		return _heads.iterator();
	}

	@Override
	public int headCount() {
		return _heads.size();
	}

	@Override
	public Iterator<Node<E>> tails() {
		return _tails.iterator();
	}

	@Override
	public int tailCount() {
		return _tails.size();
	}

	@Override
	public List<E> allItems() {
		ArrayList<E> list = new ArrayList<E>();
		for(MyNode<E> node: _graph.values()) {
			list.add(node.item());		
		}
		return list;
	}

	@Override 
	public int edgeCount() {
		int edges = 0;
		for(Node<E> node: _graph.values()) {
			edges += node.outDegree();
		}
		return edges;
	}

	@Override
	public void removeNodeFor(E item) { 
		if(item == null || !_graph.containsKey(item)) {
			throw new RuntimeException("Recieved_null_as_input");
		}
		MyNode<E> nodeToBeRemoved = _graph.get(item);
		for(MyNode<E> node: _graph.values()) {
			if(node.hasSucc(nodeToBeRemoved)) {
				node.removeSucc(nodeToBeRemoved);
			}
			if(node.hasPred(nodeToBeRemoved)) {
				node.removePred(nodeToBeRemoved);
			}
		}

		nodeToBeRemoved.disconnect();
		_graph.remove(item);
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		if(from == null || to == null) {
			throw new RuntimeException("Recieved_null_as_input");
		}
		else { 
			if(_graph.containsKey(from) && _graph.containsKey(to)){
				if(_graph.get(from).hasSucc(_graph.get(to))) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		if(from == null || to == null) {
			throw new RuntimeException("Recieved_null_as_input");
		}
		if(containsEdgeFor(from, to)) {
			MyNode<E> fromNode = _graph.get(from);
			MyNode<E> toNode = _graph.get(to);
			fromNode.removeSucc(toNode);
			toNode.removePred(fromNode);

			if(fromNode.isHead()){
				_heads.add(fromNode);
			}
			else if(fromNode.isTail()) {
				_tails.add(fromNode);
			}
			if(toNode.isHead()) {
				_heads.add(toNode);
			}
			else if(toNode.isTail()) {
				_tails.add(toNode);
			}

			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String string = "";
		Iterator iterator = iterator();
		while(iterator.hasNext()) {
			string += iterator.next() + " ";
		}
		return string;
	}

	/*
	 * Using a iterator class so that I can cast the next value of the iterator (iterator.next) to a Node<E>.
	 */
	@SuppressWarnings ("unchecked")
	private class nodeIterator implements Iterator<Node<E>> {

		Iterator iterator = _graph.values().iterator();

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public Node<E> next() {
			return (Node<E>)iterator.next();
		}
	}
}
