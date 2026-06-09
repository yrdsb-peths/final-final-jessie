import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class EndScreen extends World
{

    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        YouWin win = new YouWin();
        addObject(win, 400, 300);
        
        long endTime = System.currentTimeMillis();

        long totalTime = endTime - GameWorld.startTime;

        long seconds = totalTime / 1000;
        
        int min = (int) (seconds/ 60);
        int sec = (int) (seconds % 60);
        Label timeUsed = new Label("Time Used: " + min + ":" + sec, 40);
        addObject(timeUsed, 400, 190);
    }
}
