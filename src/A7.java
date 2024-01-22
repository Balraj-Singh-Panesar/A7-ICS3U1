import javax.swing.*;
import java.awt.*;

/*
 * Culminating Assignment A7 in ICS3U1
 * Date Created 2024/01/11
 * ROLES:
 * Chief Executive Officer - Charlie
 * Product Manager - Isa
 * Coder - Balraj
 * User Experience - Kristiana
 * Quality Assurance - Ella
 * */

class A7 extends JFrame {
    /** The name that appears on the frame when the window is opened */
    private static final String FRAME_NAME = "Connect Four";
    /** The file path of the icon to appear when the window is opened*/
    private static final String FILE_PATH_TO_ICON = "ConnectFourIcon.png";
    /**The colour of the background in RGB values*/
    private static Color backGroundColour = new Color(21, 96, 246);

    static ConnectFour _ConnectFour = new ConnectFour();


    public void run() {
            this.setName(FRAME_NAME);
            //Create the ImageIcon Object and define the file path to the image
            ImageIcon icon = new ImageIcon(FILE_PATH_TO_ICON);
            //Sets the default close operation to exit the program when closed
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Sets the default size of the window when the window is not full screen
            this.setSize(new Dimension(1440, 810 ));
            //Sets the background colour
            this.getContentPane().setBackground(backGroundColour);
            //Sets the JFrame to be full screen when created
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //Applies the IconImage to the JFrame;
            this.setIconImage(icon.getImage());
            //Disables default layout
            this.setLayout(null);
            //Sets the window to be visible after every config is applied
            this.setVisible(true);

            _ConnectFour.init(this);
            this.repaint();


        }
        public static void main(String[] args){
            A7 Panel = new A7();
            Panel.run();

            //Constantly updates board and ends the program if someone has won
            while (true){
                _ConnectFour.DisplayWinner();
                Panel.repaint();

                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException ignored) {

                }
            }
    }
}
