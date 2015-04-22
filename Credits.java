import greenfoot.*;

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends Screen
{

    /**
     * Constructor for objects of class Credits.
     * 
     */
    public Credits()
    {
        super();
        setBackground("images/CreditsScreen.png");
    }
    
    void checkClick(MouseInfo mouse) { //pixel numbers to change
        if (mouse.getX() >= 340 && mouse.getX() <= 535) {
            if (mouse.getY() >= 530 && mouse.getY() <= 555) {
                Greenfoot.setWorld(new Menu());
            }
        }
    }
}
