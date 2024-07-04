import java.util.HashSet;
import java.util.Scanner;

public class Kattis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Check for duplicate values in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    columnSet.add(matrix[j][i]);
                }
                if (rowSet.size() != matrixSize) {
                    rowDuplicates++;
                }
                if (columnSet.size() != matrixSize) {
                    columnDuplicates++;
                }
            }

            // Print the result for this test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}