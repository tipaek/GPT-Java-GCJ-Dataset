import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] matrix;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        int caseNumber = 0;

        while (numberOfCases-- > 0) {
            caseNumber++;
            n = Integer.parseInt(reader.readLine());
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] rowData = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(rowData[j]);
                }
            }

            int[] results = analyzeLatinSquare();
            System.out.println("Case #" + caseNumber + ": " + results[0] + " " + results[1] + " " + results[2]);
        }
    }

    private static int[] analyzeLatinSquare() {
        int[] results = new int[3];

        for (int i = 0; i < n; i++) {
            results[0] += matrix[i][i]; // Sum of the diagonal
            if (hasRepeatedColumn(i)) results[1]++;
            if (hasRepeatedRow(i)) results[2]++;
        }

        return results;
    }

    private static boolean hasRepeatedRow(int rowIndex) {
        boolean[] seen = new boolean[n];

        for (int j = 0; j < n; j++) {
            int value = matrix[rowIndex][j];
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }

        return false;
    }

    private static boolean hasRepeatedColumn(int colIndex) {
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            int value = matrix[i][colIndex];
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }

        return false;
    }
}