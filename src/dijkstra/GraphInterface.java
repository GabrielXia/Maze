package dijkstra;

import java.util.List;

public interface GraphInterface {
	
	/**
	 * returns all vertices
	 * @return
	 */
	public List<VertexInterface> getAllVertices();
	
	
	/**
	 * return the successors of vertex in graph
	 * @return
	 */
	public List<VertexInterface> getSuccessors(VertexInterface vertex);
	
	/**
	 * return the weight of the path between src and dst
	 * 
	 */
	public int getWeight(VertexInterface src,VertexInterface dst) ;
	
	/**
	 * 
	 * @return
	 */
	public VertexInterface getStartVertex();
	
}
