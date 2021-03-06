package maze;

public final class DBox extends MBox{
	/**Constructor
	 * 
	 * @param lengthCoordinate The vertical coordinate of the box.
	 * @param widthCoordinate The horizontal coordinate of the box.
	 * @param maze The maze where belongs the box.
	 */
	public DBox(int lengthCoordinate, int widthCoordinate) {
		super(lengthCoordinate, widthCoordinate);
	}

	
	/**
	 * @return The type of this box.
	 */
	public String getLabel() {
		return "D"; 
	}

	
}
