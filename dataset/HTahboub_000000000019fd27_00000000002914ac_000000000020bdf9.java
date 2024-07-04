import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static void solve() throws IOException {
        int t = readInt();
        for (int p = 1; p <= t; ++p) {
            StringBuilder out = new StringBuilder("C");
            int n = readInt();
            ArrayList<Point> c = new ArrayList<>();
            c.add(new Point(readInt(), readInt()));
            ArrayList<Point> j = new ArrayList<>();
            for (int i = 0; i < n-1; ++i) {
                int s = readInt();
                int e = readInt();
                String next = "C";
                for (Point point : c)
                    if (s < point.y && e > point.x) {
                        next = "J";
                        break;
                    }
                if (next.equals("C")) {
                    c.add(new Point(s, e));
                    out.append('C');
                    continue;
                }
                for (Point point : j)
                    if (s < point.y && e > point.y) {
                        next = "IMPOSSIBLE";
                        break;
                    }
                if (next.equals("J")) {
                    j.add(new Point(s, e));
                    out.append('J');
                }
                else {
                    out = new StringBuilder(next);
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