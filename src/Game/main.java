/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import MoveableObjects.Player;
import Movement.Keyboard;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Mikael
 */
public class main extends Application{

    private static int time;
    private static boolean run = false;
    private static boolean paused = false;
    private static Keyboard key;
    private static Player player;

    public main() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Squares squares = new Squares(primaryStage);
    }

    public static void main(String[] args) {
        player=new Player();
        key=new Keyboard();
        //run();
    }

    public static void run() {
        run=true;
        while (run) {
            if (!player.checkIfAlive()) {
                run=false;
            }
            if (paused) {
            } else {
                time++;
                doOneGameTick();
            }
        }

        System.out.println("GAME OVER");
    }

    public static void doOneGameTick() {

        String keyPressed = key.readInput();
        System.out.println(keyPressed);
        player.move(keyPressed);
        System.out.println("One game tick done, gametick nr: " + time);

        // TODO: Insert gamefunction, check for input and control playerClass
    }

    // Sets the game on pause if its unpaused. if the game is unpaused it will pause it.
    public void setPaused() {
        if (paused) {
            paused = false;
        } else {
            paused = true;
        }
    }

    //ends the game.
    public void end() {
        run = false;
    }

}
