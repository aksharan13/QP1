import javax.swing.JOptionPane;
import java.util.Random;
public class Race
{
    // horse1 and horse2 to distinguish into two users for the competition aspect
    //int winner stores which horse has won the race, and if winner = 0, then nobody has won yet
    private Horse horse1;
    private Horse horse2;
    private Picture2 picture;
    private int winner;
    private boolean lasso1Used = false;
    private boolean lasso2Used = false;
    private Random rand = new Random();
    // horse1 and horse2 are the two instance variables with different numbers, 230 and 430 being the y-coordinates, so that they are in different lanes
    public Race()
    {
        horse1 = new Horse(230);
        horse2 = new Horse(430);
        //winner = 0 -> nobody has won at the beginnging of the game
        winner = 0;
        //"this" references the Race object
        picture = new Picture2(this);
    //I imported JOptionPane as the rubric includes, the showMessageDialog method basically means that if the user does not type 1 or 2, the choice is null,
    //and the game will be cancelled
       if (JOptionPane.showInputDialog("Choose Horse 1 or 2:") == null)
    {
    JOptionPane.showMessageDialog(null, "Error: Game cancelled!");
    return;
    }
        //calls instructions method, below
        instructions();
    } 
    // Instructions
    public void instructions()
    {
        System.out.println("Wild West Race!"); //game's name
        System.out.println("First to 100 miles wins!"); //objective or how to win
        System.out.println("Right-click race1 to play."); //start
        System.out.println("movePlayer1() - Move Player 1"); //instructions 
        System.out.println("movePlayer2() - Move Player 2");
        System.out.println("jumpPlayer1() - Jump Player 1");
        System.out.println("jumpPlayer2() - Jump Player 2");
        System.out.println("landPlayer1() - Land Player 1");
        System.out.println("landPlayer2() - Land Player 2");
        System.out.println("wind() - Slow both horses");
        System.out.println("lassoPlayer1() - Boost Player 1");
        System.out.println("lassoPlayer2() - Boost Player 2");
        System.out.println("normalSpeed() - Reset speeds");
        System.out.println("restart() - Restart race");
    }
    public void movePlayer1()
    {
    if (winner == 0)
    {
    horse1.move();

    int x = 30 + horse1.getX() * 820 / 900;

     if (x + 100 >= 300 && x < 350 && !lasso1Used)
        {
            horse1.lasso();
            lasso1Used = true;
            System.out.println("PLAYER 1 SPEED BOOST!");
        }
    checkSnake();

    if (winner == 0)
    {
    checkWinner();
    }

    picture.refresh();
    }
    }
    // repeated the code above to move
   public void movePlayer2()
    {
    if (winner == 0)
    {
    horse2.move();

    int x = 30 + horse2.getX() * 820 / 900;

    if (x + 100 >= 500 && x < 550 && !lasso2Used)
        {
            horse2.lasso();
            lasso2Used = true;
            System.out.println("PLAYER 2 SPEED BOOST!");
        }
    checkSnake();

    if (winner == 0)
    {
    checkWinner();
    }

    picture.refresh();
    }
    }
    // in order to jump for both horses
    public void jumpPlayer1()
    {
        horse1.jump(); //jump method from Horse class
        picture.refresh();
    }
    public void jumpPlayer2()
    {
        horse2.jump();
        picture.refresh();
    }
    // after the jump in order to return to the y-coordinate and land at its original position
    public void landPlayer1()
    {
        horse1.land();
        picture.refresh();
    }
    public void landPlayer2()
    {
        horse2.land();
        picture.refresh();
    }
    // gusts of wind slow down the horses
    public void wind()
    {
        horse1.wind();
        horse2.wind();
        System.out.println("Strong wind!"); //this indicates the gusts of wind
    }
    // after touching the lasso the horses return to their normal or original pace
    public void normalSpeed()
    {
        horse1.normalSpeed();
        horse2.normalSpeed();
        System.out.println("Normal speed!");
    }
    // checks if winner is NOT equal to 0, and is instead equal to 1 (horse1) or 2 (horse2), to find the winner)
    public void checkWinner()
    {
        if (horse1.getX() >= 900)
        {
            winner = 1;
            System.out.println("Player 1 WINS!");
        }
        else if (horse2.getX() >= 900)
        {
            winner = 2;
            System.out.println("Player 2 WINS!");
        }
        
    }
    public void checkSnake()
    {
    int x1 = 30 + horse1.getX() * 820 / 900;
    int x2 = 30 + horse2.getX() * 820 / 900;

    // Player 1 touches snake
    if (x1 + 100 >= 450 && x1 < 515 &&
        horse1.getY() + 80 > 290 &&
        horse1.getY() < 335)
    {
        winner = 2;
        System.out.println("Game over! Player 1 hit a snake!");
    }

    // Player 2 touches snake
    else if (x2 + 100 >= 650 && x2 < 715 &&
             horse2.getY() + 80 > 490 &&
             horse2.getY() < 535)
    {
        winner = 1;
        System.out.println("Game over! Player 2 hit a snake!");
    }
    }
    // restart method
    public void restart()
    {
        horse1.reset();
        horse2.reset();
        winner = 0; //resets winner to 0
        picture.refresh();
        lasso1Used = false;
        lasso2Used = false;//no powerups
        System.out.println("Restarted!");
    }
    // get horse1 and horse2
    public Horse getHorse1()
    {
        return horse1;
    }
    public Horse getHorse2()
    {
        return horse2;
    }
    //return who won
    public int getWinner()
    {
        return winner;
    }
        public static void main(String[] args)
    {
    new Race();
    }
}
