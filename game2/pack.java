import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pack extends Actor
{
    /**
     * Act - do whatever the pack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double dx = 0;  // x方向速度
    private double dy = 0;  // y方向速度
    private double friction = 0.97; // 摩擦による減速（0.90〜0.99で調整）
    
    public void act() 
    {
         bounceMallet();
         movePack();
    }
    public pack()
    {
       getImage().scale( 100, 100);
    }
    private void movePack() {
        setLocation(getX() + (int)dx, getY() + (int)dy);

        // 少しずつ減速して止まる
        dx *= friction;
        dy *= friction;

        // 非常に小さくなったら完全停止
        if (Math.abs(dx) < 0.1) dx = 0;
        if (Math.abs(dy) < 0.1) dy = 0;
    }
    private void bounceMallet() {
        hanako_mallet m = (hanako_mallet)getOneIntersectingObject(hanako_mallet.class);

        if (m != null) {
            // パックを押した方向（衝突方向）
            int pushX = getX() - m.getX();
            int pushY = getY() - m.getY();

            // 正規化で方向だけ取り出す
            double length = Math.sqrt(pushX * pushX + pushY * pushY);
            if (length == 0) return;

            double nx = pushX / length;  
            double ny = pushY / length;

            // パックに速度を与える（反射）
            double power = 8.0;  // 強さ（5〜12で調整）
            dx = nx * power;
            dy = ny * power;

            // めり込み防止（衝突地点に押し戻す）
            int sepX = (int)(nx * (getImage().getWidth()/2 + m.getImage().getWidth()/2));
            int sepY = (int)(ny * (getImage().getHeight()/2 + m.getImage().getHeight()/2));
            setLocation(m.getX() + sepX, m.getY() + sepY);
        }
    }
}
