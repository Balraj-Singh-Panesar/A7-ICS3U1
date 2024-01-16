import java.util.Scanner;

class MainMenu{

    String playerOneName = "Player One";
    String playerTwoName = "Player Two";
    public static void menu() {
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
            case 1:
                // connect 4 function
            case 2:
                break;
            default:
            // if invalid choice is inputted, default to something
        }
    }
}