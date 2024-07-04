import java.io.*;
import java.util.*;

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
        char[] result = new char[pairs.size()];

        for (int i = 2; i < pairs.size(); ++i) {
            Pair p1 = pairs.get(i - 2);
            Pair p2 = pairs.get(i - 1);
            Pair p3 = pairs.get(i);
            if (isOverlap(p1, p2) && isOverlap(p1, p3) && isOverlap(p2, p3)) {
                return "IMPOSSIBLE";
            }
        }

        int[][] dp = new int[pairs.size()][2];

        for (int i = 0; i < pairs.size(); ++i) {
            if (i == 0) {
                dp[i][0] = dp[i][1] = -1;
                continue;
            }
            Pair prev = pairs.get(i - 1);
            Pair cur = pairs.get(i);
            boolean overlap = cur.start < prev.end;
            if (dp[i - 1][0] != 0) {
                dp[i][1] = 1;
            }
            if (dp[i - 1][1] != 0) {
                dp[i][0] = 2;
            }
            if (!overlap) {
                if (dp[i - 1][0] != 0) {
                    dp[i][0] = 1;
                }
                if (dp[i - 1][1] != 0) {
                    dp[i][1] = 2;
                }
            }
        }

        int x = 0;
        result[pairs.get(pairs.size() - 1).index] = 'C';
        for (int i = pairs.size() - 1; i > 0; --i) {
            if (dp[i][x] == 1) {
                result[pairs.get(i - 1).index] = 'C';
                x = 0;
            } else if (dp[i][x] == 2) {
                result[pairs.get(i - 1).index] = 'J';
                x = 1;
            }
        }

        return new String(result);
    }

    public void solve() throws Exception {
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            List<Pair> pairs = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                pairs.add(new Pair(sc.nextInt(), sc.nextInt(), j));
            }
            Collections.sort(pairs);
            System.out.println("Case #" + (i + 1) + ": " + solve(pairs));
        }
    }

    /*--------------------------------------------------------------*/

    static String filename = "";
    static boolean fromFile = false;

    BufferedReader in;
    PrintWriter out;
    FastScanner sc;

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
        if (fromFile) {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        sc = new FastScanner(in);
    }
}

class FastScanner {

    BufferedReader reader;
    StringTokenizer tokenizer;

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