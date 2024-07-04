import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with repeated elements
            int rowDuplicates = 0;
            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            // Counting columns with repeated elements
            int columnDuplicates = 0;
            for (int j = 0; j < matrixSize; j++) {
                int[] column = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}