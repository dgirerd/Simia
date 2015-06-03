import greenfoot.*;

public class PlaySettings extends Screen
{
    GreenfootSound background0, background1, background2, background3, background4, background5;

    public PlaySettings()
    {
        super(); 
        setBackground("images/PlaySettings.png");
    }

    void checkClick(MouseInfo mouse){ 
        if(mouse.getX() >= 205 && mouse.getX() <= 395) {
            if (mouse.getY() >= 215 && mouse.getY() <= 275) {
                Screen.menuSound0.pause();
                Screen.menuSound1.pause();
                Screen.menuSound2.pause();
                Screen.menuSound3.pause();
                Screen.menuSound4.pause();
                Screen.menuSound5.pause();
                Screen.gameSound0.playLoop();
                Screen.gameSound1.playLoop();
                Screen.gameSound2.playLoop();
                Screen.gameSound3.playLoop();
                Screen.gameSound4.playLoop();
                Screen.gameSound5.playLoop();
                Screen.gameSound6.playLoop();
                Screen.gameSound7.playLoop();
                Screen.gameSound9.playLoop();
                Screen.gameSound10.playLoop();
                Greenfoot.setWorld(new Game(1)); //easy
            }
            else if (mouse.getY() >= 295 && mouse.getY() <= 355) {
                Screen.menuSound0.pause();
                Screen.menuSound1.pause();
                Screen.menuSound2.pause();
                Screen.menuSound3.pause();
                Screen.menuSound4.pause();
                Screen.menuSound5.pause();
                Screen.gameSound0.playLoop();
                Screen.gameSound1.playLoop();
                Screen.gameSound2.playLoop();
                Screen.gameSound3.playLoop();
                Screen.gameSound4.playLoop();
                Screen.gameSound5.playLoop();
                Screen.gameSound6.playLoop();
                Screen.gameSound7.playLoop();
                Screen.gameSound9.playLoop();
                Screen.gameSound10.playLoop();
                Greenfoot.setWorld(new Game(2)); //medium
            }
            else if (mouse.getY() >= 370 && mouse.getY() <= 430) {
                Screen.menuSound0.pause();
                Screen.menuSound1.pause();
                Screen.menuSound2.pause();
                Screen.menuSound3.pause();
                Screen.menuSound4.pause();
                Screen.menuSound5.pause();
                Screen.gameSound0.playLoop();
                Screen.gameSound1.playLoop();
                Screen.gameSound2.playLoop();
                Screen.gameSound3.playLoop();
                Screen.gameSound4.playLoop();
                Screen.gameSound5.playLoop();
                Screen.gameSound6.playLoop();
                Screen.gameSound7.playLoop();
                Screen.gameSound9.playLoop();
                Screen.gameSound10.playLoop();
                Greenfoot.setWorld(new Game(3)); //hard
            }
        }
        if (mouse.getX() >= 380 && mouse.getX() <= 565 && mouse.getY() >= 513 && mouse.getY() <= 572) {
            Greenfoot.setWorld(new Menu());
        }
    }
}

