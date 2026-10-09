
/*
 * References:
 * I used a lot of YouTube Videos as tutorials, as well as past assignments to base my code off of. Here are the YouTube tutorials that I used (listed below). I also added single
 * line comments above the code I to specify which lines of code I used the tutorials for. I also used a couple of articles, for example on using
 * coordinate systems for 2D graphics in order to integrate some math topics into my project. I have included the used links below.
 * List of YouTube Videos:
 * 1) Java GUI from Bro Code
 * 2) Java Swing GUI Full Course from Bro Code
 * 3) "Figure out where your project is located for BlueJ or IntelliJ" from Coding Diary
 * 
 * List of articles:
 * 1) https://docs.oracle.com/javase/tutorial/2d/overview/coordinate.html -> used for 2D coordinates
 * 2) https://docs.oracle.com/javase/tutorial/uiswing/components/jcomponent.html -> used to set the bounds of my imported images (x and y values, width, and height)
 * 3) https://docs.oracle.com/javase/tutorial/uiswing/components/label.html -> used for the setText methods within JLabel for my images
 * 4) https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JOptionPane.html -> used for reading about JOptionPane as mentioned in the QP1 rubric
 * 
 * Images used:
 * Western Background from Magnific
 * Cartoon Horses from iStock
 * Cartoon Rattlesnake from Abposters.com
 * Cartoon Lasso from iStock
 * Cartoon Tumbleweed and its shadow from Vecteezy
 */
// I imported two packages "javax.swing.*"  allows me use JFrame, JPanel, and ImageIcon. JFrame creates the window for my game, JPanel creates the specific area that allows my game to 
// be viewed, and ImageIcon allows me to import the images within the OOP Project folder such as horse1.png and wildwest.jpg (background image). To learn about these packages I used
// two YouTube videos, Java GUI that went in detail over the javax.swing.* package, and the Java Swing GUI Full Course from Bro Code for tutorials on both packages.
import javax.swing.*;
import java.awt.*;

public class Picture2 extends JPanel
{
    // fields and instance variables
    private JFrame frame;
    private Race race;
    private JLabel horse1;
    private JLabel horse2;
    private JLabel miles1;
    private JLabel miles2;
    private JLabel winner;

    // constructors
    public Picture2(Race game)
    {
        race = game;

        /*
         * this is how the java.awt.* package can use ImageIcon by importing images within my QP1 folder. I included my first successful attempt of importing an image into BlueJ on
         * my github repository, but I found a more efficient way by using a YouTube video titled "Figure out where your project is located for BlueJ or IntelliJ" by Coding Diary.
         */
        String folder = "/Users/aksharanair/Downloads/";
        
        // importing images, here is where I really used JLabel as explained in the YouTube tutorials, in order to import the images.
        /*
         * I used the JLabel and ImageIcon classes from the first package I imported to display my Wild West background. First, I used the file path to locate the
         * image on my computer. Then, I createed an ImageIcon to load it and used getImage() get the image within the QP1 folder. I used getScaledInstance()* to resize it
         * to 600 pixels (from its original 1000 pixels) so it would fit my game panel without being cutoff. Finally, I converted the image back into an ImageIcon and passed it into a JLabel constructor
         * so the background could be displayed with the horse/rattlesnake/tumbleweed/lasso layered on top of it.
         */
        JLabel background = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "wildwest.jpg")
                    .getImage().getScaledInstance(1000, 600, 1) //the getScaledInstace method requires three arguments, and I didn't know about this so 
                    // I was running into a lot of errors that needed to be debugged. I just added a 1 as a default placeholder because I didn't have a third argument
            )
        );
        background.setLayout(null);
        background.setBounds(0, 0, 1000, 600);
        //I basically used the exact same code for the wildwest background import, and tweaked the getScaledInstance pixels so that the images were different sizes. I also changed
        //image that I was importing
        horse1 = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "horse1.png")
                    .getImage().getScaledInstance(100, 80, 1)
            )
        );


        horse2 = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "horse2.png")
                    .getImage().getScaledInstance(100, 80, 1)
            )
        );

        JLabel tumbleweed = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "tumbleweed.png")
                    .getImage().getScaledInstance(60, 60, 1)
            )
        );

        JLabel snake1 = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "rattlesnake.png")
                    .getImage().getScaledInstance(65, 45, 1)
            )
        );

        JLabel snake2 = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "rattlesnake.png")
                    .getImage().getScaledInstance(65, 45, 1)
            )
        );

        JLabel lasso1 = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "lasso.png")
                    .getImage().getScaledInstance(50, 50, 1)
            )
        );

        JLabel lasso2 = new JLabel(
            new ImageIcon(
                new ImageIcon(folder + "lasso.png")
                    .getImage().getScaledInstance(50, 50, 1)
            )
        );

        // setBounds allows me to change the objects position and size
        horse1.setBounds(30, 230, 100, 80); // the meaning of these four numbers are x-value, y-value, width, and height (in pixels)
        background.add(horse1); //add places the image onto the background without being covered up by the background

        horse2.setBounds(30, 430, 100, 80); // i experimented with these four values for each image, and decided to add four unique values for each image
        background.add(horse2);

        // Obstacles
        snake1.setBounds(450, 290, 65, 45);
        background.add(snake1);

        snake2.setBounds(650, 490, 65, 45);
        background.add(snake2);

        tumbleweed.setBounds(800, 370, 60, 60);
        background.add(tumbleweed);

        // Lassos
        lasso1.setBounds(300, 240, 50, 50);
        background.add(lasso1);

        lasso2.setBounds(500, 440, 50, 50);
        background.add(lasso2);

        // Finish line
        JLabel finish = new JLabel("|");
        finish.setBounds(950, 150, 30, 400);
        background.add(finish);

        // Miles
        miles1 = new JLabel("Player 1: 0/100 miles"); //new image or text
        miles1.setBounds(20, 10, 200, 30);
        background.add(miles1);

        miles2 = new JLabel("Player 2: 0/100 miles");
        miles2.setBounds(20, 40, 200, 30);
        background.add(miles2);

        // Winner
        winner = new JLabel("");
        winner.setBounds(350, 100, 300, 50);
        background.add(winner);

        // Create window
        frame = new JFrame("Wild West Horse Race");
        frame.setContentPane(background);
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }

    // game
    public void refresh()
    {
        // herses being moved
        /* Here is where I decided to integrate math in the form of coordinate values X and Y to move my horses. The objective of the game is for one user to move across the screen faster
         * than the other (across 900 pixels, which I equated to 100 miles). I decided to do this by using coordinate values, or x and y values and algebra. 
         * I used getX() and getY() to get the horizontal and vertical cooridinates of the horses and then multipled it by 820 to fit within the panel of my game (820 pixels acrosd the screen).
         * I added 30 pixels to allow the horses to start at the exact same location (30 pixels left) before the game begins. Within the Quarter Project One's instructions on Canvas
         * there needs to be words on the scren of the race that summarizes the user's actions at the end of the game. I was able to do this by multiplying the x and y coordinates 
         * in pixels of the horses, multiplying it by 100 and dividing it by 900 pixels to show the apporximate nummber of "miles" travelled out of 100 "miles"
         * 
         */
        Horse h1 = race.getHorse1();
        Horse h2 = race.getHorse2();

        horse1.setLocation(
            30 + h1.getX() * 820 / 900,
            h1.getY());

        horse2.setLocation(
            30 + h2.getX() * 820 / 900,
            h2.getY());

        // Miles
        miles1.setText("Player 1: " +
            h1.getX() * 100 / 900 + "/100 miles");

        miles2.setText("Player 2: " +
            h2.getX() * 100 / 900 + "/100 miles");

        // Winner
        /*
         * Here is where I summarized the users movements at the end of the game as mentioned on the project's instructions. I calculated the movements of the players by using the caclulations
         * in the refresh method, as explained above.
         */
     if (race.getWinner() != 0)
    {
    winner.setText("GAME OVER! PLAYER " +
        race.getWinner() + " WINS!");
    }
    else
    {
    winner.setText("");
    }
    }
}
