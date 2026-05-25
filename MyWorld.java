import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(800, 600, 1);
        
        Thief thief = new Thief();
        addObject(thief, 70, 200);
        showText("Lives: " + thief.getLives(), 70, 70);

        Diamond diamond1 = new Diamond();
        
        addObject(diamond1, 737, 317);
        
        YellowLaser yL = new YellowLaser();
        addObject(yL, 230,130);
    }
    
    public void gameOver()
    {
        showText("GAME OVER!", getWidth(), getHeight()/2);
        Greenfoot.stop();
    }
}
