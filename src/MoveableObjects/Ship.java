package MoveableObjects;

import javafx.scene.image.ImageView;

/**
 * Created by Asgeir on 06.06.2017.
 */
public abstract class Ship extends ImageView
{

    protected boolean alive;
    private double speed;
    private int currentHP;
    private int maxHP;

    public Ship(double initialX, double initialY, double speed, int maxHP)
    {
        setX(initialX);
        setY(initialY);
        this.speed = speed;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.alive = true;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public int getCurrentHP()
    {
        return currentHP;
    }

    /**
     * Method called when a ship is hit and takes damage.
     * @param damage The incoming amount of damage.
     * @return The ship's current HP after taking damage.
     */
    public int takeDamage(int damage)
    {
        currentHP = currentHP - damage;
        if (currentHP <= 1)
            alive = false;
        return currentHP;
    }

    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Method called when a ship's HP reaches 0 or less.
     */
    public abstract void die();
}
