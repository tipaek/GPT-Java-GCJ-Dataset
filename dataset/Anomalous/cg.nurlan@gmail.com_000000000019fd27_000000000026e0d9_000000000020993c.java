import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {

    private FastScanner sc;
    private PrintWriter out;

    public void solve(int t) throws Exception {
        int n = sc.nextInt();
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        Set<Integer> duplicateRows = new HashSet<>();
        Set<Integer> duplicateCols = new HashSet<>();
        int diagonalSum = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int value = sc.nextInt();
                if (i == j) {
                    diagonalSum += value;
                }
                if (!rows.get(i).add(value)) {
                    duplicateRows.add(i);
                }
                if (!cols.get(j).add(value)) {
                    duplicateCols.add(j);
                }
            }
        }

        out.println("Case #" + t + ": " + diagonalSum + " " + duplicateRows.size() + " " + duplicateCols.size());
    }

    public void solve() throws Exception {
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            solve(i + 1);
        }
    }

    private static final String FILENAME = "";
    private static final boolean FROM_FILE = false;

    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 1 << 25).start();
    }

    @Override
    public void run() {
        try {
            init();
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }

    private void init() throws Exception {
        BufferedReader in;
        if (FROM_FILE) {
            in = new BufferedReader(new FileReader(FILENAME + ".in"));
            out = new PrintWriter(new FileWriter(FILENAME + ".out"));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        sc = new FastScanner(in);
    }

    static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(BufferedReader reader) {
            this.reader = reader;
        }

        public String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        public BigInteger nextBigInteger() throws IOException {
            return new BigInteger(nextToken());
        }

        public BigDecimal nextBigDecimal() throws IOException {
            return new BigDecimal(nextToken());
        }
    }
}