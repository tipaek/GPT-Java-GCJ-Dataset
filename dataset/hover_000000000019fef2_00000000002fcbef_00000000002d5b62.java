
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
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out), true);

        int t = in.nextInt();
        for (int k = 1; k <= t; k++) {
            long x = in.nextLong();
            long y = in.nextLong();
            long base = 1;
            long next = base * 2;
            boolean ok = true;
            StringBuilder sb = new StringBuilder();
            while (x != 0 || y != 0) {
                boolean changeX = false;
                boolean changeY = false;
                if (Math.abs(x) % next == base) {
                    changeX = true;
                }
                if (Math.abs(y) % next == base) {
                    changeY = true;
                }
                
                if (changeX == changeY) {
                    ok = false;
                    break;
                }
                if (changeX) {
                    if (y == 0) {
                        if (x == base) {
                            x = 0;
                            sb.append("E");
                            break;
                        } else if (-x == base) {
                            x = 0;
                            sb.append("W");
                            break;
                        }
                    }
                    next = next * 2;
                    if (Math.abs(x + base) % next == Math.abs(y) % next) {
                        x = x - base;
                        sb.append('E');
                    } else {
                        x = x + base;
                        sb.append('W');
                    }
                } else {
                    if (x == 0) {
                        if (y == base) {
                            y = 0;
                            sb.append("N");
                            break;
                        } else if (-y == base) {
                            y = 0;
                            sb.append("S");
                            break;
                        }
                    }
                    next = next * 2;
                    if (Math.abs(y + base) % next == Math.abs(x) % next) {
                        y = y - base;
                        sb.append('N');
                    } else {
                        y = y + base;
                        sb.append('S');
                    }
                }
                base = base * 2;
            }
            if (!ok) {
                pw.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                pw.println("Case #" + k + ": " + sb.toString());
            }
            


        }
        
        pw.close();
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
