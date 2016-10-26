package interfaces;

public interface PiInterface {
	/**
	 * set value of pi(vertex)
	 * @param vertex
	 * @param distance
	 */
	public void setDistanceMinimal(VertexInterface vertex, double distance);
	/**
	 * get value of pi(vertex)
	 * @param vertex
	 * @return
	 */
	public double getDistanceMinimal(VertexInterface vertex);
	
}
