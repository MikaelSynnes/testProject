/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movement;

import java.util.Scanner;

/**
 *
 * @author Mikael
 */
public class Keyboard {

    
      public String readInput() {
        Scanner keyboard = new Scanner(System.in);
       String input=keyboard.next();
          if(keyboard==null){
         input="p";
          }
        return  input;
     
        
       
    }
}
