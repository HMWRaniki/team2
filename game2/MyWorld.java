
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootSound bgm = null;
    private int timer = 0;
    private int kogo = 0;
    private static final int TEN_SECONDS = 60;
        
            
            public MyWorld()
            {    
                // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
                super(1500, 950, 1);
                addObject( new goal1(), 84, 493 );
                addObject( new goal2(), 1395, 493 );
                addObject( new taro_mallet(), 230, 490 );
                addObject( new hanako_mallet(), 1250, 490 );
                addObject( new pack(), 740, 490);
                
                bgm = new GreenfootSound( "maou05.mp3" );
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
                    if(kogo == 0){
                        int x = Greenfoot.getRandomNumber(630) + 111;
                        int y = Greenfoot.getRandomNumber(764) + 111;
                        selectedActor.getImage().scale(75, 75);
        
                        addObject(selectedActor, x, y);
                        kogo = 1;
                    }else if(kogo == 1){
                        int x = Greenfoot.getRandomNumber(630) + 740;
                        int y = Greenfoot.getRandomNumber(764) + 111;
                        selectedActor.getImage().scale(75, 75);
        
                        addObject(selectedActor, x, y);
                        kogo = 0;
                    }
        }
    }
    
    public void started()
    {
        bgm.playLoop();
    }
    
    public void stopped()
    {
        bgm.stop();
    }
}


