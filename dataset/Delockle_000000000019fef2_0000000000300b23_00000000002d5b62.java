import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Expogo solver = new Expogo();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Expogo {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long x = in.nextLong();
            long y = in.nextLong();

            ArrayList<Long> dx;
            ArrayList<Long> dy;

            dx = getCandidates(x);
            dy = getCandidates(y);

            ArrayList<StringBuilder> jumps = new ArrayList<>();

            for (Long x0 : dx) {
                for (Long y0 : dy) {
                    String s1 = Long.toBinaryString(x0);
                    String s2 = Long.toBinaryString(y0);

                    long z = (x0 | y0) + 1;
                    boolean flag = (x0 & y0) == 0 && (z & (z - 1)) == 0;

                    if (x0 == 0 || y0 == 0 || flag) {
                        int size = Math.max(s1.length(), s2.length());
                        Character[] runJumps = new Character[size];

                        addJumps(runJumps, y, y0, 'N', 'S', size);
                        addJumps(runJumps, x, x0, 'E', 'W', size);

                        StringBuilder tmp = new StringBuilder();
                        int m = runJumps.length;

                        int i = m - 1;
                        while (i >= 0) {
                            Character c = runJumps[i];
                            if (c != null) {
                                tmp.append(c);
                            }
                            i--;
                        }
                        jumps.add(tmp);
                    }
                }
            }

            if (jumps.size() == 0) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                StringBuilder minJumps = Collections.min(jumps, (o1, o2) -> o1.length() - o2.length());

                out.printf("Case #%d: %s\n", testNumber, minJumps.toString());
            }
        }

        private void addJumps(Character[] runJumps, Long y, Long y0, char pos, char neg, int size) {
            boolean op1 = true;

            if (y0 > Math.abs(y)) {
                op1 = false;
            }

            if (y < 0) {
                char tmp = pos;
                pos = neg;
                neg = tmp;
            }

            int i = size;
            while (y0 > 0) {
                while (true) {
                    i -= 1;
                    long b = (y0 & 1);
                    if (b == 1) {
                        break;
                    }
                    y0 >>= 1;
                }
                if (op1) {
                    runJumps[i] = pos;
                } else {
                    if ((y0 & (y0 - 1)) != 0) {
                        runJumps[i] = neg;
                    } else {
                        runJumps[i] = pos;
                    }
                }
                y0 >>= 1;
            }
        }

        private ArrayList<Long> getCandidates(long x) {
            ArrayList<Long> d = new ArrayList<>();

            x = Math.abs(x);

            // power of 2
            if ((x & (x - 1)) == 0) {
                d.add(x);
            } else {
                long p = x & (x - 1);
                p *= 2;
                d.add(x);
                d.add(p | (p - x));
//            d.add()
            }

            return d;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

