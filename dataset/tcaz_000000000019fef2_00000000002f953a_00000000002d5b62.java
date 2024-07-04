import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().solve();
    }

    // try jump n, s
    // try jump e, w

    String tryJump(long x, long y, int jumps, long dstX, long dstY, char dirX, char dirY, String curr) {
        if (x == dstX && y == dstY) {
            return curr;
        }
        if (x > dstX || y > dstY) {
            return "IMPOSSIBLE";
        }
        if (x == dstX) {
            // try to jump Y
            y += Math.pow(2, jumps);
            jumps++;
            curr += dirY;
            return tryJump(x, y, jumps, dstX, dstY, dirX, dirY, curr);
        } else if (y == dstY) {
            // try to jump X
            x += Math.pow(2, jumps);
            jumps++;
            curr += dirX;
            return tryJump(x, y, jumps, dstX, dstY, dirX, dirY, curr);
        } else {
            // try to jump Y
            long tempY = y + (long)Math.pow(2, jumps);
            String tempCurr = curr + dirY;
            String res = tryJump(x, tempY, jumps + 1, dstX, dstY, dirX, dirY, tempCurr);
            if (!res.equals("IMPOSSIBLE")) {
                return res;
            }
            // try to jump X
            x += Math.pow(2, jumps);
            jumps++;
            curr += dirX;
            return tryJump(x, y, jumps, dstX, dstY, dirX, dirY, curr);
            // check x and y
        }
    }

    void solve() {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            long x = scan.nextLong();
            long y = scan.nextLong();
            int jumps = 0;
            char dirX = ' ', dirY = ' ';
            if (x != 0) {
                if (x > 0) {
                    dirX = 'E';
                } else {
                    x = Math.abs(x);
                    dirX = 'W';
                }
            }
            if (y != 0) {
                if (y > 0) {
                    dirY = 'N';
                } else {
                    y = Math.abs(y);
                    dirY = 'S';
                }
            }
            String res = tryJump(0, 0, jumps, x, y, dirX, dirY, "");
            printCase(i+1, res);
        }
    }



    void printCase(int num, String ans) {
        System.out.println("Case #" + num + ": " + ans);
    }

}
