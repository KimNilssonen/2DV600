package kn222gp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyBFS<E> implements BFS<E> {

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		HashSet<Node<E>> visitedList = new HashSet<>();
		List<Node<E>> returnList = new ArrayList<>();
		HashSet<Node<E>> hashSet = new HashSet<>(); 
		hashSet.add(root);

		return bfsRecursive(hashSet, visitedList, returnList);
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		List<Node<E>> returnList = new ArrayList<>(); // O(1)
		HashSet<Node<E>> visitedList = new HashSet<>(); // O(1)
		HashSet<Node<E>> hashSet = new HashSet<>(); // O(1)

		// If the graph does contains heads, iterate from the head.
		if(graph.headCount() > 0) { // O(1)
			Iterator<Node<E>> heads = graph.heads(); // O(1)
			while(heads.hasNext()) { // O(n)
				Node<E> node = heads.next(); // O(1)

				if(!visitedList.contains(node)) { // O(1)
					node.num = visitedList.size(); // O(1)
					visitedList.add(node); // O(1)
					hashSet.add(node); // O(1)
					returnList.add(node); // O(1)
					returnList = bfsRecursive(hashSet, visitedList, returnList); // O(1)
				}
			}
		}
		// Else start from the first node in the graph.
		else {
			hashSet.add(graph.getNodeFor(graph.allItems().get(0))); // O(1)
			returnList = bfsRecursive(hashSet, visitedList, returnList); // O(1)
		}
		return returnList;
	}

	/*
	 * -------------------------
	 * ------ Help method ------
	 * -------------------------
	 */

	private List<Node<E>> bfsRecursive(HashSet<Node<E>> hashSet, HashSet<Node<E>> visitedList, List<Node<E>> returnList) {		
		Iterator<Node<E>> hashSetIterator = hashSet.iterator(); // O(1)
		HashSet<Node<E>> newSet = new HashSet<>(); // O(1)

		while(hashSetIterator.hasNext()) { // O(n)
			Node<E> node = hashSetIterator.next(); // O(1)
			if(!visitedList.contains(node)) { // O(1)
				node.num = visitedList.size(); // O(1)
				visitedList.add(node); // O(1)
				returnList.add(node); // O(1)
			}

			Iterator<Node<E>> successors = node.succsOf(); // O(1)
			while(successors.hasNext()) { // O(s)
				Node<E> nextNode = successors.next(); // O(1)

				if(!visitedList.contains(nextNode)) { // O(1)
					newSet.add(nextNode); // O(1)
				}
			}
		}

		if(!newSet.isEmpty()) { // O(1)
			bfsRecursive(newSet, visitedList, returnList); // O(n)
		}

		return returnList;
	}
}
