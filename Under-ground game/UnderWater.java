import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a Game clase
 * 
 * @author Rojan Giri  
 * @version 1
 */
public class UnderWater extends World 
{
    private static final GreenfootImage bgImage = new GreenfootImage("Background3.png");//background Image for the game
    private int hillCounter; //declare variable to be used as a counter to count of act steps befor releasing a pipe
    /**
     * Constructor for objects of class UnderWater.
     * 
     */
    public UnderWater()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels and unbounded
        super(600, 400, 1, false);

        //Greenfoot.start(); //Autostart the game
        Greenfoot.setSpeed(50); //set the speed to 50%
        setBackground(bgImage);//set the back ground image

        //Set paint order for each game object
        setPaintOrder(Ground.class, Submarine.class, Hill.class);
        // Create instance of Submarine and then add to the screen.
        Submarine gameplayer = new Submarine();
        addObject(gameplayer,100, getHeight() /2);

        // create instance of Ground and then add to the screen
        Ground initialGround = new Ground();
        addObject(initialGround, 309, getHeight() - 5);

    }

    /**
     * Act, this method is called whenever the 'Act or 'Run' button get pressed in the environment.
     */
    public void act()
    {
        createGround();
        createHill();
    }

    /**
     * Create instance of ground to be placed off-screen to give the apperance of a looping image.
     */
    private void createGround()
    {
        if (getObjects (Ground.class).size() < 2)
        {
            Ground additionalGround = new Ground();
            addObject(additionalGround, 955, getHeight() - 5);
        }
    }

    /**
     * Create hills for Submarine to avoid
     */
    private void createHill()
    {
        // Create bottom and top hill objects
        Hill topHill = new Hill("top");
        Hill botHill = new Hill("bottom");

        //amount of space between Pipes

        int hillSpacing = 40;

        //get hill object image
        GreenfootImage image = botHill.getImage();

        //Random number to vary the number of hills shown
        int numOfHills = Greenfoot.getRandomNumber(10) + 4;

        //Counter increments to 50 , before issuing commands to release Hills on the screen
        hillCounter++;
        if (hillCounter == 50)
        {
            if (getObjects(Hill.class).size() < numOfHills)
            {
                addObject(botHill, getWidth(), getHeight() / 2 + image.getHeight()- Greenfoot.getRandomNumber(100) - 10);
                addObject(topHill, getWidth(), botHill.getY() - image.getHeight() - hillSpacing);
            }
            hillCounter = 0;
        }
    }
   
 
}
