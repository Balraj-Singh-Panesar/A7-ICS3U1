import javax.swing.*;
import java.awt.*;

class ConnectFour{
    A7 parent;
    /**Number of grid cells in a board for X*/
    private final int BOARD_SIZE_X = 7;
    /**Number of grid cells in a board for y*/
    private final int BOARD_SIZE_Y = 6;
    /** Keeps track of what player is currently playing, if the current player is player one it is true */
    public boolean isPlayerOne;
    /** the possible states the match could be in */
    /**Stores the name of the colour corresponding ot the current player*/
    String pieceColour = "";
    /** the possible states the match could be in */
    enum matchStates {
      WON, TIE, PLAYING
    };
    /** 2D array that represents the Connect Four Board */
    GridCell[][] board = null;

    /**Initialized the connect Four class*/
    public void init(A7 parent){
        this.parent = parent;
        //creates the connect four board
        board = new GridCell[BOARD_SIZE_X][BOARD_SIZE_Y];
        for (int coloumn = 0; coloumn < BOARD_SIZE_X; coloumn++) {
            for (int row = 0; row < BOARD_SIZE_Y; row++) {
                board[coloumn][row] = new GridCell(GridCell.GRID_X_SPACING * (coloumn + 1), GridCell.GRID_Y_SPACING * (row + 1),parent,coloumn);
            }
        }
    }

    /**Clears the board by setting every cell's state to zero*/
    private void resetBoard(){
        isPlayerOne = true;
        for (int coloumn = 0; coloumn < BOARD_SIZE_X; coloumn++) {
            for (int row = 0; row < BOARD_SIZE_Y; row++) {
                board[coloumn][row].setState(GridCell.State.EMPTY);
            }
        }
    }

    /**Checks if anyone has won and displays the winner or tie*/
    public void DisplayWinner(){
        if(matchState() == matchStates.TIE){
            parent.repaint();
            JOptionPane.showMessageDialog(parent, "The game has tied" );
            resetBoard();
        }
        if(matchState() == matchStates.WON){
            parent.repaint();
            JOptionPane.showMessageDialog(parent, pieceColour + " has won the match!" );
            resetBoard();
        }
        if(isPlayerOne){
            pieceColour = "Red";
        }
        else{
            pieceColour = "Yellow";
        }
    }

    /**Adds game piece to the board
     * @param column*/
    public void addPiece(int column){
        // The game piece is only added if the column is not full and if the game is still playing
        if (!invalidMove(column) && matchState() == matchStates.PLAYING) {
            /*
            * Start at the bottom of the board, if the current position is full, go up one
            * repeat this until empty spot is found and set state of the current grid cell to the current player
            * */
            for (int row = BOARD_SIZE_Y - 1; row >= 0; row--){
                if(!board[column][row].isFull()){
                    if(isPlayerOne){
                        board[column][row].setState(GridCell.State.PLAYER_ONE);
                    }
                    else {
                        board[column][row].setState(GridCell.State.PLAYER_TWO);
                    }
                    break;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(parent, "Invalid Move" );
        }
    }

    /** Determines if the move is invalid. IE. Player attempts to add the piece to full column
    @return true if invalid */
    private boolean invalidMove(int column){
        // checks the top of the board to see if is full
        return (board[column][0].isFull());
    }

    /** Determines the match state
     *@return enum matchStates */
    public matchStates matchState(){
        //Checks the horizontal win conditions
        for (int column = 0; column < BOARD_SIZE_X - 3; column++){
            for(int row = 0; row < BOARD_SIZE_Y; row++){
                if (board[column][row].isFull() && board[column][row].getState() == board[column + 1][row].getState() && board[column][row].getState() == board[column + 2][row].getState() && board[column][row].getState() == board[column + 3][row].getState()){
                    return matchStates.WON;
                }
            }
        }
        //checks the vertical win condition
        for (int colunm = 0; colunm < BOARD_SIZE_X; colunm++){
            for(int row = 0; row < BOARD_SIZE_Y - 3; row++){
                if (board[colunm][row].isFull() && board[colunm][row].getState() == board[colunm][row + 1].getState() && board[colunm][row].getState() == board[colunm][row + 2].getState() && board[colunm][row].getState() == board[colunm][row + 3].getState()){
                    return matchStates.WON;
                }
            }
        }
        //checks both diagonals
        for (int column = 0; column < BOARD_SIZE_X - 3; column++){
            for (int row = 0; row < BOARD_SIZE_Y - 3; row++){
                if (board[column][row].isFull() && board[column][row].getState() == board[column + 1][row + 1].getState() && board[column][row].getState() == board[column + 2][row + 2].getState() && board[column][row].getState() == board[column + 3][row + 3].getState()){
                    return matchStates.WON;
                }
                if (board[column + 3][row].isFull() && board[column + 3][row].getState() == board[column + 2][row + 1].getState() && board[column + 3][row].getState() == board[column + 1][row + 2].getState() && board[column + 3][row].getState() == board[column][row + 3].getState()){
                    return matchStates.WON;
                }
            }
        }

        //checks if the board is full
        for (int column = 0; column < BOARD_SIZE_X; column++){
            for (int row = 0; row < BOARD_SIZE_Y; row++){
                if (!board[column][row].isFull()){
                    return matchStates.PLAYING;
                }
            }
        }
        //if the board is full and no win condition is found then it is a tie
        return matchStates.TIE;
    }

}