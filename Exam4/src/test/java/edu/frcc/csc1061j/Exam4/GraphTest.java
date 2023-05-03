package edu.frcc.csc1061j.Exam4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.frcc.csc1061j.Exam4.Graph;
import edu.frcc.csc1061j.Exam4.Graph.Vertex;

public class GraphTest {

	public static void main(String[] args) {
		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			vertices.add(i);
		}

		// Edges for MST
		Integer[][] edges = {
				{0, 1, 5}, {0, 2, 4}, 
				{1, 0, 5}, {1, 2, 2}, {1, 5, 3},
				{2, 0, 4}, {2, 1, 2}, {2, 5, 4}, {2, 3, 5},
				{3, 2, 5}, {3, 5, 6}, {3, 4, 7},
				{4, 3, 7}, {4, 5, 8},
				{5, 1, 3}, {5, 2, 4}, {5, 3, 6}, {5, 4, 8}
		};

		Graph<Integer> graph = new Graph<>(vertices, edges);
		System.out.println("Original Graph:");
		graph.printEdges();
		
		Graph<Integer> graph1 = new Graph<>(Arrays.asList(0, 1, 2, 3, 4, 5), 
		    		new Integer[][]{{0, 1, 1}, {0, 2, 1}, {1, 3, 1}, {1, 4, 1}, {2, 4, 1}, {3, 5, 1}, {4, 5, 1}});
		    
	    System.out.println("BFS test:");
	    List<Integer> bfsList = graph.bfs(graph.vertices.get(0));
	    for (Integer i : bfsList) 
	    {
	        System.out.print(i + " ");
	    }
	    System.out.println();
	    
	    System.out.println("DFS test:");
	    List<Graph<Integer>.Vertex> dfsList = graph.dfs(graph.vertices.get(0));
	    for (Graph<Integer>.Vertex v : dfsList) {
	        System.out.print(v + " ");
	    }
	    System.out.println();

		
		
	    Graph<Integer> mst = graph.findMinimumSpanningTree();
	    System.out.println("Minimum Spanning Tree:");
	    mst.printEdges();
		
	}


}
