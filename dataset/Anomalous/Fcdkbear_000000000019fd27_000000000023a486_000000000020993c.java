import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastInput in = new FastInput(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedColumns = countRepeatedColumns(matrix, n);
            
            out.printf("Case #%d: %d %d %d\n", t, trace, repeatedRows, repeatedColumns);
        }
        out.close();
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() < n) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int repeatedColumns = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() < n) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }

    static class FastInput {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastInput(InputStream stream) {
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}