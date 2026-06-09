import greenfoot.*;

public class CameraVision extends Actor
{
    private int timer = 0;
    public CameraVision()
    {
        GreenfootImage v = new GreenfootImage("vision.png");
        v.scale(250,250);
        setImage(v);
    }
    
    public void act()
    {
        timer++;
        
        if(timer >= 240)
        {
            getWorld().removeObject(this);
        }
    }
    }

   