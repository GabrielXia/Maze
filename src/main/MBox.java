package main;
import interfaces.*;
public class MBox 
	implements VertexInterface{
	
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
	@Override
	public void setDistanceTo(VertexInterface other, double distance) {
		// TODO Auto-generated method stub
		
	}
	
	
}
