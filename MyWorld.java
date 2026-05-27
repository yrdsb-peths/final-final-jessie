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
        
        if(yellowLaserTimer >= 100)
        {
            shootLaser();
            yellowLaserTimer = 0;
        }
        
        Thief thief = (Thief) getObjects(Thief.class).get(0);
        showText("Lives: " + thief.getLives(), 50, 15);
    }
    public void gameOver()
    {
        Thief thief = (Thief) getObjects(Thief.class).get(0);
        showText("Lives: " + thief.getLives(), 50, 15);
        showText("GAME OVER!", getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    
       public void shootLaser()
    {
        YellowLaser laser = new YellowLaser();
        addObject(laser, 230, 130);
        laser.setRotation(90);
    }
}
