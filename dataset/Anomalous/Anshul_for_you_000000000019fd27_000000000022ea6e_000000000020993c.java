import java.util.Arrays;
import java.util.Scanner;

public class Trace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[] standardArray = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                standardArray[i] = i + 1;
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[] tempArray = new int[matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    tempArray[col] = scanner.nextInt();
                    matrix[row][col] = tempArray[col];
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                Arrays.sort(tempArray);
                if (!Arrays.equals(tempArray, standardArray)) {
                    rowRepeats++;
                }
            }

            int[] colArray = new int[matrixSize];
            for (int col = 0; col < matrixSize; col++) {
                for (int row = 0; row < matrixSize; row++) {
                    colArray[row] = matrix[row][col];
                }
                Arrays.sort(colArray);
                if (!Arrays.equals(colArray, standardArray)) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}