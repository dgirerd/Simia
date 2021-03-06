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
            Collections.reverse(stats);
            for(int i = 1; i <= 11 && (i - 1) < stats.size(); i++){
                Text rank = new Text();
                Text points = new Text();
                Text name = new Text();
                Text time = new Text();
                Text diff = new Text();
                rank.setImage(new GreenfootImage("" + i, 25, Color.BLACK, new Color(255, 255, 255, 0)));
                Scanner parse = new Scanner(stats.get(i - 1));
                parse.useDelimiter((char)1 + "");
                int r = parse.nextInt();
                points.setImage(new GreenfootImage("" + r, 25, Color.BLACK, new Color(255, 255, 255, 0)));
                String n = parse.next();
                name.setImage(new GreenfootImage(n, 25, Color.BLACK, new Color(255,255,255,0)));
                String t = parse.next();
                time.setImage(new GreenfootImage(t, 25, Color.BLACK, new Color(255,255,255,0)));
                switch(parse.nextInt()){
                    case 1:
                    diff.setImage(new GreenfootImage("Easy", 25, Color.BLACK, new Color(255,255,255,0)));
                    break;
                    case 2:
                    diff.setImage(new GreenfootImage("Medium", 25, Color.BLACK, new Color(255,255,255,0)));
                    break;
                    case 3:
                    diff.setImage(new GreenfootImage("Hard", 25, Color.BLACK, new Color(255,255,255,0)));
                    break;
                }
                addObject(rank, 59, y);
                addObject(points, 147, y);
                addObject(name, 288, y);
                addObject(time, 422, y);
                addObject(diff, 521, y);
                y += 39;
            }
        }catch(Exception e){
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
