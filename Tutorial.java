import greenfoot.*;

public class Tutorial extends Screen
{
    int screen = 1;
    private static final int NUM_SCREENS = 2; 

    public Tutorial()
    {
        super();
        setBackground("images/Tutorial1.png"); 
    }
    
    void checkClick(MouseInfo mouse) { 
        if(mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
        }
        /*if (screen < NUM_SCREENS && mouse.getY() >= 520 && mouse.getY() <= 555) {
            if (mouse.getX() >= 70 && mouse.getX() <= 265) {
                Greenfoot.setWorld(new Menu());
            } else if (mouse.getX() >= 410 && mouse.getX() <= 540) {
                setBackground("images/Tutorial" + (++screen) + ".png");
            }
        } else if (screen == NUM_SCREENS && mouse.getX() >= 360 && mouse.getX() <= 555 && mouse.getY() >= 530 && mouse.getY() <= 555) {
            Greenfoot.setWorld(new Menu());
        }*/
    }
}
