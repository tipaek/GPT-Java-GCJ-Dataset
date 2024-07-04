import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCaseCount = reader.nextInt();
        int currentTest = 1;
        
        while (testCaseCount-- > 0) {
            int size = reader.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateCols = countDuplicateCols(matrix);
            
            System.out.printf("Case #%d: %d %d %d\n", currentTest++, trace, duplicateRows, duplicateCols);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != matrix.length) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int duplicateCols = 0;
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != matrix.length) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
    }
}