/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.util.Scanner;

/**
 *
 * @author Mikael9
 */
public class testReadableInput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner keyboard = new Scanner(System.in);
       while(true){
          
           System.out.println("enter an integer");
           String myint = keyboard.next();
           System.out.println(myint);
       }
    }
    
}
