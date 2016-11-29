package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Maze {
	private ArrayList<ArrayList<MBox>> boxes ;
	
	/**
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public final void initFromTextFile(String fileName) throws IOException{
		BufferedReader in
		   = new BufferedReader(new FileReader(fileName));
		
		PrintStream out = System.out;
		for(int i=0;i<10;i++)out.println(in.readLine());
	}
	public Maze(String fileName) throws MazeReadingException, IOException{
		BufferedReader in
		   = new BufferedReader(new FileReader(fileName));
		int line = 0;
		while(line<10)
		switch(in.read()){
		case('A'):
			boxes.get(i)
		}
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
