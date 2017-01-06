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

import javax.swing.*;

public class Maze 
	implements GraphInterface
{

	private ArrayList<ArrayList<MBox>> boxes ;
	private DBox startVertex;
	private ABox endVertex;
	private ArrayList<WBox> wBox;
	public int width;
	public int height;
	
	/**
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException,IOException{
		BufferedReader in
				= new BufferedReader(new FileReader(fileName));
		boxes = new ArrayList<ArrayList<MBox>>();
		wBox = new ArrayList<WBox>();
		boxes.add(new ArrayList<MBox>() );
		int line = 0, colone = 0;
		while(line<height){
			if(line==height-1&&colone==width)break;
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
					wBox.add(new WBox(line,colone,this));
					boxes.get(line).add(wBox.get(wBox.size()-1));
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
	
	public Maze(String fileName) throws MazeReadingException, IOException{
		BufferedReader in
		   = new BufferedReader(new FileReader(fileName));
		boxes = new ArrayList<ArrayList<MBox>>();
		wBox = new ArrayList<WBox>();
		boxes.add(new ArrayList<MBox>() );
		int line = 0, colone = 0;
		while(line<height){
			if(line==height-1&&colone==width)break;
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
				wBox.add(new WBox(line,colone,this));
				boxes.get(line).add(wBox.get(colone));
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

	public Maze(List<WBox> wBox, DBox dBox,ABox aBox) {
		boxes = new ArrayList<ArrayList<MBox>>();
		for(int line =0; line < height;line++){
			boxes.add(new ArrayList<MBox>());
			for(int colone=0; colone <width; colone++){
				boxes.get(line).add(new EBox(line,colone,this));
			}
		}
		boxes.get(dBox.getLengthCoordinate()).set(dBox.getWidthCoordinate(),dBox);
		boxes.get(aBox.getLengthCoordinate()).set(aBox.getWidthCoordinate(),aBox);
		for( WBox i : wBox){
			boxes.get(i.getLengthCoordinate()).set(i.getWidthCoordinate(),i);
		}
	}

	public Maze(){
		JOptionPane.showMessageDialog(null, "A Click to put a mur\n" +
				"A first Shift Click to put a start box\n" +
				"The following Shift Click to put the end box\n" +
				"Control+S to save\n" +
				"Control+L to load the game saved\n" +
				"Control+N to open a new game\n" +
				"Control+Q to quit");
		DimensionPanel dimensionPanel = new DimensionPanel();
		width = dimensionPanel.getWidth();
		height = dimensionPanel.getLength();
		boxes = new ArrayList<ArrayList<MBox>>();
		wBox = new ArrayList<WBox>();
		for(int line =0; line < height;line++){
			boxes.add(new ArrayList<MBox>());
			for(int colone=0; colone <width; colone++){
				boxes.get(line).add(new EBox(line,colone,this));
			}
		}

	}

	public void addABox(ABox aBox){
		boxes.get(aBox.getLengthCoordinate()).set(aBox.getWidthCoordinate(),aBox);
		endVertex = aBox;
	}

	public void addDBox(DBox dBox){
		boxes.get(dBox.getLengthCoordinate()).set(dBox.getWidthCoordinate(),dBox);
		startVertex = dBox;
	}

	public void addWBox(WBox wBox){
		boxes.get(wBox.getLengthCoordinate()).set(wBox.getWidthCoordinate(),wBox);
		this.wBox.add(wBox);
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

	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	
	
	public ArrayList<MBox> getNeighbors(MBox box){
		
		ArrayList<MBox> result=new ArrayList<MBox>();
		
		int x=box.getLengthCoordinate();
		
		int y=box.getWidthCoordinate();
		
		int X=this.getWidth();
		
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
	public ArrayList<WBox> getWBox(){return wBox; }

	public boolean ifContainsStartVertex(){
		if(startVertex==null) return false;
		else{
			if(boxes.get(startVertex.getLengthCoordinate()).get(startVertex.getWidthCoordinate()).getLabel().equals("D")){
				return true;
			}
			else{
				startVertex =null;
				return false;
			}
		}
	}

	public boolean ifContainsEndVertex(){
		if(endVertex==null) return false;
		else{
			if(boxes.get(endVertex.getLengthCoordinate()).get(endVertex.getWidthCoordinate()).getLabel().equals("A")){
				return true;
			}
			else{
				endVertex =null;
				return false;
			}
		}
	}
	
	
	
}
