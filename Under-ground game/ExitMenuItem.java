import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitMenuItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitMenuItem extends MenuItem
{
    public ExitMenuItem() {
        super("Quit_mainmenu.png", "Quit_mainmenu2.png");
    }

    /**
     * Act - do whatever the ExitMenuItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
        if (isMouseClicked()) {
            Greenfoot.stop();
            getWorld().removeObject(this);
            Greenfoot.start();

        }
    }    
}
