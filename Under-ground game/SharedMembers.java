import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the SharedMembers class.
 * Any Varibales or methods that are be shared across diffrent classes are places in here
 * 
 * @author Rojan Giri
 * @version 1
 */
public class SharedMembers extends Actor
{
     protected int frame; // declare variable to be used to increment animation frames
     protected int animationDelay;// declare variable to be used to slow down the animation
     protected int xSpeed; // declare variable to be use to manupulate objects speed when moving on the X-axis
     
    /**
     * Move object on the X-axis to the left, Y axis to remain stationary
     */
    protected void moveleft()
    {
        setLocation(getX() - this.xSpeed, getY());
    }

}
