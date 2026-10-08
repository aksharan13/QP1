
import javax.swing.*;
import java.awt.*;

public class Picture
{
    // Instance variables
    private JFrame frame;
    private ImageIcon background;

    // Constructor
    public Picture()
    {
        frame = new JFrame("Wild West");
        background = new ImageIcon("wildwest.jpg");
    }

    // Draw method
    public void draw()
    {
        JLabel picture = new JLabel(background);

        frame.add(picture);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
