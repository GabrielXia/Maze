package dijkstra;

public interface ASetInterface {
	
	/**
	 * Adds a vertex to this set.
	 * @param vertex vertex which shall be added to this set
	 */
	public boolean add(VertexInterface vertex);
	
	/**
	 * Verify whether or not this set contains the vertex.
	 * @param vertex vertex whose presence in this set is to be tested
	 * @return a boolean equal to True if this set contains the vertex and False otherwise
	 */
	public boolean contains(Object vertex);
	
}
