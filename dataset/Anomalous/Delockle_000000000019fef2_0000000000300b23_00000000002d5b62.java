import java.io.*;
import java.util.*;

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
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Expogo {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long x = in.nextLong();
            long y = in.nextLong();

            List<Long> dx = getCandidates(x);
            List<Long> dy = getCandidates(y);

            List<StringBuilder> jumps = new ArrayList<>();

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
                        for (int i = runJumps.length - 1; i >= 0; i--) {
                            if (runJumps[i] != null) {
                                tmp.append(runJumps[i]);
                            }
                        }
                        jumps.add(tmp);
                    }
                }
            }

            if (jumps.isEmpty()) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                StringBuilder minJumps = Collections.min(jumps, Comparator.comparingInt(StringBuilder::length));
                out.printf("Case #%d: %s\n", testNumber, minJumps.toString());
            }
        }

        private void addJumps(Character[] runJumps, long y, long y0, char pos, char neg, int size) {
            boolean op1 = y0 <= Math.abs(y);

            if (y < 0) {
                char tmp = pos;
                pos = neg;
                neg = tmp;
            }

            int i = size;
            while (y0 > 0) {
                while (true) {
                    i -= 1;
                    if ((y0 & 1) == 1) {
                        break;
                    }
                    y0 >>= 1;
                }
                if (op1) {
                    runJumps[i] = pos;
                } else {
                    runJumps[i] = ((y0 & (y0 - 1)) != 0) ? neg : pos;
                }
                y0 >>= 1;
            }
        }

        private List<Long> getCandidates(long x) {
            List<Long> d = new ArrayList<>();
            x = Math.abs(x);

            if ((x & (x - 1)) == 0) {
                d.add(x);
            } else {
                long p = x & (x - 1);
                p *= 2;
                d.add(x);
                d.add(p | (p - x));
            }

            return d;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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