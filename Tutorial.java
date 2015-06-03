import greenfoot.*;

public class Tutorial extends Screen
{
    int screen = 1;
    private static final int NUM_SCREENS = 2; 

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
