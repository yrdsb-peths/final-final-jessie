import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public GameWorld(int width, int height, int cellSize)
    {
        super(width, height, cellSize);
    }
    
    public void gameOver()
    {
        Thief thief = (Thief) getObjects(Thief.class).get(0);
        showText("Lives: " + thief.getLives(), 50, 15);
        GameOver gameover = new GameOver();
        addObject(gameover, 400, 300);
        Greenfoot.stop();
    }
        
    public void nextLevel()
    {
        
    }
}
