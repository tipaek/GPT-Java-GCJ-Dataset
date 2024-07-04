import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][] results = new int[testCases][3];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            results[t][0] = trace;

            // Count rows with repeated elements
            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                if (hasRepeatedElements(matrix[i])) {
                    repeatedRows++;
                }
            }
            results[t][1] = repeatedRows;

            // Count columns with repeated elements
            int repeatedColumns = 0;
            for (int i = 0; i < n; i++) {
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasRepeatedElements(column)) {
                    repeatedColumns++;
                }
            }
            results[t][2] = repeatedColumns;
        }

        // Print the results
        for (int t = 0; t < testCases; t++) {
            System.out.println(results[t][0] + " " + results[t][1] + " " + results[t][2]);
        }
    }

    private static boolean hasRepeatedElements(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}