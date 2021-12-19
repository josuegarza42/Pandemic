import greenfoot.*;  
import java.util.ArrayList;

public class MyWorld extends World
{
    private int scenarioNumber = 0;
    private int enemyListTop = 0;
    private int enemyListMax = 10;
    private int healthPackageMax = 0;
    private int dammageBoost = 0;
    private boolean bossSpawned = false;
    Score score = new Score();
    DammageCounter dammageImage = new DammageCounter();
    Player mainPlayer = new Player();
    
    public MyWorld() 
    {  
        super(1200, 800, 1, false); 
        
        initializeworld();
    }

    public void initializeworld()
    {
        addObject(mainPlayer, 20, 600);
        addObject(score, 120, 40);
        addObject(dammageImage, 120, 75);
    }

    public void act()
    {
        spawnEnemies();
        spawnItem();
        checkLevel();
    }
    
    public Score getScore()
    {
        return score;
    }
    
    public void spawnEnemies()
    {
        if(scenarioNumber == 0)
        {
            if((Greenfoot.getRandomNumber(1000) < 20) && (enemyListTop < 5))
            {
                Enemy p = new Infected1(1, 2);
                enemyListTop++;
                addObject(p, 1220, Greenfoot.getRandomNumber(500) + 300);
            }
        }
        else if(scenarioNumber == 1)
        {
            if((Greenfoot.getRandomNumber(1000) < 20) && (enemyListTop < 7))
            {
                int aux = Greenfoot.getRandomNumber(10);
                Enemy p = null;
                if(aux < 4) p = new Infected2(2, 5, 120);
                else p = new Infected1(1, 5);
                enemyListTop++;
                addObject(p, 1220, Greenfoot.getRandomNumber(500) + 300);
            }
        }
        else if(scenarioNumber == 2)
        {
            if((Greenfoot.getRandomNumber(1000) < 20) && (enemyListTop < 9))
            {
                int aux = Greenfoot.getRandomNumber(10);
                Enemy p = null;
                if(aux < 5) p = new Infected2(2, 5, 130);
                else p = new Infected1(1, 6);
                enemyListTop++;
                addObject(p, 1220, Greenfoot.getRandomNumber(500) + 300);
            }
        }
        else if(scenarioNumber == 3)
        {
            if((Greenfoot.getRandomNumber(1000) < 20) && (enemyListTop < 11))
            {
                int aux = Greenfoot.getRandomNumber(10);
                Enemy p = null;
                if(aux < 7) p = new Infected2(2, 6, 150);
                else p = new Infected1(1, 7);
                enemyListTop++;
                addObject(p, 1220, Greenfoot.getRandomNumber(500) + 300);
            }
        }
        else if(scenarioNumber == 4)
        {
            if(bossSpawned == false) 
            {
                addObject(new Boss(3, 1, 600), 1100, 600);
                bossSpawned = true;
            }
        } 
    }

    public void spawnItem()
    {
        if((Greenfoot.getRandomNumber(1000) < 20) && (mainPlayer.getLife() < 100) && (healthPackageMax < 2))
        {
            Item item = new HealthPack(1);
            addObject(item,Greenfoot.getRandomNumber(1200), Greenfoot.getRandomNumber(500) + 300);
            healthPackageMax++;
        }
        if((Greenfoot.getRandomNumber(1000) < 20) && (dammageBoost < 1))
        {
            Item item = new Dammage(2);
            addObject(item,Greenfoot.getRandomNumber(1200), Greenfoot.getRandomNumber(500) + 300);
            dammageBoost++;
        }
        if((Greenfoot.getRandomNumber(1000) < 10) && (mainPlayer.getLife() < 150) && (scenarioNumber == 4))
        {
            Item health = new HealthPack(1);
            Item dammage = new Dammage(2);
            addObject(health, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500) + 300);
            addObject(dammage, Greenfoot.getRandomNumber(1000) , Greenfoot.getRandomNumber(500) + 300);
            dammageBoost++;
            healthPackageMax++;
        }
    }
    
    public void checkLevel()
    {
        if((mainPlayer.getEnemiesKilled() == 5) && (scenarioNumber == 0)) resetLevel();
        else if((mainPlayer.getEnemiesKilled() == 12) && (scenarioNumber == 1)) resetLevel();
        else if((mainPlayer.getEnemiesKilled() == 21) && (scenarioNumber == 2)) resetLevel();
        else if((mainPlayer.getEnemiesKilled() == 32) && (scenarioNumber == 3)) resetLevel();
    }
    
    public void resetLevel()
    {
        dammageBoost = 0;
        healthPackageMax = 0;
        scenarioNumber++;
        enemyListTop = 0;
        changeImageBackground();
    }
    
    public void changeImageBackground()
    {
        GreenfootImage bg = null;
        if(scenarioNumber == 0) bg = new GreenfootImage("bg 4_00632.png");
        else if(scenarioNumber == 1) bg = new GreenfootImage("escenario1.png");
        else if(scenarioNumber == 2) bg = new GreenfootImage("escenario2.png");
        else if(scenarioNumber == 3) bg = new GreenfootImage("escenario3.png");
        else bg = new GreenfootImage("bg 10_00362.png");// puede que aqui esta el erro
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
    
    public int getDammage()
    {
        return mainPlayer.getDammage();
    }
    
    public void addEnemiesKilled()
    {
        mainPlayer.addEnemiesKilled();
    }
    
    public int getPlayerX()
    {
        return mainPlayer.getPX();
    }
}
