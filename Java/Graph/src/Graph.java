package src;


public abstract class Graph<E> {
	public static final int MAX_VERTICES = 100;
	public static final int FIRST_VERTEX_INDEX = 1; 
	public EdgeNode<E>[] edges;
	public int numberVertices;
	public int[] degrees;
	public boolean isDirected;
	public int numberEdges;
	public Vertex<E>[] vertices;
	
	
	
	@SuppressWarnings("unchecked")
	public Graph<E> initGraph(boolean isDirected) {
		edges = (EdgeNode<E>[]) new Object[MAX_VERTICES];
		degrees = new int[MAX_VERTICES];

		numberVertices = 0;
		numberEdges = 0;
		
		this.isDirected = isDirected;
		
		return this;
	}

	public abstract void readGraph();

	
	public void insertEdge(Vertex<E> x, Vertex<E> y, boolean isDirected) {
		int xLabel = x.intLabel;
		int yLabel = y.intLabel;
		
		//Create new edge from given vertices
		EdgeNode<E> edge = new EdgeNode<E>();
		edge.weight = 1;
		edge.y = y;
		
		edge.next = this.edges[xLabel];
		
		degrees[xLabel] ++;
		edges[xLabel] = edge;
		
		
		if (!isDirected) {
			insertEdge(y, x, true);
		} else { 
			numberVertices ++;
			vertices[yLabel] = y;
		}
	}

	public String printGraph() {
		EdgeNode<E> temp;
		StringBuilder builder = new StringBuilder();
		
		for (int i = FIRST_VERTEX_INDEX; i < numberVertices+FIRST_VERTEX_INDEX; i++) {
			builder.append("From ");
			builder.append(vertices[i].value);
			builder.append(" to:");
			temp = this.edges[i];
			while (temp != null) {
				builder.append(" "+temp.y.value);
				temp = temp.next;
			}
			builder.append("\n");
		}
		
		return builder.toString();
	}

}



