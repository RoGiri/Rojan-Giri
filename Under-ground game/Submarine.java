import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Submarine, the main protagoist of the game
 * 
 * @author Rojan Giri
 * @version 1
 */
public class Submarine extends SharedMembers
{
    private static final GreenfootImage submarine1 = new GreenfootImage("Submarine1.png");//declare Submarine image
    private static final GreenfootImage submarine2 = new GreenfootImage("Submarine2.png");//declare Submarine image
    private static final GreenfootImage submarine3 = new GreenfootImage("Submarine3.png");//declare Submarine image

    private double velocity = 0; //initial velocity value
    private static final double gravity = 0.5; //gravity value to be appliled when falling
    private static final double boostSpeed = -6; //boostspedd value to be apllied when flying upwards

    public Submarine()
    {
        setImage(submarine1);
        getImage().scale(400,300);

        this.animationDelay = 4; //set the animationDalay value fromsharedMebers class to the value od 4 
    }

    /**
     * Act - do whatever the Submarine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCollision();
        applyGravity();
        checkKeys();
        //animateSubmarine();
        rotateSubmarine();
        upperBoundary();
        //if (checkHit() ){
        //   Greenfoot.stop();
        //}
    } 

    /**
     * Contantly apply gravity to Submarine
     * 
     */
    private void applyGravity()
    {
        setLocation(getX(), (int) (getY() + velocity ));
        velocity = velocity + gravity; //ensure gravity is not at a constat rate

    }

    /**
     * check if a specific leyboard key has been pressed. If it has , react accordingly.
     * Do the same if a mouse button has been clicked.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("space") == true || Greenfoot.mouseClicked(null) == true)
        {
            velocity = boostSpeed;
        }

    }

    /**
     * switch between the diffrent images
     */
    private void animateSubmarine()
    {
        this.frame++;
        if (this.frame < 1 * this.animationDelay)
        {
            setImage(submarine1);
        }
        else if (this.frame < 2 * this.animationDelay)
        {
            setImage(submarine2);
        }
        else if (this.frame < 3 * this.animationDelay)
        {
            setImage(submarine3);
            this.frame = 0;
        }

    }

    /**
     * Rotate Submarine based on current velocity value
     */
    private void rotateSubmarine()
    {
        if (velocity < 1)
        {
            setRotation(-30);
        }
        else if (velocity < 8)
        {
            setRotation(0);
        }
        else if (velocity < 12)
        {
            setRotation(30);
        }
        else if (velocity < 30)
        {
            setRotation(60);
        }
    }

    /**
     * check for collision with ground
     */
    public boolean checkCollision()
    {
        Actor Ground = getOneIntersectingObject(Ground.class);

        if (getY() > 322)
        {
            setLocation(getX(), 322);
            Greenfoot.stop();
            return true;
        }
        else
        {
            return false;
        }
    }

    //private boolean checkHit() {
    //    if (isTouching(Hill.class)) {
    //        return true;
    //    }
    //    return false;
    //}

    /**
     * Creeate a boundary to prevent Submarine's exit from the game screen
     */
    private void upperBoundary()
    {
        if (getY() <= 14)
        {
            setLocation(getX(), 14);
        }
    }
}

