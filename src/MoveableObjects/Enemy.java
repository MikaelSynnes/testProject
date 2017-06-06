package MoveableObjects;

import javafx.scene.shape.Rectangle;

/**
 * Created by Asgeir on 03.06.2017.
 */
public class Enemy extends Ship
{

    public Enemy(double initialX, double initialY, double speed)
    {
        super.setSpeed(speed);
    }

    public void move()
    {
        this.setX(this.getX() - getSpeed());
    }

    public void setSpeed(int newSpeed)
    {
        setSpeed(newSpeed);
    }
}
