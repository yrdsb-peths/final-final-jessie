import greenfoot.*;

public class MyWorld extends World {
    int yellowLaserTimer = 0;
    public MyWorld() {
        super(800, 600, 1);
        
        Thief thief = new Thief();
        addObject(thief, 70, 200);
        showText("Lives: " + thief.getLives(), 50, 15);

        Diamond diamond1 = new Diamond();
        
        addObject(diamond1, 737, 317);
        
        YellowLaser yL = new YellowLaser();
        addObject(yL, 230,130);
        yL.setRotation(90);
        
    }
    
    public void act()
    {
        yellowLaserTimer++;
        
        if(yellowLaserTimer >= 120)
        {
            shootLaser();
            yellowLaserTimer = 0;
        }
    }
    public void gameOver()
    {
        showText("GAME OVER!", getWidth(), getHeight()/2);
        Greenfoot.stop();
    }
    
       public void shootLaser()
    {
        YellowLaser laser = new YellowLaser();
        addObject(laser, 230, 130);
        laser.setRotation(90);
    }
}
