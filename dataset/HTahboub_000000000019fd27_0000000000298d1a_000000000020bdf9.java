import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static void solve() throws IOException {
        int t = readInt();
        for (int p = 1; p <= t; ++p) {
            int n = readInt();
            char[] out = new char[n];
            ArrayList<Pair<Point, Integer>> points = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                points.add(new Pair<>(new Point(readInt(), readInt()), i));
            points.sort(Comparator.comparingInt(pointIntegerPair -> pointIntegerPair.first.y));

            ArrayList<Point> c = new ArrayList<>();
            ArrayList<Point> j = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                int s = points.get(i).first.x;
                int e = points.get(i).first.y;
                String next = "C";
                for (Point point : c)
                    if (s < point.y && e > point.x) {
                        next = "J";
                        break;
                    }
                if (next.equals("C")) {
                    c.add(new Point(s, e));
                    out[points.get(i).second] = 'C';
                    continue;
                }
                for (Point point : j)
                    if (s < point.y && e > point.x) {
                        next = "IMPOSSIBLE";
                        break;
                    }
                if (next.equals("J")) {
                    j.add(new Point(s, e));
                    out[points.get(i).second] = 'J';
                }
                else {
                    out = null;
                    break;
                }
            }
            System.out.println("Case #" + p + ": " + (out == null ? "IMPOSSIBLE" : new String(out)));
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

    private static class Pair<A, B> {
        private A first;
        private B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        public void setFirst(A first) {
            this.first = first;
        }

        public void setSecond(B second) {
            this.second = second;
        }
    }
}