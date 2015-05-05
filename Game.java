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

	private int score; // Time of play
	private int bananasCollected; // Number of bananas Simia has collected
	private int numLives; // Number of lives Simia has left
	private ArrayList<Banana> bananas; // Array of the Bananas on the map at that current time
	private ArrayList<Projectile> projectiles; // Array of the Projectiles on the map at that current time
	private Simia simia; // Simia!
	private ScoreDisplay scoreDisplay; // Current score of the game
	private static boolean gameOver; // True if game ends by death or user quit
	private Random random;
	private int playTime;
	private int elapsedTimeRound;
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
		scoreDisplay = new ScoreDisplay();
		addObject(scoreDisplay, 10, 40);
		simia = new Simia();
		gameOver = false;
		random = new Random();
		playTime = 0;
		elapsedTimeRound = 0; // increments by one each frame at 60 frames per second    
		this.difficulty = difficulty;

		random.setSeed(System.currentTimeMillis());
	}

	public void act() {
		// Create all necessary variables for Game Loop
		Banana banana;
		Projectile projectile;
		List<Banana> bananaCollisions = new ArrayList<Banana>();
		int x, y; // for projectile removal

		addObject(simia, 300, 300);

		showText("numLives == " + numLives, 300, 300);

		// 1.) ScoreDisplay act()'s
		scoreDisplay.act();

		// 2.) Banana act()'s
		if (bananas.size() < MAX_BANANA) {
			banana = new Banana();
			addObject(banana, random.nextInt(500) + SIDE_BUF, random.nextInt(500) + SIDE_BUF);
			bananas.add(banana);
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
			--numLives;
		}
		else {
			for (int i = 0; i < bananaCollisions.size(); i++) {
				bananas.remove(bananaCollisions.get(i));
				++bananasCollected;
				score += difficulty;
				showText("Score == " + bananasCollected, 10, 10);
			}
		}

		if (numLives == 0) {
			Greenfoot.setWorld(new GameOver(score)); 
		}
	}

	// Moved Megan's collision functions above to if/else block right under step 7  
}
