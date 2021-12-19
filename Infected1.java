import greenfoot.*;  

public class Infected1 extends Enemy
{
    public Infected1(int type, int speed)
    {
        super(type, speed);
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
            Greenfoot.playSound("ZombieHitted.mp3");
        }
    }
    
}
