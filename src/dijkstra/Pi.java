package dijkstra;

import java.util.Hashtable;

/**This class implements PiInterface.*/

public final class Pi extends Hashtable<VertexInterface,Integer> implements PiInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 201503101423L;

	/**
	 * Set distance from this vertex to start in Pi.
	 * @param vertex vertex whose distance to the start vertex of the graph we want to know
	 * @param distance integer we want to set as the distance between the start vertex of the graph to this vertex
	 */
	public final void setDistanceMinimal(VertexInterface vertex, Integer distance) {
		this.put(vertex,distance);
		
	}

	/**
	 * Get distance from this vertex to start vertex in Pi.
	 * @param vertex the vertex whose distance to the start vertex we want to know
	 * @return integer which is the distance from the vertex to the start vertex
	 */
	public final  Integer getDistanceMinimal(VertexInterface vertex) {
		return this.get(vertex);
	}
	

}
