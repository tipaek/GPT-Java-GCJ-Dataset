import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MatrixAnalysis {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                }
            }

            // Calculate primary diagonal sum
            int primaryDiagonalSum = 0;
            for (int i = 0; i < n; i++) {
                primaryDiagonalSum += matrix[i][i];
            }

            // Calculate maximum row and column repetition
            int maxRowRepetition = calculateMaxRepetition(matrix, n, true);
            int maxColumnRepetition = calculateMaxRepetition(matrix, n, false);

            // Print the result for the current case
            System.out.println("Case #" + caseNumber + ": " + primaryDiagonalSum + " " + maxRowRepetition + " " + maxColumnRepetition);
        }
    }

    private static int calculateMaxRepetition(int[][] matrix, int size, boolean isRow) {
        int maxRepetition = 0;

        for (int i = 0; i < size; i++) {
            int[] count = new int[size + 1];
            for (int j = 0; j < size; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                count[value]++;
            }

            for (int k = 1; k <= size; k++) {
                if (count[k] > 1) {
                    maxRepetition = Math.max(maxRepetition, count[k]);
                }
            }
        }

        return maxRepetition;
    }
}