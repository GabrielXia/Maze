package main;

import java.io.IOException;

public class MainTest {

	public static void main(String[] args) throws IOException, MazeReadingException {
		// TODO Auto-generated method stub
		Maze maze= new Maze("data/labyrinthe.txt");
		maze.initFromTextFile("data/labyrinthe.txt");
		maze.saveToTextFile("data/labyrinthe3.txt");
		
	}

}
