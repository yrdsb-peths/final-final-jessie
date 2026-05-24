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
    GreenfootImage[] upSprites = new GreenfootImage[3];
    GreenfootImage[] downSprites = new GreenfootImage[3];
    GreenfootImage[] leftSprites = new GreenfootImage[3];
    GreenfootImage[] rightSprites = new GreenfootImage[3];
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
    
    int imageIndex = 0;
    
    public void animateThief()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        imageIndex++;
        if(imageIndex >= 3) {
            imageIndex = 0;
        }
    }
    
    public void moveUp()
    {
        for(int i = 0; i < 3; i++) {
            upSprites[i] = new GreenfootImage("images/theif/up" + (i + 1) + ".png");
            upSprites[i].scale(72,96);
            
        }
    }
}
