import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() != matrixSize) {
                    rowDuplicates++;
                }
                if (colSet.size() != matrixSize) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}