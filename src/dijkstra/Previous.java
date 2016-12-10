package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

import interfaces.VertexInterface;

public class Previous extends Hashtable<VertexInterface,VertexInterface> implements PreviousInterface {
	private VertexInterface start;
	public Previous(VertexInterface start){
		this.start = start;
	}
	
	public void setFatherTo(VertexInterface father, VertexInterface son) {
		this.put(son, father);
	}

	public VertexInterface getFather(VertexInterface son) {
		return this.get(son);
	}

	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		ArrayList<VertexInterface> shortestPath = new ArrayList<VertexInterface>();
		VertexInterface i = start;
		shortestPath.add(start);
		while(!i.equals(vertex)){
			shortestPath.add(this.get(i));
			i = this.get(i);
		}
		return shortestPath;
	}

}
