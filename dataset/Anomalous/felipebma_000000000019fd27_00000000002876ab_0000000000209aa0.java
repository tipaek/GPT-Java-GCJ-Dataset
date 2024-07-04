import java.util.*;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Set<Integer>> rows, cols;
    private static int targetSum;

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int i = 1; i <= numberOfCases; i++) {
            solveCase(i);
        }
    }

    private static void solveCase(int caseNumber) {
        int n = scanner.nextInt();
        targetSum = scanner.nextInt();
        int[][] matrix = new int[n][n];
        rows = new ArrayList<>();
        cols = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        if (fillMatrix(matrix, 0, 0)) {
            System.out.printf("Case #%d: POSSIBLE\n", caseNumber);
            printMatrix(matrix);
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
        }
    }

    private static boolean fillMatrix(int[][] matrix, int row, int col) {
        if (row == matrix.length) {
            return calculateDiagonalSum(matrix) == targetSum;
        }
        if (col == matrix.length) {
            return fillMatrix(matrix, row + 1, 0);
        }
        for (int num = 1; num <= matrix.length; num++) {
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

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
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