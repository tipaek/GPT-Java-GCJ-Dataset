import java.util.Scanner;

public class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[][] results = new int[testCases][3];

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            results[t][0] = trace;

            // Counting rows with duplicate elements
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }
            results[t][1] = rowDuplicates;

            // Counting columns with duplicate elements
            int colDuplicates = 0;
            for (int i = 0; i < n; i++) {
                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }
            results[t][2] = colDuplicates;
        }

        // Printing results
        for (int i = 0; i < testCases; i++) {
            System.out.println(results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }
    }

    private static boolean hasDuplicates(int[] array) {
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