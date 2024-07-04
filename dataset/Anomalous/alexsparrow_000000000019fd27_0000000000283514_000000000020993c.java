import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCasesCount = scanner.nextInt();

        for (int x = 1; x <= testCasesCount; x++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int repeatingRowsCount = 0;
            int repeatingColumnsCount = 0;

            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                boolean[] colCheck = new boolean[matrixSize + 1];
                boolean rowRepeats = false;
                boolean colRepeats = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }
                    if (colCheck[matrix[j][i]]) {
                        colRepeats = true;
                    } else {
                        colCheck[matrix[j][i]] = true;
                    }
                }

                if (rowRepeats) {
                    repeatingRowsCount++;
                }
                if (colRepeats) {
                    repeatingColumnsCount++;
                }
            }

            System.out.println("Case #" + x + ": " + trace + " " + repeatingRowsCount + " " + repeatingColumnsCount);
        }
    }
}