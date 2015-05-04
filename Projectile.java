import greenfoot.*;

public class Projectile extends Actor
{

    public void act() 
    {
    	int halfWidth = getImage().getWidth()/2;
        int halfHeight = getImage().getHeight()/2;
        
        move(5);
    }    
}
