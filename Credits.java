import greenfoot.*;

public class Credits extends Screen
{

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
