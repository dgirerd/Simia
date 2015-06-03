import greenfoot.*;

public class Tutorial extends Screen
{
    int screen = 1;
    private static final int NUM_SCREENS = 2;
    GreenfootSound background0, background1, background2, background3, background4, background5; 

    public Tutorial()
    {
        super();
        setBackground("images/Tutorial.png"); 
    }
    
    void checkClick(MouseInfo mouse) { 
        if(mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
        }
    }
}
