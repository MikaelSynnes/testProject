/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveableObjects;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author Mikael
 */
public class Player extends Ship
{

    boolean alive;

    public Player(double initialX, double initialY, double initialSpeed)
    {
        super(initialX, initialY, initialSpeed);
        this.setImage(new Image("testPlayer.png", 60, 60, true, true));
        alive = true;
    }

    /**
     * Move the player ship in the direction corresponding to what key is pressed.
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

}
