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

            int[] result = analyzeLatinSquare();
            System.out.println("Case #" + caseNumber + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static int[] analyzeLatinSquare() {
        int[] result = new int[3];
        for (int i = 0; i < n; i++) {
            result[0] += matrix[i][i];
            result[1] += hasRepeatedColumn(i) ? 1 : 0;
            result[2] += hasRepeatedRow(i) ? 1 : 0;
        }
        return result;
    }

    private static boolean hasRepeatedRow(int rowIndex) {
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            int value = matrix[rowIndex][i];
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