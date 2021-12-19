import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnemyBullet extends Actor
{
    private boolean direction; // true->left && false->right
    private int dammage;
    private int enemyTypeShooted;
    
    public EnemyBullet(boolean direction, int enemyType)
    {
        getImage().scale(getImage().getWidth()/3,getImage().getHeight()/3);
        this.direction = direction;
        enemyTypeShooted = enemyType;
        dammage = (enemyType * 10);
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
    
    public int getBulletDammage()
    {
        return dammage;
    }
}