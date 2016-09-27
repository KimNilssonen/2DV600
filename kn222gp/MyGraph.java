package kn222gp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graphs.DirectedGraph;
import graphs.Node;

public class MyGraph<E> implements DirectedGraph<E>{
	
	private Map<E, MyNode<E>> graph = new HashMap<E, MyNode<E>>();
	private Set<Node<E>> _heads = new HashSet<>();
	private Set<Node<E>> _tails = new HashSet<>();

	@Override
	public Node<E> addNodeFor(E item) {
		if(item != null) {
			if(!graph.containsKey(item)) {
				MyNode<E> node = new MyNode<E>(item);
				_heads.add(node);
				_tails.add(node);
				return graph.put(item, node);
			}
			return graph.get(item);
		}
		else {
			throw new NullPointerException();
		}
	}

	@Override
	public Node<E> getNodeFor(E item) {
		if(item != null || !graph.containsKey(item)) {
			return graph.get(item);
		}
		else {
			throw new NullPointerException();
		}
	}

	@Override
	public boolean addEdgeFor(E from, E to) {
		if(from == null || to == null) {
			throw new NullPointerException();
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
			if(graph.containsKey(item)) {
				return true;
			}
			return false;
		}
		else {
			throw new NullPointerException();
		}
	}

	@Override
	public int nodeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Node<E>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Node<E>> heads() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int headCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Node<E>> tails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tailCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<E> allItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int edgeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeNodeFor(E item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdgeFor(E from, E to) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
