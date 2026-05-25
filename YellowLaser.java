import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YellowLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YellowLaser extends Actor
{
    /**
     * Act - do whatever the YellowLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public YellowLaser()
    {
        GreenfootImage yellow = new GreenfootImage("yellowLaser.png");
        yellow.scale(100,100);
        setImage(yellow);
    }
    public void act()
    {
        // Add your action code here.
    }
}
