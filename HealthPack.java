import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthPack extends Item
{
    private int health = 10;
    
    public HealthPack(int itemType)
    {
        super(itemType);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public int healthRecover()
    {
        return health;
    }   
}
