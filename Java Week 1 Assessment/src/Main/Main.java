package Main;
import java.util.*;

import Aplayer.APlayer;

public class Main {
public static void main(String[] args) {
	Scanner user_input = new Scanner(System.in);
	System.out.println("WELCOME TO THE TREASURE GAME! LET'S SEE IF YOU AN MAKE IT ALIVE AND FIND THE TREASURE!");
	System.out.println("");
	System.out.println("To begin, player, enter your name or player name");
	
	String name = user_input.next();
	APlayer p1 = new APlayer(name);
	System.out.println("");
	System.out.println("The x axis is equivalent to the columns in the grid (west or east) and the y axis is equivalent to the rows  in the grid (north or south)");
	while(true) {
			
		    System.out.println("");
			System.out.println("Enter a row for the grid (must be an odd number and greater than 10 ). Do you want a challenge? Choose a value greater than 20");
			int gridRow = user_input.nextInt();
			System.out.println("Enter a column for the grid (must be an odd number and greater than 10). Do you want a challenge? Choose a value greater than 20");
			int gridCol= user_input.nextInt();
			
			
			System.out.println("");
			p1.gridInitial (gridRow, gridCol);
			if( p1.startChecker) {
				break;
			}
	}
	
	System.out.println("");
	System.out.println("Let the game begin!!");
	System.out.println("");
	
	while(true) {
		System.out.println("");
         System.out.println(p1.name +", enter a direction (north, east, south or west)");
          String dir = user_input.next();
          p1.gameplay(dir);
          if(p1.gameend) {
        	  System.out.println("");
        	  System.out.println("The game has ended!");
        	  break;
          }
	}
	
	
	
	


}
}
