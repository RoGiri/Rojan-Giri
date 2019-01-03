import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartMenuItem here.
 * 
 * @author Rojan Giri  
 * @version 1
 */
public class StartMenuItem extends MenuItem {
    
    public StartMenuItem() 
    {
        super("start_mainmenu.png", "start_mainmenu2.png");
    }
    
    /**
     * Act - do whatever the StartMenuItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
        if (isMouseClicked()) {
            Greenfoot.setWorld(new UnderWater());
        }
    }    
    }    

