import greenfoot.*;

public class Credits extends Screen
{
    GreenfootSound background0, background1, background2, background3, background4, background5;

    public Credits()
    {
        super();
        background0 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 0.aiff");
        background1 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 1.aiff");
        background2 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 2.aiff");
        background3 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 3.aiff");
        background4 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 4.aiff");
        background5 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 5.aiff");
        background0.playLoop();
        background1.playLoop();
        background2.playLoop();
        background3.playLoop();
        background4.playLoop();
        background5.playLoop();
        setBackground("images/Credits.png");
    }
    
    void checkClick(MouseInfo mouse) { 
        if (mouse.getX() >= 380 && mouse.getX() <= 565 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                background0.pause();
                background1.pause();
                background2.pause();
                background3.pause();
                background4.pause();
                background5.pause();
                Greenfoot.setWorld(new Menu());
        }
    }
}
