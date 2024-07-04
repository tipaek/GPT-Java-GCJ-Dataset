import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Expogo solver = new Expogo();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }
}

class Expogo {
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

                if ((x0 & y0) == 0 && (z & (z - 1)) == 0) {
                    int size = Math.max(s1.length(), s2.length());
                    Character[] runJumps = new Character[size];

                    addJumps(runJumps, y, y0, 'N', 'S', size);
                    addJumps(runJumps, x, x0, 'E', 'W', size);

                    StringBuilder tmp = new StringBuilder();
                    for (Character c : runJumps) {
                        tmp.append(c);
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

    private void addJumps(Character[] runJumps, long coord, long coord0, char pos, char neg, int size) {
        boolean isPositive = true;

        if (coord0 > coord) {
            isPositive = false;
            char temp = pos;
            pos = neg;
            neg = temp;
        }

        int i = size;
        while (coord0 > 0) {
            while (true) {
                i--;
                if ((coord0 & 1) == 1) break;
                coord0 >>= 1;
            }
            if (isPositive) {
                runJumps[i] = pos;
            } else {
                runJumps[i] = ((coord0 & (coord0 - 1)) != 0) ? neg : pos;
            }
            coord0 >>= 1;
        }
    }

    private List<Long> getCandidates(long x) {
        List<Long> candidates = new ArrayList<>();
        x = Math.abs(x);

        if ((x & (x - 1)) == 0) {
            candidates.add(x);
        } else {
            long p = x & (x - 1);
            p *= 2;
            candidates.add(x);
            candidates.add(p | (p - x));
        }

        return candidates;
    }
}

class InputReader {
    private final BufferedReader reader;
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}