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

    private double xVelocity, yVelocity;
    private final static int DEFAULT_MAX_HP = 100;

    /**
     * Default constructor. Sets max HP to DEFAULT_MAX_HP.
     *
     * @param initialX     Initial X position of player.
     * @param initialY     Initial Y position of player.
     * @param initialSpeed Initial speed of player.
     */
    public Player(double initialX, double initialY, double initialSpeed)
    {
        super(initialX, initialY, initialSpeed, DEFAULT_MAX_HP);
        setupPlayer();
    }

    /**
     * Custom HP constructor. Allows to set a custom amount of starting HP.
     *
     * @param initialX     Initial X position of player.
     * @param initialY     Initial Y position of player.
     * @param initialSpeed Initial speed of player.
     * @param maxHP        Starting HP of player.
     */
    public Player(double initialX, double initialY, double initialSpeed, int maxHP)
    {
        super(initialX, initialY, initialSpeed, maxHP);
        setupPlayer();
    }

    private void setupPlayer()
    {
        xVelocity = 0;
        yVelocity = 0;
        this.setImage(new Image("testPlayer.png", 50, 50, true, true));
    }

    /**
     * Event handler for starting player movement.
     * The player will only move in a specified direction as long as the corresponding key is held down.
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
     * The player will stop moving in a specific direction when the corresponding key is released.
     */
    private EventHandler<KeyEvent> keyUpListener = ke ->
    {
        if (ke.getCode() == KeyCode.UP || ke.getCode() == KeyCode.W || ke.getCode() == KeyCode.DOWN || ke.getCode() == KeyCode.S)
            yVelocity = 0;
        else if (ke.getCode() == KeyCode.RIGHT || ke.getCode() == KeyCode.D || ke.getCode() == KeyCode.LEFT || ke.getCode() == KeyCode.A)
            xVelocity = 0;
        // Suicide button
        else if (ke.getCode() == KeyCode.U)
        {
            alive = false;
            die();
        }
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
            alive = false;
            die();
        }


    }

    public double getxVelocity()
    {
        return xVelocity;
    }

    public void setxVelocity(double newVelocity)
    {
        xVelocity = newVelocity;
    }

    public double getyVelocity()
    {
        return yVelocity;
    }

    public void setyVelocity(double newVelocity)
    {
        yVelocity = newVelocity;
    }

    @Override
    public void die()
    {
        // TODO: Add code for death animation
    }
}
