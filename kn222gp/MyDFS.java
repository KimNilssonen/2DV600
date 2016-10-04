package kn222gp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.event.IIOReadWarningListener;

import org.w3c.dom.css.Counter;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyDFS<E> implements DFS<Integer> {
	private int counter = 0;

	@Override
	public List<Node<Integer>> dfs(DirectedGraph<Integer> graph, Node<Integer> root) {
		List<Node<Integer>> visited = new ArrayList<>();
		return dfsRecursive(graph, visited, root);
	}


	@Override
	public List<Node<Integer>> dfs(DirectedGraph<Integer> graph) {
		List<Node<Integer>> visited = new ArrayList<>();
		return dfsRecursive(graph, visited, null);
	}
	@Override
	public List<Node<Integer>> postOrder(DirectedGraph<Integer> g, Node<Integer> root) {
		List<Node<Integer>> visited = new ArrayList<>();
		return postOrderRecurv(g, visited, root);
	}



	@Override
	public List<Node<Integer>> postOrder(DirectedGraph<Integer> g, boolean attach_dfs_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCyclic(DirectedGraph<Integer> graph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Node<Integer>> topSort(DirectedGraph<Integer> graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node<Integer>> postOrder(DirectedGraph<Integer> g) {
		List<Node<Integer>> visited = new ArrayList<>();
		return postOrderRecurv(g, visited, null);
	}

	/*			--------------------------------
	 * 			--------- Help methods ---------
	 * 			--------------------------------
	 */

	/*
	 * Help method for dfs to call itself recursively.
	 */
	private List<Node<Integer>> dfsRecursive(DirectedGraph<Integer> graph, List<Node<Integer>> visitedList, Node<Integer> root) {		
		if(root != null) {
			Iterator<Node<Integer>> successors = root.succsOf();

			if(!visitedList.contains(root)) {
				visitedList.add(root);
				root.num = visitedList.size();
			}

			while(successors.hasNext()) {
				Node<Integer> node = successors.next();
				if(!visitedList.contains(node)) {
					visitedList.add(node);
					node.num = visitedList.size();
					dfsRecursive(graph, visitedList, node);
				}
			}
		}
		else {
			for(Node<Integer> node: graph) {
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
	private List<Node<Integer>> postOrderRecurv (DirectedGraph<Integer> graph, List<Node<Integer>> visitedList, Node<Integer> root) {
		if(root != null) {
			Iterator<Node<Integer>> successors = root.succsOf();

			while(successors.hasNext()) {
				Node<Integer> node = successors.next();
				if(!visitedList.contains(node)) {
					node.num = counter++;
					visitedList.add(node);
					postOrderRecurv(graph, visitedList, node);
				}
			}
			if(!visitedList.contains(root)) {
				root.num = counter++;
				visitedList.add(root);
			}
		}
		
		//		else {
		//			Iterator<Node<Integer>> successors = graph.iterator();
		//			Node<Integer> node = null;
		//			while(successors.hasNext()) {
		//				node = successors.next();
		//
		//				if(!visitedList.contains(node)) {
		//					postOrderRecurv(graph, visitedList, node);
		//				}
		//			}
		//			if(node != null && !visitedList.contains(node)) {
		//				visitedList.add(node);
		//				node.num = visitedList.size();
		//			}
		//		}
		System.out.println(visitedList.toString());
		return visitedList;
	}
}
