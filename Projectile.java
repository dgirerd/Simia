import greenfoot.*;

public class Projectile extends Actor
{
	private int difficulty;
	
    public void act() 
    {
        move(difficulty);
    }
    
    public void setDifficulty(int num) {
    	difficulty = num;
    }
}
