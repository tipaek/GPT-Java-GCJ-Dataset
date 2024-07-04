import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Set<Integer>> rows, cols;

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int i = 1; i <= numberOfCases; i++) {
            processCase(i);
        }
    }

    private static void processCase(int caseNumber) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[n][n];
        rows = new ArrayList<>(n);
        cols = new ArrayList<>(n);
        int quotient = k / n;
        int remainder = k % n;

        for (int i = 0; i < n; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            matrix[i][i] = quotient + (remainder > 0 ? 1 : 0);
            remainder = Math.max(0, remainder - 1);
            rows.get(i).add(matrix[i][i]);
            cols.get(i).add(matrix[i][i]);
        }

        if (fillMatrix(matrix, 0, 1)) {
            System.out.printf("Case #%d: POSSIBLE\n", caseNumber);
            printMatrix(matrix);
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
        }
    }

    private static boolean fillMatrix(int[][] matrix, int row, int col) {
        int n = matrix.length;
        if (row == n - 1 && col == n - 1) {
            return true;
        }
        if (row == col) {
            return fillMatrix(matrix, row, col + 1);
        }
        if (col == n) {
            return fillMatrix(matrix, row + 1, 0);
        }
        for (int num = 1; num <= n; num++) {
            if (!rows.get(row).contains(num) && !cols.get(col).contains(num)) {
                matrix[row][col] = num;
                rows.get(row).add(num);
                cols.get(col).add(num);
                if (fillMatrix(matrix, row, col + 1)) {
                    return true;
                }
                rows.get(row).remove(num);
                cols.get(col).remove(num);
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}