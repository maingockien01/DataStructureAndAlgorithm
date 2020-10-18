package src;

class EdgeNode<E> {
	public Vertex<E> y;			//Adjacency info - label vertices numbers
	public int weight;		//Edge weight, if any
	public EdgeNode<E> next;	//Next edge 

	public EdgeNode(Vertex<E> y, EdgeNode<E> next) {
		this.y = y;
		this.next = next;
	}

	
	public EdgeNode(Vertex<E> y, int weight, EdgeNode<E> next) {
		this.y = y;
		this.weight = weight;
		this.next = next;
	}


	public EdgeNode() {
	}
}
