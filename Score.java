import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Score extends Actor
{
    int score = 0;
    public Score()
    {
        setImage(new GreenfootImage("Score: ", 50, Color.GREEN, null));
    }
    
    public void act() 
    {
        setImage(new GreenfootImage("Score: " + score, 50, Color.GREEN, null));
    }    
    
    public void addScore(int score_to_add)
    {
        score += score_to_add;
    }
    
    public int getScore()
    {
        return score;
    }
}
