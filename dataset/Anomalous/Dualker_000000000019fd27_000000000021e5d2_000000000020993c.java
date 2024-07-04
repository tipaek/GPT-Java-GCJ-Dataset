import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vestigium {
    private static int[][] matrix;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 0;

        while (testCases-- > 0) {
            caseNumber++;
            n = Integer.parseInt(reader.readLine());
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            int[] results = calculateLatinSquareMetrics();
            System.out.println("Case #" + caseNumber + ": " + results[0] + " " + results[1] + " " + results[2]);
        }
    }

    private static int[] calculateLatinSquareMetrics() {
        int[] metrics = new int[3];

        for (int i = 0; i < n; i++) {
            metrics[0] += matrix[i][i];
            metrics[1] += hasRepeatedColumn(i) ? 1 : 0;
            metrics[2] += hasRepeatedRow(i) ? 1 : 0;
        }

        return metrics;
    }

    private static boolean hasRepeatedRow(int rowIndex) {
        boolean[] seen = new boolean[n];

        for (int j = 0; j < n; j++) {
            int value = matrix[rowIndex][j];
            if (seen[value - 1]) {
                return true;
            } else {
                seen[value - 1] = true;
            }
        }

        return false;
    }

    private static boolean hasRepeatedColumn(int columnIndex) {
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            int value = matrix[i][columnIndex];
            if (seen[value - 1]) {
                return true;
            } else {
                seen[value - 1] = true;
            }
        }

        return false;
    }
}