package kn222gp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {

	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		Collection<Node<E>> nodes;
		List<Node<E>> dfsNodes;
		Collection<Collection<Node<E>>> nodesCollection = new HashSet<>();
		HashSet<Node<E>> visited = new HashSet<>(); 
		boolean connection;

		MyDFS<E> dfs = new MyDFS<E>();

		Iterator<Node<E>> iterator = dg.iterator();
		while(iterator.hasNext()){
			connection = false;

			Node<E> node = iterator.next();
			if(!visited.contains(node)) {
				dfsNodes = dfs.dfs(dg, node);

				for(Node<E> n: dfsNodes) {
					if(visited.contains(n)) {
						for(Collection<Node<E>> coll: nodesCollection) {
							if(coll.contains(n)) {
								connection = true;
								visited.addAll(dfsNodes);
								coll.addAll(dfsNodes);
							}
						}
					}

				}
				if(!connection) {
					visited.addAll(dfsNodes);
					nodes = new HashSet<>();
					nodes.addAll(dfsNodes);
					nodesCollection.add(nodes);
				}
			}
			visited.add(node);
		}
		return nodesCollection;
	}

}
