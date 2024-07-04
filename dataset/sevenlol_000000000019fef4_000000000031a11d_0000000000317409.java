import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            solve(i, x, y, s);
        }
    }

    private static void solve(int T, int x, int y, String s) {
        System.out.format("Case #%d: ", T);

        // s = modify(s, x, y);
        // x = Math.abs(x);
        // y = Math.abs(y);

        if (x == 0 && y == 0) {
            System.out.println(0);
            return;
        }
        int t = 1;
        for (char c : s.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else {
                x--;
            }
            // System.out.println(x + "," + y);
            if (Math.abs(x) + Math.abs(y) <= t) {
                System.out.println(t);
                return;
            }
            t++;
        }
        System.out.println("IMPOSSIBLE");
    }

    private static String modify(String s, int x, int y) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c == 'E' || c == 'W') && x < 0) {
                sb.append(c == 'E' ? 'W' : 'E');
            } else if ((c == 'N' || c == 'S') && y < 0) {
                sb.append(c == 'N' ? 'S' : 'N');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}