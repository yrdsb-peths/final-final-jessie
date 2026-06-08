import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends GameWorld
{
    int yellowLaserTimer = 0;
    int redLaserTimer = 0;
    
    
    private int timeLeft = 240;
    
    private SimpleTimer countDown = new SimpleTimer();
    
    public Level2()
    {
        super(800,600,1);
        
        Thief thief = new Thief();
        addObject(thief, 70, 200);
        
        Diamond diamond = new Diamond();
        addObject(diamond, 373, 215);
        
        //build yellow laser
        YellowLaser yL = new YellowLaser();
        addObject(yL, 240,142);
        yL.setRotation(90);
        
        //build red lasers
        RedLaser red1 = new RedLaser(20,450);
        addObject(red1, 500, 350);
        RedLaser red2 = new RedLaser(20, 450);
        addObject(red2, 590, 350);
        RedLaser red3 = new RedLaser(20, 450);
        addObject(red3, 680, 350);
        
        //add exit
        Exit exit = new Exit();
        addObject(exit, 750, 65);
        
        //add cage
        Cage cage = new Cage();
        addObject(cage, 370, 250);
        
        //add switch
        Switch swi = new Switch();
        addObject(swi, 750, 500);
    }
    
    public void act()
    {
        mouseLocation();
        
        yellowLaserTimer++;
        if(yellowLaserTimer >= 100)
        {
            shootLaser();
            yellowLaserTimer = 0;
        }
        
        Thief thief = (Thief) getObjects(Thief.class).get(0);
        showText("Lives: " + thief.getLives(), 50, 15);
        
        redLaserTimer++;
        if(redLaserTimer >= 300)
        {
            createRedLaser();
            redLaserTimer = 0;
        }
        
        updateCountDown();
    
        
    }
    
       public void shootLaser()
    {
        YellowLaser laser = new YellowLaser();
        addObject(laser, 240, 142);
        laser.setRotation(90);
    }
    
    public void updateCountDown(){
        if(countDown.millisElapsed() >= 1000)
        {
            timeLeft--;
            countDown.mark();
            
            int min = timeLeft / 60;
            int sec = timeLeft % 60;
            
            showText(min + ":" + sec, 780, 590);
            
            if(timeLeft <= 0)
            {
                gameOver();
            }
        }
    }
    
    public void createRedLaser()
    {
        RedLaser r1 = new RedLaser(20, 450);
        addObject(r1, 500,350);
        
        RedLaser r2 = new RedLaser(20, 450);
        addObject(r2, 590, 350);
        
        RedLaser r3 = new RedLaser(20, 450);
        addObject(r3, 680, 350);
        
        
    }
}
