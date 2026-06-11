import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class EndScreen extends World
{

    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        GreenfootImage bg = new GreenfootImage("endScreen.png");
        bg.scale(800,600);
        
        setBackground(bg);
        
        YouWin win = new YouWin();
        addObject(win, 400, 300);
        
        GameWorld.music.stop();
        Greenfoot.playSound("win.mp3");
        int min = GameWorld.secondsElapsed / 60;
        int sec = GameWorld.secondsElapsed % 60;
    
        Label timeUsed = new Label("Time Used: " + min + ":" + sec, 40);
        addObject(timeUsed, 400, 190);

    }
}
