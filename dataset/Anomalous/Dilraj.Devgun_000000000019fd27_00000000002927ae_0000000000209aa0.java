import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            solveProblem(scanner, i);
        }
    }

    private static void solveProblem(Scanner scanner, int caseNumber) {
        int size = scanner.nextInt();
        int traceTarget = scanner.nextInt();

        int[][] matrix = new int[size][size];
        boolean[][] usedInRow = new boolean[size][size];
        boolean[][] usedInCol = new boolean[size][size];

        if (!fillMatrix(matrix, usedInRow, usedInCol, size, traceTarget, 0, 0, 0)) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static boolean fillMatrix(int[][] matrix, boolean[][] usedInRow, boolean[][] usedInCol,
                                      int size, int traceTarget, int currentTrace, int row, int col) {
        if (row == size && col == 0 && currentTrace == traceTarget) {
            printMatrix(matrix, size);
            return true;
        }

        if (col == size) {
            return fillMatrix(matrix, usedInRow, usedInCol, size, traceTarget, currentTrace, row + 1, 0);
        }

        if (row == size) {
            return false;
        }

        for (int num = 1; num <= size; num++) {
            int index = num - 1;
            if (!usedInRow[row][index] && !usedInCol[col][index]) {
                usedInRow[row][index] = true;
                usedInCol[col][index] = true;
                matrix[row][col] = num;

                int newTrace = currentTrace + (row == col ? num : 0);
                if (fillMatrix(matrix, usedInRow, usedInCol, size, traceTarget, newTrace, row, col + 1)) {
                    return true;
                }

                usedInRow[row][index] = false;
                usedInCol[col][index] = false;
                matrix[row][col] = 0;
            }
        }

        return false;
    }

    private static void printMatrix(int[][] matrix, int size) {
        System.out.print("POSSIBLE\n");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}