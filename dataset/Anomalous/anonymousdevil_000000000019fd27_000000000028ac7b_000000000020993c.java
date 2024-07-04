import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int[] rowRepeats = new int[n];
            int[] colRepeats = new int[n];

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate row and column repetitions
            for (int i = 0; i < n; i++) {
                int[] rowCount = new int[n];
                int[] colCount = new int[n];

                for (int j = 0; j < n; j++) {
                    rowCount[matrix[i][j] - 1]++;
                    colCount[matrix[j][i] - 1]++;
                }

                rowRepeats[i] = Arrays.stream(rowCount).max().orElse(0);
                colRepeats[i] = Arrays.stream(colCount).max().orElse(0);
            }

            // Adjust repetition counts
            for (int i = 0; i < n; i++) {
                if (rowRepeats[i] > 0) rowRepeats[i]++;
                if (colRepeats[i] > 0) colRepeats[i]++;
            }

            // Sort the repetition counts
            Arrays.sort(rowRepeats);
            Arrays.sort(colRepeats);

            // Output the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeats[n - 1], colRepeats[n - 1]);
        }

        scanner.close();
    }
}