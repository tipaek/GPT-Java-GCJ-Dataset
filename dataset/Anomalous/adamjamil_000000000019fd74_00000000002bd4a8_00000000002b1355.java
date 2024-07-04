import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private boolean multiple = true;
    private int caseNum = 0;
    private StringBuilder resultBuilder = new StringBuilder();
    private BufferedReader reader;
    private FastScanner scanner;
    private PrintWriter writer;
    private static Throwable uncaught;

    private void solve() throws Exception {
        caseNum++;
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] values = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                values[i][j] = scanner.nextInt();

        long totalSum = 0;

        while (true) {
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    totalSum += values[i][j];

            List<int[]> toRemove = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (values[i][j] == 0) continue;

                    int neighborSum = 0;
                    int neighborCount = 0;

                    for (int k = i - 1; k >= 0; k--)
                        if (values[k][j] != 0) {
                            neighborSum += values[k][j];
                            neighborCount++;
                            break;
                        }

                    for (int k = i + 1; k < rows; k++)
                        if (values[k][j] != 0) {
                            neighborSum += values[k][j];
                            neighborCount++;
                            break;
                        }

                    for (int k = j + 1; k < cols; k++)
                        if (values[i][k] != 0) {
                            neighborSum += values[i][k];
                            neighborCount++;
                            break;
                        }

                    for (int k = j - 1; k >= 0; k--)
                        if (values[i][k] != 0) {
                            neighborSum += values[i][k];
                            neighborCount++;
                            break;
                        }

                    if (neighborCount == 0) continue;
                    if (values[i][j] * neighborCount < neighborSum) {
                        toRemove.add(new int[]{i, j});
                    }
                }
            }

            if (toRemove.isEmpty()) break;
            for (int[] cell : toRemove)
                values[cell[0]][cell[1]] = 0;
        }

        println("Case #" + caseNum + ": " + totalSum);
    }

    private void print(Object s) {
        resultBuilder.append(s);
    }

    private void println(Object s) {
        resultBuilder.append(s).append('\n');
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);
            scanner = new FastScanner(reader);
            if (multiple) {
                int queries = scanner.nextInt();
                for (int i = 0; i < queries; i++) solve();
            } else {
                solve();
            }
            System.out.print(resultBuilder);
        } catch (Throwable t) {
            uncaught = t;
        } finally {
            writer.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", 1 << 26);
        thread.start();
        thread.join();
        if (uncaught != null) throw uncaught;
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
    }
}