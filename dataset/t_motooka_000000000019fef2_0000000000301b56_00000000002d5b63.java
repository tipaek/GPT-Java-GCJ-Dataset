import java.util.Scanner;

public class Solution {
    private static Scanner in = new Scanner(System.in);
    private static long a = 0;
    private static long b = 0;
    public static void main(String args[]) {
        int t = in.nextInt();
        a = in.nextLong();
        b = in.nextLong();
        for(int i=0; i<t; i++) {
            solve();
        }
    }
    public static void solve() {
        final long num109 = 1000000000;
        long diff = num109-a;
        // test set 1 : diff == 5
        // test set 2 : diff == 50
        // test set 3 : diff == huge number
        
        for(long x=-diff; x<=diff; x++) {
            for(long y=-diff; y<=diff; y++) {
                String result = communicate(x, y);
                if(result.equals("CENTER")) {
                    return;
                }
            }
        }
        return;
//        long leftEdgeX = -num109 + diff;
//        long leftEdgeHitMinY = Long.MAX_VALUE;
//        long leftEdgeHitMaxY = Long.MIN_VALUE;
//        for(long y=-diff; y<=diff; y++) {
//            String result = communicate(leftEdgeX, y);
//            if(result.equals("HIT")) {
//                leftEdgeHitMinY = Math.min(leftEdgeHitMinY, y);
//                leftEdgeHitMaxY = Math.max(leftEdgeHitMaxY, y);
//            }
//        }
//        long y = (leftEdgeHitMinY + leftEdgeHitMaxY) / 2;
//        for(long y1=y-1; y1<=y+1; y1++) {
//            for(long x=-diff; x<=diff; x++) {
//                String result = communicate(x, y1);
//                if(result.equals("CENTER")) {
//                    return;
//                }
//            }
//        }
    }
    
    private static String communicate(long x, long y) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(' ');
        sb.append(y);
        System.out.println(sb.toString());
        String result = in.next();
        if(result.equals("WRONG")) {
            throw new RuntimeException("WRONG");
        }
        return result;
    }
}