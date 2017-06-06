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

    public Player()
    {
        this.setImage(new Image("testPlayer.png"));
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
            //Move up
        }
        else if (ke.getCode() == KeyCode.A || ke.getCode() == KeyCode.LEFT)
        {
            //move left
        }
        else if (ke.getCode() == KeyCode.S || ke.getCode() == KeyCode.DOWN)
        {
            //move down
        }
        else if (ke.getCode() == KeyCode.D || ke.getCode() == KeyCode.RIGHT)
        {
            //move right
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
