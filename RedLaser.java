import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedLaser extends Laser
{
    private int timer = 0;
    
    public RedLaser()
    {
        GreenfootImage red = new GreenfootImage("redLaser.png");
        red.scale(1550,200);
        setImage(red);
    }
    
    public void act()
    {
        timer++;
        
        if(timer >= 240)
        {
            getWorld().removeObject(this);
        }
    }
}
