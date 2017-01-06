package main;

import dijkstra.VertexInterface;
import interfaces.FileMenu;
import interfaces.GameFrame;
import interfaces.GameModel;
import interfaces.GameThread;
import maze.DBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.WBox;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the main controller of the game
 */
public class MazeController extends FileMenu.GameController {
    /**
     * this is  main function
     * @param args
     */
    public static void main(String[] args){
        Maze labyrinth = new Maze();
        new MazeController("Maze",labyrinth.getWidth(),labyrinth.getHeight(),30,30,labyrinth) ;
    }

    private final boolean debug = true ;

    /** The model of this game*/
    private GameModel gameModel ;

    /**The width of maze*/
    private int gameWidth ;

    /**THe height of maze*/
    private int gameHeight;

    /** The width of each block*/
    private final int blockWidth ;

    /** The height of each blaock*/
    private final int blockHeight ;

    /** The game thread*/
    private final GameThread gameThread ;

    /** The maze of this game*/
    private maze.Maze labyrinth;

    /** The path from start box to end box*/
    ArrayList<VertexInterface> path;

    /**
     * Constructor
     * @param name name of game
     * @param gameWidth width of game
     * @param gameHeight height of game
     * @param blockWidth width of block
     * @param blockHeight height of block
     * @param maze maze of game
     */
    public MazeController(String name, int gameWidth, int gameHeight, int blockWidth, int blockHeight, Maze maze)
    {
        super(name,gameWidth,gameHeight,blockWidth,blockHeight) ;

        this.gameWidth   = gameWidth ;
        this.gameHeight  = gameHeight ;
        this.blockWidth  = blockWidth ;
        this.blockHeight = blockHeight ;
        this.labyrinth = maze;

        this.gameModel   = new GameModel(gameWidth,gameHeight,blockWidth,blockHeight) ;
        gameModel.fillRectangle(0,0,gameWidth,gameHeight,GameModel.white);
        notify(gameModel);

        gameThread = new GameThread(this,"tictac") ;
        gameThread.start() ;
    }

    /**
     * getter of game width
     * @param gameWidth
     */
    public final void setGameWidth(int gameWidth) {
        this.gameWidth = gameWidth;
    }

    /**
     * setter of game height
     * @param gameHeight
     */
    public final void setGameHeight(int gameHeight) {
        this.gameHeight = gameHeight;
    }

    /**
     * setter of maze
     * @param labyrinth
     */
    public final void setLabyrinth(Maze labyrinth) {
        this.labyrinth = labyrinth;
    }

    /**
     * start a new maze
     */
    public final void newMaze(){
        this.labyrinth = new Maze();
        this.setLabyrinth(labyrinth);
        this.setGameHeight(labyrinth.getHeight());
        this.setGameWidth(labyrinth.getWidth());
        this.gameModel   = new GameModel(gameWidth,gameHeight,blockWidth,blockHeight) ;
        this.disposeGameFrame();
        this.setGameFrame(new GameFrame(this,"Maze",gameWidth,gameHeight,blockWidth,blockHeight) );
        gameModel.fillRectangle(0,0,gameWidth,gameHeight,GameModel.white);
        notify(gameModel);

    }

    /**
     * save maze to data/labyrinthe.txt
     * @throws FileNotFoundException
     */
    public  final void saveMaze() throws FileNotFoundException{
        labyrinth.saveToTextFile("data/labyrinthe.txt");
    }

    /**
     * load maze from data/labyrinthe.txt
     * @throws IOException
     * @throws MazeReadingException
     */
    public final void loadMaze() throws IOException,MazeReadingException{
        labyrinth.initFromTextFile("data/labyrinthe.txt");
        drawFromMaze();
    }

    /**
     * refresh game model from maze in memory
     */
    public void drawFromMaze(){
        gameModel.fillRectangle(0,0,gameWidth,gameHeight,GameModel.white);
        if(labyrinth.ifContainsStartVertex())
        gameModel.set( labyrinth.getStartVertex().getWidthCoordinate(), labyrinth.getStartVertex().getLengthCoordinate(),GameModel.red);
        if(labyrinth.ifContainsEndVertex())
        gameModel.set( labyrinth.getEndVertex().getWidthCoordinate(), labyrinth.getEndVertex().getLengthCoordinate(),GameModel.blue);
        for(WBox i:labyrinth.getWBox()){
            gameModel.set( i.getWidthCoordinate(), i.getLengthCoordinate(),GameModel.black);
        }
        notify(gameModel);
        if(labyrinth.ifContainsStartVertex()&&labyrinth.ifContainsEndVertex()){
            path = dijkstra.Dijkstra.dijkstra(labyrinth,labyrinth.getStartVertex()).getShortestPathTo(labyrinth.getEndVertex());
            for(VertexInterface i :path){
                maze.MBox m = (maze.MBox) i;
                if(m.equals(labyrinth.getStartVertex()) || m.equals(labyrinth.getEndVertex()))continue;
                gameModel.set(m.getWidthCoordinate(),m.getLengthCoordinate(),GameModel.yellow);
                //notify(gameModel);
            }
        }
        notify(gameModel);
    }

    /**
     * this function run every period
     */
    public final synchronized void tictac()
    {
        if (debug){
            System.err.println("lala");
        }
    }

    /**
     * test if there is already an ABox
     * @param e
     * @return
     */
    public final boolean ifSetABox(MouseEvent e){
        if(labyrinth.getStartVertex()==null)return false;
        else return labyrinth.getStartVertex().getWidthCoordinate()==this.getGameX(e)&&(labyrinth.getStartVertex().getLengthCoordinate()==this.getGameY(e));
    }
    
    public final boolean ifDeleteWBox(MouseEvent e){
        if(labyrinth.getWBox()==null)return false;
        for(WBox i:labyrinth.getWBox()){
        	if(i.getWidthCoordinate()==this.getGameX(e)&&i.getLengthCoordinate()==this.getGameY(e)){
        		labyrinth.getWBox().remove(i);
        		return true;
        	}
        }
        return false;
    }

    /** Invoked when the mouse button has been clicked (pressed and released) on a component. */
    @Override
    public final synchronized void mouseClicked(MouseEvent e) {
        if (debug) {
        	System.err.println("Mouse clicked");
            if (!e.isShiftDown()) {
            	if(!ifDeleteWBox(e)){
            		labyrinth.addWBox(new WBox(this.getGameY(e), this.getGameX(e)));
            	}
                
            } else {
                if (!ifSetABox(e)) {
                    labyrinth.addDBox(new DBox(getGameY(e), getGameX(e)));
                } else {
                    labyrinth.addABox(new maze.ABox(getGameY(e), getGameX(e)));

                }
            }
            drawFromMaze();
        }
    }

    /** Invoked when a mouse button has been pressed on a component. */
    @Override
    public final synchronized void mousePressed(MouseEvent e)
    {
        if (debug){
            System.err.println("Mouse pressed") ;
        }
    }

    /** Invoked when a mouse button has been released on a component. */
    @Override
    public final synchronized void mouseReleased(MouseEvent e)
    {
        if (debug)
            System.err.println("Mouse released") ;
    }

    /** Invoked when the mouse enters a component. */
    @Override
    public final synchronized void mouseEntered(MouseEvent e)
    {
        if (debug)
            System.err.println("Mouse entered") ;
    }

    /** Invoked when the mouse exits a component. */
    @Override
    public final synchronized void mouseExited(MouseEvent e)
    {
        if (debug)
            System.err.println("Mouse exited") ;
    }

    /** Invoked when a mouse button is pressed on a component and then dragged.
     *  MOUSE_DRAGGED events will continue to be delivered to the component
     *  where the drag originated until the mouse button is
     *  released regardless of whether the mouse position is within the
     *  bounds of the component.
     */
    @Override
    public final synchronized void mouseDragged(MouseEvent e)
    {
        if (debug)
            System.err.println("Mouse dragged") ;
    }

    /** Invoked when the mouse cursor has been moved onto a
     *  component but no buttons have been pushed.
     */
    @Override
    public final synchronized void mouseMoved(MouseEvent e)
    {
        if (debug)
            System.err.println("Mouse moved") ;
    }

    /** Invoked when the mouse wheel is rotated. */
    @Override
    public final synchronized void mouseWheelMoved(MouseWheelEvent e)
    {
        if (debug)
            System.err.println("Mouse wheel moved") ;
    }

    /** Invoked when a key has been typed.
     *  See the class description for KeyEvent for a definition of a key typed event.
     */
    @Override
    public final synchronized void keyTyped(KeyEvent e)
    {
        if (debug)
            System.err.println("Key typed: " + e.paramString()) ;

    }

    /** Invoked when a key has been pressed.
     *  See the class description for KeyEvent for a definition of a key pressed event.
     */
    @Override
    public final synchronized void keyPressed(KeyEvent e)
    {
        if (debug) {
            System.err.println("Key pressed: " + e.getModifiers());


            //Ctrl + s to save
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
                try {
                    saveMaze();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

            if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_L){
                try {
                    loadMaze();
                } catch (IOException exception ) {
                    exception.printStackTrace();
                } catch (MazeReadingException exception){
                    exception.printStackTrace();
                }
            }

            if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N){
                newMaze();
            }

            if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Q){
                System.exit(0);
            }
        }
    }

    /** Invoked when a key has been released.
     *  See the class description for KeyEvent for a definition of a key released event.
     */
    @Override
    public final synchronized void keyReleased(KeyEvent e)
    {
        if (debug) {
            System.err.println("Key released: " + e.paramString());
        }
    }

    /** Invoked when a component gains the keyboard focus. */
    @Override
    public final synchronized void focusGained(FocusEvent e)
    {
        if (debug)
            System.err.println("Focus gained") ;
    }

    /** Invoked when a component loses the keyboard focus. */
    @Override
    public final synchronized void focusLost(FocusEvent e)
    {
        if (debug)
            System.err.println("Focus lost") ;
    }

    /** Invoked the first time a window is made visible. */
    @Override
    public final synchronized void windowOpened(WindowEvent e)
    {
        if (debug)
            System.err.println("Windows opened") ;
    }

    /** Invoked when the user attempts to close the window from the window's system menu. */
    @Override
    public final synchronized void windowClosing(WindowEvent e)
    {
        if (debug)
            System.err.println("Windows closing") ;
    }

    /** Invoked when a window has been closed as the result of calling dispose on the window. */
    @Override
    public final synchronized void windowClosed(WindowEvent e)
    {
        if (debug)
            System.err.println("Windows closed") ;
    }

    /** Invoked when a window is changed from a normal to a minimized state.
     * For many platforms, a minimized window is displayed as the icon specified in the window's iconImage property.
     */
    @Override
    public final synchronized void windowIconified(WindowEvent e)
    {
        if (debug)
            System.err.println("Windows iconified") ;
    }

    /** Invoked when a window is changed from a minimized to a normal state. */
    @Override
    public final synchronized void windowDeiconified(WindowEvent e)
    {
        if (debug)
            System.err.println("Windows deiconified") ;
    }

    /** Invoked when the Window is set to be the active Window.
     * Only a Frame or a Dialog can be the active Window.
     * The native windowing system may denote the active Window or
     * its children with special decorations, such as a highlighted title bar.
     * The active Window is always either the focused Window,
     * or the first Frame or Dialog that is an owner of the focused Window.
     */
    @Override
    public final synchronized void windowActivated(WindowEvent e)
    {
        if (debug)
            System.err.println("Windows activated") ;
    }

    /** Invoked when a Window is no longer the active Window.
     * Only a Frame or a Dialog can be the active Window.
     * The native windowing system may denote the active Window or its children
     * with special decorations, such as a highlighted title bar.
     * The active Window is always either the focused Window,
     * or the first Frame or Dialog that is an owner of the focused Window.
     */
    @Override
    public final synchronized void windowDeactivated(WindowEvent e)
    {
        if (debug)
            System.err.println("Windows deactivated") ;
    }

}
