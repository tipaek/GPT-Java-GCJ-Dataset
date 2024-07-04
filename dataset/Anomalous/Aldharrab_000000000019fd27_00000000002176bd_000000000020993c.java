import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("testFile.txt"));
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            analyzeMatrix(scanner, i + 1);
        }
    }

    private static void analyzeMatrix(Scanner scanner, int caseNumber) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        // Read matrix and calculate row repeats
        for (int i = 0; i < matrixSize; i++) {
            boolean rowHasRepeat = false;
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                System.out.println(matrix[i][j]);
                if (!rowHasRepeat) {
                    for (int k = 0; k < j; k++) {
                        if (matrix[i][k] == matrix[i][j]) {
                            rowHasRepeat = true;
                            rowRepeats++;
                        }
                    }
                }
            }
        }

        // Calculate trace and column repeats
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
            boolean columnHasRepeat = false;
            for (int j = 0; j < matrixSize; j++) {
                if (i != j && matrix[i][i] == matrix[j][i]) {
                    columnHasRepeat = true;
                }
            }
            if (columnHasRepeat) {
                columnRepeats++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + columnRepeats + " " + rowRepeats);
    }
}