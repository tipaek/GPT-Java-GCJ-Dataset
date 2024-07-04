import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private final InputReader inputReader = new InputReader();

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() throws Exception {
        int testCases = inputReader.readInt();
        for (int caseId = 1; caseId <= testCases; caseId++) {
            int n = inputReader.readInt();
            int[][] matrix = inputReader.readIntMatrix(n);
            int trace = calculateTrace(matrix);
            int rowsWithDuplicates = 0;
            int colsWithDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) rowsWithDuplicates++;
                if (hasDuplicates(getColumn(matrix, i))) colsWithDuplicates++;
            }
            System.out.printf("Case #%d: %d %d %d\n", caseId, trace, rowsWithDuplicates, colsWithDuplicates);
        }
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private boolean hasDuplicates(int[] array) {
        Set<Integer> elements = new HashSet<>();
        for (int element : array) {
            if (!elements.add(element)) {
                return true;
            }
        }
        return false;
    }

    private int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }

    private static class InputReader {
        private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws Exception {
            return Integer.parseInt(bufferedReader.readLine());
        }

        int[][] readIntMatrix(int n) throws Exception {
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = bufferedReader.readLine().split("\\s+");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            return matrix;
        }
    }
}