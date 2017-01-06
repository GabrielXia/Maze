package main;

import java.io.IOException;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.Previous;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import interfaces.GameModel;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

/** This class is for testing*/
public class MainTest {

	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze maze= new Maze("data/labyrinthe.txt");
		PreviousInterface previous = Dijkstra.dijkstra(maze,maze.getStartVertex());
		ArrayList<VertexInterface> shortestPathTo = previous.getShortestPathTo(maze.getEndVertex());
		System.out.println(shortestPathTo.size());
		
	}
}
