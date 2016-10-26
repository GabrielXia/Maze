package tp04;

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
	/**
	 * return a list of succesor of this vertex
	 * @return
	 */
	public List<VertexInterface> getSuccesor();
	/**
	 * return if this vertex is belong to ASet
	 * @param Aset
	 * @return
	 */
	public boolean isContainedTo(ASetInterface Aset);
	
	
}
