package interfaces;

import javax.swing.* ;

/** The frame Panel that gets dimensions from users containing the game. */

public class DimensionPanel {
    private int width;
    private int height;

    /**
     * Constructor
     */
    public DimensionPanel(){
        try {
            JTextField xField = new JTextField(5);
            JTextField yField = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("width:"));
            myPanel.add(xField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("height:"));
            myPanel.add(yField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter Width and Height", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                width = Integer.parseInt(xField.getText());
                height = Integer.parseInt(yField.getText());
            }
        }catch (NumberFormatException e){
            ErrorWindows.errorEntered();
            System.exit(1);

        }
    }

    /**
     *Returns the horizontal size of the maze.
     * @return integer which is the horizontal size of the maze
     */
    public final int getWidth() {
        return width;
    }

    /**
     *Returns the vertical size of the maze.
     * @return integer which is the vertical size of the maze
     */
    public final int getLength() {
        return height;
    }
}
