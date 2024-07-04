import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vestigium {
    private static int[][] matrix;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            n = Integer.parseInt(reader.readLine());
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
            int[] results = calculateLatinSquareMetrics();
            System.out.printf("Case #%d: %d %d %d%n", caseNum, results[0], results[1], results[2]);
        }
    }

    private static int[] calculateLatinSquareMetrics() {
        int[] metrics = new int[3];
        for (int i = 0; i < n; i++) {
            metrics[0] += matrix[i][i]; // Trace
            if (hasRepeatedInColumn(i)) {
                metrics[1]++;
            }
            if (hasRepeatedInRow(i)) {
                metrics[2]++;
            }
        }
        return metrics;
    }

    private static boolean hasRepeatedInRow(int row) {
        boolean[] seen = new boolean[n];
        for (int col = 0; col < n; col++) {
            int value = matrix[row][col];
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }

    private static boolean hasRepeatedInColumn(int col) {
        boolean[] seen = new boolean[n];
        for (int row = 0; row < n; row++) {
            int value = matrix[row][col];
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}