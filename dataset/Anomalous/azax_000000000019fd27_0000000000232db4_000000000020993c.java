import java.util.Scanner;
import java.io.BufferedInputStream;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            for (int row = 0; row < matrixSize; row++) {
                String[] rowData = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
                trace += matrix[row][row];
            }

            int[] issues = evaluateMatrix(matrix);
            int problematicRows = issues[0];
            int problematicCols = issues[1];

            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, problematicRows, problematicCols);
        }
        
        scanner.close();
    }

    private static int[] evaluateMatrix(int[][] matrix) {
        int problematicRows = 0;
        int problematicCols = 0;
        int matrixSize = matrix.length;

        for (int i = 0; i < matrixSize; i++) {
            boolean[] rowSeen = new boolean[matrixSize + 1];
            boolean rowHasDuplicate = false;
            for (int j = 0; j < matrixSize; j++) {
                int value = matrix[i][j];
                if (rowSeen[value]) {
                    rowHasDuplicate = true;
                    break;
                }
                rowSeen[value] = true;
            }
            if (rowHasDuplicate) {
                problematicRows++;
            }
        }

        for (int j = 0; j < matrixSize; j++) {
            boolean[] colSeen = new boolean[matrixSize + 1];
            boolean colHasDuplicate = false;
            for (int i = 0; i < matrixSize; i++) {
                int value = matrix[i][j];
                if (colSeen[value]) {
                    colHasDuplicate = true;
                    break;
                }
                colSeen[value] = true;
            }
            if (colHasDuplicate) {
                problematicCols++;
            }
        }

        return new int[] { problematicRows, problematicCols };
    }
}