import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Actor
{
    private boolean direction; // true->left && false->right
    
    public Bullet(boolean direction)
    {   getImage().scale(getImage().getWidth()/5,getImage().getHeight()/5);
        this.direction = direction;
    }

    public void act() 
    {
        projectileMove();
        removeFromWorld();
    }

    public void projectileMove()
    {
        if(direction == false)setLocation(getX() + 7, getY());
        else setLocation(getX() - 7, getY());
    }

    public void removeFromWorld()
    {   
        if((getX() >= 1200) || (getX() <= 0)) getWorld().removeObject(this);
    }
}