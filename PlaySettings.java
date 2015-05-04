import greenfoot.*;

public class PlaySettings extends Screen
{

    public PlaySettings()
    {
        super();
        setBackground("images/PlaySettings.png");
        //music = new GreenfootSound("greatmusic.wav");//to be stolen
    }
    
    void checkClick(MouseInfo mouse){ 
        if(mouse.getX() >= 205 && mouse.getX() <= 395) {
            if (mouse.getY() >= 215 && mouse.getY() <= 275) {
                //music.playLoop();
                Greenfoot.setWorld(new Game(1)); //easy
            }
            else if (mouse.getY() >= 295 && mouse.getY() <= 355) {
                //music.playLoop();
                Greenfoot.setWorld(new Game(2)); //medium
            }
            else if (mouse.getY() >= 370 && mouse.getY() <= 430) {
                //music.playLoop();
                Greenfoot.setWorld(new Game(3)); //hard
            }
        }
            if (mouse.getX() >= 380 && mouse.getX() <= 565 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
        }
    }
}

