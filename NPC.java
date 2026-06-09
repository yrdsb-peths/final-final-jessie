import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class NPC extends Actor
{
    public NPC()
    {
        GreenfootImage npc = new GreenfootImage("oldMan.png");
        npc.scale(120,140);
        setImage(npc);
    }
    
    public void act()
    {
        if(isTouching(Thief.class))
        {
            GameWorld world = (GameWorld)getWorld();
            world.showHint();
            getWorld().removeObject(this);
        }
    }
    
}
