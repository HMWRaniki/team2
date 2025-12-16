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
        movemallet();
    }    
    public taro_mallet()
    {
       getImage().scale( 75, 75 );
    }
    private void movemallet() {
        if (Greenfoot.isKeyDown("d")) setLocation(getX() + 15, getY());
        if (Greenfoot.isKeyDown("a")) setLocation(getX() - 15, getY());
        if (Greenfoot.isKeyDown("w")) setLocation(getX(), getY() - 15);
        if (Greenfoot.isKeyDown("s")) setLocation(getX(), getY() + 15);
    }
}
