import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read matrix and calculate trace
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;

                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();

                    if (row == col) {
                        trace += matrix[row][col];
                    }

                    if (!rowSet.add(matrix[row][col]) && !hasDuplicateInRow) {
                        hasDuplicateInRow = true;
                        duplicateRows++;
                    }
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInCol = false;

                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col]) && !hasDuplicateInCol) {
                        hasDuplicateInCol = true;
                        duplicateColumns++;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}