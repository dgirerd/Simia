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
    private static final int BANANA_SEC = 120; // Seconds until a new banana can be spawned
    private static final int LEVEL_UP_SEC = 3600;
    private static final int NUM_LIVES = 3;

    private int score; // Time of play
    private int bananasCollected; // Number of bananas Simia has collected
    private ArrayList<Life> lives;
    private ArrayList<Banana> bananas; // Array of the Bananas on the map at that current time
    private ArrayList<Projectile> projectiles; // Array of the Projectiles on the map at that current time
    private Simia simia; // Simia!
    private static boolean gameOver; // True if game ends by death or user quit
    private Random random;
    private double playTime;
    private int elapsedTimeRound;
    private int difficulty;
    GreenfootSound background0, background1, background2, background3, background4, background5, background6, background7, background8, background9, background10;
    

    public Game(int difficulty)
    {
        super.act();
        setBackground("images/JungleBackground.png");

        score = 0;
        bananasCollected = 0;
        lives = new ArrayList<Life>();
        bananas = new ArrayList<Banana>();
        projectiles = new ArrayList<Projectile>();
        simia = new Simia();
        gameOver = false;
        random = new Random();
        playTime = 0;
        elapsedTimeRound = 0; // increments by one each frame at 60 frames per second    
        this.difficulty = difficulty;

        Life life;
        int lifeX = 500;

        for (int i = 0; i < NUM_LIVES; i++) {
            life = new Life();
            lives.add(life);
            addObject(life, lifeX + i * 30, 30);
        }

        addObject(simia, 300, 300);

        random.setSeed(System.currentTimeMillis());
    }

    public void act() {
        // Create all necessary variables for Game Loop
        Banana banana;
        Projectile projectile;
        List<Banana> bananaCollisions = new ArrayList<Banana>();
        int x, y; // for projectile removal

        // 2.) Banana act()'s
        playTime++;
        if (elapsedTimeRound > 30) {
            if (bananas.size() < MAX_BANANA) {
                banana = new Banana();
                addObject(banana, random.nextInt(500) + SIDE_BUF, random.nextInt(500) + SIDE_BUF);
                bananas.add(banana);
            }
        }

        // 3.) See if we need to increase the difficulty
        if (elapsedTimeRound >= LEVEL_UP_SEC) {
            if (difficulty < 4)
                ++difficulty;
            elapsedTimeRound = 0;
        }
        else
            ++elapsedTimeRound;

        // 4.) Projectile act()'s
        if (elapsedTimeRound > 30) {
            if (projectiles.size() < MAX_PROJ) {
                projectile = new Projectile();

                projectile.setDifficulty(difficulty);

                if (projectiles.size() * random.nextInt(600) % 4 == 0) {
                    addObject(projectile, random.nextInt(600), 0);
                    projectile.turnTowards(simia.getX(), simia.getY());
                }
                else if (projectiles.size() * random.nextInt(600) % 3 == 0) {
                    addObject(projectile, 0, random.nextInt(600));
                    projectile.turnTowards(simia.getX(), simia.getY());
                }
                else if (projectiles.size() * random.nextInt(600) == 0) {
                    addObject(projectile, 600, random.nextInt(600));
                    projectile.turnTowards(simia.getX(), simia.getY());
                }
                else {
                    addObject(projectile, random.nextInt(600), 600);
                    projectile.turnTowards(simia.getX(), simia.getY());
                }

                projectiles.add(projectile);
            }
        }

        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).act();
            x = projectiles.get(i).getX();
            y = projectiles.get(i).getY();
            if (x < 0 || x > 600 || y < 0 || y > 600) {
                removeObject(projectiles.get(i));
                projectiles.remove(projectiles.get(i));
            }
        }

        // 5.) Increments time of play - figure out how to do this correctly
        // Moved inside if statement to check time above^^

        // somehow print playTime probably;

        // 6.) Toucan act()'s
        // implement once toucans exist

        // 7.) If Simia gets hit, then decrease numLives

        bananaCollisions = simia.checkBananaCollisions();
        projectile = simia.checkProjectileCollisions();

        if (projectile != null) {
            projectiles.remove(projectile);
            removeObject(projectile);

            removeObject(lives.get(0));
            lives.remove(0);
        }
        else {
            for (int i = 0; i < bananaCollisions.size(); i++) {
                bananas.remove(bananaCollisions.get(i));
                removeObject(bananaCollisions.get(i));
                ++bananasCollected;
                if(difficulty == 1) {
                    score++;
                } else if(difficulty == 2) {
                    score+=3;
                } else if(difficulty == 3) {
                    score+=10;
                }
            }
            showText("Score: " + score, 65, 30);
            
            
        }
        showText("Time: " + playTime/100, 175, 30);
        if (lives.size() == 0) {
            Greenfoot.setWorld(new GameOver(score, difficulty, playTime/100.00)); 
        }
    }

    // Moved Megan's collision functions above to if/else block right under step 7  
}
