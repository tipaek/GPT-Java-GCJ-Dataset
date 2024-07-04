import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static void solve() throws IOException {
        int t = readInt();
        for (int p = 1; p <= t; ++p) {
            StringBuilder out = new StringBuilder("C");
            int n = readInt();
            Point c = new Point(readInt(), readInt());
            Point j = new Point(0, 0);
            for (int i = 0; i < n-1; ++i) {
                int s = readInt();
                int e = readInt();
                if (s >= c.y || e <= c.x) {
                    c = new Point(s, e);
                    out.append('C');
                } else if (s >= j.y || e <= j.y) {
                    j = new Point(s, e);
                    out.append('J');
                } else {
                    out = new StringBuilder("IMPOSSIBLE");
                    for (; i < n-2; ++i, readInt(), readInt());
                    break;
                }
            }
            System.out.println("Case #" + p + ": " + out);
        }
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
