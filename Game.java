import greenfoot.*;

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends GameWorld
{
    private int score; // Time of play
    private int currentBananas; // Number of bananas on map
    private int bananasCollected; // Number of bananas Simia has collected
    private boolean hit; // False until Simia has been hit
    private int numLives; // Number of lives Simia has left
    private Banana[] bananas; // Array of the Bananas on the map at that current time
    private Projectile[] projectiles; // Array of the Projectiles on the map at that current time
    private Simia simia; // Simia!
    private boolean gameOver; // True if game ends by death or user quit
    // Create more private variables as necessary
    
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game(int difficulty)
    {
        // construct something
    }
    
    public static void main(String[] args) {
        // Create all necessary variables for Game Loop
        
        while (!gameOver) {
            // 1.) Banana act()'s
            // 2.) See if we need to increase the difficulty
            // 3.) Projectile act()'s
            // 4.) Increments time of play - figure out how to do this correctly
            // 5.) Toucan act()'s
            // 6.) If Simia gets hit, then decrease numLives
        }
        
        // When the game is over:
        //  greenfoot.setWorld(new GameOver(boolean win, int score))
    }
}
