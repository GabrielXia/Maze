package tp04;

import java.util.List;

public interface GraphInterface {
	/**
	 * set root of the graph
	 * @param vertex
	 */
	public void setRoot(VertexInterface vertex);
	/**
	 * return root of the graph
	 * @return
	 */
	public VertexInterface getRoot();
	
	/**
	 * add new vertex to graph
	 * @param vertex
	 */
	public void addVertex(VertexInterface vertex);
	/**
	 * return all vertex in the graph
	 * @return
	 */
	public List<VertexInterface> getAllVertex();
	/**
	 * return the number of vertex in graph
	 * @return
	 */
	public int getNumberOfVertex();
}
