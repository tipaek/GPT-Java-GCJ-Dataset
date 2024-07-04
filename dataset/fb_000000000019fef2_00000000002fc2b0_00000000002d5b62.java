
import java.util.*;


public class Solution {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for(int i = 0; i < T; i++) {
            solve(i+1, s);
        }

    }

    private static void solve(int cid, Scanner in) {

        int X = in.nextInt();
        int Y = in.nextInt();

        String path = "";

        String up = "N";
        String dn = "S";
        String rt = "E";
        String lt = "W";

        int x = X;
        int y = Y;
        while(x != 0 || y != 0) {
            if(x < 0) {
                x = -x;
                String tmp = up;
                up = dn;
                dn = tmp;
            }
            if(y < 0) {
                y = -y;
                String tmp = lt;
                lt = rt;
                rt = tmp;
            }
            if(x % 2 == y % 2) {
                System.out.println("Case #" + cid + ": IMPOSSIBLE");
                return;
            }
            if(x == 1 && y == 0) {
                path += rt;
                break;
            } else if(x == 0 && y == 1) {
                path += up;
                break;
            }
            if(x % 2 != 0) {
                if((y/2) % 2 == ((x+1)/2) % 2) {
                    x -= 1;
                    path += rt;
                } else {
                    x += 1;
                    path += lt;
                }
            } else {
                if((x/2) % 2 == ((y+1)/2) % 2) {
                    y -= 1;
                    path += up;
                } else {
                    y += 1;
                    path += dn;
                }
            }
            x /= 2;
            y /= 2;
        }

        System.out.println("Case #" + cid + ": " + path);
    }

}