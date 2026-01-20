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
       getImage().scale( 100, 100 );
    }
    private void movemallet() {
        int x = getX();
        int y = getY();
        int speed = 15;

        if (Greenfoot.isKeyDown("d")) x += speed;
        if (Greenfoot.isKeyDown("a"))  x -= speed;
        if (Greenfoot.isKeyDown("w"))    y -= speed;
        if (Greenfoot.isKeyDown("s"))  y += speed;

        int halfW = getImage().getWidth() / 2;
        int halfH = getImage().getHeight() / 2;
        
        int leftLimit   = 111;
        int rightLimit  = 740;
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
