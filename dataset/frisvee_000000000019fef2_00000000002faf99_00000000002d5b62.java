import java.io.*;
import java.util.*;

public class Solution {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static final char[] LETTERS = new char[]{'N', 'W', 'S', 'E'};
    private static final int[] DIST = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
    private static final String[][] precalc = new String[1024][1024];

    public static void add(Point p, char c, int i) {
        if (c == 'N') {
            p.y += DIST[i - 1];
        } else if (c == 'S') {
            p.y -= DIST[i - 1];
        } else if (c == 'E') {
            p.x += DIST[i - 1];
        } else if (c == 'W') {
            p.x -= DIST[i - 1];
        }
    }

    private static void put(Point p, String s) {
        String ss = precalc[p.x + 256][p.y + 256];
        if (ss == null || ss.length() > s.length()) {
            precalc[p.x + 256][p.y + 256] = s;
        }
    }

    private static void calc() {
        for (char c1 : LETTERS) {
            for (char c2 : LETTERS) {
                for (char c3 : LETTERS) {
                    for (char c4 : LETTERS) {
                        for (char c5 : LETTERS) {
                            for (char c6 : LETTERS) {
                                for (char c7 : LETTERS) {
                                    for (char c8 : LETTERS) {
                                        Point p = new Point(0, 0);
                                        String s = "";
                                        add(p, c1, 1); s+=c1; put(p, s);
                                        add(p, c2, 2); s+=c2; put(p, s);
                                        add(p, c3, 3); s+=c3; put(p, s);
                                        add(p, c4, 4); s+=c4; put(p, s);
                                        add(p, c5, 5); s+=c5; put(p, s);
                                        add(p, c6, 6); s+=c6; put(p, s);
                                        add(p, c7, 7); s+=c7; put(p, s);
                                        add(p, c8, 8); s+=c8; put(p, s);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static String solve(int X, int Y) {
        String result = "IMPOSSIBLE";
        if (X >= -100 && X <= 100 && Y >= -100 && Y <= 100) {
            if (precalc[X + 256][Y + 256] != null) {
                result = precalc[X + 256][Y + 256];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        calc();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();

            System.out.println("Case #" + t + ": " + solve(X, Y));
        }

        in.close();
    }
}