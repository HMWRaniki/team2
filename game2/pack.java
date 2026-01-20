import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class pack extends Actor
{
    private double dx = 0;  // x方向速度
    private double dy = 0;  // y方向速度
    private double friction = 0.99; // 摩擦（0.95〜0.995くらいで調整）

    public static int hanako_point = 0;
    public static int taro_point = 0;

    public pack()
    {
        getImage().scale(125, 125);
    }

    public void act()
    {
        bounceMallet();
        bounceMallet2();

        movePack();

        // 枠で反射させる
        bounceWithBounds();

        hanako_getPoint();
        taro_getPoint();
        win();
    }

    private void movePack()
    {
        setLocation(getX() + (int)Math.round(dx), getY() + (int)Math.round(dy));

        // 摩擦で減速
        dx *= friction;
        dy *= friction;

        // 非常に小さくなったら停止
        if (Math.abs(dx) < 0.1) dx = 0;
        if (Math.abs(dy) < 0.1) dy = 0;
    }

    private void bounceWithBounds()
    {
        World w = getWorld();
        if (w == null) return;

        int rX = getImage().getWidth() / 2;
        int rY = getImage().getHeight() / 2;

        // 枠線そのものの座標（線の位置）
        int LINE_LEFT   = 100;
        int LINE_RIGHT  = 1379;
        int LINE_TOP    = 111;
        int LINE_BOTTOM = 874;

        // パック中心が行ける限界（枠線から半径分内側）
        int LEFT   = LINE_LEFT   + rX;
        int RIGHT  = LINE_RIGHT  - rX;
        int TOP    = LINE_TOP    + rY;
        int BOTTOM = LINE_BOTTOM - rY;

        int x = getX();
        int y = getY();

        // 左右反射
        if (x < LEFT) {
            x = LEFT;
            dx = -dx;
        } else if (x > RIGHT) {
            x = RIGHT;
            dx = -dx;
        }

        // 上下反射
        if (y < TOP) {
            y = TOP;
            dy = -dy;
        } else if (y > BOTTOM) {
            y = BOTTOM;
            dy = -dy;
        }

        setLocation(x, y);
    }

    public void setdx(double dx){ this.dx = dx; }

    public void setdy(double dy){ this.dy = dy; }

    public void bounceX(){ dx = -dx; } // （必要なら残す）
    public void bounceY(){ dy = -dy; } // （必要なら残す）

    private void bounceMallet()
    {
        hanako_mallet m = (hanako_mallet)getOneIntersectingObject(hanako_mallet.class);
        if (m == null) return;

        int pushX = getX() - m.getX();
        int pushY = getY() - m.getY();

        double length = Math.sqrt(pushX * pushX + pushY * pushY);
        if (length == 0) return;

        double nx = pushX / length;
        double ny = pushY / length;

        double power = 8.0;  // 強さ調整
        dx = nx * power;
        dy = ny * power;

        // めり込み防止（軽く離す）
        int PUSH_OUT = 3; // 小さくしたいなら 2〜6
        int sepX = (int)(nx * PUSH_OUT);
        int sepY = (int)(ny * PUSH_OUT);
        setLocation(getX() + sepX, getY() + sepY);
    }

    private void bounceMallet2()
    {
        taro_mallet m = (taro_mallet)getOneIntersectingObject(taro_mallet.class);
        if (m == null) return;

        int pushX = getX() - m.getX();
        int pushY = getY() - m.getY();

        double length = Math.sqrt(pushX * pushX + pushY * pushY);
        if (length == 0) return;

        double nx = pushX / length;
        double ny = pushY / length;

        double power = 8.0;  // 強さ調整
        dx = nx * power;
        dy = ny * power;

        int PUSH_OUT = 3; // 小さくしたいなら 2〜6
        int sepX = (int)(nx * PUSH_OUT);
        int sepY = (int)(ny * PUSH_OUT);
        setLocation(getX() + sepX, getY() + sepY);

    }

    public void hanako_getPoint() {

        World w = getWorld();
        if (w == null) return;

        int r = getImage().getWidth() / 2;

        int GOAL_LINE_X = 102;  // 例：90pxより左に“中心”が入ったら得点

        if (getX() <= GOAL_LINE_X + r) {
            hanako_point++;
            resetCenter();
        }
    }

    public void taro_getPoint() {
        World w = getWorld();
        if (w == null) return;

        int r = getImage().getWidth() / 2;

        int GOAL_LINE_X = 1377; // 例：1410pxより右に“中心”が入ったら得点

        if (getX() >= GOAL_LINE_X - r) {
            taro_point++;
            resetCenter();
        }
    }

    private void resetCenter()
    {
        setLocation(750, 475); // World中心（MyWorldと合わせる）
        dx = 0;
        dy = 0;
    }

    public void win()
    {
        if (taro_point >= 5) {
            getWorld().showText("Taro Winner!", 750, 100);
            taro_point = 0;
            hanako_point = 0;
            Greenfoot.stop();
        }
        if (hanako_point >= 5) { // ★元コードは1になってたので5に統一
            getWorld().showText("Hanako Winner!", 750, 100);
            taro_point = 0;
            hanako_point = 0;
            Greenfoot.stop();
        }
    }
}
