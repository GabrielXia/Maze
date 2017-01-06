package maze;

public final class WBox extends MBox{
	
	/**Constructor
	 * 
	 * @param lengthCoordinate The horizontal coordinate of the box.
	 * @param widthCoordinate The vertical coordinate of the box.
	 * @param maze The maze where belongs the box.
	 */
	public WBox(int lengthCoordinate, int widthCoordinate) {
		super(lengthCoordinate, widthCoordinate);
	}
	
	/**
	 * @return The type of this box.
	 */
	public String getLabel() {
		return "W";
	}
	
	
}
