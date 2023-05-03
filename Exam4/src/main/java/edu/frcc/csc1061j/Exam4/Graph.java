package edu.frcc.csc1061j.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	
	public class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();
		
		public Vertex (E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}
		
		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;
			
			if (elem.equals(((Vertex)other).elem)) {
				return true;
			}
			return false;		
		}
		
		@Override 
		public String toString() {
			return elem.toString();
		}
	}

	
	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) { // use this constructor for the spanning tree
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}
	
	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {
		
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for(Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}
	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int)edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}
	
	/* TODO: Implement the DFS algorithm for a graph either recursively
	** or iteratively using a stack. It should return a list of all the 
	** vertices in the pre-order depth-first traversal.
	*/
	public List<Vertex> dfs(Vertex root) {
		// label v as discovered
		// for all directed edges from v to w that are in G.adjacentEdges(v) do
			// if vertex w is not labeled as discovered then
				// recursively call dfs(G, w)
		List<Vertex> discovered = new ArrayList<>();
		Stack<Vertex> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty())
		{
			Vertex v = stack.pop();
			
			if (!discovered.contains(v)) 
			{
	            discovered.add(v);
	            for (Vertex w : getChildNodes(v)) 
	            {
	                stack.push(w);
	            }
	        }
		}
		 
		 
		// or
		
		// let S be a stack
		// S.push(v)
		// while S is not empty do
			// v = S.pop()
			// if v is not labeled as discovered then
				// label v as discovered
				// for all edges from v to w in G.adjacentedges(v) do
					//S.pop(w) 
		
		return discovered;
	}

	/* TODO: Implement the BFS algorithm for a graph. It should return a list 
	** of all the vertices in the breadth-first traversal.
	*/
	public List<E> bfs(Vertex root) {
		// Let Q be a queue
		// label root as explored
		// Q.enqueue(root)
		// while Q is not empty do
			// v := Q.dequeue()
			// if v is the goal then
				//return v
			// for all edges from v to w in G.adjecentEdges(v) do
				// if w is not labeled as explored then
					// label w as explored
					// Q.enqueue(w)
		
		LinkedList<E> explored = new LinkedList<>();
		Queue<Vertex> queue = new LinkedList<>();
		explored.add(root.getKey());
		
		queue.offer(root);
		
		while (!queue.isEmpty())
		{
			Vertex v = queue.poll();
			
			for (Vertex w : getChildNodes(v))
			{
				if (!explored.contains(w.getKey()))
				{
					explored.add(w.getKey());
					queue.offer(w);
				}
			}
		}
		return explored;
	}
	

	/* TODO: Create a spanning tree using Kruskal's Algorithm and return it. 
	** The spanning tree will be a new graph
	*/
	public Graph<E> findMinimumSpanningTree() {		
	    List<Edge> edges = new ArrayList<>();
	    for (Vertex vertex : vertices) 
	    {
	        edges.addAll(vertex.neighbors);
	    }
	    Collections.sort(edges);

	    List<Vertex> mstVertices = new ArrayList<>();
	    for (Vertex vertex : vertices) 
	    {
	        mstVertices.add(new Vertex(vertex.getKey()));
	    }
	    
	    Graph<E> mstGraph = new Graph<E>(mstVertices);

	    for (Edge edge : edges) 
	    {
	        Graph<E>.Vertex source = mstGraph.findVertex(edge.s.getKey());
	        Graph<E>.Vertex destination = mstGraph.findVertex(edge.d.getKey());
	        List<Graph<E>.Vertex> sPath = mstGraph.dfs(source);
	        if (sPath.contains(destination)) 
	        {
	            continue;
	        }

	        Graph<E>.Edge mstEdge = new Edge(source, destination, edge.weight);
	        mstGraph.addEdge(mstEdge);
	    }

	    return mstGraph;
	}
}
