package maze;
import dijkstra.VertexInterface;
public abstract class MBox 
	implements VertexInterface{
	
	/**
	 * The maze where belongs the box.
	 */
	
	/**
	 * The vertical coordinates of the box.
	 */
	private int widthCoordinate;
	
	/**
	 * The horizontal coordinates of the box.
	 */
	private int lengthCoordinate;
	
	/**Constructor
	 * 
	 * @param lengthCoordinate The horizontal coordinate of the box.
	 * @param widthCoordinate The vertical coordinate of the box.
	 * @param maze The maze where belongs the box.
	 */
	public MBox(int lengthCoordinate,int widthCoordinate){
		this.lengthCoordinate = lengthCoordinate;
		this.widthCoordinate = widthCoordinate;
	}
	
	
	/**
	 * @return the horizontal coordinate.
	 */
	public int getLengthCoordinate() {
		return lengthCoordinate;
	}
	
	
	/**
	 * @return the vertical coordinate.
	 */
	
	public int getWidthCoordinate() {
		return widthCoordinate;
	}

	
	/**
	 * 
	 * @param other The other box whose distance to this one you want to set.
	 * @param distance The distance between this box and the box "other".
	 * 
	 */
	public void setDistanceTo(VertexInterface other, Integer distance) {
	
	}
	
	
}
