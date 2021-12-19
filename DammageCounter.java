import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class DammageCounter extends Actor
{
    private int dammage;
    public DammageCounter()
    {
        setImage(new GreenfootImage("Dammage: ", 30, Color.RED, null));
    }
    
    public void act() 
    {
        getCounterDammage();
        setImage(new GreenfootImage("Dammage: " + dammage, 30, Color.RED, null));
    }
    
    public void getCounterDammage()
    {   
        MyWorld world = (MyWorld)getWorld();
        dammage = world.getDammage();
    }
}
