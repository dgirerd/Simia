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
        if (Greenfoot.isKeyDown("right") && this.xPos + ms < 600) {
            this.xPos += ms;
            setLocation((int)this.xPos, (int)this.yPos);
            if (!getIntersectingObjects(null).isEmpty()) {
                this.xPos -= ms;
            }
        }
        if (Greenfoot.isKeyDown("left") && this.xPos - ms >= 0) {
            this.xPos -= ms;
            setLocation((int)this.xPos, (int)this.yPos);
            if (!getIntersectingObjects(null).isEmpty()) {
                this.xPos += ms;
            }
        }
        if (Greenfoot.isKeyDown("down") && this.yPos + ms < 600) {
            this.yPos += ms;
            setLocation((int)this.xPos, (int)this.yPos);
            if (!getIntersectingObjects(null).isEmpty()) {
                this.yPos -= ms;
            }
        }
        if (Greenfoot.isKeyDown("up") && this.yPos - ms >= 0) {
            this.yPos -= ms;
            setLocation((int)this.xPos, (int)this.yPos);
            if (!getIntersectingObjects(null).isEmpty()) {
                this.yPos += ms;
            }
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
