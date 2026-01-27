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
    private GreenfootImage img_bkup = null;
    private int width=75;
    private int height= 75;
    public void act() 
    {
        // Add your action code here.
        movemallet();
        getkinoko();
        getdokukinoko();
        getWorld().showText( "Hanako's point = " + pack.hanako_point, 1000, 75 );
    }
    public hanako_mallet()
    {
       getImage().scale( width, height );
       img_bkup = new GreenfootImage( getImage() );
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
        
    public void getkinoko() {
        kinoko Kino = (kinoko)getOneIntersectingObject(kinoko.class);
        if(Kino != null){
            GreenfootImage img = new GreenfootImage(img_bkup);
            
            width = width + 50;
            height = height + 50;
            
            img.scale(width,height);
            setImage(img);
            getWorld().removeObject( Kino );
        }
    }
        
    public void getdokukinoko() {
        dokukinoko DKino = (dokukinoko)getOneIntersectingObject(dokukinoko.class);
        if(DKino != null){
            GreenfootImage img = new GreenfootImage(img_bkup);
            
            width = width - 50;
            height = height - 50;
            if(width < 25)
            {
                width = 25;
            }
            if(height < 25)
            {
                height = 25;
            }
            
            img.scale(width,height);
            setImage(img);
            getWorld().removeObject( DKino );
        }
    }
}
