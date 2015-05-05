import greenfoot.*;
import java.awt.Color;

public class ScoreDisplay extends Actor
{
    private int score = 0;
    private int prevScore = 0;
    
    public void act() 
    {
        if (score != prevScore) {
        	// Correctly display image
            setImage(new GreenfootImage(Integer.toString(score), 25, Color.black, Color.green));    
            prevScore = score;
        }
    }
    
    public void setScore(int newScore) {
        score = newScore;
    }    
}
