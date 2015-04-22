import greenfoot.*;

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
        setBackground("images/MenuScreen.png"); 
    }
    
    void checkClick(MouseInfo mouse) { 
        if (mouse.getX() >= 200 && mouse.getX() <= 350) {
            if (mouse.getY() >= 150 && mouse.getY() <= 185) {
                Greenfoot.setWorld(new Backstory());
            }
            else if (mouse.getY() >= 225 && mouse.getY() <= 255) {
                Greenfoot.setWorld(new Tutorial());
            }
            else if (mouse.getY() >= 290 && mouse.getY() <= 330) {
                Greenfoot.setWorld(new PlaySettings());
            }
            else if (mouse.getY() >= 365 && mouse.getY() <= 400) {
                Greenfoot.setWorld(new Hiscores());
            }
            else if (mouse.getY() >= 440 && mouse.getY() <= 465) {
                Greenfoot.setWorld(new Credits());
            }
        }
    }
}
