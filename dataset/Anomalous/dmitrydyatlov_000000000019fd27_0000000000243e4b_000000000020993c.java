import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final boolean READ_FROM_FILE = false;
    private static final boolean WRITE_TO_FILE = false;
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "A-large.out";

    private void run(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        int rowDuplicates = 0, colDuplicates = 0, trace = 0;

        for (int i = 0; i < n; i++) {
            boolean[] rowChecker = new boolean[n + 1];
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                int value = in.nextInt();
                matrix[i][j] = value;
                if (rowChecker[value]) {
                    hasDuplicate = true;
                } else {
                    rowChecker[value] = true;
                }
            }
            if (hasDuplicate) {
                rowDuplicates++;
            }
        }

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            boolean[] colChecker = new boolean[n + 1];
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                int value = matrix[j][i];
                if (colChecker[value]) {
                    hasDuplicate = true;
                } else {
                    colChecker[value] = true;
                }
            }
            if (hasDuplicate) {
                colDuplicates++;
            }
        }

        out.printf("%d %d %d", trace, rowDuplicates, colDuplicates);
    }

    public static void main(String[] args) {
        InputReader in;
        PrintWriter out;
        try {
            if (READ_FROM_FILE) {
                in = new InputReader(new FileInputStream(INPUT_FILE));
            } else {
                in = new InputReader(System.in);
            }
            if (WRITE_TO_FILE) {
                out = new PrintWriter(OUTPUT_FILE);
            } else {
                out = new PrintWriter(System.out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            solution.run(in, out);
            out.println();
        }

        out.flush();
        out.close();
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextCharacter() {
            return next().charAt(0);
        }
    }
}