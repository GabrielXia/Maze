package main;

import java.util.ArrayList;

public class Maze {

	private ArrayList<ArrayList<MBox>> boxes ;
	private int getLength(){
		return boxes.size();
	}
	private int getWidth(){
		return boxes.get(0).size();
	}
	
}
