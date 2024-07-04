import java.util.*;
import static java.lang.Math.*;

public class Solution {
    static Scanner scan;
    static final String CENTER = "CENTER";
    static final String HIT = "HIT";
    static final  String MISS = "MISS";
    static final int MAX = 1_000_000_000;
    static int ansx = Integer.MIN_VALUE, ansy = Integer.MIN_VALUE;
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int t = scan.nextInt(), A = scan.nextInt(), B = scan.nextInt();
        while (t-->0) {
            int x = Integer.MIN_VALUE,y = Integer.MIN_VALUE;
            ansx = Integer.MIN_VALUE;
            ansy = Integer.MIN_VALUE;
            for(int i=0;i<100;++i) {
                int X = (int)(random()*2_000_000_001) - 1_000_000_000;
                int Y = (int)(random()*2_000_000_001) - 1_000_000_000;
                String s = query(X,Y);
                if(s.equals(CENTER) || s.equals(HIT)) {
                    x = X;
                    y = Y;
                    break;
                }
            }

            if(x==Integer.MIN_VALUE || y==Integer.MIN_VALUE) {
                System.exit(1);
            }

            if(ansx!=Integer.MIN_VALUE) {
                continue;
            }
            int lx = findLeast(x,y,false);
            if(ansx!=Integer.MIN_VALUE) {
                continue;
            }
            int rx = findLeast(x,y,false);
            if(ansx!=Integer.MIN_VALUE) {
                continue;
            }
            int ly = findLeast(x,y,true);
            if(ansx!=Integer.MIN_VALUE) {
                continue;
            }
            int ry = findLeast(x,y,true);
            if(ansx!=Integer.MIN_VALUE) {
                continue;
            }

            int possx = (lx+rx)/2;
            int possy = (ly+ry)/2;

            for(int i=possx-1;i<=possx+1;i++) {
                for(int j=possy-1;j<=possy+1;j++) {
                    String s = query(i,j);
                    if(s.equals(CENTER)) {
                        ansx = i;
                        ansy = j;
                        break;
                    }
                }
                if(ansx!=Integer.MIN_VALUE) {
                    break;
                }
            }

            if(ansx==Integer.MIN_VALUE) {
                System.exit(1);
            }
        }
    }
    static int findLeast(int x, int y, boolean first_fixed) {
        int low = -1_000_000_000, high = (first_fixed ? y : x), ans = (first_fixed ? y : x), mid;
        while (low<=high) {
            mid = (low+high)>>1;
            int px = first_fixed ? x : mid;
            int py = first_fixed ? mid : y;
            if(query(px,py).equals(HIT)) {
                ans = mid;
                high = --mid;
            }
            else {
                low = ++mid;
            }
            if(ansx!=Integer.MIN_VALUE) {
                return px;
            }
        }
        return ans;
    }

    static int findGreatest(int x, int y, boolean first_fixed) {
        int low = (first_fixed ? y : x), high = 1_000_000_000, ans = (first_fixed ? y : x), mid;
        while (low<=high) {
            mid = (low+high)>>1;
            int px = first_fixed ? x : mid;
            int py = first_fixed ? mid : y;
            if(query(px,py).equals(HIT)) {
                ans = mid;
                low = ++mid;
            }
            else {
                high = --mid;
            }
            if(ansx!=Integer.MIN_VALUE) {
                return px;
            }
        }
        return ans;
    }

    static String query(int x,int y) {
        if(x<-MAX || x>MAX || y<-MAX || y>MAX) {
            return MISS;
        }
        System.out.println(x+" "+y);
        System.out.flush();
        String s = scan.next();
        if(s.equals(CENTER)) {
            ansx = x;
            ansy = y;
        }
        return s;
    }
}