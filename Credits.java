import greenfoot.*;

public class Credits extends Screen
{

    public Credits()
    {
        super();
        setBackground("images/Credits.png");
        addObject(new ScoreDisplay(), 500, 100);
    }
    
    void checkClick(MouseInfo mouse) { //pixel numbers to change
        if (mouse.getX() >= 380 && mouse.getX() <= 565 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
        }
    }
}
