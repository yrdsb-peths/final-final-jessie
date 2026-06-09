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
    int speed = 3;
    private int oldX;
    private int oldY;
    SimpleTimer loseLifeTimer = new SimpleTimer();
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootImage[] upSprites = new GreenfootImage[3];
    GreenfootImage[] downSprites = new GreenfootImage[3];
    GreenfootImage[] leftSprites = new GreenfootImage[3];
    GreenfootImage[] rightSprites = new GreenfootImage[3];
    private int lives = 3;
    boolean hasTreasure = false;
    private boolean cageUnlock = false;
    //constructor
    
    public Thief()
    {
        //Up
        for(int i = 0; i < 3; i++) {
            upSprites[i] = new GreenfootImage("images/thief/up" + (i + 1) + ".png");
            upSprites[i].scale(72,96);
        }
        //Down
        for(int i = 0; i < 3; i++) {
            downSprites[i] = new GreenfootImage("images/thief/front" + (i + 1) + ".png");
            downSprites[i].scale(72,96);
        }
        //left
         for(int i = 0; i < 3; i++) {
            leftSprites[i] = new GreenfootImage("images/thief/left" + (i + 1) + ".png");
            leftSprites[i].scale(72,96);
        }
        //right
        for(int i = 0; i < 3; i++) {
            rightSprites[i] = new GreenfootImage("images/thief/right" + (i + 1) + ".png");
            rightSprites[i].scale(72,96);
        }
        
        setImage(downSprites[1]);
    }
    
    public void act()
    {
        // Add your action code here.
        movement();
        getTreasure();
        animateThief();
        checkLaser();
        checkExit();
        checkSwitch();
        checkFakeSwitch();
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
    public void checkFakeSwitch()
    {
        if(isTouching(FakeSwitch.class))
        {
            loseLife();
        }
    }
    public void checkVision()
    {
        if(isTouching(CameraVision.class))
        {
            loseLife();
        }
    }
    public void movement()
    {
        int oldX = getX();
        int oldY = getY();
        
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
        
        if(isTouching(Wall.class))
        {
            setLocation(oldX, oldY);
        }
    }
    
    public void moveUp()
    {
        setImage(upSprites[imageIndex]);
    }
    
    public void moveDown()
    {
        setImage(downSprites[imageIndex]);
    }
    
    public void moveLeft()
    {
        setImage(leftSprites[imageIndex]);
    }
    
     public void moveRight()
    {
        setImage(rightSprites[imageIndex]);
    }
    
    public void getTreasure()
    {
        if(isTouching(Diamond.class))
        {
            if(getWorld().getObjects(Cage.class).isEmpty() || cageUnlock)
            {
                removeTouching(Diamond.class);
                Greenfoot.playSound("collect.mp3");
                hasTreasure = true;
            }
            
        }
    }
    
    public void checkLaser()
    {
        Actor laser = getOneIntersectingObject(Laser.class);
        
        if(laser != null && loseLifeTimer.millisElapsed() > 500)
        {
            double x = Math.abs(getX() - laser.getX());
            int y = Math.abs(getY() - laser.getY());
            
            boolean touch = false;
            if(laser instanceof RedLaser)
            {
                touch = (x < 15);
            } else if(laser instanceof BlueLaser)
            {
                touch = (y < 113 && x < 20);
            } else if(laser instanceof YellowLaser)
            {
                touch = (y < 5);
            }
            
            if(touch) {
                loseLife();
                loseLifeTimer.mark();
            }
        }
    }
    
    public int getLives()
    {
        return lives;
    }
    public void loseLife()
    {
        
        Greenfoot.playSound("loseLife.mp3");
        lives--;
        setLocation(70, 200); //spawn        
        if(lives <= 0)
        {
            GameWorld world = (GameWorld) getWorld();
            world.gameOver();
        }
    }
    
    public void checkExit()
    {
        if(hasTreasure && isTouching(Exit.class))
        {
            GameWorld world = (GameWorld)getWorld();
            world.nextLevel();
        }
    }
    
    public void checkSwitch()
    {
        if(isTouching(Switch.class) && !cageUnlock)
        {
            Cage cage = (Cage)getWorld().getObjects(Cage.class).get(0);
            getWorld().removeObject(cage);
            cageUnlock = true;
            Greenfoot.playSound("unlock-cage.mp3");
        }
    }
}
