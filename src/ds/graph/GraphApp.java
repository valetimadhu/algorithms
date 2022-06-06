package ds.graph;

import java.util.Stack;

public class GraphApp {

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

class Graph{
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int nVerts;
	private int adjMat[][];
	private Stack stack;
	
	public Graph() {
		 Vertex[] vertexList;
		 nVerts = 0;
		 adjMat = new int[MAX_VERTS][MAX_VERTS];
		for(int j=0; j< MAX_VERTS; j++) {
			for(int k=0; k<MAX_VERTS; k++) {
				adjMat[j][k] = 0;
			}
		}
		 stack = new Stack();
		 
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] =1;
		adjMat[end][start] =1;
	}
	
	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}
	
	public void dfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		
		while(!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex((int)stack.peek());
			if(v ==-1) stack.pop();
			else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			}
			
		}
		
		for(int j=0; j< nVerts; j++) vertexList[j].wasVisited = false;
	}
	
	public int getAdjUnvisitedVertex(int v) {
		for(int j=0; j< nVerts; j++) 
			if(adjMat[v][j] ==1 & vertexList[j].wasVisited == false) return j;
		return -1;
		
	}
	
	
}
