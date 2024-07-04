import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int testCases = in.nextInt();
            for (test = 1; test <= testCases; test++) {
                out.print("Case #" + test + ": ");
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void solve() throws Exception {
        int rows = in.nextInt();
        int cols = in.nextInt();

        int[] grid = new int[rows * cols];
        long totalInterest = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i * cols + j] = in.nextInt();
            }
        }

        int[] nextGrid = Arrays.copyOf(grid, rows * cols);
        totalInterest += calculateInterest(grid);

        int eliminated;
        do {
            eliminated = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i * cols + j] != Integer.MAX_VALUE) {
                        int totalClass = 0;
                        int totalNeighbors = 0;

                        int t = 1;
                        while (i - t >= 0 && grid[(i - t) * cols + j] == Integer.MAX_VALUE) t++;
                        if (i - t >= 0) {
                            totalClass += grid[(i - t) * cols + j];
                            totalNeighbors += 1;
                        }

                        t = 1;
                        while (i + t < rows && grid[(i + t) * cols + j] == Integer.MAX_VALUE) t++;
                        if (i + t < rows) {
                            totalClass += grid[(i + t) * cols + j];
                            totalNeighbors += 1;
                        }

                        t = 1;
                        while (j - t >= 0 && grid[i * cols + j - t] == Integer.MAX_VALUE) t++;
                        if (j - t >= 0) {
                            totalClass += grid[i * cols + j - t];
                            totalNeighbors += 1;
                        }

                        t = 1;
                        while (j + t < cols && grid[i * cols + j + t] == Integer.MAX_VALUE) t++;
                        if (j + t < cols) {
                            totalClass += grid[i * cols + j + t];
                            totalNeighbors += 1;
                        }

                        if (totalNeighbors > 0 && grid[i * cols + j] * totalNeighbors < totalClass) {
                            nextGrid[i * cols + j] = Integer.MAX_VALUE;
                            eliminated++;
                        }
                    }
                }
            }
            grid = Arrays.copyOf(nextGrid, rows * cols);
            if (eliminated > 0) {
                totalInterest += calculateInterest(grid);
            }
        } while (eliminated > 0);

        out.println(totalInterest);
    }

    static long calculateInterest(int[] grid) {
        long interest = 0;
        for (int value : grid) {
            if (value != Integer.MAX_VALUE) {
                interest += value;
            }
        }
        return interest;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return "";
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}