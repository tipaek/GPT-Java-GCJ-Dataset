
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    static class Point {
        int x;
        int y;
        public Point(int a, int b) {
            x=a;
            y=b;
        }
    }

    private static String solve(InputReader sc, PrintWriter sop) {

        int x = sc.nextInt();
        int y = sc.nextInt();
        Point me = new Point(0, 0);
        String s = sc.nextLine();
        ArrayList<Point> path = new ArrayList<>();
        path.add(new Point(x,y));
        for(char c:s.toCharArray()) {
            switch(c) {
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            path.add(new Point(x,y));
        }

        List<Integer> times = new ArrayList<>();
        for(Point p: path) {
            int d = dist(me, p);
            times.add(d);
        }

        int step = 0;
        List<Integer> pTimes = new ArrayList<>();
        for(Point p: path) {
            pTimes.add(step++);
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<times.size(); i++) {
            int t = times.get(i);
            int pt = pTimes.get(i);
            int diff = Math.abs(t - pt);
            if(t > pt) {
                continue;
            }
            if(diff < min) {
                min = diff;
                minIndex = i;
            }
        }

        if(minIndex == -1) {
            return "IMPOSSIBLE";
        } else {
            return ""+pTimes.get(minIndex);
        }

    }

    private static int dist(Point a, Point b) {
        int distX =  Math.abs(a.x - b.x);
        int distY = Math.abs(a.y - b.y);
        return distX + distY;
    }


    public static void main(String[] args) {


        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {

            String ans = solve(in, w);
            System.out.println("Case #" + i + ": " + ans);
        }

    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

}
