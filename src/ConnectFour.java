import java.awt.*;

class ConnectFour{
    A7 parent;
    /**Number of grid cells in a board for X*/
    private final int BOARD_SIZE_X = 7;
    /**Number of grid cells in a board for y*/
    private final int BOARD_SIZE_Y = 6;
    /** Keeps track of what player is currently playing, if the current player is player one it is true */
    private boolean isPlayerOne;
    /** the possible states the match could be in */
    enum matchStates {
      WON, TIE, PLAYING
    };


    /** 2D array that represents the Connect Four Board */
    GridCell[][] board = null;

    public void init(A7 parent){
        this.parent = parent;
        board = new GridCell[BOARD_SIZE_X][BOARD_SIZE_Y];
        for (int i = 0; i < BOARD_SIZE_X; i++) {
            for (int j = 0; j < BOARD_SIZE_Y; j++) {
                board[i][j] = new GridCell(GridCell.GRID_X_SPACING * (i + 1), GridCell.GRID_Y_SPACING * (j + 1),parent);
            }
        }
        board[1][3].setState(GridCell.State.PLAYER_TWO);
    }

    /** Determines if the move is invalid. IE. Player attempts to add the piece to full column
    @return true if invalid */
    private boolean invalidMove(){
        return false;
    }

    /** Determines the match state
     *@return enum matchStates */









}