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
		if ((Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))&& this.xPos + ms + halfWidth <= Game.areaXmax) {
			this.xPos += ms;
			if(!faceRight) {
				getImage().mirrorHorizontally();
				faceRight = true;
				// could also do"
				//	faceRight = !faceRight;
			}
		}
		if ((Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) && this.xPos - ms - halfWidth >= Game.areaXmin) {
			this.xPos -= ms;
			if(faceRight) {
				getImage().mirrorHorizontally();
				faceRight = false;
				// could also do"
				//	faceRight = !faceRight;
			}
		}
		if ((Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) && this.yPos + ms + halfHeight <= Game.areaYmax) {
			this.yPos += ms;
		}
		if ((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) && this.yPos - ms - halfHeight >= Game.areaYmin) {
			this.yPos -= ms;
		}
		setLocation(this.xPos, this.yPos);
	}

	public List<Banana> checkBananaCollisions() {
		List<Banana> bananas = new ArrayList<Banana>();
		Banana b = new Banana();
		int total = 0;

		bananas = getIntersectingObjects(b.getClass());

		return bananas;
	}
	
	public Projectile checkProjectileCollisions() {
		List<Actor> arr = new ArrayList<Actor>();
		Game g = new Game(1);
		Projectile projectile = new Projectile();
		int total = 0;

		arr = getIntersectingObjects(projectile.getClass());
		if (arr.size() > 0)
			projectile = (Projectile)arr.get(0);
		else
			projectile = null;

		return projectile;
	}
}
