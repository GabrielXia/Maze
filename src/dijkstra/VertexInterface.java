package dijkstra;

/**This is interface for vertex*/
public interface VertexInterface {
	/**
	 * set the distance from this vertex to others
	 * @param other
	 * @param distance
	 */
	public void setDistanceTo(VertexInterface other, Integer distance);
	
	/**
	 * get the label of this vertex
	 * @return
	 */
	public String getLabel();

	
}
