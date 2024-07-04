import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 1; k <= t; ++k) {
            int m = in.nextInt();
            int n = in.nextInt();
            String step = in.next();
            int res = helper(m, n, step);
            if (res == -1) System.out.println("Case #" + k + ": IMPOSSIBLE");
            else System.out.println("Case #" + k + ": " + res);
        }
    }

    private static int helper(int m, int n, String steps) {
        int len = steps.length();
        int time = 1;
        char[] ch = steps.toCharArray();
        for (int i = 0; i < len; i++) {
            if (ch[i] == 'N') {
                n++;
            } else if (ch[i] == 'S') {
                n--;
            } else if (ch[i] == 'E') {
                m++;
            } else if (ch[i] == 'W') {
                m--;
            }
            if (Math.abs(m) + Math.abs(n) <= time) {
                return time;
            }
            time++;
        }
        return -1;
    }
}
