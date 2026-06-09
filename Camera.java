import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Camera extends Actor
{
    private int speed = 1;
    
    public Camera()
    {
        GreenfootImage cam = new GreenfootImage("camera.png");
        cam.scale(300,300);
        cam.setTransparency(200);
        setImage(cam);
    }
    public void act()
    {
        rotate();
    }
    
    public void rotate()
    {
        turn(speed);
        int angle = getRotation();
        if(angle > 180)
        {
            angle-=360;
        }
        
        if(angle >= 90)
        {
            speed = -1;
        }
        if(angle <= -90)
        {
            speed = 1;
        }
    }
}
