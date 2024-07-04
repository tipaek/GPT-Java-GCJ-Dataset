import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private static class Pair implements Comparable<Pair> {
        final int start;
        final int end;
        final int id;

        Pair(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    private static final int MULTIPLIER = 10000;

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            if (fromConsole) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                writer = new PrintWriter(System.out);
            } else {
                reader = new BufferedReader(new FileReader(filename + ".in"));
                writer = new PrintWriter(filename + ".out");
            }
            tokenizer = new StringTokenizer("");
            solve();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void solve() {
        int testCases = nextInt();
        for (int i = 1; i <= testCases; i++) {
            String result = solveCase();
            writer.printf("Case #%d: %s\n", i, result);
        }
    }

    private String solveCase() {
        int n = nextInt();
        Pair[] pairs = new Pair[n + 1];
        pairs[0] = new Pair(0, 0, -1);
        for (int i = 0; i < n; i++) {
            pairs[i + 1] = new Pair(nextInt(), nextInt(), i);
        }
        Arrays.sort(pairs);

        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentC = current / MULTIPLIER;
            int currentJ = current % MULTIPLIER;
            int endC = pairs[currentC].end;
            int endJ = pairs[currentJ].end;
            int next = Math.max(currentC, currentJ) + 1;

            if (next == n + 1) {
                char[] result = new char[n];
                while (currentC != 0 || currentJ != 0) {
                    int previousC = dp[currentC][currentJ] / MULTIPLIER;
                    int previousJ = dp[currentC][currentJ] % MULTIPLIER;
                    if (previousC != currentC) {
                        result[pairs[currentC].id] = 'C';
                    } else {
                        result[pairs[currentJ].id] = 'J';
                    }
                    currentC = previousC;
                    currentJ = previousJ;
                }
                return new String(result);
            }

            if (endC <= pairs[next].start && dp[next][currentJ] == -1) {
                dp[next][currentJ] = currentC * MULTIPLIER + currentJ;
                queue.add(next * MULTIPLIER + currentJ);
            }
            if (endJ <= pairs[next].start && dp[currentC][next] == -1) {
                dp[currentC][next] = currentC * MULTIPLIER + currentJ;
                queue.add(currentC * MULTIPLIER + next);
            }
        }
        return "IMPOSSIBLE";
    }

    private boolean hasNext() {
        try {
            while (!tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String next() {
        return hasNext() ? tokenizer.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    private static final String filename = "A";
    private static final boolean fromConsole = true;
}