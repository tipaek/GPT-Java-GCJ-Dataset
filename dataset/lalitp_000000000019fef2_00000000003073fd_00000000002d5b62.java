import java.util.*;

public class Solution {

    static long X, Y;
    static boolean isReachFlag;
    public static void main(String[] args) {
        // write your code here
        long T, t;
        Scanner sc = new Scanner(System.in);
        String max, cur;
        int maxNum;

        StringBuffer sb = new StringBuffer();
        T = sc.nextLong();
        for(t = 1; t <= T; t++) {
            max = null;
            maxNum = Integer.MAX_VALUE;
            isReachFlag = false;
            X = sc.nextLong();
            Y = sc.nextLong();

            if((X % 2 == 0 && Y % 2 == 0) || (X % 2 == 1 && Y % 2 == 1)) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }
            
            if(X % 2 == 0) {
                sb.setLength(0);
                sb.append("N");
                cur = search(0, 1, sb, 1);
                if(cur != null && cur.length() < maxNum) {
                    maxNum = cur.length();
                    max = cur;
                }
                sb.setLength(0);
                sb.append("S");
                cur = search(0, -1, sb, 1);
                if(cur != null && cur.length() < maxNum) {
                    max = cur;
                }
            } else {
                sb.setLength(0);
                sb.append("E");
                cur = search(1, 0, sb, 1);
                if(cur != null && cur.length() < maxNum) {
                    maxNum = cur.length();
                    max = cur;
                }
                sb.setLength(0);
                sb.append("W");
                cur = search(-1, 0, sb, 1);
                if(cur != null && cur.length() < maxNum) {
                    max = cur;
                }
            }
            System.out.println("Case #" + t + ": " + max);
        }
    }
    
    private static String search(long x, long y, StringBuffer sb, long jump) {
        if(isReached(x, y)) return sb.toString();
        if(isBreak(x, y)) return null;
        if(jump > 63) return null;
        
        String max = null, cur;
        int maxNum = Integer.MAX_VALUE;

        sb.setLength((int)jump);
        sb.append("E");
        cur = search(x + (1L << jump), y, sb, jump + 1);
        if(cur != null && cur.length() < maxNum) {
            maxNum = cur.length();
            max = cur;
        }

        sb.setLength((int)jump);
        sb.append("W");
        cur = search(x - (1L << jump), y, sb, jump + 1);
        if(cur != null && cur.length() < maxNum) {
            maxNum = cur.length();
            max = cur;
        }

        sb.setLength((int)jump);
        sb.append("N");
        cur = search(x, y + (1L << jump), sb, jump + 1);
        if(cur != null && cur.length() < maxNum) {
            maxNum = cur.length();
            max = cur;
        }

        sb.setLength((int)jump);
        sb.append("S");
        cur = search(x, y - (1L << jump), sb, jump + 1);
        if(cur != null && cur.length() < maxNum) {
            max = cur;
        }

        sb.setLength((int)jump);
        
        return max;
    }
    
    private static boolean isReached(long x, long y) {
        if(x == X && y == Y)
            isReachFlag = true;
        
        return isReachFlag;
    }

    private static boolean isBreak(long x, long y) {
        return (x > Math.abs(X * X) || y > Math.abs(Y * Y));
    }
}