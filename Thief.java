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
    
    boolean hasTreasure = false;
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
        movement();
        getTreasure();
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
    
    public void movement()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY() - speed);
            moveUp();
        } else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
            moveDown();
        } else if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
            moveLeft();
        } else if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
            moveRight();
        }
    }
    
    public void moveUp()
    {
        for(int i = 0; i < 3; i++) {
            upSprites[i] = new GreenfootImage("images/thief/up" + (i + 1) + ".png");
            upSprites[i].scale(72,96);
        }
        setImage(upSprites[imageIndex]);
    }
    
    public void moveDown()
    {
        for(int i = 0; i < 3; i++) {
            downSprites[i] = new GreenfootImage("images/thief/front" + (i + 1) + ".png");
            downSprites[i].scale(72,96);
        }
        setImage(downSprites[imageIndex]);
    }
    
    public void moveLeft()
    {
        for(int i = 0; i < 3; i++) {
            leftSprites[i] = new GreenfootImage("images/thief/left" + (i + 1) + ".png");
            leftSprites[i].scale(72,96);
        }
        setImage(leftSprites[imageIndex]);
    }
    
     public void moveRight()
    {
        for(int i = 0; i < 3; i++) {
            rightSprites[i] = new GreenfootImage("images/thief/right" + (i + 1) + ".png");
            rightSprites[i].scale(72,96);
        }
        setImage(rightSprites[imageIndex]);
    }
    
    public void getTreasure()
    {
        if(isTouching(Diamond.class))
        {
            removeTouching(Diamond.class);
            hasTreasure = true;
        }
    }
}
