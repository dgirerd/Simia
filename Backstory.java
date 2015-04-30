import greenfoot.*;

public class Backstory extends Screen
{
    int screen = 1;
    private static final int NUM_SCREENS = 2; //to be changed

    public Backstory()
    {
        super();
        setBackground("images/Backstory1.png");
    }
    
    void checkClick(MouseInfo mouse) {

            if(screen < NUM_SCREENS && mouse.getY() >= 515 && mouse.getY() <= 545) {
                if(mouse.getX() >= 50 && mouse.getX() <= 250) {
                    Greenfoot.setWorld(new Menu());
                } else if (mouse.getX() >= 410 && mouse.getX() <= 540){
                    setBackground("images/Backstory" + (++screen) + ".png");
                }
            } else if (screen == NUM_SCREENS && mouse.getY() >= 525 && mouse.getY() <= 555 && mouse.getX() >= 350 && mouse.getX() <= 550) {
                    Greenfoot.setWorld(new Menu());
            }
    }
}
