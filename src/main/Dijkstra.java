package main;

import interfaces.ASetInterface;
import interfaces.GraphInterface;
import interfaces.PiInterface;
import interfaces.PreviousInterface;
import interfaces.VertexInterface;

public class Dijkstra {
	public PreviousInterface dijkstra(GraphInterface g,VertexInterface r,ASetInterface a,PiInterface pi,PreviousInterface previous){
		a.add(g.getRoot());
		VertexInterface pivot = g.getRoot();
		pi.setDistanceMinimal(r, 0);
		
		for(VertexInterface i:g.getAllVertex()){
			if(!i.equals(r))pi.setDistanceMinimal(i, Double.POSITIVE_INFINITY);
		}
		
		for(int j=1;j<g.getNumberOfVertex();j++){
			for(VertexInterface y:pivot.getSuccesor()){
				if(a.contains(y))continue;
				if(pi.getDistanceMinimal(pivot)+pivot.getDistanceTo(y)<pi.getDistanceMinimal(y)){
					pi.setDistanceMinimal(y, pi.getDistanceMinimal(pivot)+pivot.getDistanceTo(y));
					previous.setFatherTo(pivot,y);
				}
			}
			
			//find y not in A that pi(y) is minimal
			double minimal = Double.POSITIVE_INFINITY;
			VertexInterface y = null;
			for(VertexInterface i:g.getAllVertex()){
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
