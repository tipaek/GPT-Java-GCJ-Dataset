import java.util.*;

public class Vestigium {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowRepeats = 0, columnRepeats = 0;

            // Read matrix and calculate trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check row repeats
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check column repeats
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", caseIndex, trace, rowRepeats, columnRepeats));
        }
        scanner.close();
    }
}