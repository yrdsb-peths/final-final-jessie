import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(800, 600, 1);
        
        Thief thief = new Thief();
        addObject(thief, 70, 200);
        
        Diamond diamond1 = new Diamond();
        
        addObject(diamond1, 737, 317);
        
        YellowLaser yL = new YellowLaser();
        addObject(yL, 200,70);
    }
}
