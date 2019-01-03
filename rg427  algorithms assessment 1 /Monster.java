import java.util.*;
/**
 * This is the monster class which is rh part of the Gamemain
 * It also get and set monster name
 * it also set and get the score 
 * finds the position and print its
 *
 * @author (Rojan Giri )
 * @version (V1)
 */
public class Monster
{
    int score ; 
    String monstername; 
    int[] position; //create array positon 
    /**
     * Constructor for objects of class Monster
     * it initialise the score and monstername
     * 
     */
    public Monster(String monstername)
    {
        this.monstername=monstername;
        this.score= 0; // initial value is 0
        position = new int[2]; //initialize  the array which can stroe 2 values

    }

    /**
     * 
     * It get the monstername stores monstername from the constructor 
     * 
     * @return monstername
     */
    public String getName(){
        return monstername;
    }

    /**
     * Sets the monster name 
     * @param set the name 
     */
    public void  setName(String m){
        monstername=m;
    }

    /**
     *  It gets initial charecter of the monsters name and changes to uppercase. 
     *  @return the name with the first charecter of the monster name
     */
    public char  getFirst (){
        return getName().toUpperCase( ).charAt(0);   
    }

    /**
     * 
     * Its adds the score 10 eveytime its been called 
     * @param set Score 10
     */
    public void setScore(){
        this.score+= 10; 
    }

    /**
     * it gets the number stored in the score filed.
     * @return score 
     */
    public int getScore(){
        return score; 
    }

    /**
     * return the position within the board of the monster 
     * @return the postion of the monster
     */
    public int[]  getMonsterPosition(){
        return position;
    }

    /**
     * 
     *@param prints the position of the monster
     */
    public void Postion(){
        System.out.println("Postion of the Monster"+Arrays.toString(position));
    }

} 

