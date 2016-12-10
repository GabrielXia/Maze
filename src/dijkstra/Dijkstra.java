package dijkstra;

import interfaces.*;

public class Dijkstra {
	private static PreviousInterface previous;
	private static ASetInterface a ;
	private static PiInterface pi;
	
	public static PreviousInterface dijkstra(GraphInterface g,VertexInterface r){
		previous = new Previous(r);
		a.add(r);
		VertexInterface pivot = r;
		pi.setDistanceMinimal(r, 0);
		
		for(VertexInterface i:g.getAllVertices()){
			if(!i.equals(r)) pi.setDistanceMinimal(i, Integer.MAX_VALUE);
		}
		
		for(VertexInterface j:g.getAllVertices()){
			for(VertexInterface y:g.getSuccessors(pivot)){
				if(a.contains(y))continue;
				if(pi.getDistanceMinimal(pivot)+pi.getDistanceMinimal(y)<pi.getDistanceMinimal(y)){
					pi.setDistanceMinimal(y, pi.getDistanceMinimal(pivot)+pi.getDistanceMinimal(y));
					previous.setFatherTo(pivot,y);
				}
			}
			
			//find y not in A that pi(y) is minimal
			Integer minimal = Integer.MAX_VALUE;
			VertexInterface y = null;
			for(VertexInterface i:g.getAllVertices()){
				if(a.contains(i))continue;
				if(pi.getDistanceMinimal(i)<minimal){
					minimal = pi.getDistanceMinimal(i);
					y = i;
				}
				
			}
			
			pivot = y;
			a.add(pivot);
			}
		
		
		return previous;
	}
}
