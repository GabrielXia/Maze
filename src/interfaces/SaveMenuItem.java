package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by XIAJin on 2017/1/1.
 */
public class SaveMenuItem extends JMenuItem implements ActionListener {
    static final long serialVersionUID = 201503101423L ;

    /** The current Java frame. */
    private final GameFrame gameWindow ;

    /** Constructor:
     * @param gameWindow The current Java frame.
     */
    public SaveMenuItem(GameFrame gameWindow)
    {
        super("Save") ;
        this.gameWindow = gameWindow ;
        addActionListener(this) ;
    }

    /** Action for the menu. */
    public final void actionPerformed(ActionEvent evt)
    {
        try {
            gameWindow.save();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
