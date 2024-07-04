import java.io.BufferedReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new java.io.InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row repetitions
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n];
                for (int col = 0; col < n; col++) {
                    int value = matrix[row][col];
                    if (seen[value - 1]) {
                        rowRepeats++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            // Check for column repetitions
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n];
                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];
                    if (seen[value - 1]) {
                        colRepeats++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            // Print the results
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}