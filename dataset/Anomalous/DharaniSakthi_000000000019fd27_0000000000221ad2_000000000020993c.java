import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and validate input
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (matrix[row][col] < 1 || matrix[row][col] > n) {
                        throw new IllegalArgumentException("Matrix element out of bounds");
                    }
                }
            }

            // Calculate the trace of the matrix
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Check for duplicate elements in each row
            for (int row = 0; row < n; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!seen.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in each column
            for (int col = 0; col < n; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!seen.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}