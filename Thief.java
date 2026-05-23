import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thief here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thief extends Actor
{
    private String direction ="";
    int speed = 2;
    SimpleTimer animationTimer = new SimpleTimer();
    
    
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
        animateThief();
    }
    
    public void animateThief()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
    }
}
