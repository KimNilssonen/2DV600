package kn222gp;


public class DFSTester {

	public static void main(String[] args) {
		
		MyDFS dfs = new MyDFS<>();
		MyBFS bfs = new MyBFS<>();
		MyGraph<String> graph = new MyGraph<>();

		graph.addEdgeFor("a", "b");
		graph.addEdgeFor("b", "c");
		graph.addEdgeFor("c", "d");
		graph.addEdgeFor("c", "e");
		graph.addEdgeFor("c", "f");
		graph.addEdgeFor("c", "g");
		graph.addEdgeFor("f", "h");
		
		graph.addEdgeFor("a", "d");
		graph.addEdgeFor("i", "h");
		graph.addEdgeFor("h", "j");
		graph.addEdgeFor("j", "k");
		graph.addEdgeFor("k", "l");
		
		System.out.println("dfs graph: " + dfs.dfs(graph));
		System.out.println();
		System.out.println("dfs graph node: " + dfs.dfs(graph, graph.getNodeFor("c")));
		System.out.println();
		System.out.println("postOrder node: " + dfs.postOrder(graph, graph.getNodeFor("c")));
		System.out.println();
		System.out.println("postOrder: " + dfs.postOrder(graph));
		System.out.println();
		System.out.println("topSort: " + dfs.topSort(graph));
		
		System.out.println();
		System.out.println("bfs graph: " + bfs.bfs(graph));
		System.out.println();
		System.out.println("bfs graph node: " + bfs.bfs(graph, graph.getNodeFor("c")));
		System.out.println();
		
		
		

	}

}