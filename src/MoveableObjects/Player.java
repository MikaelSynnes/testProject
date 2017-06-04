/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoveableObjects;

import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.input.KeyEvent;


/**
 *
 * @author Mikael
 */
public class Player {

    boolean alive;

    public Player() {
        alive = true;

    }

    //Reads input from keyboard to decide if the player is going to move or stand still.
    public void move(String input) {
        System.out.println("input");
        //TODO check for input on keyboard to check where is moving or if he is standing still
        if (input.equals("w")) {
            //Move up
        } else if (input.equals("a")) {
            //move left
        } else if (input.equals("s")) {
            //move down
        } else if (input.equals("d")) {
            //move right
        } else if (input.equals("u")) {
            killPlayer();
        } else {
            //Do nothing

        }

    }

   

    public boolean checkIfAlive() {
        return alive;
    }

    public void killPlayer() {
        alive = false;
    }



     public void keyTyped(KeyEvent e) {
            e.getCode();
        System.out.println(e);
       
    }

     public void keyPressed(KeyEvent e) {
        KeyCode i=e.getCode();
        if(i==DOWN){
            System.out.println("DOWN");
        }
       if(i==UP){
            System.out.println("UP");
        }
       if(i==LEFT){
            System.out.println("LEFT");
       }
       if(i==RIGHT){
          System.out.println("RIGHT");
     }
    }


    public void keyReleased(KeyEvent e) {
        e.getCharacter();
     System.out.println("It works");
    }

}
