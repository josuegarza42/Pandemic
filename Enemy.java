import greenfoot.*;  

public class Enemy extends Actor
{
    private boolean removed = false;
    private boolean direction = true; //true->left && false->right || Boss--> true->up && false->down
    private int life = 100;
    private int enemyType;
    private int speed;
    
    public void act() 
    {
        // Add your action code here.
    }

    public Enemy(int enemyType, int speed)
    {
        this.enemyType = enemyType;
        this.speed = speed;
    }
    
    public Enemy(int enemyType, int speed, int life)
    {
        this.enemyType = enemyType;
        this.speed = speed;
        this.life = life;
    }

    public void receiveDamage(int lifeToReduce)
    {
        life -= lifeToReduce;
        checkLife();
    }

    public void checkLife()
    {
        if(life <= 0)
        {
            MyWorld myWorld = (MyWorld)getWorld();
            Score score = myWorld.getScore();
            myWorld.addEnemiesKilled();
            score.addScore(enemyType * 10);
            getWorld().removeObject(this);
            playDeathSound();
                if(enemyType==3){
                    Greenfoot.setWorld(new GameWin());
            Greenfoot.stop();
                }
        }
        
    }

    public void moveEnemyLeft()
    {
        setLocation(getX() - speed, getY());
        checkDirection();
    }

    public void moveEnemyRight()
    {
        setLocation(getX() + speed, getY());
        checkDirection();
    }

    public void checkDirection()
    {
        if((getX() <= 0)) direction = false;
        else if(getX() >= 1200)  direction = true;
    }
    
    public void playDeathSound()
    {
        if(enemyType == 1) Greenfoot.playSound("ZombieDeath.mp3");
        else if(enemyType == 2) Greenfoot.playSound("Infected2Hitted.mp3");
    }

    public void changeDirection()
    {
        if(direction == false) direction = true;
        else direction = false;
    }
    
    public void enemyShoots()
    {
        if(Greenfoot.getRandomNumber(1000) < (enemyType * 2)) 
        {
            boolean playerDirection = getPlayerDirection();
            getWorld().addObject(new EnemyBullet(playerDirection, enemyType), getX(), getY());
            //Greenfoot.playSound("shot.mp3");
        }
    }
    
    public int getEnemyType()
    {
        return enemyType;
    }
    
    public boolean getPlayerDirection()
    {
        MyWorld myWorld = (MyWorld)getWorld();
        int aux = 0;
        aux = myWorld.getPlayerX();
        if(aux < getX()) return true;
        else return false;
    }
    
    public boolean getDirection()
    {
        return direction;
    }
    
    public int getspeed()
    {
        return speed;
    }
    
    public int getDammage()
    {
        return (enemyType * 10);
    }
}

