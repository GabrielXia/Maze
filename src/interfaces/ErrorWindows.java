package interfaces;

import javax.swing.*;

/** This class is to show the error window
 */
public class ErrorWindows {
    /**
     * windows show when there is no solution
     */
    public final static  void errorNoSolution(){
        JOptionPane.showMessageDialog(null, "There is no solution");
    }

    /**
     * windows show when there are errors in number entered
     */
    public final static  void errorEntered(){
        JOptionPane.showMessageDialog(null,"Please enter width and height !");
    }
}
