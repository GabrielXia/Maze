package main;


public class MazeReadingException extends Exception {
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
