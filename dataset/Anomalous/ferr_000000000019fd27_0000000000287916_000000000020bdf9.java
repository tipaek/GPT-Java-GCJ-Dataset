import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private class Pair implements Comparable<Pair> {
        public final int start;
        public final int end;
        public final int id;

        Pair(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start)
                return Integer.compare(this.start, other.start);
            return Integer.compare(this.end, other.end);
        }
    }

    private class Edge {
        public final int C;
        public final int J;

        Edge(int C, int J) {
            this.C = C;
            this.J = J;
        }
    }

    private static final int MULTIPLIER = 10000;
    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    public String solveCase() {
        int n = nextInt();
        Pair[] pairs = new Pair[n + 1];
        pairs[0] = new Pair(0, 0, -1);
        for (int i = 0; i < n; i++) {
            pairs[i + 1] = new Pair(nextInt(), nextInt(), i);
        }
        Arrays.sort(pairs);
        Edge[][] dp = new Edge[n + 1][n + 1];
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(0, 0));
        
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentCEnd = pairs[current.C].end;
            int currentJEnd = pairs[current.J].end;
            int nextIndex = Math.max(current.C, current.J) + 1;
            
            if (nextIndex == n + 1) {
                char[] result = new char[n];
                while (current.C != 0 || current.J != 0) {
                    Edge previous = dp[current.C][current.J];
                    if (previous.C != current.C) {
                        result[pairs[current.C].id] = 'C';
                    } else {
                        result[pairs[current.J].id] = 'J';
                    }
                    current = previous;
                }
                return new String(result);
            }
            
            if (currentCEnd <= pairs[nextIndex].start) {
                dp[nextIndex][current.J] = current;
                queue.add(new Edge(nextIndex, current.J));
            }
            if (currentJEnd <= pairs[nextIndex].start) {
                dp[current.C][nextIndex] = current;
                queue.add(new Edge(current.C, nextIndex));
            }
        }
        return "IMPOSSIBLE";
    }

    public void solve() {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            String result = solveCase();
            writer.printf("Case #%d: %s\n", i + 1, result);
        }
    }

    static final String FILE_NAME = "A";
    static final boolean FROM_CONSOLE = true;

    public void run() {
        try {
            if (!FROM_CONSOLE) {
                reader = new BufferedReader(new FileReader(FILE_NAME + ".in"));
                writer = new PrintWriter(FILE_NAME + ".out");
            } else {
                reader = new BufferedReader(new InputStreamReader(System.in));
                writer = new PrintWriter(System.out);
            }
            tokenizer = new StringTokenizer("");
            solve();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
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

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}