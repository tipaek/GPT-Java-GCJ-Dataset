import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean multiple = true;
    private long MOD;
    private boolean isInitialized = false;
    private long[][] nckCache = new long[600][600];
    private int caseNumber = 0;

    private long calculateNCK(int n, int k) {
        if (n == k || k == 0) return 1;
        if (nckCache[n][k] != -1) return nckCache[n][k];
        return nckCache[n][k] = (n * calculateNCK(n - 1, k - 1)) / k;
    }

    private void solve() throws Exception {
        caseNumber++;
        printLine("Case #" + caseNumber + ": ");
        if (!isInitialized) {
            for (int i = 0; i < nckCache.length; i++) {
                Arrays.fill(nckCache[i], -1);
            }
            isInitialized = true;
        }
        long n = scanner.nextLong();
        long current = 1;
        int row = 1, col = 1;
        printLine(row + " " + col);
        while (current < n) {
            if (row <= 2 || n - current < row - 1) {
                row++;
                current++;
                printLine(row + " " + col);
            } else {
                long returnCost = 1;
                for (int furthest = 2; furthest <= row + 1; furthest++) {
                    returnCost += calculateNCK(row - 1, furthest - 1) + calculateNCK(row, furthest - 1);
                    if (furthest == row + 1 || returnCost + current > n) {
                        furthest--;
                        for (int k = 2; k <= furthest; k++) {
                            current += calculateNCK(row - 1, k - 1);
                            printLine(row + " " + k);
                        }
                        row++;
                        for (int k = furthest; k >= 1; k--) {
                            current += calculateNCK(row - 1, k - 1);
                            printLine(row + " " + k);
                        }
                        row++;
                        col = 1;
                        printLine(row + " " + col);
                        current++;
                        break;
                    }
                }
            }
        }
    }

    private StringBuilder output = new StringBuilder();
    private void print(Object s) { output.append(s); }
    private void printLine(Object s) { output.append(s).append('\n'); }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            scanner = new FastScanner(in);
            if (multiple) {
                int q = scanner.nextInt();
                for (int i = 0; i < q; i++) solve();
            } else {
                solve();
            }
            System.out.print(output);
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }

    private static Throwable uncaught;
    private BufferedReader in;
    private FastScanner scanner;
    private PrintWriter out;
}

class FastScanner {
    private BufferedReader in;
    private StringTokenizer tokenizer;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}