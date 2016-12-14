package dijkstra;

import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface,Integer> implements PiInterface{

	public void setDistanceMinimal(VertexInterface vertex, Integer distance) {
		this.put(vertex,distance);
		
	}

	public Integer getDistanceMinimal(VertexInterface vertex) {
		return this.get(vertex);
	}
	

}
