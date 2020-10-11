package src;

public abstract class DepthFirstTraverse<E> extends GraphTraversal<E> {
	private int time;
	private int[] parent;
	private int[] entryTime;
	private int[] exitTime;
	
	public DepthFirstTraverse(Graph<E> graph) {
		super(graph);
		time = 0;
		parent = new int[graph.numberVertices];
	}

	@Override
	public void traverse(Graph<E> graph, Vertex<E> startingV) {
		resetSearch();
		
		depthFirstSearchRec (graph, startingV);

	}
	
	private void depthFirstSearchRec (Graph<E> graph, Vertex<E> startingVertex) {
		if(isSearchDone) {
			return;
		}
		
		isDiscovered[startingVertex.intLabel] = true;
		time ++;
		entryTime[startingVertex.intLabel] = time;
		
		processVertexEarly (startingVertex);
		
		EdgeNode<E> incidentEdge = graph.edges[startingVertex.intLabel];
		
		while (incidentEdge != null) {
			Vertex<E> adjacentVertex = incidentEdge.y;
			
			if (!isDiscovered[adjacentVertex.intLabel]) {
				parent[adjacentVertex.intLabel] = startingVertex.intLabel;
				processEdge (startingVertex, adjacentVertex);
				
				depthFirstSearchRec(graph, startingVertex);
			} else if (!isProcessed[startingVertex.intLabel] || graph.isDirected) {
				processEdge (startingVertex, adjacentVertex);
			}
			
			if (isSearchDone) {
				return;
			}
			
			incidentEdge = incidentEdge.next;
		}
		
		processVertexLate(startingVertex);
		isProcessed[startingVertex.intLabel] = true;
		
		exitTime[startingVertex.intLabel] = time;
		time ++;
		
	}
	
	@Override
	protected void resetSearch() {
		super.resetSearch();
		time = 0;
		for (int i = 0; i < parent.length; i ++) {
			parent[i] = 0;
		}
	}

}
