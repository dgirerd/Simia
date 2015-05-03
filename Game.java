import greenfoot.*;
import java.util.*;

public class Game extends GameWorld
{
    public static int areaXmin = 50;
    public static int areaXmax = 550;
    public static int areaYmin = 50;
    public static int areaYmax = 550;
    
    private static final int SIDE_BUF = 50; // Buffer around side of screen where nothing will be 
    private static final int MAX_PROJ = 8; // Maximum number of projectiles
    private static final int MAX_BANANA = 3; // Maximum number of bananas
    private static final int BANANA_SEC = 2; // Seconds until a new banana can be spawned
    private static final double PROJ_SEC = 0.4; // Seconds until a projectile can be spawned

    private int score; // Time of play
    private int bananasCollected; // Number of bananas Simia has collected
    private int numLives; // Number of lives Simia has left
    private ArrayList<Banana> bananas; // Array of the Bananas on the map at that current time
    private ArrayList<Projectile> projectiles; // Array of the Projectiles on the map at that current time
    private Simia simia; // Simia!
    private static boolean gameOver; // True if game ends by death or user quit
    private Random random;
    private int playTime;
    private long elapsedTimeStart;
    private long elapsedTimeRound;
    private long lastTime;
    private long startTime;
    private int difficulty;

    public Game(int difficulty)
    {
        super.act();
        setBackground("images/JungleBackground.png");
        
        
        score = 0;
        bananasCollected = 0;
        numLives = 3;
        bananas = new ArrayList<Banana>();
        projectiles = new ArrayList<Projectile>();
        simia = new Simia();
        gameOver = false;
        random = new Random();
        playTime = 0;
        elapsedTimeStart = 0; // ?
        elapsedTimeRound = 0; // ?        
        lastTime = 0; // ?
        startTime = 0; // ?    
        this.difficulty = difficulty;
        
        random.setSeed(System.currentTimeMillis());
    }
    
    public void act() {
        // Create all necessary variables for Game Loop
        Banana banana;
        Projectile projectile;
        
        startTime = System.currentTimeMillis();
        lastTime = startTime;
        addObject(simia, 300, 300);
        
         elapsedTimeRound = System.currentTimeMillis() - lastTime;
         elapsedTimeStart = System.currentTimeMillis();
     
         // 1.) Banana act()'s
         if (bananas.size() < MAX_BANANA && elapsedTimeRound / 1000 > BANANA_SEC) {
            banana = new Banana();
            addObject(banana, random.nextInt(500) + SIDE_BUF, random.nextInt(500) + SIDE_BUF);
            bananas.add(banana);
            lastTime = elapsedTimeRound; // maybe we can't use the same time for proj/banana
         }

         // 2.) See if we need to increase the difficulty
         if (elapsedTimeStart / 1000 >= 60) {
            // increase difficulty
         }
         
         // 3.) Projectile act()'s
         if (projectiles.size() < MAX_PROJ && elapsedTimeRound / 1000.0 > PROJ_SEC) {
            projectile = new Projectile();
            
            // this is sort of lame and janky
            if (projectiles.size() % 4 == 0) {
               addObject(projectile, random.nextInt(600), 0);
            }
            else if (projectiles.size() % 3 == 0) {
               addObject(projectile, 0, random.nextInt(600));
            }
            else if (projectiles.size() % 2 == 0) {
               addObject(projectile, 600, random.nextInt(600));
            }
            else {
               addObject(projectile, random.nextInt(600), 600);
            }
            
            projectiles.add(projectile);
         }
         
         for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).act();
         }
         
         // 4.) Increments time of play - figure out how to do this correctly
         playTime = (int)(elapsedTimeStart - startTime) / 1000;
         // somehow print playTime probably;

         // 5.) Toucan act()'s
         // implement once toucans exist
         
         // 6.) If Simia gets hit, then decrease numLives
         if (numLives == 0) {
            Greenfoot.setWorld(new GameOver(score)); 
         }
    }
    
    public void collectedBanana(ArrayList<Banana> collisions) {
       for (int i = 0; i < collisions.size(); i++) {
          bananas.remove(collisions.get(i));
          bananasCollected++;
          score += difficulty;
       }
    }
    
    public void hitByProjectile(ArrayList<Projectile> collisions) {
        for (int i = 0; i < collisions.size(); i++) {
           projectiles.remove(collisions.get(i));
           numLives--;
        }
    }   
}
