package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	
	/**
	 * set pere(son) = father
	 */
	public void setFatherTo(VertexInterface son,VertexInterface father);
	
	/**
	 * return the father of son
	 */
	public VertexInterface getFather(VertexInterface son);
	
	/**
	 * return the shortest way to vertex, in the way inverse, end to end
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);
	
}
