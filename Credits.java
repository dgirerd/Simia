import greenfoot.*;

public class Credits extends Screen
{

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
