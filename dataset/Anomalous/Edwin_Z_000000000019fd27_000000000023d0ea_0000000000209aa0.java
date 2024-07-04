import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int targetSum = in.nextInt();
            int[][] matrix = new int[n][n];
            int[] sequence = new int[n];

            for (int i = 0; i < n; i++) {
                sequence[i] = i + 1;
            }

            for (int start = 1; start <= n; start++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = sequence[(i + j + start) % n];
                    }
                }

                int currentSum = targetSum;
                for (int i = 0; i < n; i++) {
                    currentSum -= matrix[i][i];
                }

                if (currentSum == 0) {
                    out.println("Case #" + testNumber + ": POSSIBLE");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            out.print(matrix[i][j] + " ");
                        }
                        out.println();
                    }
                    return;
                }
            }

            out.println("Case #" + testNumber + ": IMPOSSIBLE");
        }
    }

    static class InputReader {
        private BufferedReader reader;
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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}