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
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 950, 1);
        bgm = new GreenfootSound( "maou05.mp3" );
        
        addObject( new goal1(), 67, 493 );
        addObject( new goal2(), 1413, 493 );
        addObject( new waku(), 740, 490 );
        addObject( new taro_mallet(), 250, 475 );
        addObject( new hanako_mallet(), 1250, 475 );
        addObject( new pack(), 740, 485);
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
