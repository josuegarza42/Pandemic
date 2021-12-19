import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Menu extends World
{
private int opcion=0;// 0=star 1=beck 2=help
    public Menu()
    {    
      super(1150, 650, 1); 
    PreparaMundo();
  
}

  private void PreparaMundo()
 {
  //Greenfoot.playSound("duel-of-the-fates.mp3");
  addObject(new Star(),1000,500);
  addObject(new Back(),1000,560);
  addObject(new help(),1000,620);
  select s=new select();
   addObject(s,700,500);
}


}


