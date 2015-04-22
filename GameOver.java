import greenfoot.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Screen
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(boolean win, int score)
    {
        super();
        music.stop();
        if (win) {
            setBackground("images/winScreen.png");
            music = new GreenfootSound("winner.wav");//to be stolen
            music.play();
        }
        else {
            setBackground("images/loseScreen.png");
            music = new GreenfootSound("loser.wav");//to be stolen
            music.play();
        }
    }
    
    void checkClick(MouseInfo mouse) {
        if (mouse.getX() >= 340 && mouse.getX() <= 560) {
            if (mouse.getY() >= 550 && mouse.getY() <= 585) {
                Greenfoot.setWorld(new Hiscores());
            }
        }
    }
}
