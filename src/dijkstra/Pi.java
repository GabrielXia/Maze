package dijkstra;

import java.util.Hashtable;

/**This class implement PiInterface*/

public final class Pi extends Hashtable<VertexInterface,Integer> implements PiInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 201503101423L;

	/**
	 * set distance from this vertex to start in Pi
	 * @param vertex
	 * @param distance
	 */
	public final void setDistanceMinimal(VertexInterface vertex, Integer distance) {
		this.put(vertex,distance);
		
	}

	/**
	 * get distance from this vertex to start in Pi
	 * @param vertex
	 * @return
	 */
	public final  Integer getDistanceMinimal(VertexInterface vertex) {
		return this.get(vertex);
	}
	

}
