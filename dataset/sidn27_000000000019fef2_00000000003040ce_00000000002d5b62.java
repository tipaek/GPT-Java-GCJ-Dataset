import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    static ArrayList<Long> jumps;

    private static void generate() {
        int high = (int) Math.pow(10, 9);
        int MAX = high + high + 1;
        long curr = 1;
        long a = 1;
        int r = 2;
        int x = 1;
        jumps.add(1L);

        long prev = 1;
        while(curr <= MAX) {
            long num = a * (int)Math.pow(r, x);
            long den = r-1;

            curr = num/den;
            prev = curr;
            jumps.add(curr);
            x++;
        }

//        for(int i=-4; i<=4; i++) {
//            for(int j=-4; j<=4; j++) {
//                answ = new ArrayList<>();
//                int minIndex = -1;
//                int minLen = Integer.MAX_VALUE;
//
//                String ss= mapRec("", 0, 0, i, j);
//
//                for(int index = 0; index<answ.size(); index++) {
//                    String s = answ.get(index);
//                    if(s.length() < minLen) {
//                        minIndex = index;
//                    }
//                }
//
//                String ans;
//                if(minIndex != -1) {
//                    ans = answ.get(minIndex);
//                } else {
//                    ans = "";
//
//                }
//                System.out.println(i + " , " + j + " : " + ans);
//            }
//        }
    }

    static boolean flag;

    static ArrayList<String> answ;

    private static String mapRec(String cur, long x, long y, long goalX, long goalY) {

        long xa = Math.abs(x);
        long ya = Math.abs(y);
        long goalXa = Math.abs(goalX);
        long goalYa = Math.abs(goalY);
        if(xa > goalXa || ya > goalYa || cur.length() > jumps.size()-1) {
            return "";
        }

        if(x == goalX && y == goalY) {
            answ.add(cur);
            return cur;
        }

        long d = jumps.get(cur.length());

        String c = mapRec(cur+"E", x + d, y, goalX, goalY);
        String a = mapRec(cur+"S", x, y - d, goalX, goalY);
        String b = mapRec(cur+"N", x, y + d, goalX, goalY);
        String de = mapRec(cur+"W", x - d, y, goalX, goalY);

        return a + b + c + de;
    }

    public static void main(String[] args) {

        jumps = new ArrayList<>();

        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        generate();

        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {

            int goalX = in.nextInt();
            int goalY = in.nextInt();

            answ = new ArrayList<>();
            int minIndex = -1;
            int minLen = Integer.MAX_VALUE;

            String ss= mapRec("", 0, 0, goalX, goalY);

            for(int index = 0; index<answ.size(); index++) {
                String s = answ.get(index);
                if(s.length() < minLen) {
                    minIndex = index;
                    minLen = s.length();
                }
            }

            String ans;
            if(minIndex != -1) {
                ans = answ.get(minIndex);
            } else {
                ans = "IMPOSSIBLE";

            }
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
