import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueLaser extends Laser
{
    /**
     * Act - do whatever the BlueLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BlueLaser()
    {
        GreenfootImage blue = new GreenfootImage("blueLaser.png");
        blue.scale(211, 59);
        //423/4 = 105.75. 119/4 = 29.75
        setImage(blue);
        
    }
    public void act()
    {
        // Add your action code here.
    }
}
