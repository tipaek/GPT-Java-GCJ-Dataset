import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            solveCase(scanner, caseNum);
        }
    }

    private static void solveCase(Scanner scanner, int caseNumber) {
        int size = scanner.nextInt();
        int targetTrace = scanner.nextInt();

        int[][] matrix = new int[size][size];
        boolean[][] rowUsed = new boolean[size][size];
        boolean[][] colUsed = new boolean[size][size];

        boolean isPossible = fillMatrix(matrix, rowUsed, colUsed, size, targetTrace, 0, 0, 0, caseNumber);

        if (!isPossible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static boolean fillMatrix(int[][] matrix, boolean[][] rowUsed, boolean[][] colUsed,
                                      int size, int targetTrace, int currentTrace,
                                      int row, int col, int caseNumber) {
        if (row == size) {
            if (currentTrace == targetTrace) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] rowArray : matrix) {
                    for (int i = 0; i < size - 1; i++) {
                        System.out.print(rowArray[i] + " ");
                    }
                    System.out.println(rowArray[size - 1]);
                }
                return true;
            }
            return false;
        }

        if (col == size) {
            return fillMatrix(matrix, rowUsed, colUsed, size, targetTrace, currentTrace, row + 1, 0, caseNumber);
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

                if (fillMatrix(matrix, rowUsed, colUsed, size, targetTrace, newTrace, row, col + 1, caseNumber)) {
                    return true;
                }

                matrix[row][col] = 0;
                rowUsed[row][num - 1] = false;
                colUsed[col][num - 1] = false;
            }
        }

        return false;
    }
}