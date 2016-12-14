package dijkstra;


public interface VertexInterface {
	/**
	 * set the distance from this vertex to other
	 * @param other
	 * @param distance
	 */
	public void setDistanceTo(VertexInterface other, Integer distance);
	
	/**
	 * 
	 * @return
	 */
	public String getLabel();
	
}