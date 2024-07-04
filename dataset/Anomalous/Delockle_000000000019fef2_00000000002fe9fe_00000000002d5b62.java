import java.io.*;
import java.util.*;

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
                    if (isValidJump(x0, y0)) {
                        StringBuilder jumpSequence = buildJumpSequence(x, y, x0, y0);
                        jumps.add(jumpSequence);
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

        private boolean isValidJump(long x0, long y0) {
            long z = (x0 | y0) + 1;
            return (x0 & y0) == 0 && (z & (z - 1)) == 0;
        }

        private StringBuilder buildJumpSequence(long x, long y, long x0, long y0) {
            String s1 = Long.toBinaryString(x0);
            String s2 = Long.toBinaryString(y0);
            int size = Math.max(s1.length(), s2.length());
            Character[] runJumps = new Character[size];

            addJumps(runJumps, y, y0, 'N', 'S', size);
            addJumps(runJumps, x, x0, 'E', 'W', size);

            StringBuilder jumpSequence = new StringBuilder();
            for (int i = size - 1; i >= 0; i--) {
                jumpSequence.append(runJumps[i]);
            }
            return jumpSequence;
        }

        private void addJumps(Character[] runJumps, long coord, long coord0, char pos, char neg, int size) {
            boolean positiveDirection = coord0 <= coord;
            if (coord < 0) {
                char temp = pos;
                pos = neg;
                neg = temp;
            }

            int i = size;
            while (coord0 > 0) {
                while ((coord0 & 1) == 0) {
                    i--;
                    coord0 >>= 1;
                }
                runJumps[--i] = positiveDirection ? pos : neg;
                coord0 >>= 1;
            }
        }

        private List<Long> getCandidates(long coord) {
            List<Long> candidates = new ArrayList<>();
            coord = Math.abs(coord);

            if ((coord & (coord - 1)) == 0) {
                candidates.add(coord);
            } else {
                long p = coord & (coord - 1);
                p *= 2;
                candidates.add(coord);
                candidates.add(p | (p - coord));
            }
            return candidates;
        }
    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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