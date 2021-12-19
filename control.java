import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class control extends World
{

    /**
     * Constructor for objects of class control.
     * 
     */
    public control()
    {    
        super(1150, 650, 1, false); 
        PreparaMundo();
        }
        
    private void PreparaMundo()
 {
 arrow a=new arrow();
 addObject(a,1000,50);
}
        
     
 
}

