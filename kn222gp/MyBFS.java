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
		List<Node<E>> returnList = new ArrayList<>();
		HashSet<Node<E>> visitedList = new HashSet<>();
		HashSet<Node<E>> hashSet = new HashSet<>();;

		// If the graph does contains heads, iterate from the head.
		if(graph.headCount() > 0) {
			Iterator<Node<E>> heads = graph.heads();
			while(heads.hasNext()) {
				Node<E> node = heads.next();

				if(!visitedList.contains(node)) {
					node.num = visitedList.size();
					visitedList.add(node);
					hashSet.add(node);
					returnList.add(node);
					returnList = bfsRecursive(hashSet, visitedList, returnList);
				}
			}
		}
		// Else start from the first node in the graph.
		else {
			hashSet.add(graph.getNodeFor(graph.allItems().get(0)));
			returnList = bfsRecursive(hashSet, visitedList, returnList);
		}
		return returnList;
	}

	/*
	 * -------------------------
	 * ------ Help method ------
	 * -------------------------
	 */

	private List<Node<E>> bfsRecursive(HashSet<Node<E>> hashSet, HashSet<Node<E>> visitedList, List<Node<E>> returnList) {		
		Iterator<Node<E>> hashSetIterator = hashSet.iterator();
		HashSet<Node<E>> newSet = new HashSet<>();

		while(hashSetIterator.hasNext()) {
			Node<E> node = hashSetIterator.next();
			if(!visitedList.contains(node)) {
				node.num = visitedList.size();
				visitedList.add(node);
				returnList.add(node);
			}

			Iterator<Node<E>> successors = node.succsOf();
			while(successors.hasNext()) {
				Node<E> nextNode = successors.next();

				if(!visitedList.contains(nextNode)) {
					newSet.add(nextNode);
				}
			}
		}

		if(!newSet.isEmpty()) {
			bfsRecursive(newSet, visitedList, returnList);
		}

		return returnList;
	}
}
