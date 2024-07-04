import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int rowRepeats = 0, columnRepeats = 0, trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowElements = new HashSet<>();
                boolean rowHasDuplicates = false;
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowElements.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowHasDuplicates) {
                    rowRepeats++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> columnElements = new HashSet<>();
                boolean columnHasDuplicates = false;
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnElements.add(matrix[i][j])) {
                        columnHasDuplicates = true;
                        break;
                    }
                }
                if (columnHasDuplicates) {
                    columnRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeats, columnRepeats);
        }
    }
}