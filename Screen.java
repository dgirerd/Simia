import greenfoot.*;

public abstract class Screen extends World
{
    public static GreenfootSound music;
    public static int width = 600;
    public static int height = 600;

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
