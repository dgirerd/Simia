import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Simia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Simia extends Actor
{
    double xPos = 300.0D;
    double yPos = 300.0D;
    private static int ms = 5;

    /**
     * Act - do whatever the Simia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int halfWidth = getImage().getWidth()/2;
        int halfHeight = getImage().getHeight()/2;
        if (Greenfoot.isKeyDown("right") && this.xPos + ms + halfWidth <= Game.areaXmax) {
            this.xPos += ms;
        }
        if (Greenfoot.isKeyDown("left") && this.xPos - ms - halfWidth >= Game.areaXmin) {
            this.xPos -= ms;
        }
        if (Greenfoot.isKeyDown("down") && this.yPos + ms + halfHeight <= Game.areaYmax) {
            this.yPos += ms;
        }
        if (Greenfoot.isKeyDown("up") && this.yPos - ms - halfHeight >= Game.areaYmin) {
            this.yPos -= ms;
        }
        checkCollisions();
        setLocation((int)this.xPos, (int)this.yPos);
    }
    
    public void checkCollisions() {
    	List<Actor> arr = new ArrayList<Actor>();
    	List<Projectile> projectiles = new ArrayList<Projectile>();
    	List<Banana> bananas = new ArrayList<Banana>();
    	Banana b = new Banana();
    	//Game g = new Game();
    	
    	arr = getIntersectingObjects(null);
    	for (Actor a : arr) {
    		if (b.getClass().equals(a.getClass()))
    			bananas.add((Banana)a);
    		else
    			projectiles.add((Projectile)a);
    	}
    	
    	//g.collectedBanana(bananas);
    	//g.hitByProjectile(projectiles);
    }
}
