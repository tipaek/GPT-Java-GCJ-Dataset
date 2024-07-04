import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            Set<Integer> uniqueElements = new HashSet<>();

            // Read matrix and compute trace and row repeats
            for (int i = 0; i < matrixSize; i++) {
                boolean rowHasDuplicate = false;
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowHasDuplicate && !uniqueElements.add(matrix[i][j])) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                uniqueElements.clear();
            }

            // Compute column repeats
            for (int j = 0; j < matrixSize; j++) {
                boolean colHasDuplicate = false;
                for (int i = 0; i < matrixSize; i++) {
                    if (!colHasDuplicate && !uniqueElements.add(matrix[i][j])) {
                        colRepeats++;
                        colHasDuplicate = true;
                    }
                }
                uniqueElements.clear();
            }

            System.out.printf("Case #%d: %d %d %d\n", caseIndex, trace, rowRepeats, colRepeats);
        }
    }
}