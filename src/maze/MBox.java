package maze;
import dijkstra.VertexInterface;
import interfaces.*;
public abstract class MBox 
	implements VertexInterface{
	private Maze maze;
	private int widthCoordinate;
	private int lengthCoordinate;
	
	public MBox(int lengthCoordinate,int widthCoordinate,Maze maze){
		this.lengthCoordinate = lengthCoordinate;
		this.widthCoordinate = widthCoordinate;
		this.maze =maze;
	}
	/**
	 * @return the coordonneeLarge
	 */
	public int getLengthCoordinate() {
		return lengthCoordinate;
	}
	/**
	 * @return the coordonneeHauteur
	 */
	
	public int getWidthCoordinate() {
		return widthCoordinate;
	}

	public void setDistanceTo(VertexInterface other, Integer distance) {
	
	}
	
	
}
