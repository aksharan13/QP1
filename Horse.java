
public class Horse
{
    // x and y are the coordinate values
    //groundY is the original y coordinate the horse is to return to after a jump
    private int x;
    private int y;
    private int groundY;
    private int speed; //speed is used during gusts of wind and lasso touches

    // inital values
    public Horse(int startY)
    {
        x = 0;
        y = startY;
        groundY = startY;
        speed = 10;
    }

    // horizontal coordinate (x) plus the speed. when x = 900 pixels, that is the finish line
    public void move()
    {
        x = x + speed;

        if (x > 900)
        {
            x = 900;
        }
    }

    // y coordinate - 50
    public void jump()
    {
        y = groundY - 50;
    }

    // return to original y coordinate value after the jump
    public void land()
    {
        y = groundY;
    }

    // slows horse from the original speed 10 (see line 17), to 5
    public void wind()
    {
        speed = 5;
    }

    // quickens horse from the original speed 10 (see line 17), to 20
    public void lasso()
    {
        speed = 20;
    }

    // return to the original speed (see line 17) after the lasso or wind methods
    public void normalSpeed()
    {
        speed = 10;
    }

    // return to original horizontal x or y positions
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    // reset the x, y, and speed when the reset method is invoked
    public void reset()
    {
        x = 0;
        y = groundY;
        speed = 10;
    }
}
