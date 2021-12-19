import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class select extends Actor
{
 private int op=0;
 public  select(){
    getImage().scale(getImage().getWidth()/3,getImage().getHeight()/3);
    }
   public void act() 
    {
        // Add your action code here.
        mover();
       
    }    
   
    public void mover()
    {
    int x=getX(),y=getY();
     if(Greenfoot.isKeyDown("S"))y++;
     if(Greenfoot.isKeyDown("w"))y--;
     if(y<490)
     {
      y=490;  
     }
     if(y>=620)
     {
      y=620;  
     }
     setLocation(x,y);
      if(Greenfoot.isKeyDown("enter")){
       if(y<500 && y >420)
       {
        Greenfoot.setWorld(new MyWorld());
        }else if(y<560 && y>520)
       {
        Greenfoot.stop();
        }else
        if(y<620 && y>580)
       {
       Greenfoot.setWorld(new control());
        }
        };
    }
}
