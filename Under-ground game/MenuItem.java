import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Write a description of class MenuItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuItem extends Actor
{    
    /**
     * Images for normal and over states.
     */
    private GreenfootImage normalImage;
    private GreenfootImage overImage;
    
    public static void MsgBox(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * State control flag.
     */
    private boolean overShowing;
    
    /**
     * Constructor.
     * Initialises the normal and over images.
     */
    public MenuItem(String normal, String over) {
        this.normalImage = new GreenfootImage(normal);
        this.overImage = new GreenfootImage(over);
        setImage(this.normalImage);
    }
    
    /**
     * Returns true if the mouse is over this object.
     * 
     * @return boolean.
     */
    protected boolean isMouseOver() {
        boolean ret;
        
        ret = false;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), MenuItem.class);
            for (Object object : objects) {
                if (object == this) {
                    ret = true;
                    break;
                }
            }             
        }
        return ret;
    }
    
    /**
     * Return true if the mouse has been clicked over this object.
     * 
     * @return boolean.
     */
    protected boolean isMouseClicked() {
        return Greenfoot.mouseClicked(this);
    }
    
    /**
     * Act - do whatever the MenuItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (isMouseOver()) {
            if (!overShowing) {
                overShowing = true;
                setImage(overImage);
            }
        }
        else if (overShowing) {
            overShowing = false;
            setImage(normalImage);
        }
    }
}

