package kn222gp;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
		Map<Node<E>, Collection<Node<E>>> map = new HashMap<>(); // O(1)
		Collection<Node<E>> nodes = new HashSet<>(); // O(1)
		DFS<E> dfs = new MyDFS<E>(); // O(1)
		
		Iterator<Node<E>> iterator = dg.iterator(); // O(1)
		
		while(iterator.hasNext()){ // O(n)
			Node<E> node = iterator.next(); // O(1)
			nodes = dfs.dfs(dg, node); // O(n+s)
			map.put(node, nodes); // O(1)
		}
		return map;
	}

}
