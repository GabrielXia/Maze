package dijkstra;

import java.util.List;
/** This is an interface  of graph*/
public interface GraphInterface {
	
	/**
	 * get all vertices in graph
	 * @return all verteces in the graph
	 */
	public List<VertexInterface> getAllVertices();


	/**
	 * get successors of this vertex
	 * @param vertex
	 * @return all successors
	 */
	public List<VertexInterface> getSuccessors(VertexInterface vertex);

	/**
	 * get the weight of a border in graph
	 * @param src the start vertex
	 * @param dst the arrive vertex
	 * @return
	 */
	public int getWeight(VertexInterface src,VertexInterface dst) ;
	
	/**
	 * 
	 * @return the start vertex in graph
	 */
	public VertexInterface getStartVertex();
	
}
