package dijkstra;


/** This class implements the Dijkstra algorithm. */

public final class Dijkstra {
	
	
	/**
	 * Calculates the shortest path from a vertex to the others in a graph.
	 * @param g graph to which we want to apply the Djikstra algorithm
	 * @param r vertex whose distance to others we want to know
	 * @return the path to the other vertices
	 */
	public static final PreviousInterface dijkstra(GraphInterface g,VertexInterface r){
		PreviousInterface previous = new Previous(r);
		ASetInterface a = new ASet();
		PiInterface pi = new Pi();
		
		a.add(r);
		VertexInterface pivot = r;
		pi.setDistanceMinimal(r, 0);
		
		for(VertexInterface i:g.getAllVertices()){
			if(!i.equals(r)) pi.setDistanceMinimal(i, Integer.MAX_VALUE);
		}
		
		for(int j=1;j<=g.getAllVertices().size()-1;j++){
			for(VertexInterface y:g.getSuccessors(pivot)){
				if(a.contains(y))continue;
				if(pi.getDistanceMinimal(pivot)+g.getWeight(pivot, y)<pi.getDistanceMinimal(y)){
					pi.setDistanceMinimal(y, pi.getDistanceMinimal(pivot)+g.getWeight(pivot, y));
					previous.setFatherTo(y,pivot);
				}
			}
			
			//find y not in A where pi(y) is minimal
			Integer minimal = Integer.MAX_VALUE;
			VertexInterface y = null;
			for(VertexInterface i:g.getAllVertices()){
				if(a.contains(i))continue;
				if(pi.getDistanceMinimal(i)<minimal){
					minimal = pi.getDistanceMinimal(i);
					y = i;
				}
				
			}
			if(y==null)return previous;//all points are in Aset, finish
			pivot = y;
			a.add(pivot);
		}
		
		
		return previous;
	}
}
