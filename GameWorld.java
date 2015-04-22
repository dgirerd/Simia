import greenfoot.*;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int gameTime = 0;
    private static boolean gameOver = false;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1, false);
        gameOver = false;
    }
    
    public int getGameTime() {
        return gameTime;
    }
    
    public void act() {
        gameTime++;
    }
    
    public static void playerWin(int score) {
        gameOver = true;
        Greenfoot.setWorld(new GameOver(true, score));
    }
    
    public static void playerLoss(int score) {
        gameOver = true;
        Greenfoot.setWorld(new GameOver(false, score));
    }
}
