import greenfoot.*;
import java.awt.Color;

public class Menu extends Screen
{
    GreenfootSound background0, background1, background2, background3, background4, background5;
    
    public Menu()
    {
        super();
        Screen.menuSound0.playLoop();
        Screen.menuSound1.playLoop();
        Screen.menuSound2.playLoop();
        Screen.menuSound3.playLoop();
        Screen.menuSound4.playLoop();
        Screen.menuSound5.playLoop();
        
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
