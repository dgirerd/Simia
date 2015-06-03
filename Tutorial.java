import greenfoot.*;

public class Tutorial extends Screen
{
    int screen = 1;
    private static final int NUM_SCREENS = 2;
    GreenfootSound background0, background1, background2, background3, background4, background5; 

    public Tutorial()
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
        setBackground("images/Tutorial.png"); 
    }
    
    void checkClick(MouseInfo mouse) { 
        if(mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 513 && mouse.getY() <= 572) {
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
