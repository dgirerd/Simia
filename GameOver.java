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
    public GameOver(int score) throws IOException
    {
        super();
        ArrayList<String> stats = new ArrayList<String>();
        //music.stop();
        setBackground("images/endScreen.png");
        FileInputStream file;
        int least;
        //music = new GreenfootSound("end.wav");//to be stolen
        //music.play();
        try{
            file = new FileInputStream(new File("scores.txt"));
        }
        catch(FileNotFoundException e){
            File scores = new File("scores.txt");
            scores.createNewFile();
            file = new FileInputStream(new File("scores.txt"));
        }
        Scanner lines = new Scanner("scores.txt");
        while(lines.hasNext()){
            stats.add(lines.next());
        }
        file.close();
        FileWriter fileWrite = new FileWriter(new File("scores.txt"), false);
        Collections.sort(stats);
        try{
            lines = new Scanner(stats.get(0));
            least = lines.nextInt();
        }catch(Exception e){
            least = score + 1;
        }
        if(stats.size() < 50 ||  score < least){
            String name = JOptionPane.showInputDialog("Enter your name:");
            stats.add(String.format("%09", score) + " " + name);
            stats.remove(0);
            for(String s : stats){
                fileWrite.write(s);
            }
            Greenfoot.setWorld(new Hiscores());
        }
        else{
            Greenfoot.setWorld(new Menu());
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
