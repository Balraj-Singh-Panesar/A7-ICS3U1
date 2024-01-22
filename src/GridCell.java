import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GridCell extends JPanel {
    A7 parent;
    int column;

    /**Constant for the size of the grid cell*/
    static final int GRID_CELL_SIZE = 125;
    /**Initial X offset of the grid corner*/
    private static final int GRID_X_OFFSET = 325;
    /**Initial Y offset of the grid corner*/
    private static final int GRID_Y_OFFSET = 40;
    /**X offset between each cell*/
    public static final int GRID_X_SPACING = 135;
    /**Y offset between each cell*/
    public static final int GRID_Y_SPACING = 135;
    /**Colour of the grid cell when empty*/
    private static final Color emptyColour = new Color(87, 158, 250);
    /**Colour of the grid cell for player one*/
    private static final Color playerOneColour = new Color(217, 0, 0);
    /**Colour of the outline of the grid cell for player one*/
    private static final Color playerOneOutlineColour = new Color(171, 2, 2);
    /**Colour of the grid cell for player two*/
    private static final Color playerTwoColour = new Color(255, 206, 0);
    /**Colour of the outline of the grid cell for player two*/
    private static final Color playerTwoOutlineColour = new Color(159, 132, 18);

    private static final int STROKE_WIDTH = 10;


    /**Possible states of the grid cell*/
    enum State{
        EMPTY,
        PLAYER_ONE,
        PLAYER_TWO
    }

    /**Stores the current state of grid cell*/
    private State state = State.EMPTY;

    /** Creates a Jpanel on frame of a fixed size
     * @param xOffset Relative to the initial offset
     * @param yOffset Relative to the initial offset*/
    GridCell(int xOffset, int yOffset, A7 parent, int column){
        this.parent = parent;
        this.column = column;

        this.setBounds(GRID_X_OFFSET + xOffset,GRID_Y_OFFSET + yOffset, GRID_CELL_SIZE, GRID_CELL_SIZE);
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                parent._ConnectFour.addPiece(column);
                parent._ConnectFour.isPlayerOne = !parent._ConnectFour.isPlayerOne;
            }
        });
        this.setOpaque(false);
        parent.add(this);

    }

    /**Set the state of the grid cell
     * @param state*/
    public void setState(State state) {
        this.state = state;
    }

    /**Get the state of the gridcell
     * @return GridCell.state*/
    public State getState(){
        return state;
    }

    /**Checks to see if cell is full
     * @return Boolean True if full, false if empty*/
    public boolean isFull(){
        return state == State.PLAYER_ONE || state == State.PLAYER_TWO;
    }

    // Paints the correct colour depending on grid state;
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (state) {
            case EMPTY:
                g2d.setColor(emptyColour);
                g2d.fillOval(0, 0, this.getWidth(), this.getHeight());
                break;
            case PLAYER_ONE:
                g2d.setColor(playerOneColour);
                g2d.fillOval(0, 0, this.getWidth(), this.getHeight());
                g2d.setColor(playerOneOutlineColour);
                g2d.setStroke(new BasicStroke(STROKE_WIDTH));
                g2d.drawOval(STROKE_WIDTH / 2,STROKE_WIDTH / 2,this.getWidth() - STROKE_WIDTH,this.getHeight() - STROKE_WIDTH);
                break;
            case PLAYER_TWO:
                g2d.setColor(playerTwoColour);
                g2d.fillOval(0, 0, this.getWidth(), this.getHeight());
                g2d.setColor(playerTwoOutlineColour);
                g2d.setStroke(new BasicStroke(STROKE_WIDTH));
                g2d.drawOval(STROKE_WIDTH / 2,STROKE_WIDTH / 2,this.getWidth() - STROKE_WIDTH,this.getHeight() - STROKE_WIDTH);
                break;
        }
    }

}


