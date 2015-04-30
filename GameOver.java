import greenfoot.*;
import javax.swing.*;
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
    public GameOver(int score)
    {
        super();
        //music.stop();
        setBackground("images/endScreen.png");
        //music = new GreenfootSound("end.wav");//to be stolen
        //music.play();
        /*FileInputStream file = new FileInputStream(new File("scores.txt"));
        Scanner line = new Scanner("scores.txt");
        Scanner parse;
        int temp;
        int num = -1;
        while(line.hasNext()){
            parse = new Scanner(line.next);
            temp = parse.nextInt();
            if(num == -1 || temp < num)
                num = temp;
        }
        if(temp < score){
            String name = JOptionPane.showInputDialog("Enter your name:");
            greenfoot.setWorld(new Hiscores(name, score)); 
        }
        else{
            greenfoot.setWorld(new Menu());
        }*/
    }
    
    void checkClick(MouseInfo mouse) {
        if (mouse.getX() >= 340 && mouse.getX() <= 560) {
            if (mouse.getY() >= 550 && mouse.getY() <= 585) {
                Greenfoot.setWorld(new Hiscores());
            }
        }
    }
}
