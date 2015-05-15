import greenfoot.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Hiscores extends Screen
{
    public Hiscores()
    {
        super();
        FileInputStream file;
        setBackground("images/Hiscores.png");
        ArrayList<String> stats = new ArrayList<String>();
        int y = 150;
        try{
            file = new FileInputStream(new File("scores.txt"));
            Scanner lines = new Scanner(file);
            while(lines.hasNext()){
                stats.add(lines.nextLine());
            }
            Collections.sort(stats);
            for(int i = 0; i < 10 && i < stats.size(); i++){
                Text text = new Text();
                text.setImage(new GreenfootImage(i + " " + stats.get(i), 25, Color.BLACK, new Color(255, 255, 255, 0)));
                addObject(text, 300, y);
                y += 39;
            }
        }catch(Exception e){
            System.out.println(e);
            //display empty page
         GreenfootImage image = new GreenfootImage("No high scores", 50, Color.BLACK, new Color(255, 255, 255, 0));
         Text text = new Text();
         text.setImage(image);
         addObject(text, 300, 300);
        }        
    }
    
    void checkClick(MouseInfo mouse) {
        if(mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
        }
    }
    
    private class Text extends Actor{}
    
}
