package maze;


public class MazeReadingException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	/**Constructor
	 * 
	 * @param name Name of the file where the error happened..
	 * @param line Line where the error happened in the file named "Name"
	 * @param message Message that must be printed on the screen when the error happens.
	 */
	MazeReadingException(String name, int line, String message){
		super("MazeReadingException in file:"+name+"\nin line:"+line+"\nmessage:"+message);
	}
}
