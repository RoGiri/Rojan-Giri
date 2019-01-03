import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hill, this will act as an obstracle for Submarine to aviod
 * 
 * Rojan Giri
 * @version 0.1
 */
public class Hill extends SharedMembers
{
    private static final GreenfootImage Bottom = new GreenfootImage("Bottom_Hill1.png") ; //declare Hill Image
    private static final GreenfootImage Top = new GreenfootImage("Top_Hill1.png") ; //declare Hill Image    
      
  public Hill(String selection)
    
  {
    this.xSpeed = 4;//apply X-axis speed of 4 
    if (selection == "top")//Select pipe image depending on selection value
    {
        setImage(Top);   
    }
    else if (selection == "bottom")// select pipe image depending on selection value
    {
         setImage(Bottom);  
    }
  }
       
            
            
    /**
     * Act - do whatever the Hill wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         this.moveleft();
         removeHill();
         //if(hitting() =true) {
         //   Greenfoot.stop();
         //   }
    }
    
    //public boolean hitting()
    //{
        //if(isTouching(Submarine.class)) {
        //    return true;
        //}
        //else return false;
    //}
    
    /**
     * When Hill reached its object width past the screen, it is removed from the game
     */
    private void removeHill()
    {
        if(getX() < - getImage().getWidth())
        {
           getWorld().removeObject(this);
        }
    }
    
}