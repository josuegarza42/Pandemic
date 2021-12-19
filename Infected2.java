import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Infected2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Infected2 extends Enemy
{
    public Infected2(int type, int speed, int life)
    {
        super(type, speed, life);
        getImage().scale(getImage().getWidth()/5,getImage().getHeight()/5);
    }
    
    public void act() 
    {
        if(getDirection() == true) moveEnemyLeft();
        else moveEnemyRight();
        enemyShoots();
        hitBullet();
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
            Greenfoot.playSound("Infected2.mp3");
        }
    }   
}
