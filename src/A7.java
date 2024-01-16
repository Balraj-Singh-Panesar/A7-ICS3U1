/*
 * Culminating Assignment A7 in ICS3U1
 * Date Created 2024/01/11
 * Code Contributors: Balraj Singh,
 * ROLES:
 * Chief Operating Officer - Charlie
 * Product Manager - Isa
 * Coder - Balraj
 * User Experience - Kristiana
 * Quality Assurance - Ella
 * */

import javax.swing.*;
import java.awt.*;

class A7 {
    private static final String FRAME_NAME = "Connect Four";
    private static final String FILE_PATH_TO_ICON = "";
    private static void createWindow(){
        JFrame A7 = new JFrame(FRAME_NAME);
        ImageIcon icon = new ImageIcon(FILE_PATH_TO_ICON);
        A7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        A7.setSize(new Dimension(810,  1440));
        A7.setExtendedState(JFrame.MAXIMIZED_BOTH);
        A7.setIconImage(icon.getImage());
        A7.setVisible(true);
    }
    public static void main(String[] args) {
        createWindow();
    }
}