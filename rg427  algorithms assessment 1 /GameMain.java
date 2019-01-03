import java.util.*;
/**
 * This class is the main class of the this game.
 * The player has to choose 5 option that are given on th game. 
 * To play this game create an instance of main(String[] args)
 *  This main class creates and initialises all the others: 
 *  It creates board and display the menu 
 *  
 * @author (Rojan Giri )
 * @version (v1)
 */
public class GameMain 
{
    public static Board boards;
    public static Monster monsters;
    /**
     * Need to initialise to play the game 
     * it create the board and manu after the game is launched 
     * 
     * @param game display the board and menu
     */
    public static void main(String[] args) {
        boards= new Board();
        display_menu();
        System.out.println("");
    }   

    /**
     * 
     * ask the player for the input 
     * the player has to choose one of the option given to play the game 
     * it also catches if the input is not from the option and any string instead of any integers input
     * @param choose between the options
     */
    public static void display_menu() 
    {
        Scanner in = new Scanner ( System.in ); 
        boolean quit = false;   // quit set to false 
        int menuItem; 
        try{// check for any other values then the given options 
            do {
                System.out.print("Please choose an option from the menu ");
                System.out.println("\n1) Enter a monster onto the board \n2) Launch an attack on a monster \n3) View the board \n4) Retrieve a score \n5) List all Players \n6) quit playing  ");
                System.out.print("Selection: ");
                System.out.println("");
                System.out.println("");
                menuItem = in.nextInt();// get the input from the user 

                switch (menuItem) {// choose the case  based on the input  from the user and display the menu again
                    case 1: boards.inputMonsters();display_menu();
                    break;
                    case 2:boards.attackMonster();display_menu();
                    break;
                    case 3:boards.viewBoard();display_menu();
                    break;
                    case 4:boards.getScore();display_menu();
                    break;
                    case 5:boards.getList();display_menu();
                    break;
                    case 6: quit = true;// quit is set to true
                    break;
                    default:
                    System.out.println ("Unrecognized option! Please Select option from 1 -6" );
                    System.out.println ("");
                    System.out.println ("");
                    boards.viewBoard();

                }
            }
            while (!quit);// if the quite is false
            System.out.println("Thank you for Playing ");
            System.exit(0); // exit the game 
        }
        catch(Exception e){
            System.out.println("Enter only integer & Please Select option from 1 -6" );
            System.out.println("");
            System.out.println("");
            boards.viewBoard();// display the board
            display_menu(); // display the menu 

        }  
    }
}
