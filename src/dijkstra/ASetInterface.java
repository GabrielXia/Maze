package dijkstra;

import interfaces.VertexInterface;

public interface ASetInterface {
	/**
	 * add vertex in ASet
	 * @param vertex
	 */
	public boolean add(VertexInterface vertex);
	
	/**
	 * returns True if Aset contains vertex and False otherwise
	 * @param vertex
	 * @return
	 */
	public boolean contains(Object vertex);
	
}
