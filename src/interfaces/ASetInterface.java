package interfaces;

public interface ASetInterface {
	/**
	 * add vertex in ASet
	 * @param vertex
	 */
	public void add(VertexInterface vertex);
	
	/**
	 * returns True if Aset contains vertex and False otherwise
	 * @param vertex
	 * @return
	 */
	public boolean contains(VertexInterface vertex);
	
}
