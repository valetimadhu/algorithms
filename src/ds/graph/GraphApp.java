package ds.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphApp {

	public static void dfs(GraphWAdjMtrx g) {
		Stack stack = new Stack();
		g.vertexList[0].wasVisited = true;
		g.displayVertex(0);
		stack.push(0);
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(g, (int) stack.peek());
			if (v == -1)
				stack.pop();
			else {
				g.vertexList[v].wasVisited = true;
				g.displayVertex(v);
				stack.push(v);
			}
		}
		for (int j = 0; j < g.nVerts; j++)
			g.vertexList[j].wasVisited = false;
	}

	public static int getAdjUnvisitedVertex(GraphWAdjMtrx g, int v) {
		for (int j = 0; j < g.nVerts; j++)
			if (g.adjMat[v][j] == 1 & g.vertexList[j].wasVisited == false)
				return j;
		return -1;
	}

	public static void bfs(GraphWAdjMtrx g) {
		Queue queue = new LinkedList();
		g.vertexList[0].wasVisited = true;
		g.displayVertex(0);
		queue.add(0);
		int v2;
		while (!queue.isEmpty()) {
			int v1 = (int) queue.remove();
			while ((v2 = getAdjUnvisitedVertex(g, v1)) != -1) {
				g.vertexList[v2].wasVisited = true;
				g.displayVertex(v2);
				queue.add(v2);
			}
		}
		for (int j = 0; j < g.nVerts; j++) {
			g.vertexList[j].wasVisited = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Vertex {
	public char label;
	public boolean wasVisited;
	public Vertex(char lab) {
		this.label = lab;
		this.wasVisited = false;
	}
}

class GraphWAdjMtrx {
	
	Vertex[] vertexList;
	int nVerts;
	int adjMat[][];
	public GraphWAdjMtrx(int maxNoOfVrtx) {
		nVerts = 0;
		adjMat = new int[maxNoOfVrtx][maxNoOfVrtx];
		for (int j = 0; j < maxNoOfVrtx; j++) {
			for (int k = 0; k < maxNoOfVrtx; k++) {
				adjMat[j][k] = 0;
			}
		}
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void addEdge(int start, int end,int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}

	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}

}

class GraphWAdjLst {
	int vertices;
	LinkedList<Integer>[] adjList;
	public GraphWAdjLst(int noOfVrtx) {
		this.vertices = noOfVrtx; 
		adjList = new LinkedList[noOfVrtx];
		for(int i=0; i< noOfVrtx; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int start, int end) {
		this.adjList[start].addLast(end);
	}
	
}
