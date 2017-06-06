package MoveableObjects;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 * Created by Asgeir on 03.06.2017.
 */
public class Enemy extends Ship
{

    public Enemy(double initialX, double initialY, double speed)
    {
        super(initialX, initialY, speed);
        this.setImage(new Image("basicEnemy.png", 50, 50, true, true));
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
