import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YellowLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowLaser extends Laser
{
    
    int speed = 3;
    public YellowLaser()
    {
        GreenfootImage yellow = new GreenfootImage("yellowLaser.png");
        yellow.scale(100,100);
        setImage(yellow);
    }
    public void act()
    {
        // Add your action code here.
        moveLaser();
        
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    public void moveLaser()
    {
        move(speed);
    }
    
    
}
