package MoveableObjects;

import javafx.scene.image.ImageView;

/**
 * Created by Asgeir on 06.06.2017.
 */
public abstract class Ship extends ImageView
{
    private double speed;

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
}
