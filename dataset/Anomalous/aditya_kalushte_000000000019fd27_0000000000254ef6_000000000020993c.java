import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row duplicates
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowElements = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowElements.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < matrixSize; j++) {
                Set<Integer> columnElements = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnElements.add(matrix[i][j])) {
                        columnDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}