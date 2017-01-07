# Maze
Find the shortest path from a start box to an end box
###1. Introduction
This maze constituted of four kinds of boxes : DBox is the start box, ABox is the end box, WBoxs are wall box that the path cann't pass, EBox are the empty boxes that the path can pass. The goal is to find the shortest path from DBox to ABox using algorithm Dijkstra.
###2. Documents
####2.1. src
#####2.1.1. package dijkstra
This package contains the interfaces and the classes to implement algorithm Dijkstra.
#####2.1.2. package interface
This package contains the classes to implement java interface graphic using Swing.
#####2.1.3. package main
This package contains the main controller of this program.
#####2.1.4. package maze
This package contains the classes implement elements in this maze.
####2.2. doc
Folder doc contains Java Doc of every class in this program.
####2.3. data
Folder data contains text to store maze information, it's used for "save" and "load" function.
###3. How to use
- Run MazeController in main package
- Enter the width and height
- A click to put a wall in a block, a second click to delete the wall
- A shift-click on an empty block to put a start block
- A shift-click on a start block to put an end block (When there are start box and end box, the shortest path shows !)
- `ctrl + s` to save the maze  
- `ctrl + l` to load the maze that you save
- `ctrl + n` to start a new maze
- `ctrl + q` to quit
