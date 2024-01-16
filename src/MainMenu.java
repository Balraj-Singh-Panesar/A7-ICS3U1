import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

class MainMenu{

    String playerOneName = "Player One";
    String playerTwoName = "Player Two";
    public static void menu() {

        JFrame myFrame = new JFrame();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(new Dimension(500,500));
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setLocationRelativeTo(null);

        Scanner myObj = new Scanner(System.in);

        // gets the users names
        System.out.print("What is player ones name?");
        String playerOneName = myObj.nextLine();
        System.out.println("What is player twos name");
        String playerTwoName = myObj.nextLine();

        System.out.println("Main Menu \n====================================");
        System.out.println("1. Connect 4 \n2. Quit");

        // the user chooses what they would like to do
        int choice = myObj.nextInt();

        // determines if the user wants to play connect 4 or exit the program
        switch (choice) {
            case 1: // connect 4 is chosen
                // connect 4 function
            case 2: // the user exits the game
                break;
        } */
    }
}
            case 1:
                // connect 4 function
            case 2:
                break;
            default:
            // if invalid choice is inputted, default to something
        }
    }
}
