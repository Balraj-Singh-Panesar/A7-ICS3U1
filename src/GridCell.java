import javax.swing.*;
import java.awt.*;
public class GridCell extends JPanel {
    A7 parent;
    /**Constant for the size of the grid*/
    static final int GRID_SIZE = 125;
    /**Initial X offset of the grid corner*/
    private static final int GRID_X_OFFSET = 325;
    /**Initial Y offset of the grid corner*/
    private static final int GRID_Y_OFFSET = 40;
    /**X offset between each cell*/
    public static final int GRID_X_SPACING = 135;
    /**Y offset between each cell*/
    public static final int GRID_Y_SPACING = 135;
    /**Colour of the grid cell when empty*/
    private Color emptyColour = new Color(87, 158, 250);
    /**Colour of the grid cell for player one*/
    private Color playerOneColour = new Color(217, 0, 0);
    /**Colour of the grid cell for player two*/
    private Color playerTwoColour = new Color(255, 206, 0);

    /**Possible states of the grid cell*/
    enum State{
        EMPTY,
        PLAYER_ONE,
        PLAYER_TWO
    }

    /**Stores the curent state of grid cell*/
    private State state = State.EMPTY;

    /** Creates a Jpanel on frame of a fixed size
     * @param xOffset Relative to the initial offset
     * @param yOffset Relative to the initial offset*/
    GridCell(int xOffset, int yOffset, A7 parent){
        this.parent = parent;
        this.setBounds(GRID_X_OFFSET + xOffset,GRID_Y_OFFSET + yOffset,GRID_SIZE,GRID_SIZE);
        //System.out.printf("x: %d, y: %d\n", gridCell.getX(), gridCell.getY());
        this.setOpaque(false);
        parent.add(this);

    }

    /**Set the state of the grid cell*/
    public void setState(State state) {
        this.state = state;
    }

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
                break;
            case PLAYER_TWO:
                g2d.setColor(playerTwoColour);
                g2d.fillOval(0, 0, this.getWidth(), this.getHeight());
                break;
        }
    }

}


