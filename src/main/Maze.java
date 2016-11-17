package main;

import java.util.ArrayList;

public class Maze {

	private ArrayList<ArrayList<MBox>> boxes ;
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
