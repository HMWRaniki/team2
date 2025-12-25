import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hanako_mallet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hanako_mallet extends Actor
{
    /**
     * Act - do whatever the hanako_mallet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        movemallet();
    }
    public hanako_mallet()
    {
       getImage().scale( 75, 75 );
    }
    private void movemallet() {
        if (Greenfoot.isKeyDown("right")) setLocation(getX() + 15, getY());
        if (Greenfoot.isKeyDown("left")) setLocation(getX() - 15, getY());
        if (Greenfoot.isKeyDown("up")) setLocation(getX(), getY() - 15);
        if (Greenfoot.isKeyDown("down")) setLocation(getX(), getY() + 15);
    }
}
