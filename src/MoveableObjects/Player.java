/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveableObjects;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Class representing a player ship.
 * A player ship can move with WASD and the arrow keys.
 * A player ship can die. Suicide key is U.
 *
 * @author Mikael
 * @author Asgeir
 */
public class Player extends Ship
{

    private boolean alive;
    private double xVelocity, yVelocity;

    public Player(double initialX, double initialY, double initialSpeed)
    {
        super(initialX, initialY, initialSpeed);
        xVelocity = 0;
        yVelocity = 0;
        this.setImage(new Image("testPlayer.png", 50, 50, true, true));
        alive = true;
    }

    /**
     * Event handler for starting player movement.
     */
    private EventHandler<KeyEvent> keyDownListener = ke ->
    {
        if (ke.getCode() == KeyCode.UP || ke.getCode() == KeyCode.W)
        {
            //Move up
            yVelocity = -getSpeed();
        }
        else if (ke.getCode() == KeyCode.A || ke.getCode() == KeyCode.LEFT)
        {
            // Move left
            xVelocity = -getSpeed();
        }
        else if (ke.getCode() == KeyCode.S || ke.getCode() == KeyCode.DOWN)
        {
            // Move down
            yVelocity = getSpeed();
        }
        else if (ke.getCode() == KeyCode.D || ke.getCode() == KeyCode.RIGHT)
        {
            // Move right
            xVelocity = getSpeed();
        }
        ke.consume();
    };

    /**
     * Event handler for stopping player movement. (Killing a player technically stops them from moving.)
     */
    private EventHandler<KeyEvent> keyUpListener = ke ->
    {
        if (ke.getCode() == KeyCode.UP || ke.getCode() == KeyCode.W || ke.getCode() == KeyCode.DOWN || ke.getCode() == KeyCode.S)
            yVelocity = 0;
        else if (ke.getCode() == KeyCode.RIGHT || ke.getCode() == KeyCode.D)
            xVelocity = 0;
        else if (ke.getCode() == KeyCode.U)
            killPlayer();
    };

    public EventHandler<KeyEvent> getKeyDownListener()
    {
        return keyDownListener;
    }

    public EventHandler<KeyEvent> getKeyUpListener()
    {
        return keyUpListener;
    }

    /**
     * Move the player ship in the direction corresponding to what key is pressed.
     *
     * @param ke Which direction to move the player ship.
     */
    public void move(KeyEvent ke)
    {
        if (ke.getCode() == KeyCode.W || ke.getCode() == KeyCode.UP)
        {
            // Move up
            setY(getY() - getSpeed());
        }
        else if (ke.getCode() == KeyCode.A || ke.getCode() == KeyCode.LEFT)
        {
            // Move left
            setX(getX() - getSpeed());
        }
        else if (ke.getCode() == KeyCode.S || ke.getCode() == KeyCode.DOWN)
        {
            // Move down
            setY(getY() + getSpeed());
        }
        else if (ke.getCode() == KeyCode.D || ke.getCode() == KeyCode.RIGHT)
        {
            // Move right
            setX(getX() + getSpeed());
        }
        else if (ke.getCode() == KeyCode.U)
        {
            killPlayer();
        }


    }

    public boolean checkIfAlive()
    {
        return alive;
    }

    public void killPlayer()
    {
        alive = false;
    }

    public double getxVelocity()
    {
        return xVelocity;
    }

    public double getyVelocity()
    {
        return yVelocity;
    }
}
