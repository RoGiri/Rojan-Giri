import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * The score board.
 * 
 * @author imacat <imacat@mail.imacat.idv.tw>
 * @version 2014/2/10
 */
public class ScoreBoard extends Actor {
    
    /**
     * Creates a new score board.
     * 
     */
    public ScoreBoard() {
        drawScore(0);
    }
    
    /**
     * Sets the score.
     * 
     * @param score the score
     */
    public void setScore(int score) {
        // Draws the score.
        drawScore(score);
    }
    
    /**
     * Draws the score.
     * 
     * @param score the score
     */
    private void drawScore(int score) {
        GreenfootImage text = new GreenfootImage("Score: " + score, 25, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage image = new GreenfootImage(text.getWidth() + 20, text.getHeight() + 20);
        image.setColor(Color.BLUE);
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);
        image.drawImage(text, 10, 10);
        setImage(image);
    }
}

