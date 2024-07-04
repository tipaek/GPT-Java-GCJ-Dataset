import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    private static int n, k;
    private static Integer[][] solution;
    private static boolean isFound;

    private static void search(Integer[][] matrix, int row, int col) {
        if (isFound) return;

        int diagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != null) {
                diagonalSum += matrix[i][i];
            }
        }
        if (diagonalSum > k) return;

        int rowViolations = 0, colViolations = 0;
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            int rowCount = 0, colCount = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != null) {
                    rowSet.add(matrix[i][j]);
                    rowCount++;
                }
                if (matrix[j][i] != null) {
                    colSet.add(matrix[j][i]);
                    colCount++;
                }
            }
            if (rowSet.size() != rowCount) rowViolations++;
            if (colSet.size() != colCount) colViolations++;
        }
        if (rowViolations > 0 || colViolations > 0) return;

        if (row == n) {
            if (diagonalSum == k && rowViolations == 0 && colViolations == 0) {
                isFound = true;
                for (int i = 0; i < matrix.length; i++) {
                    System.arraycopy(matrix[i], 0, solution[i], 0, matrix.length);
                }
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            matrix[row][col] = i;
            if (col + 1 == n) {
                search(matrix, row + 1, 0);
            } else {
                search(matrix, row, col + 1);
            }
            matrix[row][col] = null;
        }
    }

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCases = inputReader.nextInt();
        int testCaseNumber = 1;
        while (testCases-- > 0) {
            n = inputReader.nextInt();
            k = inputReader.nextInt();
            Integer[][] matrix = new Integer[n][n];
            solution = new Integer[n][n];
            isFound = false;
            search(matrix, 0, 0);
            if (isFound) {
                for (Integer[] row : solution) {
                    System.out.println(Arrays.toString(row));
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader fileReader) {
            reader = new BufferedReader(fileReader);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
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