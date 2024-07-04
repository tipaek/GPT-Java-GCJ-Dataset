import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            int[][] matrix = new int[t][t];
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < t; i++) {
                trace += matrix[i][i];
            }

            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < t; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                for (int j = 0; j < t; j++) {
                    if (!rowSet.add(matrix[i][j])) rowDuplicate = true;
                    if (!colSet.add(matrix[j][i])) colDuplicate = true;
                }
                if (rowDuplicate) rowCount++;
                if (colDuplicate) colCount++;
            }

            out.println("Case #" + testNumber + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    static class InputReader {
        private final BufferedReader reader;
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