import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] matrix;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (cases-- > 0) {
            n = Integer.parseInt(reader.readLine());
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int[] result = analyzeLatinSquare();
            System.out.printf("Case #%d: %d %d %d%n", caseNumber++, result[0], result[1], result[2]);
        }
    }

    private static int[] analyzeLatinSquare() {
        int[] result = new int[3];

        for (int i = 0; i < n; i++) {
            result[0] += matrix[i][i];
            if (hasRepeatedColumn(i)) result[1]++;
            if (hasRepeatedRow(i)) result[2]++;
        }

        return result;
    }

    private static boolean hasRepeatedRow(int row) {
        boolean[] seen = new boolean[n];
        for (int j = 0; j < n; j++) {
            int value = matrix[row][j];
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }

    private static boolean hasRepeatedColumn(int col) {
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            int value = matrix[i][col];
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}