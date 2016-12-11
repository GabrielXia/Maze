package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	
	/**
	 * set pere(son) = father
	 */
	public void setFatherTo(VertexInterface father,VertexInterface son);
	
	/**
	 * return the father of son
	 */
	public VertexInterface getFather(VertexInterface son);
	
	/**
	 * return the shortest way to vertex
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
	
}
