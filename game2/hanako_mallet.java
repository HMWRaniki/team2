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
        int x = getX();
        int y = getY();
        int speed = 15;

        if (Greenfoot.isKeyDown("right")) x += speed;
        if (Greenfoot.isKeyDown("left"))  x -= speed;
        if (Greenfoot.isKeyDown("up"))    y -= speed;
        if (Greenfoot.isKeyDown("down"))  y += speed;

        int halfW = getImage().getWidth() / 2;
        int halfH = getImage().getHeight() / 2;
        
        int leftLimit   = 740;
        int rightLimit  = 1368;
        int topLimit    = 111;
        int bottomLimit = 874;

        // はみ出し補正
        if (x < leftLimit + halfW)  x = leftLimit + halfW;
        if (x > rightLimit - halfW) x = rightLimit - halfW;
        if (y < topLimit + halfH)   y = topLimit + halfH;
        if (y > bottomLimit - halfH) y = bottomLimit - halfH;
        
        setLocation(x, y);
    }
}
