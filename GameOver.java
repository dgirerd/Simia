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

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int score, int difficulty, int playTime)
    {
        super();
        ArrayList<String> stats = new ArrayList<String>();
        //music.stop();
        setBackground("images/GameOver.png");
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
                String name = JOptionPane.showInputDialog("Enter your name:");
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
        if(mouse.getX() >= 207 && mouse.getX() <= 392 && mouse.getY() >= 513 && mouse.getY() <= 572) {
                Greenfoot.setWorld(new Menu());
            }
        /*if (mouse.getX() >= 340 && mouse.getX() <= 560) {
            if (mouse.getY() >= 550 && mouse.getY() <= 585) {
                Greenfoot.setWorld(new Hiscores()); //add option to return to menu, try again
            }
        }*/
    }
}
