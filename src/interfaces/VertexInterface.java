package interfaces;

import java.util.List;

public interface VertexInterface {
	/**
	 * set the distance from this vertex to other
	 * @param other
	 * @param distance
	 */
	public void setDistanceTo(VertexInterface other, double distance);
	/**
	 * return distance from this vertex to other
	 * @param other
	 * @return
	 */
	public double getDistanceTo(VertexInterface other);
	
	
	
}
