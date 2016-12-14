package maze;


public class MazeReadingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param name
	 * @param line
	 * @param message
	 */
	MazeReadingException(String name, int line, String message){
		super("MazeReadingException in file:"+name+"\nin line:"+line+"\nmessage:"+message);
	}
}