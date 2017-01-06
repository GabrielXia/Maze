package maze;

public final class ABox extends MBox{
	/**Constructor
	 * 
	 * @param lengthCoordinate The horizontal coordinate of the box.
	 * @param widthCoordinate The vertical coordinate of the box.
	 * @param maze The maze where belongs the box.
	 */
	public ABox(int lengthCoordinate, int widthCoordinate, Maze maze) {
		super(lengthCoordinate, widthCoordinate, maze);
	}
	
	/**
	 * @return The type of this box.
	 */
	public String getLabel() {
		return "A";
	}
	
}
