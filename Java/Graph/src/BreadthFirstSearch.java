package src;

public abstract class BreadthFirstSearch<E> extends GraphTraversal<E> {
	
	public BreadthFirstSearch (Graph<E> graph) {
		super(graph);
	}
	
	@Override
	public void traverse(Graph<E> graph, Vertex<E> startingV) {
		resetSearch ();
		
		Queue<Vertex<E>> discoveredQueue = new LinkedListQueue<> ();
		
		isDiscovered[startingV.intLabel] = true;
		discoveredQueue.queue(startingV); 
		
		while (!discoveredQueue.isEmpty() && !isSearchDone) {
			Vertex<E> vertex = discoveredQueue.dequeue();
			processVertexEarly(vertex);
			
			EdgeNode<E> incidentEdge = graph.edges[vertex.intLabel];
			
			while(incidentEdge != null ) {
				Vertex<E> adjacentVertex = incidentEdge.y;
				
				if (!isDiscovered[adjacentVertex.intLabel]) {
					isDiscovered[adjacentVertex.intLabel] = true;
					discoveredQueue.queue(adjacentVertex);
					
					processEdge (vertex, adjacentVertex);
				} else if (graph.isDirected || !isProcessed[adjacentVertex.intLabel]) {
					processEdge(vertex, adjacentVertex);
				}
				
				incidentEdge = incidentEdge.next;
			}

			processVertexLate (vertex);
			isProcessed[vertex.intLabel] = true;
		}

	}
	

}
