import greenfoot.*;

public class Level1 extends GameWorld {
    int yellowLaserTimer = 0;
    int redLaserTimer = 0;
    private int timeLeft = 180;
    private int frameCounter = 0;
    private SimpleTimer countDown = new SimpleTimer();
    
    public Level1() {
        super(800, 600, 1);
        
        Thief thief = new Thief();
        addObject(thief, 70, 200);
        showText("Lives: " + thief.getLives(), 50, 15);

        Diamond diamond1 = new Diamond();
        
        addObject(diamond1, 737, 317);
        
        YellowLaser yL = new YellowLaser();
        addObject(yL, 230,130);
        yL.setRotation(90);
        
        //creating blue lasers
        BlueLaser blue1 = new BlueLaser();
        addObject(blue1,395,180);
        blue1.setRotation(90);
        BlueLaser blue2 = new BlueLaser();
        addObject(blue2, 391, 480);
        blue2.setRotation(270);
        BlueLaser blue3 = new BlueLaser();
        blue3.getImage().scale(150,59);
        blue3.setRotation(90);
        addObject(blue3, 485, 150);
        BlueLaser blue4 = new BlueLaser();
        blue4.getImage().scale(280,59);
        blue4.setRotation(270);
        addObject(blue4, 480, 460);
        
        //creating red lasers
        RedLaser rd = new RedLaser(20,360);
        addObject(rd, 613, 330);
        
        //create exit
        Exit exit = new Exit();
        addObject(exit, 710,65);
        
        //create invisible wall
        Wall wall = new Wall();
        wall.getImage().scale(656,23);
        addObject(wall, 328, 62);
        
        GameWorld.music.playLoop();
        startTimer();
    }
 
    public void act()
    {
        yellowLaserTimer++;
        
        if(yellowLaserTimer >= 100)
        {
            shootLaser();
            yellowLaserTimer = 0;
        }
        
        frameCounter++;
        if(frameCounter >= 60)
        {
            GameWorld.secondsElapsed++;
            frameCounter = 0;
        }
        Thief thief = (Thief) getObjects(Thief.class).get(0);
        showText("Lives: " + thief.getLives(), 50, 15);
        
        mouseLocation();
        
        redLaserTimer++;
        // laser disappear & reappear every 8 seconds
        if(redLaserTimer >= 480)
        {
            createRedLaser();
            
            redLaserTimer = 0;
        }
        
        updateCountDown();
    }
    
    public void shootLaser()
    {
        YellowLaser laser = new YellowLaser();
        addObject(laser, 230, 130);
        laser.setRotation(90);
    }
    
    public void createRedLaser()
    {
        RedLaser red  = new RedLaser(20, 360);
        addObject(red, 613,330);
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
        Greenfoot.setWorld(new Level2());
    }
}
