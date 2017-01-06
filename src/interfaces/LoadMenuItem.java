package interfaces;

import maze.MazeReadingException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by XIAJin on 2017/1/2.
 */
public class LoadMenuItem extends JMenuItem implements ActionListener {
    static final long serialVersionUID = 201503101423L ;

    /** The current Java frame. */
    private final GameFrame gameWindow ;

    /** Constructor:
     * @param gameWindow The current Java frame.
     */
    public LoadMenuItem(GameFrame gameWindow)
    {
        super("Load") ;
        this.gameWindow = gameWindow ;
        addActionListener(this) ;
    }

    /** Action for the menu. */
    public final void actionPerformed(ActionEvent evt)
    {
        try {
            gameWindow.load();
        }catch (IOException e){
            e.printStackTrace();
        }catch (MazeReadingException e){
            e.printStackTrace();
        }
    }
}
