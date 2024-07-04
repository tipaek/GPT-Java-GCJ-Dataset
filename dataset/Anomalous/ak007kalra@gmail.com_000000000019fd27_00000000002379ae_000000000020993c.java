import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix input
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = input.nextInt();
                }
            }

            // Calculate the trace of the matrix
            int trace = 0;
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Calculate row and column duplicates
            int rowDuplicates = countDuplicates(matrix, n, true);
            int colDuplicates = countDuplicates(matrix, n, false);

            // Output the result for the current test case
            System.out.printf("Case #%d: %d %d %d\n", i, trace, rowDuplicates, colDuplicates);
        }
    }

    private static int countDuplicates(int[][] matrix, int n, boolean isRow) {
        int duplicates = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Boolean> seen = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (seen.containsKey(value)) {
                    duplicates++;
                    break;
                }
                seen.put(value, true);
            }
        }

        return duplicates;
    }
}