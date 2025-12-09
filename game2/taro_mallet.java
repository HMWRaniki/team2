import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class taro_mallet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class taro_mallet extends Actor
{
    /**
     * Act - do whatever the taro_mallet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if( Greenfoot.isKeyDown( "d" ) ){
        setRotation(0);
        move(10);
        }
        if( Greenfoot.isKeyDown( "a" ) ){
        setRotation(0);
        move(-10);
        }
        if( Greenfoot.isKeyDown( "w" ) ){
        setRotation(270);
        move(10);
        }
        if( Greenfoot.isKeyDown( "s" ) ){
        setRotation(270);
        move(-10);
        }
    }    
    public taro_mallet()
    {
       getImage().scale( 75, 75 );
    }
}
