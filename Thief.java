import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thief here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thief extends Actor
{
    /**
     * Act - do whatever the Thief wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //constructor
    
    public Thief()
    {
        GreenfootImage iniThief = new GreenfootImage("images/thief/front2.png");
        iniThief.scale(72,96);
        setImage(iniThief);
    }
    
    public void act()
    {
        // Add your action code here.
    
    }
}
