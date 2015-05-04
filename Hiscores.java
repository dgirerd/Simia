import greenfoot.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/**
 * Write a description of class Hiscores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hiscores extends Screen
{
    int screen = 1;
    private int numScreens = 5;
    /**
     * Constructor for objects of class Hiscores.
     * 
     */
    public Hiscores()
    {
        super();
        FileInputStream file;
        setBackground("images/Hiscores1.png");
        ArrayList<String> stats = new ArrayList<String>();
        int y = 130;
        try{
            file = new FileInputStream(new File("scores.txt"));
            Scanner lines = new Scanner(file);
            while(lines.hasNext()){
                stats.add(lines.next());
            }
            Collections.sort(stats);
            for(int i = (screen - 1) * 10; i < screen * 10; i++){
                Text text = new Text();
                text.setImage(new GreenfootImage(stats.get(i - 1), 25, Color.BLACK, Color.WHITE));
                addObject(text, 300, y);
                y += 20;
            }
        }catch(Exception e){
            //display empty page
         GreenfootImage image = new GreenfootImage("No high scores", 25, Color.BLACK, Color.WHITE);
         Text text = new Text();
         text.setImage(image);
         addObject(text, 300, 300);
        }        
        
    }
    
    void checkClick(MouseInfo mouse) {
        if (mouse.getY() >= 525 && mouse.getY() <= 560) {
            if (mouse.getX() >= 35 && mouse.getX() <= 235) {
                Greenfoot.setWorld(new Menu());
            }
            else if (mouse.getX() >= 400 && mouse.getX() <= 530) {
                if (screen < numScreens) {
                    setBackground("images/Hiscores.png");
                }
            }
        }
    }
    
    private class Text extends Actor{}
    
}
