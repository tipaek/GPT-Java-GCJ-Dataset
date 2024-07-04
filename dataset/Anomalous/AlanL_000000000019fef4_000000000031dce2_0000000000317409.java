import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static String s;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int tests = 1; tests <= t; tests++) {
            System.out.print("Case #" + tests + ": ");
            int x = readInt(), y = readInt();
            s = next();
            ans = Integer.MAX_VALUE;
            solve(x, y, 0);
            if (ans == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }
        }
    }

    static void solve(int x, int y, int cur) {
        if (cur == s.length()) {
            if (x == 0 && y == 0) {
                ans = Math.min(ans, cur);
            }
            return;
        }
        if (x == 0 && y == 0) {
            ans = Math.min(ans, cur);
            return;
        }
        if (s.charAt(cur) == 'N') {
            y++;
        } else if (s.charAt(cur) == 'S') {
            y--;
        } else if (s.charAt(cur) == 'E') {
            x++;
        } else {
            x--;
        }
        solve(x, y, cur + 1);
        solve(x - 1, y, cur + 1);
        solve(x, y - 1, cur + 1);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}