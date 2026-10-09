
public class Obstacle
{
    private int x;
    private int y;
    private int speed;

    public Obstacle(int startX, int startY, int startSpeed) //starting x, y, and speed values
    {
        x = startX;
        y = startY;
        speed = startSpeed;
    }

    public void move()
    {
        x = x - speed; //current x value - 10 speed, so for example if the move method is called when the horse is at 790 pixels
        // and the speed is 10, when the move method is called the horse would be at 780 pixels, and would have moved

        if (x < -100) //checks whether the obstacle has moved beyond the left edge at -100 and is out of the game's panel
        {
            x = 1000;
        }
    }
    //get the x and y values
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    //set method changes the horizontal position
    public void setX(int newX)
    {
        x = newX;
    }
}
