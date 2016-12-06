package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
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
		boxes = new ArrayList<ArrayList<MBox>>();
		boxes.add(new ArrayList<MBox>() );
		int line = 0, colone = 0;
		while(line<10){
			if(line==9&&colone==10)break;
			switch(in.read()){
			case('A'):
				boxes.get(line).add(new ABox(line,colone,this));
				colone++;
				break;
			case('D'):
				boxes.get(line).add(new DBox(line,colone,this));
				colone++;
				break;
			case('E'):
				boxes.get(line).add(new EBox(line,colone,this));
				colone++;
				break;
			case('W'):
				boxes.get(line).add(new WBox(line,colone,this));
				colone++;
				break;
			case('\n'):
				boxes.add(new ArrayList<MBox>());
				line++;
				colone=0;
				break;
			default:
				throw new MazeReadingException(fileName,line,"This box type is invalid");
			}
		}
	}
	
	/**
	 * 
	 * @param fileName
	 * @throws FileNotFoundException 
	 */
	public final void saveToTextFile(String fileName) throws FileNotFoundException{
		PrintWriter out =new PrintWriter(fileName);
		for(ArrayList<MBox> line :boxes){
			for(MBox box:line){
				if(box instanceof EBox)out.write('E');
				if(box instanceof WBox)out.write('W');
				if(box instanceof ABox)out.write('A');
				if(box instanceof DBox)out.write('D');
			}
			out.write('1');
			out.write('\n');
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
