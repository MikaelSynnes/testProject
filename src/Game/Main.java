/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import MoveableObjects.Player;
import Movement.Keyboard;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javax.swing.JTextField;

/**
 *
 * @author Mikael
 */
public class Main extends Application {

    private static int time;
    private static boolean run = false;
    private static boolean paused = false;
    private static Keyboard key;
    private static Player player;
    private static JTextField typingArea;
    private static Squares squares;

    public Main() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        squares = new Squares(primaryStage);
    

        squares.run();

    }

    public static void main(String[] args) {
        player = new Player();
        //key=new Keyboard();
        //run();
        launch(args);
    }

    public static void run() {
        run = true;
        while (run) {
            if (!player.checkIfAlive()) {
                run = false;
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
