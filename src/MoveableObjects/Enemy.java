package MoveableObjects;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 * Created by Asgeir on 03.06.2017.
 */
public class Enemy extends Ship
{

    private boolean collidable;

    public Enemy(double initialX, double initialY, double speed, int maxHP)
    {
        super(initialX, initialY, speed, maxHP);
        collidable = true;
        this.setImage(new Image("basicEnemy.png", 50, 50, true, true));
    }

    @Override
    public void die()
    {
        alive = false;
        collidable = false;
        this.setImage(null);
        // TODO: Add code for death animation
    }

    public void move()
    {
        this.setX(this.getX() - getSpeed());
    }

    public void setSpeed(int newSpeed)
    {
        setSpeed(newSpeed);
    }

    public boolean isCollidable()
    {
        return collidable;
    }

    public void setCollidable(boolean collidable)
    {
        this.collidable = collidable;
    }
}
