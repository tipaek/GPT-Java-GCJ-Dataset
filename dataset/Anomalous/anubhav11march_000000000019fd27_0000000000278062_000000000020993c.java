import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                boolean[] colCheck = new boolean[matrixSize + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]] && !rowHasDuplicate) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }

                    if (colCheck[matrix[j][i]] && !colHasDuplicate) {
                        colRepeats++;
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[j][i]] = true;
                    }

                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowRepeats, colRepeats);
        }
    }
}