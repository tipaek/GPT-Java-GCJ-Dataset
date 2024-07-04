import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int currentCase = 1; currentCase <= testCases; currentCase++) {
            solveProblem(scanner, currentCase);
        }
    }

    public static void solveProblem(Scanner scanner, int caseNumber) {
        int size = scanner.nextInt();
        int traceTarget = scanner.nextInt();
        int[][] matrix = new int[size][size];
        boolean[][] rowUsed = new boolean[size][size];
        boolean[][] colUsed = new boolean[size][size];

        if (!fillMatrix(matrix, rowUsed, colUsed, size, traceTarget, 0, 0, 0, caseNumber)) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    public static boolean fillMatrix(int[][] matrix, boolean[][] rowUsed, boolean[][] colUsed,
                                     int size, int traceTarget, int currentTrace,
                                     int row, int col, int caseNumber) {

        if (row == size) {
            if (currentTrace == traceTarget) {
                printMatrix(matrix, size, caseNumber);
                return true;
            }
            return false;
        }

        if (col == size) {
            return fillMatrix(matrix, rowUsed, colUsed, size, traceTarget, currentTrace, row + 1, 0, caseNumber);
        }

        for (int num = 1; num <= size; num++) {
            if (!rowUsed[row][num - 1] && !colUsed[col][num - 1]) {
                matrix[row][col] = num;
                rowUsed[row][num - 1] = true;
                colUsed[col][num - 1] = true;

                int newTrace = currentTrace;
                if (row == col) {
                    newTrace += num;
                }

                if (fillMatrix(matrix, rowUsed, colUsed, size, traceTarget, newTrace, row, col + 1, caseNumber)) {
                    return true;
                }

                matrix[row][col] = 0;
                rowUsed[row][num - 1] = false;
                colUsed[col][num - 1] = false;
            }
        }
        return false;
    }

    public static void printMatrix(int[][] matrix, int size, int caseNumber) {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}