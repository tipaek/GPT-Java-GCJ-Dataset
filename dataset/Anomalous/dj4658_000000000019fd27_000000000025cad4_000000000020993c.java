import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[101];
                boolean hasRepeat = false;
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        hasRepeat = true;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
                if (hasRepeat) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[101];
                boolean hasRepeat = false;
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        hasRepeat = true;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
                if (hasRepeat) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}