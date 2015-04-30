import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Screen
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {
        super();
        setBackground("images/Menu.png"); 
        
        
    }
    
    void checkClick(MouseInfo mouse) { 
            if (mouse.getX() >= 235 && mouse.getX() <= 365 && mouse.getY() >= 188 && mouse.getY() <= 228) {
                Greenfoot.setWorld(new Backstory());
            }
            else if (mouse.getX() >= 235 && mouse.getX() <= 365 && mouse.getY() >= 245 && mouse.getY() <= 285) {
                Greenfoot.setWorld(new Tutorial());
            }
            else if (mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 301 && mouse.getY() <= 362) {
                Greenfoot.setWorld(new PlaySettings());
            }
            else if (mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 381 && mouse.getY() <= 440) {
                Greenfoot.setWorld(new Hiscores());
            }
            else if (mouse.getX() >= 235 && mouse.getX() <= 365 && mouse.getY() >= 458 && mouse.getY() <= 498) {
                Greenfoot.setWorld(new Credits());
            }
    }
}
