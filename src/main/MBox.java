package main;

public class MBox {
	
	private int widthCoordinate;
	private int lengthCoordinate;
	
	public MBox(int lengthCoordinate,int widthCoordinate){
		this.lengthCoordinate = lengthCoordinate;
		this.widthCoordinate = widthCoordinate;
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
	
	
}
