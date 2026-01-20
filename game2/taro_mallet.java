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
    private GreenfootImage img_bkup = null;
    private int width=75;
    private int height= 75;
    
    public taro_mallet(){
        img_bkup = new GreenfootImage( getImage() );
        getImage().scale( width,height );
    }
    
    public void act() 
    {
        // Add your action code here.
        movemallet();
        getkinoko();
        getdokukinoko();
        getWorld().showText( "Taro's point = " + pack.taro_point, 450, 75 );
    }    
    
    private void movemallet() {
        if (Greenfoot.isKeyDown("d")) setLocation(getX() + 15, getY());
        if (Greenfoot.isKeyDown("a")) setLocation(getX() - 15, getY());
        if (Greenfoot.isKeyDown("w")) setLocation(getX(), getY() - 15);
        if (Greenfoot.isKeyDown("s")) setLocation(getX(), getY() + 15);
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
