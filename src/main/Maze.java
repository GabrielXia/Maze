package main;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Maze 
	implements GraphInterface
{

	private ArrayList<ArrayList<MBox>> boxes ;
	
	
	public ArrayList<VertexInterface> getAllVertices(){
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();
		for (int i=0;i<boxes.size();i++){
			for (int j=0;j<boxes.get(0).size();j++){
				vertices.add(boxes.get(i).get(j));
			}
		}
		return vertices;
	}
	
	
	
	public List<VertexInterface> getSuccessors(VertexInterface vertex){
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		MBox box = (MBox)vertex ;
		int x=box.getLengthCoordinate();
		int y=box.getWidthCoordinate();
		int X=boxes.get(0).size();
		int Y=boxes.size();
		if (x>0 && !(boxes.get(y).get(x-1) instanceof WBox)) successors.add(boxes.get(y).get(x-1));
		if (y>0 && !(boxes.get(y-1).get(x) instanceof WBox)) successors.add(boxes.get(y-1).get(x));
		if (X>x+1 && !(boxes.get(y).get(x+1) instanceof WBox)) successors.add(boxes.get(y).get(x+1));
		if (Y>y+1 && !(boxes.get(y+1).get(x) instanceof WBox)) successors.add(boxes.get(y+1).get(x));
		return successors;
	}
	
	
	
	public int getWeight(VertexInterface src,VertexInterface dst){
		
		return 1;
		
	}

	
	
	
	
	
	private int getLength(){
		return boxes.get(0).size();
	}
	
	private int getWidth(){
		return boxes.size();
	}
	
	
	
	public ArrayList<MBox> getNeighbors(MBox box){
		
		ArrayList<MBox> result=new ArrayList<MBox>();
		
		int x=box.getLengthCoordinate();
		
		int y=box.getWidthCoordinate();
		
		int X=this.getLength();
		
		int Y=this.getWidth();
		
		for (int k=0;k<2;k++){
			int i=2*k-1;
			if (0<=x-i && x-i<X ){
				result.add(boxes.get(y).get(x-i));
			}
			if (0<=y-i && y-i<Y ){
				result.add(boxes.get(y-i).get(x));
			}
		}
		return result;
	}
	
	
	
}
