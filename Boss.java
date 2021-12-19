import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    public Boss(int type, int speed, int life)
    {
        super(type, speed, life);
        getImage().scale(getImage().getWidth()/5,getImage().getHeight()/5);
    }
    
    public void act() 
    {
        moveBoss();
        enemyShoots();
        hitBullet();
    }
    
    public void moveUp()
    {
        setLocation(getX(), getY() - getspeed());
    }
    
    public void moveDown()
    {
        setLocation(getX(), getY() + getspeed());
    }
    
    public void checkDirectionToMove()
    {
        if(getY() <= 300) changeDirection();
        else if(getY() >= 700) changeDirection(); 
    }
    
    public void moveBoss()
    {
        if(getDirection() == true) moveUp();
        else moveDown();
        checkDirectionToMove();
    }
    
    public void hitBullet()
    {
        Actor hit = getOneIntersectingObject(Bullet.class);
        if((hit != null))
        {
            World world = getWorld();
            MyWorld myWorld = (MyWorld)world;
            
            getWorld().removeObject(hit);
            
            receiveDamage(myWorld.getDammage());
            //Greenfoot.playSound("Infected2.mp3");
        }
    }
}
