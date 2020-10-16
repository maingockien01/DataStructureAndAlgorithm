package src;

public abstract class GraphTraversal<E> {

	boolean[] isDiscovered;
	boolean[] isProcessed;
	protected boolean isSearchDone;
	
	protected Graph<E> graph;
	
	public GraphTraversal(Graph<E> graph) {
		isDiscovered = new boolean[graph.numberVertices];
		isProcessed = new boolean[graph.numberVertices];
		isSearchDone = false;
		this.graph = graph;
	}
	
	public abstract void traverse (Graph<E> graph, Vertex<E> startingV);
	
	protected abstract void processVertexEarly (Vertex<E> v);
	protected abstract void processVertexLate (Vertex<E> v);
	protected abstract void processEdge (Vertex<E> from, Vertex<E> to);
	
	protected void resetSearch () {
		for (int i = 0 ; i < isDiscovered.length; i ++) {
			isDiscovered[i] = false;
		}
		for (int i = 0; i < isProcessed.length; i ++) {
			isProcessed[i] = false;
		}
		isSearchDone = false;

	}
	
	protected void terminateSearch () {
		isSearchDone = true;
	}
}
