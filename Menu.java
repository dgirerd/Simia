import greenfoot.*;
import java.awt.Color;

public class Menu extends Screen
{

    public Menu()
    {
        super();
        setBackground("images/Menu.png"); 
        
        
    }
    
    void checkClick(MouseInfo mouse) { 
        if(mouse.getX() >= 205 && mouse.getX() <= 395) {
            if (mouse.getY() >= 185 && mouse.getY() <= 245) {
                Greenfoot.setWorld(new PlaySettings());
            }
            else if (mouse.getY() >= 265 && mouse.getY() <= 325) {
                Greenfoot.setWorld(new Backstory());
            }
            else if (mouse.getY() >= 330 && mouse.getY() <= 390) {
                Greenfoot.setWorld(new Tutorial());
            }
            else if (mouse.getY() >= 400 && mouse.getY() <= 460) {
                Greenfoot.setWorld(new Hiscores());
            }
            else if (mouse.getY() >= 465 && mouse.getY() <= 525) {
                Greenfoot.setWorld(new Credits());
            }
        }
    }
}
