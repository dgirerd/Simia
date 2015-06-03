import greenfoot.*;

public class Credits extends Screen
{
    GreenfootSound background0, background1, background2, background3, background4, background5;

    public Credits()
    {
        super();
        setBackground("images/Credits.png");
    }
    
    void checkClick(MouseInfo mouse) { 
        if (mouse.getX() >= 380 && mouse.getX() <= 565 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
        }
    }
}
