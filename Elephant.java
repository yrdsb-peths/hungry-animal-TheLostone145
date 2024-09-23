import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Elephant extends Actor
{
    GreenfootSound elephantSound= new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idle=new GreenfootImage[8];
    
    
    public Elephant()
    {
        for(int i=0; i< idle.length; i++)
        {
            idle[1]=new GreenfootImage("images/elephant_idle/idle"+i+".png");
        }
        setImage(idle[0]);
    }
    int imageIndex=0;
    
    public void animateElephant()
    {
        setImage(idle[imageIndex]);
        imageIndex= (imageIndex+1)%idle.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left")){
            move(-2);
        }else if(Greenfoot.isKeyDown("right")){
           move(2); 
        }
        eat();
        animateElephant();
    }
    public void eat(){
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world= (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            elephantSound.play();
        }
        
    }
}
