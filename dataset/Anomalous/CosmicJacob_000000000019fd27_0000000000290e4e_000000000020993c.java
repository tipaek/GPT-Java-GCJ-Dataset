import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row repeats
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

            // Check for column repeats
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

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}