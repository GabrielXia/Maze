package interfaces;

import javax.swing.*;

/**This class is for the windows to Reminder the utilisation of this game*/
public class ReminderWindows {
    /**
     * windows show at the build of maze
     */
    public static final void reminderUtilization(){
        JOptionPane.showMessageDialog(null, "A Click to put a wall(block black)\n" +
                "A Shift Click on a block to put a start box(block red)\n" +
                "A Shift Click on a start box to put the end box(block blue)\n" +
                "Control+S to save\n" +
                "Control+L to load the game saved\n" +
                "Control+N to open a new game\n" +
                "Control+Q to quit");
    }
}
