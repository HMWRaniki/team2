import greenfoot.*;
 
/**
* 外枠の壁 - ボールが当たったら反射する
*/
public class waku extends Actor {
    private double dx = 0;  // x方向速度
    private double dy = 0;  // y方向速度
    public boolean isPixelColliding(Actor other) {
        if (other == null) {
            return false;
        }
        GreenfootImage img1 = getImage();
        GreenfootImage img2 = other.getImage();
        
        int thisX = getX() - img1.getWidth() / 2;
        int thisY = getY() - img1.getHeight() / 2;
        int otherX = other.getX() - img2.getWidth() / 2;
        int otherY = other.getY() - img2.getHeight() / 2;
        
        int left = Math.max(thisX, otherX);
        int right = Math.min(thisX + img1.getWidth(), otherX + img2.getWidth());
        int top = Math.max(thisY, otherY);
        int bottom = Math.min(thisY + img1.getHeight(), otherY + img2.getHeight());
        
        if (left >= right || top >= bottom) return false;
        
        for (int x = left; x < right; x++) {
            for (int y = top; y < bottom; y++) {
                int p1 = img1.getColorAt(x - thisX, y - thisY).getAlpha();
                int p2 = img2.getColorAt(x - otherX, y - otherY).getAlpha();
                if (p1 > 0 && p2 > 0) return true;
            }
        }
        return false;
    }
    
    public void act() {
        // packクラスのオブジェクト（ボール）を取得
        Actor pack = getOneIntersectingObject(pack.class);
        
        if (pack != null && isPixelColliding(pack)) {
            // ボールの位置と壁の中心からの相対位置を計算
            int packX = pack.getX();
            int packY = pack.getY();
            int centerX = getX();
            int centerY = getY();
            
            GreenfootImage img = getImage();
            int halfWidth = img.getWidth() / 2;
            int halfHeight = img.getHeight() / 2;
            
            // 壁の各辺の位置
            int leftEdge = centerX - halfWidth;
            int rightEdge = centerX + halfWidth;
            int topEdge = centerY - halfHeight;
            int bottomEdge = centerY + halfHeight;
            
            // ボールがどの辺に当たったかを判定
            int distLeft = Math.abs(packX - leftEdge);
            int distRight = Math.abs(packX - rightEdge);
            int distTop = Math.abs(packY - topEdge);
            int distBottom = Math.abs(packY - bottomEdge);
            
            // 最も近い辺を見つける
            int minDist = Math.min(Math.min(distLeft, distRight), Math.min(distTop, distBottom));
            
            // packクラスに反射メソッドがあると仮定して呼び出し
            if (minDist == distLeft || minDist == distRight) {
                // 左右の壁に当たった場合、X方向の速度を反転
                if (pack instanceof pack) {
                    ((pack)pack).bounceX();
                }
            } else if (minDist == distTop || minDist == distBottom) {
                // 上下の壁に当たった場合、Y方向の速度を反転
                if (pack instanceof pack) {
                    ((pack)pack).bounceY();
                }
            }
        }
        // 半透明に設定
        getImage().setTransparency(128);
    }
    private void bouncePack() {
        pack p = (pack)getOneIntersectingObject(pack.class);

        if (p != null) {
            // パックを押した方向（衝突方向）
            int pushX = getX() - p.getX();
            int pushY = getY() - p.getY();

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
            int sepX = (int)(nx * (getImage().getWidth()/2 + p.getImage().getWidth()/2));
            int sepY = (int)(ny * (getImage().getHeight()/2 + p.getImage().getHeight()/2));
            setLocation(p.getX() + sepX, p.getY() + sepY);
        }
    }
    public waku() {
        getImage().scale(1480, 1000);
    }
}