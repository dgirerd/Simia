import greenfoot.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Screen
{

    private int difficulty;
    
    public GameOver(int score, int difficulty, int playTime)
    {
        super();
        this.difficulty = difficulty;
        ArrayList<String> stats = new ArrayList<String>();
        //music.stop();
        setBackground("images/GameOver.png");
        showText("Score: " + score, 300, 167);
        FileInputStream file;
        FileWriter fileWrite;
        int least = 0;
        //music = new GreenfootSound("end.wav");//to be stolen
        //music.play();
        try{
            file = new FileInputStream(new File("scores.txt"));
        }catch(FileNotFoundException e){
            System.out.println("1 " + e);
            File scores = new File("scores.txt");//only needs to create file if file doesn't exist
            try{
                scores.createNewFile();
                file = new FileInputStream(new File("scores.txt"));
            }catch(Exception x){
                System.out.println("2" + x);
                return;
            }
        }
        Scanner lines = new Scanner(file);
        while(lines.hasNext()){
            stats.add(lines.next());
        }
        try{
            file.close();
            File textfile = new File("scores.txt");
            fileWrite = new FileWriter(textfile, false);
           /* if(stats.size() > 0){
                Collections.sort(stats);
                lines = new Scanner(stats.get(0));
                least = lines.nextInt();
            }*/
    
            if(stats.size() < 50 ||  score > least){
                String name = JOptionPane.showInputDialog("Game Over! Enter your name:");
                stats.add(score + " " + name);
                System.out.println(stats.size());
                if(stats.size() == 50)
                    stats.remove(0);
                for(String s : stats){
                    System.out.println(s);
                    fileWrite.write(s + "\n");
                }
            }
            
            fileWrite.close();
        
        }catch(Exception e){
            System.out.println("3 " +e);
        }
    }
    
    void checkClick(MouseInfo mouse) {
        if(mouse.getX() >= 205 && mouse.getX() <= 395) {
            if (mouse.getY() >= 215 && mouse.getY() <= 275) {
                //music.playLoop();
                Greenfoot.setWorld(new Game(difficulty)); 
            }
            else if (mouse.getY() >= 295 && mouse.getY() <= 355) {
                //music.playLoop();
                Greenfoot.setWorld(new Hiscores());
            }
            else if (mouse.getY() >= 370 && mouse.getY() <= 430) {
                //music.playLoop();
                Greenfoot.setWorld(new Credits()); 
            }
        }
            if (mouse.getX() >= 380 && mouse.getX() <= 565 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
        }
    }
}
