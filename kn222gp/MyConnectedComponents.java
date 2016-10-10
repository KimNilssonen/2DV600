package kn222gp;

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

		// Make an iterator of the graph and loop through it as long as there is a node to look at.
		Iterator<Node<E>> iterator = dg.iterator();
		while(iterator.hasNext()){
			connection = false;

			/* 
			 * If the node is not visited, do a depth-first search in the graph from that node.
			 * Save the returned list in a new collection.
			 */
			Node<E> node = iterator.next();
			if(!visited.contains(node)) {
				dfsNodes = dfs.dfs(dg, node);

				/*
				 * For each node in the new collection, check if that node is visited.
				 * If it is, then look through each collection and see if that node contains in one of them.
				 * If it is, then merge those collections, then set the connection to true.
				 * 
				 */
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
				/*
				 * If there is no connection between the collections, mark all nodes in the new collection as visited
				 *  and add them to the collection-to-be-returned.
				 */
				if(!connection) {
					visited.addAll(dfsNodes);
					nodes = new HashSet<>();
					nodes.addAll(dfsNodes);
					nodesCollection.add(nodes);
				}
			}
		}
		return nodesCollection;
	}

}
