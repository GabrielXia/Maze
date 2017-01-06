package dijkstra;

import interfaces.ErrorWindows;

import java.util.ArrayList;
import java.util.Hashtable;

/** This class implements PreviousInterface*/
public final class Previous extends Hashtable<VertexInterface,VertexInterface> implements PreviousInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 201503101423L;
	/**The start vertex in graph*/
	private final VertexInterface start;

	/**
	 * Constructor
	 * @param start start vertex
	 */
	public Previous(VertexInterface start){
		this.start = start;
	}

	/**
	 * set father vertex to son vertex
	 * @param son
	 * @param father
	 */
	public final void setFatherTo(VertexInterface son, VertexInterface father) {
		this.put(son,father );
	}

	/**
	 * get the father of this vertex
	 * @param son
	 * @return the father of this vertex
	 */
	public final VertexInterface getFather(VertexInterface son) {
		return this.get(son);
	}

	/**
	 * get the shortest path from start to this vertex
	 * @param vertex
	 * @return
	 */
	public final ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		try {
			ArrayList<VertexInterface> shortestPath = new ArrayList<VertexInterface>();
			VertexInterface i = vertex;
			shortestPath.add(vertex);
			while (!i.equals(start)) {
				shortestPath.add(this.get(i));
				i = this.get(i);
			}
			return shortestPath;
		} catch (NullPointerException e) {
			ErrorWindows.errorNoSolution();
			return null;
		}
	}
}
