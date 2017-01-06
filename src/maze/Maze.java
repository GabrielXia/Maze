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

public final class Maze
	implements GraphInterface
{

	/**
	 * Two dimensions array representing the maze.
	 */
	private ArrayList<ArrayList<MBox>> boxes ;
	
	/**
	 * The box witch beginning of the maze.
	 */
	private MBox startVertex;
	
	/**
	 * The box which is the exit of the maze.
	 */
	private MBox endVertex;
	
	/**
	 * One dimension array containing all the wall boxes of the maze.
	 */
	private ArrayList<WBox> wBox;
	
	/**
	 * The vertical size of the maze.
	 */
	public int width;
	
	/**
	 * The horizontal size of the maze.
	 */
	public int height;
	
	/**
	 * Modify the existing maze by reinitializing it as described in the text file.
	 * @param fileName Name of the file which describes the maze the method will build.
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
	
	/**Constructor 1 which makes a new maze which is initialized as described in the text file.
	 * 
	 * @param fileName Name of the file describing the maze we want to build.
	 * @throws MazeReadingException
	 * @throws IOException
	 */
	public  Maze(String fileName) throws MazeReadingException, IOException{
		initFromTextFile( fileName);
	}

	
	/**Constructor 2 which makes a new maze with the boxes given by wBox, dBox ,and aBox.
	 * 
	 * @param wBox One dimension array containing all the wall box of the maze.
	 * @param dBox Departure box of the maze
	 * @param aBox Arrival box of the maze
	 */
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

	
	/**Constructor 3 creating a blank maze whose dimensions are given by the user.
	 * 
	 */
	public Maze(){
		ReminderWindows.reminderUtilization();
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

	/**
	 * Create or modify the arrival box of the maze
	 * @param aBox new arrival box of the maze
	 */
	public final void addABox(ABox aBox){
		boxes.get(aBox.getLengthCoordinate()).set(aBox.getWidthCoordinate(),aBox);
		endVertex = aBox;
	}

	/**
	 * Create or modify the departure box of the maze
	 * @param dBox new departure box of the maze
	 */
	public final void addDBox(DBox dBox){
		boxes.get(dBox.getLengthCoordinate()).set(dBox.getWidthCoordinate(),dBox);
		startVertex = dBox;
	}

	/**
	 * Create a new wall box in the maze
	 * @param wBox new wall box of the maze
	 */
	public final void addWBox(WBox wBox){
		boxes.get(wBox.getLengthCoordinate()).set(wBox.getWidthCoordinate(),wBox);
		this.wBox.add(wBox);
	}


	/**
	 * Saves the maze in a file which can be read by the initFromTextFile method to rebuild the maze.
	 * @param fileName Name of the file where the maze shall be saved
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


	/**
	 * @return Returns a one dimension array which contains all the boxes of the maze.
	 */
	public final ArrayList<VertexInterface> getAllVertices(){
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();
		for (int i=0;i<boxes.size();i++){
			for (int j=0;j<boxes.get(0).size();j++){
				vertices.add(boxes.get(i).get(j));
			}
		}
		return vertices;
	}
	
	
	/**
	 * @param vertex The box whose neighbors we want to get
	 * @return Returns a one dimension array containing all the neighbors of the box vertex apart of the wall boxes.
	 */
	public final List<VertexInterface> getSuccessors(VertexInterface vertex){
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
	
	
	/**
	 * @param src The box where starts the arch 
	 * @param dst The box where arrives the arch
	 * @return Returns the weight of the arch linking src and dst (in this case every existing arch has a weight of 1)
	 */
	public final int getWeight(VertexInterface src,VertexInterface dst){
		
		return 1;
		
	}

	
	/**
	 * 
	 * @return Returns the horizontal size of the maze.
	 */
	public final int getHeight(){
		return height;
	}
	
	/**
	 * 
	 * @return Returns the vertical size of the maze.
	 */
	public final int getWidth(){
		return width;
	}
	
	
	/**
	 * 
	 * @param box Box whose neighbors we want to get
	 * @return Returns a one dimension array containing all the boxes next to the box "box", even the wall boxes.
	 */
	public final ArrayList<MBox> getNeighbors(MBox box){
		
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

	/**
	 * @return Returns the departure box of the maze
	 */
	public final MBox getStartVertex() {
		return startVertex;
	}
	
	
	/**
	 * @return Returns the arrival box of the maze
	 */
	public final MBox getEndVertex(){
		return endVertex;
	}
	
	/**
	 * @return Returns an array containing all the wall boxes of the maze
	 */
	public final ArrayList<WBox> getWBox(){return wBox; }

	
	/**
	 * @return Returns a boolean equal to True if there is a departure box and False otherwise 
	 */
	public final boolean ifContainsStartVertex(){
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

	
	
	/**
	 * @return Returns a boolean equal to True if there is an arrival box and False otherwise 
	 */
	public final boolean ifContainsEndVertex(){
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
