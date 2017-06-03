/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Mikael
 */
public class main {

    private int time;
    private boolean run = false;
    private boolean paused = false;

    public main() {

    }

    public static void main(String[] args) {

    }

    public void run() {
        while (run) {
            
            if (paused) {
            } else {
                time++;
                doOneGameTick();
            }
        }
        
        System.out.println("GAME OVER");
    }
    
    
            
    public void doOneGameTick(){
        System.out.println("One game tick done, gametick nr: " + time);
        
        // TODO: Insert gamefunction, check for input and control playerClass
        
    }
    
    
    
    // Sets the game on pause if its unpaused. if the game is unpaused it will pause it.
    public void setPaused(){
        if(paused){
            paused=false;
        }
        else{
        paused=true;
        }
    }
   
    
    //ends the game.
    public void end(){
        run=false;
    }

}

