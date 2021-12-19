import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Item extends Actor
{
    private int itemType = 1;
    
    public Item(int itemType)
    {
        this.itemType = itemType;
        getImage().scale(getImage().getWidth()/5,getImage().getHeight()/5);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public int itemFunction()
    {
        return itemType;
    }
}
