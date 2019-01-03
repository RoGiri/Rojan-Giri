import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ground, moves left of the screen, alos acts as an obstracle for Submarine.
 * 
 * @author Rojan Giri 
 * @version 1
 */
public class Ground extends SharedMembers
{
    private static final GreenfootImage ground = new GreenfootImage("Ground5.png");//declare fround image
    
    public Ground()
    { 
        setImage(ground); //set the image for the ground object
        this.xSpeed = 4;
    }
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveleft();
        removeGround();
    } 
    
    /**
     * When the ground reaches half it width past the screen it is removed from the game
     */
    private void removeGround()
    {
        if (getX() < - getImage().getWidth() / 2)
        {
            getWorld().removeObject(this);
        }
    }

}
