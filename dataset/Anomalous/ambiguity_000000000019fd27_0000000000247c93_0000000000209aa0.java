import java.util.*;
import java.io.*;

class Solver {
    public int[][] generateMatrix(int n, int k) {
        int[][] matrix = new int[n][n];
        List<Integer> elements = new ArrayList<>();

        // Initialize diagonal elements
        for (int i = 0; i < n; i++) {
            matrix[i][i] = k;
        }

        // Collect elements excluding k
        for (int i = 1; i <= n; i++) {
            if (i != k) {
                elements.add(i);
            }
        }

        // Sort elements
        Collections.sort(elements);

        // Fill non-diagonal elements
        for (int i = 0; i < n; i++) {
            for (int j = 0, idx = n - i - 1; j < i; j++, idx++) {
                matrix[i][j] = elements.get(idx);
            }
            for (int j = i + 1, idx = 0; j < n; j++, idx++) {
                matrix[i][j] = elements.get(idx);
            }
        }

        return matrix;
    }
}

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int testCases = in.nextInt();
        Solver solver = new Solver();

        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            out.print("Case #" + t + ": ");

            if (k % n != 0) {
                out.println("IMPOSSIBLE");
            } else {
                out.println("POSSIBLE");
                int[][] result = solver.generateMatrix(n, k / n);

                for (int[] row : result) {
                    for (int j = 0; j < n; j++) {
                        out.print(row[j]);
                        if (j < n - 1) {
                            out.print(" ");
                        }
                    }
                    out.println();
                }
            }
        }
        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
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
    }
}