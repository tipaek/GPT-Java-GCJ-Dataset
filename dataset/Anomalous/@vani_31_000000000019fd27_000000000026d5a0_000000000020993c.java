import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int currentTest = 1; currentTest <= testCases; currentTest++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    if (seen[value]) {
                        rowRepeats++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            // Check for repeated elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    int value = matrix[j][i];
                    if (seen[value]) {
                        colRepeats++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            System.out.println("Case #" + currentTest + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}