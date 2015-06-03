import greenfoot.*;

public abstract class Screen extends World
{
    public static GreenfootSound music;
    public static int width = 600;
    public static int height = 600;
    public static GreenfootSound menuSound0 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 0.aiff");
    public static GreenfootSound menuSound1 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 1.aiff");
    public static GreenfootSound menuSound2 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 2.aiff");
    public static GreenfootSound menuSound3 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 3.aiff");
    public static GreenfootSound menuSound4 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 4.aiff");
    public static GreenfootSound menuSound5 = new GreenfootSound("sounds/Simia2.loopysession/Media/Track 5.aiff");
    public static GreenfootSound gameSound0 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 0.aiff");
    public static GreenfootSound gameSound1 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 1.aiff");
    public static GreenfootSound gameSound2 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 2.aiff");
    public static GreenfootSound gameSound3 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 3.aiff");
    public static GreenfootSound gameSound4 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 4.aiff");
    public static GreenfootSound gameSound5 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 5.aiff");
    public static GreenfootSound gameSound6 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 6.aiff");
    public static GreenfootSound gameSound7 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 7.aiff");
    public static GreenfootSound gameSound9 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 9.aiff");
    public static GreenfootSound gameSound10 = new GreenfootSound("sounds/Simia.loopysession/Media/Track 10.aiff");

    public Screen()
    {    
        super(width, height, 1);
    }
    
    public void act() {
        if (Greenfoot.mousePressed(this)) {
           checkClick(Greenfoot.getMouseInfo());
        }
    }
    
    abstract void checkClick(MouseInfo mouse);
}
