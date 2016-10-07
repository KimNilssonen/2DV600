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
		Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
		Collection<Node<E>> nodes = new HashSet<>();
		DFS<E> dfs = new MyDFS<E>();
		
		Iterator<Node<E>> iterator = dg.iterator();
		
		while(iterator.hasNext()){
			Node<E> node = iterator.next();
			nodes = dfs.dfs(dg, node);
			map.put(node, nodes);
		}
		return map;
	}

}
