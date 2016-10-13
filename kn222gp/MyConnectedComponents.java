package kn222gp;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {

	/*
	 * Returns a collection which in turn holds collections of nodes.
	 */
	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		Collection<Node<E>> nodes;
		List<Node<E>> dfsNodes;
		Collection<Collection<Node<E>>> nodesCollection = new HashSet<>(); // O(1)
		HashSet<Node<E>> visited = new HashSet<>(); // O(1)
		boolean connection;

		MyDFS<E> dfs = new MyDFS<E>(); // O(1)

		// Make an iterator of the graph and loop through it as long as there is a node to look at.
		Iterator<Node<E>> iterator = dg.iterator(); // O(1)
		while(iterator.hasNext()){ // O(n)
			connection = false;

			/* 
			 * If the node is not visited, do a depth-first search in the graph from that node.
			 * Save the returned list in a new collection.
			 */
			Node<E> node = iterator.next(); // O(1)
			if(!visited.contains(node)) { // O(1)
				dfsNodes = dfs.dfs(dg, node); // O(n + s)

				/*
				 * For each node in the new collection, check if that node is visited.
				 * If it is, then look through each collection and see if that node contains in one of them.
				 * If it is, then merge those collections, then set the connection to true.
				 * 
				 */
				for(Node<E> n: dfsNodes) { // O(n)
					if(visited.contains(n)) { // O(1)
						for(Collection<Node<E>> coll: nodesCollection) { // O(c)
							if(coll.contains(n)) { // O(1)
								connection = true; // O(1)
								visited.addAll(dfsNodes); // O(n)
								coll.addAll(dfsNodes); // O(n)  
							}
						}
					}
				}
				/*
				 * If there is no connection between the collections, mark all nodes in the new collection as visited
				 *  and add them to the collection-to-be-returned.
				 */
				if(!connection) { // O(1)
					visited.addAll(dfsNodes); // O(n)
					nodes = new HashSet<>(); // O(1)
					nodes.addAll(dfsNodes); // O(n)
					nodesCollection.add(nodes); // O(1)
				}
			}
		}
		return nodesCollection;
	}

}
