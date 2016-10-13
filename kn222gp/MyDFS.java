package kn222gp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

public class MyDFS<E> implements DFS<E> {

	/*
	 * This method calls the dfsRecursive method which returns a list of all nodes in a depth first order.
	 * 		The dfsRecursive method calls itself until the graph has no more nodes to search through.
	 * This methods takes a node as a parameter and sets it as start node to search from.
	 * Returns a list sorted as depth first.
	 */
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		List<Node<E>> returnList = new ArrayList<>();
		HashSet<Node<E>> hashSet = new HashSet<>(); 
		return dfsRecursive(returnList, root, hashSet);
	}

	/*
	 * This method calls the dfsRecursive method which returns a list of all nodes in a depth first order.
	 * 		The dfsRecursive method calls itself until the graph has no more nodes to search through.
	 *  This method does not take a node as a parameter to start the search from so it takes a head node if
	 *   	there is one, otherwise it takes a random node as start node.
	 *   Returns a list sorted as depth first.
	 */
	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		List<Node<E>> returnList = new ArrayList<>(); // O(1)
		HashSet<Node<E>> hashSet = new HashSet<>();  // O(1)

		if(graph.headCount() > 0) {
			Iterator<Node<E>> heads = graph.heads(); // O(1)
			while(heads.hasNext()) { // O(n)
				returnList = dfsRecursive(returnList, heads.next(), hashSet); // O(1)
			}
		}
		else {
			returnList = dfsRecursive(returnList, graph.getNodeFor(graph.allItems().get(0)), hashSet); // O(1)
		}
		return returnList;
	}

	/*
	 * This method calls the postOrderRecursive method which returns a list of all nodes in a post order.
	 * 		The dfsRecursive method calls itself until the graph has no more nodes to search through.
	 * This methods takes a node as a parameter and sets it as start node to search from.
	 * Returns a list sorted as post order.
	 */
	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		HashSet<Node<E>> visited = new HashSet<>();
		List<Node<E>> returnList = new ArrayList<>();
		return postOrderRecurv(visited, returnList, root);
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * This method checks if the graph is cyclic by checking if a node has a successor to itself.
	 * Returns true if the graph is cyclic.
	 */
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

	/*
	 * This method sorts the graph to a topological order as long as the graph is not cyclic.
	 * 	Top sort means that for every directed edge nm from node n to node m, n comes before m in the ordering.
	 * Returns a list sorted as topological.
	 */
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

	/*
	 * This method calls the postOrderRecursive method which returns a list of all nodes in a post order.
	 * 		The postOrderRecursive method calls itself until the graph has no more nodes to search through.
	 *  This method does not take a node as a parameter to start the search from so it takes a head node as start node.
	 *  Returns a list sorted as post order.
	 */	
	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		HashSet<Node<E>> visitedList = new HashSet<>();
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
	 * Returns a list sorted as depth first.
	 */
	private List<Node<E>> dfsRecursive(List<Node<E>> returnList, Node<E> root, HashSet<Node<E>> setOfNodes) {		
		Iterator<Node<E>> successors = root.succsOf(); // O(1)

		root.num = returnList.size(); // O(1)
		returnList.add(root); // O(1)
		setOfNodes.add(root); // O(1)


		while(successors.hasNext()) { // O(s)
			Node<E> node = successors.next(); // O(1)
			if(!setOfNodes.contains(node)) { // O(1)
				dfsRecursive(returnList, node, setOfNodes); // O(n)
			}
		}
		return returnList;
	}

	/*
	 *  Help method for postOrder.
	 *  Returns a list sorted as post order.
	 */
	private List<Node<E>> postOrderRecurv (HashSet<Node<E>> visitedList, List<Node<E>> returnList, Node<E> root) {
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
