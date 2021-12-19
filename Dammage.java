import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dammage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dammage extends Item
{
    private int dammageBoost = 5;
    
    public Dammage(int itemType)
    {
        super(itemType);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public int getDammage()
    {
        return dammageBoost;
    }
}