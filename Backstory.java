import greenfoot.*;

public class Backstory extends Screen
{

    public Backstory()
    {
        super();
        setBackground("images/Backstory.png");
    }
    
    void checkClick(MouseInfo mouse) {
            if(mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
            }
    }
}
