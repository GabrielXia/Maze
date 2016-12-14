package dijkstra;

public interface PiInterface {
	/**
	 * set value of pi(vertex)
	 * @param vertex
	 * @param distance
	 */
	public void setDistanceMinimal(VertexInterface vertex, Integer distance);
	/**
	 * get value of pi(vertex)
	 * @param vertex
	 * @return
	 */
	public Integer getDistanceMinimal(VertexInterface vertex);
	
}
