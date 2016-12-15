package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze 
	implements GraphInterface
{

	private ArrayList<ArrayList<MBox>> boxes ;
	private DBox startVertex;
	private ABox endVertex;
	
	/**
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public final void initFromTextFile(String fileName) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		
		PrintStream out = System.out;
		for(int i=0;i<10;i++)out.println(in.readLine());
		in.close();
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
				endVertex = new ABox(line,colone,this);
				boxes.get(line).add(endVertex);
				colone++;
				break;
			case('D'):
				startVertex = new DBox(line,colone,this);
				boxes.get(line).add(startVertex); 
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
		in.close();
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
				if(box.getLabel().equals("E"))out.write('E');
				if(box.getLabel().equals("W"))out.write('W');
				if(box.getLabel().equals("A"))out.write('A');
				if(box.getLabel().equals("D"))out.write('D');
			}
			out.write('\n');
		}
		out.close();
	}


	
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
		int X=boxes.size();
		int Y=boxes.get(0).size();
		if (x>0 && !(boxes.get(x-1).get(y).getLabel().equals("W"))) successors.add(boxes.get(x-1).get(y));
		if (y>0 && !(boxes.get(x).get(y-1).getLabel().equals("W"))) successors.add(boxes.get(x).get(y-1));
		if (X>x+1 && !(boxes.get(x+1).get(y).getLabel().equals("W"))) successors.add(boxes.get(x+1).get(y));
		if (Y>y+1 && !(boxes.get(x).get(y+1).getLabel().equals("W"))) successors.add(boxes.get(x).get(y+1));
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


	public VertexInterface getStartVertex() {
		return startVertex;
	}
	public VertexInterface getEndVertex(){
		return endVertex;
	}
	
	
	
}
