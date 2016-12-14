package main;

import java.io.IOException;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.Previous;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

public class MainTest {

	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze maze= new Maze("data/labyrinthe.txt");
		PreviousInterface previous = Dijkstra.dijkstra(maze,maze.getStartVertex());
		ArrayList<VertexInterface> shortestPathTo = previous.getShortestPathTo(maze.getEndVertex());

		
	}

}
