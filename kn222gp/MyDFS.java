package kn222gp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyDFS<E> implements DFS<E> {

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		List<Node<E>> visited = new ArrayList<>();
		return dfsRecursive(graph, visited, root);
	}


	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		List<Node<E>> visited = new ArrayList<>();
		return dfsRecursive(graph, visited, null);
	}
	
	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		List<Node<E>> visited = new ArrayList<>();
		List<Node<E>> returnList = new ArrayList<>();
		return postOrderRecurv(visited, returnList, root);
	}



	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		Iterator<Node<E>> iterator = graph.iterator();
		
		while(iterator.hasNext()) {
			Node<E> source = iterator.next();
			Iterator<Node<E>> iterator2 = source.succsOf();
			while(iterator2.hasNext()) {
				if(iterator2.next().hasSucc(source)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		if(!isCyclic(graph)) {
			List<Node<E>> graphList = postOrder(graph);
			Node<E>[] sortArray = new Node[graph.nodeCount()];
			for(Node<E> node: graphList) {
				sortArray[graphList.size() - node.num] = node; // Place every node in it's appropriate place.
			}
			return Arrays.asList(sortArray);
		}
		else {
			throw new RuntimeException("Graph cannot be cyclic!");
		}
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		List<Node<E>> visitedList = new ArrayList<>();
		List<Node<E>> returnList = new ArrayList<>();
		Iterator<Node<E>> heads = g.heads();

		while(heads.hasNext()) {
			returnList = postOrderRecurv(visitedList, returnList, heads.next());
		}
		return returnList;
	}

	/*			--------------------------------
	 * 			--------- Help methods ---------
	 * 			--------------------------------
	 */

	/*
	 * Help method for dfs to call itself recursively.
	 */
	private List<Node<E>> dfsRecursive(DirectedGraph<E> graph, List<Node<E>> visitedList, Node<E> root) {		
		if(root != null) {
			Iterator<Node<E>> successors = root.succsOf();

			if(!visitedList.contains(root)) {
				visitedList.add(root);
				root.num = visitedList.size();
			}

			while(successors.hasNext()) {
				Node<E> node = successors.next();
				if(!visitedList.contains(node)) {
					visitedList.add(node);
					node.num = visitedList.size();
					dfsRecursive(graph, visitedList, node);
				}
			}
		}
		else {
			for(Node<E> node: graph) {
				if(!visitedList.contains(node)) {
					node.num = visitedList.size();
					visitedList.add(node);
					dfsRecursive(graph, visitedList, null);
				}
			}
		}
		return visitedList;
	}

	/*
	 *  Help method for postOrder.
	 */
	private List<Node<E>> postOrderRecurv (List<Node<E>> visitedList, List<Node<E>> returnList, Node<E> root) {
		if(root != null) {

			if(!visitedList.contains(root)) {
				Iterator<Node<E>> successors = root.succsOf();
				visitedList.add(root);

				while(successors.hasNext()) {
					Node<E> nextNode = successors.next();
					if(!returnList.contains(nextNode)) {
						postOrderRecurv(visitedList, returnList, nextNode);
					}
				}
				root.num = returnList.size()+1;
				returnList.add(root);
			}
		}
		return returnList;
	}
}
