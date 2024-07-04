import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        try (BufferedReader stream = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(stream.readLine());

            for (int testCase = 1; testCase <= testCases; ++testCase) {
                int[][] matrix = solution.readMatrix(stream);
                String result = solution.test(testCase, matrix);
                solution.outputResult(result);
            }
        };
    }

    private void outputResult(String result) {
        System.out.println(result);
    }

    String test(final int testCase, final int[][] matrix) {
        Result result = test(matrix);
        return String.format("Case #%s: %s %s %s", testCase, result.trace, result.rowsRepeated, result.columnsRepeated);
    }

    private Result test(final int[][] matrix) {
        int size = matrix.length;

        int trace = getTrace(matrix, size);

        int repeatedInRows = getRepeatedInRows(matrix, size);

        int repeatedInColumns = getRepeatedInColumns(matrix, size);

        return new Result(trace, repeatedInRows, repeatedInColumns);
    }

    private int getTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int getRepeatedInColumns(int[][] matrix, int size) {
        int result = 0;
        for (int i = 0; i < size; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < size; ++j) {
                if (!set.add(matrix[j][i])) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    private int getRepeatedInRows(int[][] matrix, int size) {
        int result = 0;
        for (int i = 0; i < size; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < size; ++j) {
                if (!set.add(matrix[i][j])) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    private int[][] readMatrix(BufferedReader stream) throws IOException {
        int size = Integer.parseInt(stream.readLine());
        int[][] matrix = new int[size][];

        for (int i = 0; i < size; ++i) {
            int[] row = new int[size];
            matrix[i] = row;

            String[] charNumbers = stream.readLine()
                    .split(" ");
            for (int j = 0; j < size; ++j) {
                row[j] = Integer.parseInt(charNumbers[j]);
            }
        }

        return matrix;
    }

    static class Result {
        private final int trace;
        private final int rowsRepeated;
        private final int columnsRepeated;

        Result(int trace, int rowsRepeated, int columnsRepeated) {
            this.trace = trace;
            this.rowsRepeated = rowsRepeated;
            this.columnsRepeated = columnsRepeated;
        }
    }
}
