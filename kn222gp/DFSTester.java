package kn222gp;


public class DFSTester {

	public static void main(String[] args) {
		
		MyDFS dfs = new MyDFS<>();
		MyGraph<String> graph = new MyGraph<>();

		graph.addEdgeFor("a", "b");
		graph.addEdgeFor("b", "c");
		graph.addEdgeFor("c", "d");
		graph.addEdgeFor("c", "e");
		graph.addEdgeFor("c", "f");
		graph.addEdgeFor("c", "g");
		graph.addEdgeFor("f", "h");
		
		System.out.println("dfs graph: " + dfs.dfs(graph));
		System.out.println();
		System.out.println("dfs graph node: " + dfs.dfs(graph, graph.getNodeFor("c")));
		System.out.println();
		System.out.println("postOrder node: " + dfs.postOrder(graph, graph.getNodeFor("c")));
		System.out.println();
		System.out.println("postOrder: " + dfs.postOrder(graph));
		System.out.println();
		System.out.println("topSort: " + dfs.topSort(graph));
		

	}

}
