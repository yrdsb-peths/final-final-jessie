import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Level3 extends GameWorld
{
    int yellowLaserTimer = 0;
    int redLaserTimer = 0;
    private int timeLeft = 120;
    
    private SimpleTimer countDown = new SimpleTimer();
    
    public Level3()
    {
        super(800, 600, 1);
        
        Thief thief = new Thief();
        addObject(thief, 70, 200);
        
        //create red lasers
        RedLaser red1 = new RedLaser(20, 200);
        addObject(red1, 255,504);
        RedLaser red2 = new RedLaser(20, 200);
        addObject(red2, 440,504);
        
        //create yellow laser
        YellowLaser y1 = new YellowLaser();
        addObject(y1, 240, 142);
        y1.setRotation(90);
        YellowLaser y2 = new YellowLaser();
        addObject(y2, 444, 142);
        y2.setRotation(90);
        
        //create real and fake switch
        Switch realsw = new Switch();
        addObject(realsw, 300, 515);
        FakeSwitch fakeSw = new FakeSwitch();
        addObject(fakeSw, 390, 515);
        
        //create diamond
        Diamond diamond = new Diamond();
        addObject(diamond, 635, 282);
        
        //npc
        NPC oldMan = new NPC();
        addObject(oldMan, 70, 500);
        //cage
        Cage cage = new Cage();
        addObject(cage, 635, 310);
        
        //exit
        Exit exit = new Exit();
        addObject(exit, 338, 66);
        
        //camera
        Camera c = new Camera();
        addObject(c, 700, 80);
        CameraVision v = new CameraVision();
        addObject(v, 700, 160);
    }
    
    public void act()
    {
        mouseLocation();
        yellowLaserTimer++;
        
        if(yellowLaserTimer >= 130)
        {
            shootLaser();
            yellowLaserTimer = 0;
        }
        
        Thief thief = (Thief) getObjects(Thief.class).get(0);
        showText("Lives: " + thief.getLives(), 50, 15);
        
        redLaserTimer++;
        if(redLaserTimer >= 350)
        {
            createRedLaser();
            createVision();
            redLaserTimer = 0;
            
        }
        
        updateCountDown();
        
    }
    
    public void createVision()
    {
        CameraVision v1 = new CameraVision();
        addObject(v1, 700, 160);
    }
        public void shootLaser()
    {
        YellowLaser laser = new YellowLaser();
        addObject(laser, 240, 142);
        laser.setRotation(90);
        
        YellowLaser laser2 = new YellowLaser();
        addObject(laser2, 444, 142);
        laser2.setRotation(90);
    }
    
    public void createRedLaser()
    {
        RedLaser r1 = new RedLaser(20, 200);
        addObject(r1, 255,504);
        
        RedLaser r2 = new RedLaser(20, 200);
        addObject(r2, 440, 504);
        
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
    public void nextLevel()
    {
        Greenfoot.setWorld(new EndScreen());
    }
}
