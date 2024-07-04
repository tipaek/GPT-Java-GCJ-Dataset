import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            int x = sc.nextInt(); int y = sc.nextInt();
            String m = sc.next();
            int xDist = x; int yDist = y; int ansX = x; int ansY = y; int idx = 0;
            int [][] dp = new int [m.length() + 1][2]; dp[0][0] = x; dp[0][1] = y; int min = Integer.MAX_VALUE;
            for (int i = 1; i <= m.length(); i++) {
                if (m.charAt(i-1) == 'N') {
                    yDist++;
                } else if (m.charAt(i-1) == 'S') {
                    yDist--;
                } else if (m.charAt(i-1) == 'E') {
                    xDist++;
                } else {
                    xDist--;
                }
                dp[i][0] = xDist; dp[i][1] = yDist;
                if (Math.abs(xDist) + Math.abs(yDist) <= i) {
                    min = i; break;
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println("Case #" + p + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + p + ": " + min);
            }

        }
    }

}