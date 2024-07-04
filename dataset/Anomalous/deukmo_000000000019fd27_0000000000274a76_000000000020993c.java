import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Count rows with duplicates
            int rowDuplicates = countDuplicates(matrix, size, true);

            // Count columns with duplicates
            int columnDuplicates = countDuplicates(matrix, size, false);

            // Print the result
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, columnDuplicates);
        }

        scanner.close();
    }

    private static int countDuplicates(int[][] matrix, int size, boolean isRow) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size];
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (seen[value - 1]) {
                    hasDuplicate = true;
                    break;
                } else {
                    seen[value - 1] = true;
                }
            }
            if (hasDuplicate) {
                count++;
            }
        }
        return count;
    }
}