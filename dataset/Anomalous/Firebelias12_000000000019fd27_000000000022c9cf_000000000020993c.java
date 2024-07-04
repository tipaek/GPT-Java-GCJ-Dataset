import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int repeatRows = calculateMaxRepeats(matrix, n, true);
            int repeatCols = calculateMaxRepeats(matrix, n, false);

            System.out.println("Case #" + i + ": " + trace + " " + repeatRows + " " + repeatCols);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateMaxRepeats(int[][] matrix, int n, boolean isRow) {
        int maxRepeats = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> seen = new HashSet<>();
            int repeats = 0;

            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (seen.contains(value)) {
                    repeats++;
                } else {
                    seen.add(value);
                }
            }
            maxRepeats = Math.max(maxRepeats, repeats);
        }

        return maxRepeats;
    }
}