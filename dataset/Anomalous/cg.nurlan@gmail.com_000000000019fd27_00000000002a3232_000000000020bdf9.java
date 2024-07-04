import java.io.*;
import java.util.*;
import java.math.*;

public class Solution implements Runnable {

    class Pair implements Comparable<Pair> {
        int start, end, index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    private boolean isOverlap(Pair p1, Pair p2) {
        return !(p1.end <= p2.start || p1.start >= p2.end);
    }

    private String solve(List<Pair> pairs) {
        int n = pairs.size();
        for (int mask = 0; mask < (1 << n); ++mask) {
            List<Pair> cList = new ArrayList<>();
            List<Pair> jList = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    cList.add(pairs.get(i));
                } else {
                    jList.add(pairs.get(i));
                }
            }
            if (isValid(cList) && isValid(jList)) {
                StringBuilder result = new StringBuilder(n);
                for (int i = 0; i < n; ++i) {
                    result.append((mask & (1 << i)) != 0 ? 'C' : 'J');
                }
                return result.toString();
            }
        }
        return "IMPOSSIBLE";
    }

    private boolean isValid(List<Pair> list) {
        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                if (isOverlap(list.get(i), list.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void solveCases() throws IOException {
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            List<Pair> pairs = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                pairs.add(new Pair(sc.nextInt(), sc.nextInt(), j));
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(pairs));
        }
    }

    private static final String filename = "";
    private static final boolean fromFile = false;

    private BufferedReader in;
    private PrintWriter out;
    private FastScanner sc;

    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 1 << 25).start();
    }

    @Override
    public void run() {
        try {
            init();
            solveCases();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    private void init() throws Exception {
        if (fromFile) {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        sc = new FastScanner(in);
    }

    static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(BufferedReader reader) {
            this.reader = reader;
        }

        String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        BigInteger nextBigInteger() throws IOException {
            return new BigInteger(nextToken());
        }

        BigDecimal nextBigDecimal() throws IOException {
            return new BigDecimal(nextToken());
        }
    }
}