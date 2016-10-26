package tp04;

public interface PreviousInterface {
	/**
	 * set pere(son) = father
	 * @param father
	 * @param son
	 */
	public void setFatherTo(VertexInterface father,VertexInterface son);
	/**
	 * return the father of son
	 * @param son
	 * @return
	 */
	public VertexInterface getFather(VertexInterface son);
	
}
