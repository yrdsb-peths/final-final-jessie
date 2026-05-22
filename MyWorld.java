import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(800, 600, 1);
        
        Thief thief = new Thief();
        addObject(thief, 70, 200);
    }
}
