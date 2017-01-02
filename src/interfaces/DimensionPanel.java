package interfaces;

import javax.swing.* ;
/**
 * Created by XIAJin on 2017/1/2.
 */
public class DimensionPanel {
    private int width;
    private int height;

    public  DimensionPanel(){
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
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return height;
    }
}
