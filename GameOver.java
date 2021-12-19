import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    private GreenfootImage gameOver = new GreenfootImage("GAMEOVER1.jpeg");
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        Greenfoot.playSound("national-anthem-of-ussr.mp3");
    }
}
