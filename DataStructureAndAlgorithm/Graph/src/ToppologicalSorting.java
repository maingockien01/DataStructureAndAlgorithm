package src;

public class ToppologicalSorting<E> extends DepthFirstTraverse<E> {

	Stack<Vertex<E>> topologicalStack;
	
	public ToppologicalSorting(Graph<E> graph) {
		super(graph);
		topologicalStack =  new LinkedListStack<> ();
	}
	
	@Override
	protected void resetSearch() {
		super.resetSearch();
		topologicalStack =  new LinkedListStack<> ();
	}

	@Override
	protected void processVertexEarly(Vertex<E> v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processVertexLate(Vertex<E> v) {
		topologicalStack.push(v);
	}

	@Override
	protected void processEdge(Vertex<E> from, Vertex<E> to) {
		EdgeClass edgeClass = classifyEdge (from, to);
		
		if (edgeClass == EdgeClass.BACK) {
			
			System.out.println("Error: Graph is not directed ascyclic graph!");
		}
		
	}
	
	public void topSort () {
		resetSearch();
		
		for (int i = Graph.FIRST_VERTEX_INDEX; i < graph.numberVertices; i ++) {
			if (!isDiscovered[i]) {
				traverse(this.graph, this.graph.vertices[i]);
			}
		}
		
		processStack ();
	}
	
	protected void processStack () {
		
	};

}
