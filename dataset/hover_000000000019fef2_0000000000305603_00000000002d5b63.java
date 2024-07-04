
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EndUser
 * Done
 */
public class Solution {
    
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        long max = 1000000000L;
        for (int k = 1; k <= t; k++) {
            if (a == b) {
                long limit = max - a;
                boolean finish = false;
                System.out.println(0 + " " + a);
                String answer1 = in.nextLine();
                if (answer1.equals("CENTER")) {
                    continue;
                }
                System.out.println(0 + " " + (-a));
                String answer2 = in.nextLine();
                if (answer2.equals("CENTER")) {
                    continue;
                }
                System.out.println(a + " " + 0);
                String answer3 = in.nextLine();
                if (answer3.equals("CENTER")) {
                    continue;
                }
                System.out.println((-a) + " " + 0);
                String answer4 = in.nextLine();
                if (answer4.equals("CENTER")) {
                    continue;
                }
                for (long i = -limit; i <= limit; i++) {
                    for (long j = -limit; j <= limit; j++) {
                        if (!checkAnswer(0, a, i, j, a, answer1)) {
                            continue;
                        }
                        if (!checkAnswer(0, -a, i, j, a, answer2)) {
                            continue;
                        }
                        if (!checkAnswer(a, 0, i, j, a, answer3)) {
                            continue;
                        }
                        if (!checkAnswer(-a, 0, i, j, a, answer4)) {
                            continue;
                        }
                        System.out.println(i + " " + j);
                        String answer = in.nextLine();
                        if (answer.equals("CENTER")) {
                            finish = true;
                            break;
                        }
                    }
                    if (finish) {
                        break;
                    }
                }
            } else {
                
            }
        }
    }
    
    public static long distance(long a, long b, long c, long d) {
        long result = (a - c) * (a - c) + (b - d) * (b - d);
        long sqr = Math.round(Math.sqrt(result));
        if (sqr * sqr < result) {
            return sqr + 1;
        } else {
            return sqr;
        }
    }
    
    public static long distance2(long a, long b, long c, long d) {
        return Math.round(Math.sqrt((a - c) * (a - c) + (b - d) * (b - d)));
    }
    
    public static boolean checkAnswer(long a, long b, long c, long d, long r, String answer) {
        long dd = distance(a, b, c, d);
        boolean inCircle = (dd <= r);
        return inCircle == answer.equals("HIT");
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
            if (snumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0) {
                    return -1;
                }
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
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
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
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
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
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
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
