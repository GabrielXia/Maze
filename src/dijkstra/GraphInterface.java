package dijkstra;

import java.util.List;
/** This is an interface  of a graph.*/
public interface GraphInterface {
	
	/**
	 * Get all the vertices of this graph.
	 * @return all the vertices of this graph
	 */
	public List<VertexInterface> getAllVertices();


	/**
	 * Get all the successors of a vertex in this graph.
	 * @param vertex vertex whose successors we want to know
	 * @return all the successors of the vertex in this graph
	 */
	public List<VertexInterface> getSuccessors(VertexInterface vertex);

	/**
	 * Get the weight of an arch in this graph.
	 * @param src vertex of this graph
	 * @param dst one of the successors of the src vertex
	 * @return the weight of the arch going from src to dst
	 */
	public int getWeight(VertexInterface src,VertexInterface dst) ;
	
	
	
	/**
	 * Returns the start vertex of this graph.
	 * @return the start vertex of this graph
	 */
	public VertexInterface getStartVertex();
	
}
