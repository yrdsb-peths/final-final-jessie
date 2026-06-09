import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hint extends Actor
{
    private int timer = 180;
    public Hint()
    {
        GreenfootImage hint = new GreenfootImage("hint.png");
        setImage(hint);
    }
    public void act()
    {
        timer--;
        if(timer <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
