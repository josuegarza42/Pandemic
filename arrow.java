import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arrow extends Actor
{
   
     public arrow(){
         getImage().scale(getImage().getWidth(),getImage().getHeight());
        }
     public void act() 
    {
        // Add your action code here.
        mover();
       
    }    
   
    public void mover()
    {
         if(Greenfoot.isKeyDown("space"))
         {
            Greenfoot.setWorld(new Menu());
         }
        }  
}
