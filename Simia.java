import greenfoot.*;
import java.util.*;

public class Simia extends Actor
{
    int xPos = 300;
    int yPos = 300;
    private static int ms = 5;
    private boolean faceRight = true;
    
    public void act() 
    {
        int halfWidth = getImage().getWidth()/2;
        int halfHeight = getImage().getHeight()/2;
        if (Greenfoot.isKeyDown("right") && this.xPos + ms + halfWidth <= Game.areaXmax) {
            this.xPos += ms;
            if(!faceRight) {
                getImage().mirrorHorizontally();
                faceRight = true;
            }
        }
        if (Greenfoot.isKeyDown("left") && this.xPos - ms - halfWidth >= Game.areaXmin) {
            this.xPos -= ms;
            if(faceRight) {
                getImage().mirrorHorizontally();
                faceRight = false;
            }
        }
        if (Greenfoot.isKeyDown("down") && this.yPos + ms + halfHeight <= Game.areaYmax) {
            this.yPos += ms;
        }
        if (Greenfoot.isKeyDown("up") && this.yPos - ms - halfHeight >= Game.areaYmin) {
            this.yPos -= ms;
        }
        checkCollisions();
        setLocation(this.xPos, this.yPos);
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
