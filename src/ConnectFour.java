import javax.swing.*;
class ConnectFour{
    /**
     * Keeps track of what player is currently playing, if the current player is player one it is true
     */
    private boolean isPlayerOne;
    /**
     the possible states the match could be in
     */
    private enum matchStates {
      WON, TIE, PLAYING
    };
    /**
     * 2D array that represents the Connect Four Board;
     */
    private int [][] board = {{1, 2, 3, 4, 5, 6, 7}, {1, 2, 3, 4, 5, 6, 7}};

    /**
     * Draw the Board on screen to be viewed;
     */
    public static void drawBoard(){
    }
    /**
     * Determines if the move is invalid. IE. Player attempts to add the piece to full column
    @return true if invalid
     */
    private static boolean invalidMove(){
        return false;
    }

    /**
     * Determines the match state
     *@return enum matchStates
     */
    private static matchStates matchState(){
        return matchStates.PLAYING;
    }








}