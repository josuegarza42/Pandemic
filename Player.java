import greenfoot.*; 

public class Player extends Actor
{
    private String player_name;
    private int steps = 4;
    private boolean canFire = true;
    private int life = 100;
    private boolean direction; //true->left && false->right
    private boolean stunned = false;
    private int dammage = 10;
    private int enemiesKilled = 0;
    private GreenfootImage runIzq = new GreenfootImage("Prota-Izq-Walk_00000.png");
    private GreenfootImage runDer = new GreenfootImage("Prota-Der-Walk_00000.png"); 
    private int frame =1;//decimos que la imagen va de lleno a derecha
    public Player()
    {
        getImage().scale(getImage().getWidth()/5,getImage().getHeight()/5);
        Greenfoot.playSound("duel-of-the-fates.mp3");
    }
    
    public void act() 
    {
        moveAround();
        fireGun();
        getHittedByEnemy();
    }
    public void animateR()
    {
        if(frame ==1)
        {
        setImage(runDer);
        frame =0;
        }
    }
    public void animateL()
    {
         if(frame ==0)
        {
        setImage(runIzq);
        frame =1;
        }
    }
    public void moveAround()
    {
        String shootButton = null;
        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("W")) && (getY() > 300))
        {
            setLocation(getX(), getY() - steps);
        }
        if((Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("S")) && (getY() < 780))
        {
            setLocation(getX(), getY() + steps);
        }
        if((Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("A")) && (getX() > 20))
        {
            direction = true;
            move(-steps);
            animateL();
        }
        if((Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("D")) && (getX() < 1180))
        {
            direction = false;
            move(steps);
            animateR();
        }
        if((Greenfoot.isKeyDown("e") || Greenfoot.isKeyDown("E"))) pickUpItem();
    }

    public void fireGun()
    {
        if(Greenfoot.isKeyDown("space") && canFire == true)
        {  
            getWorld().addObject(new Bullet(direction), getX(), getY());
            canFire = false;
            Greenfoot.playSound("shot.mp3");
        }
        else if(!Greenfoot.isKeyDown("space")) canFire = true;
    }
    
    public void pickUpItem()
    {
        Item itemPicked = getOneIntersectingObject(Item.class);
        if(itemPicked != null)
        {
            int itemUse = itemPicked.itemFunction();
            if(itemUse == 1) 
            {
                HealthPack item = getOneIntersectingObject(HealthPack.class);
                life += item.healthRecover();
                Greenfoot.playSound("HealthUp.mp3");
            }
            else if(itemUse == 2) 
            {
                Dammage item = getOneIntersectingObject(Dammage.class);
                dammage += item.getDammage();
                Greenfoot.playSound("PowerUp.mp3");
            }
            getWorld().removeObject(itemPicked);
        }
    }
    
    public void getHittedByEnemy()
    {
        EnemyBullet hit = getOneIntersectingObject(EnemyBullet.class);
        if(hit != null) 
        {
            life -= hit.getBulletDammage();
            getWorld().removeObject(hit);
        }
        checkLife();
    }
    
    public void checkLife()
    {
        if(life <= 0) 
        {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new GameOver());
            Greenfoot.stop();
        }
       
    }
    
    public int getLife()
    {
        return life;
    }
    
    public int getDammage()
    {
        return dammage;
    }
    
    public int getEnemiesKilled()
    {
        return enemiesKilled;
    }
    
    public void addEnemiesKilled()
    {
        enemiesKilled++;
    }
    
    public int getPX()
    {
        return getX();
    }
}