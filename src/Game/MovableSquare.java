package Game;

import javafx.scene.shape.Rectangle;

/**
 * Created by Asgeir on 03.06.2017.
 */
public class MovableSquare extends Rectangle
{

    private double speed;

    public MovableSquare(double size, double initialSpeed, double initialX, double initialY)
    {
        super(initialX, initialY, size, size);
        this.speed = initialSpeed;
    }

    public void move()
    {
        this.setX(this.getX() - speed);
    }

    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
}
