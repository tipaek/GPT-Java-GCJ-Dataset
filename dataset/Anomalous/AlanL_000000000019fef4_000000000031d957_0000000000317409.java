import java.util.*;
import java.io.*;

public class Solution {

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static String s;
    private static int ans;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int tests = 1; tests <= t; tests++) {
            System.out.print("Case #" + tests + ": ");
            int x = readInt();
            int y = readInt();
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

    private static void solve(int x, int y, int cur) {
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
        switch (s.charAt(cur)) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
        }
        solve(x, y, cur + 1);
        solve(x - 1, y, cur + 1);
        solve(x, y - 1, cur + 1);
        solve(x + 1, y, cur + 1);
        solve(x, y + 1, cur + 1);
    }

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    private static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private static char readChar() throws IOException {
        return next().charAt(0);
    }

    private static String readLine() throws IOException {
        return input.readLine().trim();
    }
}