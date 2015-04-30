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
            if (mouse.getX() >= 250 && mouse.getX() <= 340 && mouse.getY() >= 175 && mouse.getY() <= 220) {
                //music.playLoop();
                Greenfoot.setWorld(new Game(1)); //easy
            }
            else if (mouse.getX() >= 205 && mouse.getX() <= 370 && mouse.getY() >= 285 && mouse.getY() <= 330) {
                //music.playLoop();
                Greenfoot.setWorld(new Game(2)); //medium
            }
            else if (mouse.getX() >= 245 && mouse.getX() <= 335 && mouse.getY() >= 400 && mouse.getY() <= 445) {
                //music.playLoop();
                Greenfoot.setWorld(new Game(3)); //hard
            }
            else if (mouse.getX() >= 350 && mouse.getX() <= 580 && mouse.getY() >= 500 && mouse.getY() <= 580) {
                //music.playLoop();
                Greenfoot.setWorld(new Menu());
            }
    }
}

