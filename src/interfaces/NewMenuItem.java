package interfaces;

import javax.swing.* ;

/** The Quit menu item inside the File menu. */

import java.awt.event.* ;

public final class NewMenuItem extends JMenuItem
        implements ActionListener
{
    static final long serialVersionUID = 201503101423L ;

    /** The current Java frame. */
    private final GameFrame gameWindow ;

    /** Constructor:
     * @param gameWindow The current Java frame.
     */
    public NewMenuItem(GameFrame gameWindow)
    {
        super("New") ;
        this.gameWindow = gameWindow ;
        addActionListener(this) ;
    }

    /** Action for the menu. */
    public final void actionPerformed(ActionEvent evt)
    {
        gameWindow.newMaze() ;
    }

}
