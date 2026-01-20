import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int timer = 0;
    private static final int TEN_SECONDS = 60;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 950, 1);
        
        addObject( new goal1(), 67, 493 );
        addObject( new goal2(), 1413, 493 );
        addObject( new waku(), 740, 490 );
        addObject( new taro_mallet(), 250, 475 );
        addObject( new hanako_mallet(), 1250, 475 );
        addObject( new pack(), 740, 485);
        
        
    }
    
    public void act(){
        spawnRandomActorTimer();
    }
    
    private void spawnRandomActorTimer(){
        timer++;
        
        if(timer >= TEN_SECONDS){
            spawnRandomActor();
            timer = 0;
        }
    }
    
    private void spawnRandomActor() {
        int choice = Greenfoot.getRandomNumber(3);
        Actor selectedActor = null;
        
        if(choice == 0){
            selectedActor = new kinoko();
        }else if(choice == 1){
            selectedActor = new dokukinoko();
        }else if(choice == 2){
        }
        
        if(selectedActor != null){
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            selectedActor.getImage().scale(75, 75);
        
            addObject(selectedActor, x, y);
        }
    }
}
