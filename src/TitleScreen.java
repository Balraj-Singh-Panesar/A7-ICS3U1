import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen {
    private JPanel TitleScreen;
    private JTextField connect4TextField;
    private JButton playConnect4Button;
    private JTextField playerOneTextField;

    public TitleScreen() {
        playConnect4Button.addActionListener(new ActionListener() {
            // runs connect 4 once the "Play Connect 4" is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                // connect 4 run function
            }
        });
    }
}
