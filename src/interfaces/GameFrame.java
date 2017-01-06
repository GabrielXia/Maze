package interfaces;

import main.MazeController;
import maze.MazeReadingException;

import java.awt.* ;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.* ;

/** This is the JFrame class for the main game window. */

public final class GameFrame extends JFrame
{
	static final long serialVersionUID = 201503101423L ;
	
	/** The game panel, ie. the content of the window. */
	private final GamePanel gamePanel ;

	/** The gameController is to communicate with controller*/
	private final FileMenu.GameController gameController;

	/** The constructor :
	 * @param gameController The game controller.
	 * @param name The game name to be displayed at the top of the window.
	 * @param gameWidth The width of the game in blocks.
	 * @param gameHeight The height of the game in blocks.
	 * @param blockWidth The width in pixel of a screen block.
	 * @param blockHeight The height in pixel of a screen block.
	 */
	public GameFrame(FileMenu.GameController gameController, String name, int gameWidth, int gameHeight, int blockWidth, int blockHeight)
	{
		super(name) ;
		this.gameController = gameController;
		// Widgets

		setJMenuBar(new GameMenuBar(this)) ;
		
		setContentPane(gamePanel = new GamePanel(gameController,gameWidth,gameHeight,blockWidth,blockHeight)) ;
		
		// Epilogue
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		int sizeW = blockWidth  * gameWidth  ;
		int sizeH = blockHeight * gameHeight ;

		setSize(sizeW,sizeH) ;
		setVisible(true) ;
		
		Dimension dimension = gamePanel.getSize() ;
		
		int widthToAdd  = (int)(sizeW - dimension.getWidth()) ;
		int heightToAdd = (int)(sizeH - dimension.getHeight()) ;
		
		setSize(sizeW + widthToAdd,sizeH + heightToAdd) ;
		setResizable(false) ;	
		
		addKeyListener(gameController) ;
	}

	/**
	 * The setter
	 * @param gameModel the game model
	 */
	public final void set(GameModel gameModel)
	{
		gamePanel.set(gameModel);
		repaint() ;
	}

	/**
	 * creat a new maze
	 */
	public final void newMaze()
	{
		int response
				= JOptionPane.showInternalOptionDialog(
				gamePanel,
				"New maze ?",
				"New application",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,null,null) ;
		switch (response) {
			case JOptionPane.OK_OPTION:
				((MazeController)gameController).newMaze();
			case JOptionPane.NO_OPTION:
				break ;
		}
	}

	/**
	 * quit the game
	 */
	public final void quit()
	{
		   int response 
		   	= JOptionPane.showInternalOptionDialog(
		   			 gamePanel,
                   "Really quit ?",
                   "Quit application",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.WARNING_MESSAGE,
                   null,null,null) ;
		   switch (response) {
		   case JOptionPane.OK_OPTION:
			   System.exit(0) ;
		   case JOptionPane.NO_OPTION:
			   break ;
		   }		
	}

	/**
	 * save maze to data.labyrinthe.txt
	 * @throws FileNotFoundException
	 */
	public final void save() throws FileNotFoundException{
		int response
				= JOptionPane.showInternalOptionDialog(
						gamePanel,
				"Really save ?",
				"Save application",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,null,null) ;
		switch (response) {
			case JOptionPane.OK_OPTION:
				((MazeController)gameController).saveMaze();
			case JOptionPane.NO_OPTION:
				break ;
		}
	}

	/**
	 * load maze from data/labyrinthe.txt
	 * @throws IOException
	 * @throws MazeReadingException
	 */
	public final void load() throws IOException, MazeReadingException{
		int response
				= JOptionPane.showInternalOptionDialog(
				gamePanel,
				"Really load ?",
				"Load application",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,null,null) ;
		switch (response) {
			case JOptionPane.OK_OPTION:
				((MazeController)gameController).loadMaze();
			case JOptionPane.NO_OPTION:
				break ;
		}
	}

}
