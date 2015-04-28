import greenfoot.*;

/**
 * Write a description of class Hiscores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hiscores extends Screen
{
    int screen = 1;
    private  int numScreens = 8;
    /**
     * Constructor for objects of class Hiscores.
     * 
     */
    public Hiscores()
    {
        super();
        setBackground("images/Hiscores1.png");
    }
    
    void checkClick(MouseInfo mouse) {
        if (mouse.getY() >= 525 && mouse.getY() <= 560) {
            if (mouse.getX() >= 35 && mouse.getX() <= 235) {
                Greenfoot.setWorld(new Menu());
            }
            else if (mouse.getX() >= 400 && mouse.getX() <= 530) {
                if (screen < numScreens) {
                    setBackground("images/Hiscores" + (++screen) + ".png");
                }
            }
        }
    }
}
